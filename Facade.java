import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setProperty;

public class Facade {

	public static UserInfoItem userInfoItem = new UserInfoItem();
	Facade(){}
	private int UserType;

	public static Product theSelectedProduct;

	private int nProductCategory;
	private ClassProductList classProductListObj = 	new ClassProductList();

	public static List<Product> theProductList;

	private static Person thePerson;

	public void login() {
		Login loginObj = new Login();
		loginObj.setModal(true);
		loginObj.setVisible(true);
		userInfoItem.username = loginObj.GetUserName();
		userInfoItem.type = loginObj.GetUserType();
		System.out.println(userInfoItem.username+" logged in");
		System.out.println(userInfoItem.username+" is a "+userInfoItem.type);
		createProductList();
		createUser(userInfoItem);
	}
//	list of things buyer wants to buy, offering corresponds to seller

	public void addTrading() {
		Trading tradingObj = new Trading(theSelectedProduct);
		tradingObj.addTrading();
		viewAllProducts();
	}

	public void viewAllProducts(){
		System.out.println("-----------------List Of All The Products-----------------");
		ProductIterator productIteratorObj = new ProductIterator(theProductList);
		int i = 0;
		while (productIteratorObj.hasNext()){
			i++;
			Product currentProd = productIteratorObj.Next();
			System.out.println(i+". "+currentProd);
		}
		theSelectedProduct = SelectProduct();
		productOperation();
	}

	public void viewTrading() {
		Trading tradingObj = new Trading(theSelectedProduct);
		tradingObj.viewOfferings();
		viewAllProducts();
	}

	public void decideBidding(Offering offering) {
		System.out.println(offering.selectedProduct+ " will be sold to "+offering.buyerName +" for "+ offering.buyerBid);
		System.out.println("----- Auction for "+ offering.selectedProduct+ " is now over -----");
		AttachProductToUser(offering);
	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.type == UserInfoItem.USER_TYPE.Buyer){
			 thePerson = new Buyer();
		}else {
			thePerson = new Seller();
		}
		thePerson.username = userinfoitem.username;
		thePerson.showMenu();
	}

	public void createProductList() {
		theProductList = classProductListObj.makeList();
//		System.out.println(theProductList);
	}

	public void AttachProductToUser(Offering offering) {
		File offeringByBuyerFile = new File("OfferingByBuyer.txt");
		File userProductFile = new File("UserProduct.txt");
		List<Product> allProducts = new ArrayList<>();
		Scanner sr = null;
		Scanner sr2 = null;
		try{
			sr= new Scanner(new FileReader(offeringByBuyerFile));
			sr2 = new Scanner(new FileReader(userProductFile));
		} catch (FileNotFoundException e){
			System.out.println(e);
		}
		int counter = 1;
		while (sr.hasNextLine()){
			if (counter == offering.indexInFile){
				String buffer = sr.nextLine();
				buffer = "";
				break;
			}
			counter++;
		}
		while (sr2.hasNextLine()){
			String[] eachLine = (sr2.nextLine()).split(":");
			if (eachLine[0].equals(offering.buyerName) && eachLine[1].equals(theSelectedProduct.item)){
				String buffer = sr2.nextLine();
				buffer = "";
				break;
			}
		}
		try {
			FileWriter myWriter = new FileWriter("UserProduct.txt", true);
			myWriter.append("\n"+offering.buyerName +":"+ offering.selectedProduct);
			myWriter.close();
			System.out.println("Product successfully attached to "+offering.buyerName);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Product SelectProduct() {
		System.out.println("Select a Product or press 0 to exit");
		Scanner scanner = new Scanner (System.in);
		int option = scanner.nextInt();
		if (option == 0){exit(0);}
		theSelectedProduct = theProductList.get(option-1);
		System.out.println("The Selected Product is "+ theSelectedProduct);
		return theSelectedProduct;
	}

	public void productOperation() {
		OfferingMenu offeringMenuObj = new OfferingMenu(theSelectedProduct);
		if (userInfoItem.type== UserInfoItem.USER_TYPE.Buyer){
//			offeringMenuObj.viewOfferings();
			System.out.println("Press 1 to bid for "+ theSelectedProduct +" else enter 0");
			Scanner scanner = new Scanner (System.in);
			int addOption = scanner.nextInt();
			if (addOption == 1){
				addTrading();
			}
		}
		else {
			System.out.println("Press 1 to sell "+ theSelectedProduct +" else press 0 to view bidding for "+theSelectedProduct);
			Scanner scanner = new Scanner (System.in);
			int addOption = scanner.nextInt();
			if (addOption == 1){
				offeringMenuObj.addNewOffering();
			}
			else {
				viewTrading();
			}
		}
	}

}
