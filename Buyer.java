import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Buyer extends Person {
	List<Product> meatMenuOFBuyer = new ArrayList<>();
	List<Product> produceMenuOFBuyer = new ArrayList<>();
	Buyer(){
		type = 0;
	}

	/**
	 *  
	 */
	public void showMenu() {
		HashMap<String, List<Product>> userProdDict;
		List<Product> buyerWantsProducts;
//		UserInfoItem userInfoItem = new UserInfoItem();
		userProdDict = ClassProductList.userProductDict;
		buyerWantsProducts = userProdDict.get(Facade.userInfoItem.username);
		System.out.println("Select an option:");
		System.out.println("1. Meat Menu");
		System.out.println("2. Produce Menu");
		Scanner scanner = new Scanner (System.in);
		int option = scanner.nextInt();
		if(option == 1){
			List<Product> meatItems = ClassProductList.meatMenu;
			for (Product products : meatItems){
				for(Product buyerProduct : buyerWantsProducts) {
					if (products.item.equals(buyerProduct.item)) {
						meatMenuOFBuyer.add(products);
					}
				}
			}
			CreateProductMenu(1);

		}
		else {
			List<Product> produceItems = ClassProductList.produceMenu;
			for (Product products : produceItems){
				for(Product sellerProduct : buyerWantsProducts) {
					if(products.item.equals(sellerProduct.item)) {
						produceMenuOFBuyer.add(products);
					}
				}
			}
			CreateProductMenu(2);
		}
	}

	public ProductMenu CreateProductMenu(int choice) {
		if (choice == 2){
			ProduceProductMenu produceProductMenuObj = new ProduceProductMenu();
			produceProductMenuObj.showMenu(produceMenuOFBuyer);
		}
		else if (choice == 1) {
//			System.out.println("I am in meat");
			MeatProductMenu meatProductMenuObj = new MeatProductMenu();
			meatProductMenuObj.showMenu(meatMenuOFBuyer);
		}
		else{
			throw new IllegalArgumentException("Invalid input");
		}
		return null;
	}

}
