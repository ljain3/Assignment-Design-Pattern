import java.util.ArrayList;
import java.util.List;

public class OfferingList {

	private Trading trading;

	private ClassProductList classProductListObj = 	new ClassProductList();

	List<Offering> offering = new ArrayList<>();

//	public Offering[] getOfferingList(Product theSelectedProduct){
//		Product selectedProduct = theSelectedProduct;
//		List<Product> offeringForSelectedProd;
//		File offeringFile = new File("OfferingByBuyer.txt");
//		Scanner sr = null;
//		try{
//			sr= new Scanner(new FileReader(offeringFile));
//
//		} catch (FileNotFoundException e){
//			System.out.println(e);
//		}
//
////        String buyerFileContents;
//		while (sr.hasNextLine()){
//			String[] eachLine = (sr.nextLine()).split(":");
//			if (eachLine[0] == selectedProduct.item && eachLine[1] == Facade.userInfoItem.username){}
//		}
//		return offering;
//	}

}
