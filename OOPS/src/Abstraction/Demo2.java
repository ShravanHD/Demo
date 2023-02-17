package Abstraction;

public class Demo2 extends Demo1 {
	@Override
	void m1()
	{
		System.out.println("Hi");
	}
	void m2()
	{
		System.out.println("macha");
	}
	public static void main(String[] args)
	{
		Demo2 sc = new Demo2();
		sc.m1();
		sc.m2();
	}

}
