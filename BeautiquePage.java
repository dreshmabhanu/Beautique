package user_package;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BeautiquePage {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		String head = "Welcome to Beautique💅💄";
		char ch[] = head.toCharArray();
		for(char c : ch) {
			//"\u001B[36m"+"\u001B[1m"+
			System.out.print(c);
			Thread.sleep(30);
		}
		System.out.println("\u001B[0m");
		System.out.println("\nLogin to Beautique💅💄");
		System.out.println("\nEnter your mobile number📱");
		long mobile = sc.nextLong();
		
		if(mobile>6000000000l || mobile>7000000000l || mobile>8000000000l || mobile>9000000000l && mobile<9999999999l)
		{
			int otp = GenerateOTP.generateOTP();
			System.out.println("Your OTP for Beautique is "+otp);
			System.out.println("Enter the OTP");
			int enteredOTP = sc.nextInt();
			
			if(otp == enteredOTP)
			{
				System.out.println("Logged in successfully📲");
				List<SellProducts> productList = new ArrayList<SellProducts>();
				boolean login = true;
				while(login)
				{
					GenerateOTP.displayOptions();
					System.out.println("Enter your choice");
					System.out.println();
					int option = sc.nextInt();
					switch(option) 
					{
						case 1:{
							SellProducts sell = GenerateOTP.newItem();
							productList.add(sell);
							System.out.println("Product added successfully ^_^");
							
						}break;
						case 2:{
							GenerateOTP.displayAllProducts(productList);
						}
							break;
						case 3:{
							GenerateOTP.searchProducts(productList);
						} break;
						case 4:{
							GenerateOTP.updateProducts(productList);
						} break;
						case 5:{
							System.out.println("Enter the product name to delete");
							String product = sc.next();
							GenerateOTP.deleteProducts(productList, product);
						} break;
						case 6: {
							GenerateOTP.purchaseProducts(productList);
						}break;
						case 7: 
							login = false;
							System.out.println("Logged out successfully👋");
							break;
						default:
							System.out.println("Enter a valid option");
					
					}
					
				}
			}
			else
				System.out.println("Invalid OTP\nRetry again after some time");
		}
		else
			System.out.println("Invalid mobile number");
		
	sc.close();
	}

}

