import java.util.List;

public interface ProductMenu {

//	Person person = new Person();

	public abstract void showMenu(List<Product> menu);

	public abstract void showAddButton();

	public abstract void showViewButton();

	public abstract void showRadioButton();

	public abstract void showLabels();

	public abstract void showComboxes();

}
