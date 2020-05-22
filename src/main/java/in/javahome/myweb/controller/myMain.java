package in.javahome;
import java.util.Scanner;
public class myMain {
	public static void main(String[] args) {
		int  num1, num2, ans;
		char op;
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter two numbers: ");
		num1 = reader.nextInt();
		num2 = reader.nextInt();
		System.out.print("\nEnter an operator (+, -, *, /): ");
        op = reader.next().charAt(0);
        Calculator cal = new Calculator();
		switch(op) {
		   case '+': ans = cal.add(num1, num2);
			  break;
		   case '-': ans = cal.subtract(num1, num2);
			  break;
		   case '*': ans = cal.multiply(num1, num2);
			  break;
		   case '/': ans = cal.divide(num1, num2);
			  break;
		   default:  System.out.printf("Error! Enter correct operator");
			  return;
		}
		System.out.print("\nThe result is given as follows:\n");
		System.out.printf(num1 + " " + op + " " + num2 + " = " + ans);
	 }
}

