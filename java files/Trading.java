import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trading {
	List<List<String>> tradingList=new ArrayList<List<String>>();
	public Trading(String ptr,String str)
	{

		try{
			File myObj = new File("D:/Assignments/SER 515/Design patterns/UserProduct.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				List<String> ll=new ArrayList<String>();
				String data = myReader.nextLine();
				String[] parts=data.split(":");
				if( (ptr.equals(parts[0])) && (str.equals(parts[1]))) {
					ll.add(parts[0]);
					ll.add(parts[1]);
					tradingList.add(ll);
				}
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
