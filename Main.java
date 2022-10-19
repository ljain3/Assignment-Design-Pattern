import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, String> buyersDict = new HashMap<String, String>();
    public static HashMap<String, String> sellersDict = new HashMap<String, String>();
    public static void main(String[] args) {
        createSellerAuthDict();
        System.out.println("Seller's Authentication Dictionary Created");
        createBuyerAuthDict();
        System.out.println("Buyer's Authentication Dictionary Created");
        Facade facadeObj = new Facade();
        facadeObj.login();
    }

    private static void createBuyerAuthDict() {
        File buyerInfoFile = new File("BuyerInfo.txt");
        Scanner sr = null;
        try{
            sr= new Scanner(new FileReader(buyerInfoFile));

        } catch (FileNotFoundException e){
            System.out.println(e);
        }

//        String buyerFileContents;
        while (sr.hasNextLine()){
            String[] eachLine = (sr.nextLine()).split(":");
            buyersDict.put(eachLine[0],eachLine[1]);
        }
    }

    private static void createSellerAuthDict() {
        File sellerInfoFile = new File("SellerInfo.txt");
        Scanner sr = null;
        try{
            sr= new Scanner(new FileReader(sellerInfoFile));

        } catch (FileNotFoundException e){
            System.out.println(e);
        }

//        String buyerFileContents;
        while (sr.hasNextLine()){
            String[] eachLine = (sr.nextLine()).split(":");
            sellersDict.put(eachLine[0],eachLine[1]);
        }
    }
}