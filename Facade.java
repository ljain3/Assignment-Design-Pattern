import java.util.Scanner;

public class Facade {
	Facade(){}
	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	public void login() {
		Login loginObj = new Login();
		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter your user name");
		String uname = scanner.next();
		System.out.print("Enter your password");
		String pass = scanner.next();
		if(loginObj.findInBuyers(uname,pass)){
			UserType=0;
			System.out.println("User is a buyer");
		} else if (loginObj.findInSellers(uname,pass)) {
			UserType=1;
			System.out.println("User is a seller");
		} else {System.out.println("Incorrect User Name or Password, Try again!");}
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {

	}

	public void createProductList() {

	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

}
