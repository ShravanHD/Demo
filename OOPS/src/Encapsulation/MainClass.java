package Encapsulation;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Demo1 ref = new Demo1();
		System.out.println(ref.getComp());
		System.out.println("Enter the Name");
		ref.setName(sc.nextLine());
		System.out.println("Enter the password");
		ref.setPassword(sc.nextLong());
		System.out.println(ref.getName());
		System.out.println(ref.getPassword());
	}
}
