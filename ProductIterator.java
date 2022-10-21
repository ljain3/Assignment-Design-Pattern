import java.util.ArrayList;
import java.util.List;

public class ProductIterator {

	private List<Product> productList;
	private int count = -1;
	ProductIterator(List<Product> productListObj){
		productList = productListObj;
	}
	public boolean hasNext() {
		return count < productList.size() - 1;
	}

	public Product Next() {
		if (hasNext()){
			count++;
			return productList.get(count);
		}
		return null;
	}

	public void MoveToHead() {

	}

	public void Remove() {
		productList.remove(count);
	}

}
