import java.util.ArrayList;

public class Product {
	public String item;
	private Trading trading;
	ArrayList<Trading> tradingList= new ArrayList<>();

	public Product(String item) {
		this.item = item;
	}

	public String toString() {
		return item;
	}

//	void AddTrading(Assignment newAss)
//	{
//		assignmentList.add(newAss);
//	}
//
//	public String toString()
//	{
//		return CourseName;
//	}
//
//	void accept(NodeVisitor visitor)
//	{
//		visitor.visitCourse(this);
//	}


}
