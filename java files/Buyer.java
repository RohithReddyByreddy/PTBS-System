public class Buyer extends Person {

	public String name;
	public String type;
	public String product;
	public Buyer(String name, String type)
	{
		this.name=name;
		this.type=type;
	}
	public void showMenu() {
		classProductList cl=new classProductList();
		System.out.println("meat menu");
		for(Product st:cl.list2)
		{
			if(st.type=="Meat")
			{
				System.out.println(st.product);
			}
		}
	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
