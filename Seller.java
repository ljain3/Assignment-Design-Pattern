import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Seller extends Person {
	List<Product> meatMenuOFSeller = new ArrayList<>();
	List<Product> produceMenuOFSeller = new ArrayList<>();
	Seller(){
		type = 1;
	}

	/**
	 *  
	 */
	public void showMenu() {
		HashMap<String, List<Product>> userProdDict;
		List<Product> sellerHasProducts;
//		UserInfoItem userInfoItem = new UserInfoItem();
		userProdDict = ClassProductList.userProductDict;
		sellerHasProducts = userProdDict.get(Facade.userInfoItem.username);
		System.out.println("Select an option:");
		System.out.println("1. Meat Menu");
		System.out.println("2. Produce Menu");
		Scanner scanner = new Scanner (System.in);
		int option = scanner.nextInt();
		if(option == 1){
			List<Product> meatItems = ClassProductList.meatMenu;
			for (Product products : meatItems){
				for(Product sellerProduct : sellerHasProducts) {
					if (products.item.equals(sellerProduct.item)) {
						meatMenuOFSeller.add(products);
					}
				}
			}
			CreateProductMenu(1);
		}
		else {
			List<Product> produceItems = ClassProductList.produceMenu;
			for (Product products : produceItems){
				for(Product sellerProduct : sellerHasProducts) {
					if(products.item.equals(sellerProduct.item)) {
						produceMenuOFSeller.add(products);
					}
				}
//				if(produceItems.contains(products)){
//
//				}
			}
			CreateProductMenu(2);
		}


	}

	public ProductMenu CreateProductMenu(int menuType) {
		if (menuType == 2){
			ProduceProductMenu produceProductMenuObj = new ProduceProductMenu();
			produceProductMenuObj.showMenu(produceMenuOFSeller);
		}
		else if (menuType == 1) {
//			System.out.println("I am in meat");
			MeatProductMenu meatProductMenuObj = new MeatProductMenu();
			meatProductMenuObj.showMenu(meatMenuOFSeller);
		}
		else{
			throw new IllegalArgumentException("Invalid input");
		}
		return null;
	}

}
