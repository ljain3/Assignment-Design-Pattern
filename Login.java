import java.util.Hashtable;
import java.util.Scanner;
import java.io.*;
public class Login {
    Login(){
//        System.out.println(Main.buyersDict.get("tutu"));
    }

    public boolean findInSellers(String uname, String pass) {
        if (Main.sellersDict.get(uname)!=null){
            if(Main.sellersDict.get(uname).equals(pass)){return true;}
            else {return false;}
        }
        else {return false;}
    }

    public boolean findInBuyers(String uname, String pass) {
        if (Main.buyersDict.get(uname)!=null){
            if(Main.buyersDict.get(uname).equals(pass)){return true;}
            else {return false;}
        }
        else {return false;}
    }




}
