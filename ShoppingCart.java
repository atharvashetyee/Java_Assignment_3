import java.util.*;

public class ShoppingCart {
	public static void main(String[]args) {
		
		Scanner sc=new Scanner(System.in);
		try {
			String [] cart= {"Mouse","Keyboard"};
			System.out.println("1.Mouse 2.Keyboard");
			System.out.println("Select Product");
			int choice=sc.nextInt();
			sc.nextLine();
			for(int i=0;i<cart.length;i++) {
				System.out.println((i+1)+"."+cart[i]);
			}

			String chosenItem=cart[choice-1];
		}
		catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("Input is out of bound");
		}
		try {
			System.out.println("Enter the quantity");
			String quantity=sc.nextLine();
			int quant=Integer.parseInt(quantity);
		}
		catch(NumberFormatException ne) {
			System.out.println("invalid input");
		}
		try {
			System.out.println("Amt to be distributes");
		    int ppl=sc.nextInt();
		    sc.nextLine();
			double amt=1200/ppl;
		}
		catch(ArithmeticException ae) {
			
			System.out.println("Cant be zero");
		}
	

	}
}
