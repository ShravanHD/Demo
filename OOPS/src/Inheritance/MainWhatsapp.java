package Inheritance;

public class MainWhatsapp
{
	public static void main(String[] args)
	{
		Contacts o1 = new Contacts();
		System.out.print("Username : ");
		o1.m1("Shravan");
		System.out.print("contact number : ");
		o1.m2(636245698);

		Group o2 = new Group();
		System.out.print("number of chats : ");
		o2.m3(10);
		System.out.print("number of groups : ");
		o2.m4(4);

		AudioAndVideo o3=new AudioAndVideo();
		System.out.print("number of call : ");
		o3.m5(10);
		System.out.print("number of vcall: ");
		o3.m6(4);
                
   		Status o4 = new Status();
		System.out.print("number of status :");
		o4.m7(22.7);
		
	}
}


