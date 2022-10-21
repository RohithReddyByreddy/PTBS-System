import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
public class classProductList {
	public List<Product> list2 = new ArrayList<Product>();
	private ProductIterator productIterator;
	 public classProductList(){
		 MeatProductMenu mp;
		 ProduceProductMenu pp;
		 List<String> list=new ArrayList<String>();
		 List<String> list1=new ArrayList<String>();
		 try{
		 File myObj = new File("D:/Assignments/SER 515/Design patterns/ProductInfo.txt");
		 Scanner myReader = new Scanner(myObj);
		 while (myReader.hasNextLine()) {
			 Product p=new Product();
			 String data = myReader.nextLine();
			 String[] parts=data.split(":");
			 p.product=parts[1];
			 p.type=parts[0];
			 list2.add(p);
		 }
		 myReader.close();
	 	 }
		 catch (FileNotFoundException e) {
		 System.out.println("An error occurred.");
		 e.printStackTrace();
		 }
	 }

	public void accept(NodeVisitor visitor) {

	}

}
