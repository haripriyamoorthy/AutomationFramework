package practice;

public class GenericMethodsPractise {

	public static void main(String[] args) {//calling function//caller function 
		// TODO Auto-generated method stub

		int sum=add(20,30);
		System.out.println(sum);
		System.out.println(add(sum,78));
		System.out.println(add(100,sum));
		
		int sub=sub(50,30);
		System.out.println(sub);
		System.out.println(sub(sub,18));
		System.out.println(sub(100,sub));
		
		
		
		
	}
	public static int add(int a ,int b) {//called function
		int c=a+b;
		return c;
	}
	public static int sub(int a,int b)
	{
		int c=a-b;
		return c;
	}
}
