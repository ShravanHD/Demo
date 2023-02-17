package Encapsulation;

public class Demo1 {
	private String companyname="Google";
	private String name ;
	private long password;
	
	public void setName(String name)
	{
		this.name=name;
	}
	public void setPassword(long password)
	{
		this.password=password;
	}
	public String getName()
	{
		return name;
	}
	public long getPassword()
	{
		return password;
	}
	public String getComp()
	{
		return companyname;
	}

}
