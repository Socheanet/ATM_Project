package atm;
import java.util.*;

public class Login {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.print("Card ID: ");
		int id = sc.nextInt();
		Scanner ps = new Scanner(System.in);
		System.out.print("Password: ");
		int pw = ps.nextInt();
		
		if(id == 1111 && pw == 1234 || pw ==4321 && id == 2222) {
			System.out.print("You have logged in Successfully");
		}
		else 
			System.out.print("Wrong Password or ID Please check again");
		
		sc.close();
		ps.close();
	}

}
