import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.*;
public class Facade {
	//Facade Pattern
	private int UserType;

	public Product theSelectedProduct;

	private int nProductCategory;

	public classProductList theProductList;

	private Person thePerson;

	private String type1;
	private String name;
	private boolean flag;
	public Facade() {
		boolean flag = false;
		while(!flag) {
			flag = login();
		}
	}
	public boolean login() {
		Login lt=new Login();
		lt.LoginWindow();
		lt.waitTime();
		if(lt.flag==true)
		{
			this.name=lt.name;
			this.type1=lt.type1;
			return true;
		}
		return false;
	}

	public void addTrading(Trading pt,String str,String name) {
		String st=name+":"+str;
		try (FileWriter f = new FileWriter("D:/Assignments/SER 515/Design patterns/UserProduct.txt", true);
			 BufferedWriter b = new BufferedWriter(f);
			 PrintWriter p = new PrintWriter(b);) {
			p.println(st);
		} catch (IOException i) {
			i.printStackTrace();
		}
		List<String> ll=new ArrayList<String>();
		ll.add(name);
		ll.add(str);
		pt.tradingList.add(ll);
		System.out.println("Added product to the trading");
	}

	public void viewTrading(Trading p) {
		System.out.println("Name  Product");
			for(List<String> li:p.tradingList)
			{
				System.out.println(li.get(0)+"  "+li.get(1));
			}
	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public Person createUser(String name,String type) {
		Person p;
		if(type.equals("buyer")) {
			p = new Buyer(name,type);
		}
		else
		{
			p=new Seller(name,type);
		}
		return p;
	}

	public void createProductList() {
		this.theProductList=new classProductList();
	}

	public void AttachProductToUser(Person p, String product) {

	}

	public void SelectProduct() {


	}

	public void productOperation() {

	}
public static void main(String[] args)
{
	Facade fac=new Facade();
	Scanner sc=new Scanner(System.in);
	fac.createProductList();
	Person p=fac.createUser(fac.name,fac.type1);
	System.out.println("Hi "+fac.name);
	System.out.println("Enter item you want");
	p.showMenu();
	String str=sc.nextLine();
	Trading t=new Trading(fac.name,str);
	System.out.println("Select options from the menu");
	if(fac.type1=="buyer")
	{
		while(true) {
			System.out.println("1.View Trading");
			System.out.println("2.exit");
			int n = sc.nextInt();
			if (n == 1) fac.viewTrading(t);
			else if(n==2)
			{
				break;
			}
		}
	}
	else
	{
		while(true) {
			System.out.println("1.add Trading");
			System.out.println("2.View Trading");
			System.out.println("3.exit");
			int n=sc.nextInt();
			if (n == 1) {
				fac.addTrading(t, str, fac.name);
			} else if(n==2){
				fac.viewTrading(t);
			}
			else if(n==3)
			{
				break;
			}
		}
	}



}

}

