import java.io.*;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Offering {
	String buyerName;
	int indexInFile;
	String buyerBid;
	private OfferingList offeringList;
	String selectedProduct;
	Offering(String buyerName, String buyerBid, int indexInFile, String selectedProduct){
		this.buyerName = buyerName;
		this.buyerBid = buyerBid;
		this.indexInFile = indexInFile;
		this.selectedProduct = selectedProduct;
	}

}
