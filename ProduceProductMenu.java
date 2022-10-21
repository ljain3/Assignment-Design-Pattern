import java.util.List;

public class ProduceProductMenu implements ProductMenu {

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
		ProductIterator productIteratorObj = new ProductIterator(menu);
		System.out.println("------------YOUR PRODUCE MENU ------------");
		while (productIteratorObj.hasNext()){
			System.out.println(productIteratorObj.Next());
		}
//			System.out.println(menu);
//		System.out.println("-------------------------------------------");
		Facade facadeObj = new Facade();
		facadeObj.viewAllProducts();
	}

}
