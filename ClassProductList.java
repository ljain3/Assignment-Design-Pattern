import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ClassProductList extends ArrayList<Product>{

	private ReminderVisitor reminderVisitor;

//	private Product[] product;
	public static HashMap<String, List<Product>> userProductDict = new HashMap<String, List<Product>>();
	public static List<Product> meatMenu = new ArrayList<>();
	public static List<Product> produceMenu = new ArrayList<>();
	private ProductIterator productIterator;

	public void accept(NodeVisitor visitor) {

	}
	public List<Product> makeList(){
		List<Product> allProducts;
		File userProductFile = new File("UserProduct.txt");
		Scanner sr = null;
		try{
			sr= new Scanner(new FileReader(userProductFile));

		} catch (FileNotFoundException e){
			System.out.println(e);
		}

//        String buyerFileContents;
		while (sr.hasNextLine()){
			String[] eachLine = (sr.nextLine()).split(":");
			Product newProd = new Product(eachLine[1]);
			add(newProd);
			if(userProductDict.get(eachLine[0])==null){
				userProductDict.put(eachLine[0], new ArrayList<Product>());
			}
			userProductDict.get(eachLine[0]).add(new Product(eachLine[1]));
		}
		System.out.println(userProductDict);
		allProducts= createMeatAndProduceMenu();
		return allProducts;
	}

	private List<Product> createMeatAndProduceMenu() {
		File productInfoFile = new File("ProductInfo.txt");
		List<Product> allProducts = new ArrayList<>();
		Scanner sr = null;
		try{
			sr= new Scanner(new FileReader(productInfoFile));

		} catch (FileNotFoundException e){
			System.out.println(e);
		}
		while (sr.hasNextLine()){
			String[] eachLine = (sr.nextLine()).split(":");
			allProducts.add(new Product(eachLine[1]));
			if(eachLine[0].equals("Meat")){
				meatMenu.add(new Product(eachLine[1]));
			}
			else {

				produceMenu.add(new Product(eachLine[1]));
//				System.out.println("mm: " + produceMenu);
			}
		}
		return allProducts;
	}

}
