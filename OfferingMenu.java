import java.io.*;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class OfferingMenu {
    Product selectedProduct;
    OfferingMenu(Product theSelectedProduct){
        this.selectedProduct = theSelectedProduct;
    }
    public void addNewOffering() {
        int goToElse =1;
        for (Product product:ClassProductList.userProductDict.get(Facade.userInfoItem.username)){
            if (product.item.equals(selectedProduct.item)){
                System.out.println("You have already added an offering for this product");
                goToElse = 0;
                break;
            }
        }
        if (goToElse == 0){
            System.out.println("Press 0 to exit or press 1 to go back to the product list");
            Scanner scanner = new Scanner (System.in);
            int option = scanner.nextInt();
            if (option == 1) {
                Facade facadeObj = new Facade();
                facadeObj.viewAllProducts();
            }
            else {exit(0);}
        }
        else{
//            System.out.println(selectedProduct);
//            System.out.println(ClassProductList.userProductDict.get(Facade.userInfoItem.username));
//            System.out.println(ClassProductList.userProductDict.get(Facade.userInfoItem.username).contains(selectedProduct));
            try {
                FileWriter myWriter = new FileWriter("UserProduct.txt", true);
                myWriter.append("\n"+Facade.userInfoItem.username +":"+ selectedProduct.item);
                myWriter.close();
                System.out.println("Offering successfully added.");
                Facade facadeObj = new Facade();
                facadeObj.viewAllProducts();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
