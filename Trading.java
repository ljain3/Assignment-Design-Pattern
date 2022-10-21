import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Trading {
	Product selectedProduct;
	Trading(Product theSelectedProduct){

		this.selectedProduct = theSelectedProduct;
	}

	private final OfferingList buyerOfferingList = new OfferingList();

	public void accept(NodeVisitor visitor) {

	}

	public void viewOfferings() {
		List<Product> offeringForSelectedProd;
		File offeringByBuyerFile = new File("OfferingByBuyer.txt");
		Scanner sr = null;
		try{
			sr= new Scanner(new FileReader(offeringByBuyerFile));

		} catch (FileNotFoundException e){
			System.out.println(e);
		}
		int i = 0;
		System.out.println("---Following are the offerings by Buyers for "+selectedProduct.item+ " ---");
		while (sr.hasNextLine()){
			String[] eachLine = (sr.nextLine()).split(":");
			if (Objects.equals(eachLine[0], selectedProduct.item) && Objects.equals(eachLine[1], Facade.userInfoItem.username)){
				i++;
				System.out.println(i+ ". "+eachLine[2]+" $"+eachLine[3]);
				Offering offering = new Offering(eachLine[2],eachLine[3],i,selectedProduct.item);
				buyerOfferingList.offering.add(offering);
			}
		}
		if (i == 0){
			System.out.println("You have not offered this Product or there is no buyer for this product yet.");
		}
		System.out.println("Press 0 to exit or 1 to decide bidding");
		Scanner scanner = new Scanner (System.in);
		int option = scanner.nextInt();
		if (option == 1) {
			System.out.println("Select bid which you want to confirm");
			Scanner scanner1 = new Scanner (System.in);
			int bidNumber = scanner1.nextInt();
			Facade facadeObj = new Facade();
			facadeObj.decideBidding(buyerOfferingList.offering.get(bidNumber-1));
		}
		else {exit(0);}
	}
	public void addTrading() {
		if (!isOffered()){
			System.out.println("This product is currently not being sold by an sellers");
			System.out.println("Press 0 to exit or press 1 to go back to the product list");
			Scanner scanner = new Scanner (System.in);
			int option = scanner.nextInt();
			if (option == 1) {
				Facade facadeObj = new Facade();
				facadeObj.viewAllProducts();
			}
			else {exit(0);}
		}
		else {
			String sellerName = viewSellers();
			System.out.println("Enter your bidding Price:");
			Scanner scanner = new Scanner (System.in);
			String bidPrice = scanner.nextLine();
			if (sellerName.equals("")){
				return;
			}
			try {
				FileWriter myWriter = new FileWriter("OfferingByBuyer.txt", true);
				myWriter.append(selectedProduct.item+":"+sellerName+":"+Facade.userInfoItem.username +":"+ bidPrice+"\n");
				myWriter.close();
				System.out.println("Bidding for "+selectedProduct+" successfully added.");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Press 0 to exit or 1 to go to the main menu");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			if (option == 0){exit(0);}
			else{
				Facade facadeObj = new Facade();
				facadeObj.viewAllProducts();
			}
		}

	}

	private String viewSellers() {
		List<String> listOfSellers = new ArrayList<String>();
		System.out.println("---- Select the Seller you want to offer bidding to ----");
		System.out.println("The following sellers are selling "+selectedProduct+" :");
		int count = 0;
		for (String i : ClassProductList.userProductDict.keySet()){
			if (Main.sellersDict.get(i)!=null){
			for (Product products : ClassProductList.userProductDict.get(i)){
					if (products.item.equals(selectedProduct.item)){
						count++;
						System.out.println(count+". "+ i);
						listOfSellers.add(i);
						break;
					}
				}
			}
		}
		System.out.println("Press 0 if you don't want to bid for this product");
		Scanner scanner = new Scanner (System.in);
		int option = scanner.nextInt();
		if (option == 0){return "";}
		return listOfSellers.get(option-1);


	}

	private boolean isOffered() {
		for (String i : ClassProductList.userProductDict.keySet()){
			for (Product products : ClassProductList.userProductDict.get(i)){
				if (products.item.equals(selectedProduct.item)){
					return true;
				}
			}
		}
		return false;
	}
}
