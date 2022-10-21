import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MeatProductMenu implements ProductMenu {

	Set<String> meatProduceSet = new HashSet<String>();
	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public void showComboxes() {

	}

	public void showMenu(List<Product> menu) {
		System.out.println("------------YOUR MEAT MENU ------------");
		//for (Product produceMenu : menu) {
		System.out.println(menu);
		//}
//		System.out.println("---------------------------------------");
		Facade facadeObj = new Facade();
		facadeObj.viewAllProducts();
	}

}
