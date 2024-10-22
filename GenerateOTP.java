package user_package;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GenerateOTP {
	public static int generateOTP()
	{
		Random rand = new Random();
		return rand.nextInt(1000,9999);
	}
	
	public static void displayOptions()
	{
		System.out.println("__________ Select one from the below options:__________");
		System.out.println("\n1. Sell your own products");
		System.out.println("2. View products");
		System.out.println("3. Search products");
		System.out.println("4. Update products");
		System.out.println("5. Delete products");
		System.out.println("6. Purchase products");
		System.out.println("7.Logout");
	}
	
	public static SellProducts newItem()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product name");
		String name = sc.next();
		System.out.println("Enter product price");
		double price = sc.nextDouble();
		System.out.println("Enter product genre");
		String genre = sc.next();
		System.out.println("Enter product quantity available as of now");
		int quantityAvail = sc.nextInt();
		
		return new SellProducts(name, price, genre, quantityAvail);
	}
	
	public static void displayAllProducts(List<SellProducts> productList)
	{
		if(productList.isEmpty())
			System.out.println("No products found");
		else
		{
			System.out.format("%-30s %-10s %-10s %-3s", "Product", "Cost", "Genre", "Quantity");
			System.out.println("\n______________________________________________________________");
			for(SellProducts sp : productList)
			{
				System.out.format("%-30s %-10s %-10s %-3s", sp.getProductName(), sp.getPrice(), sp.getGenre(), sp.getQuantityAvail());
				System.out.println("\n______________________________________________________________");
			}
		}
	}
	
	
	public static void searchProducts(List<SellProducts> productList)
	{
		Scanner sc = new Scanner(System.in);
		boolean found = false;
		System.out.println("Dou you want to search by\n1. genre\n2. product name");
		switch(sc.nextInt())
		{
			case 1:{
				System.out.println("The genres are- Face, Nails, Skin, Hair");
				System.out.println("Enter your required genre to search products");
				String genre = sc.next();
				for(SellProducts sp : productList)
					if(sp.getGenre().equalsIgnoreCase(genre))
					{
						System.out.format("%-30s %-10s %-10s %-3s", sp.getProductName(), sp.getPrice(), sp.getGenre(), sp.getQuantityAvail());
						System.out.println("\n______________________________________________________________");
						found = true;
					}
				if(found == false)
					System.out.println("--------No products found of genre "+genre+"--------");
			}break;
			case 2:{
				System.out.println("Enter the product name to search");
				String name = sc.next();
				for(SellProducts sp : productList)
					if(sp.getProductName().equalsIgnoreCase(name))
					{
						System.out.format("%-30s %-10s %-10s %-3s", sp.getProductName(), sp.getPrice(), sp.getGenre(), sp.getQuantityAvail());
						System.out.println("\n______________________________________________________________");
						found = true;
					}
				if(found == false)
					System.out.println("--------No products found of name "+name+"--------");
			}break;
			default:System.out.println("Invalid choice");
		}
	}

	
	public static void updateProducts(List<SellProducts> productList)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Do you want to update the\n\t1. Cost\n\t2.Quantity");
		int choice = s.nextInt();
		System.out.println("Enter product name");
		String product = s.next();
		boolean found = false;
		switch(choice)
		{
			case 1:{
				System.out.println("Update price");
				double price = s.nextDouble();
				for(SellProducts sp : productList)
					if(sp.getProductName().equalsIgnoreCase(product))
					{
						sp.setPrice(price);
						found = true;
						System.out.println("--------Updated succsessfully--------");
					}
				if(found == false)
					System.out.println("No such products found of name"+product);
			}break;
			case 2:{
				System.out.println("Update quantity");
				int quant = s.nextInt();
				for(SellProducts sp : productList)
					if(sp.getProductName().equalsIgnoreCase(product))
					{
						sp.setQuantityAvail(quant);
						found = true;
						System.out.println("--------Updated succsessfully--------");
					}
				if(found == false)
					System.out.println("No products found of name "+product);
			}break;
			default:System.out.println("Invalid choice");
		}
	}

	
	public static void deleteProducts(List<SellProducts> productList, String product)
	{
		boolean found = false;
		Iterator itr = productList.iterator();
		while(itr.hasNext())
		{
			SellProducts sp = (SellProducts) itr.next();
			if(sp.getProductName().equalsIgnoreCase(product))
			{
				itr.remove();
				found = true;
				System.out.println("--------Product deleted succsessfully--------");
			}
		}
		if(found == false)
			System.out.println("--------No such products found of name"+product+"--------");
		
	}
	
	
	public static void purchaseProducts(List<SellProducts> productList)
	{
		Scanner sc = new Scanner(System.in);
		if(productList.isEmpty())
			System.out.println("--------No products found--------");
		else
		{
			System.out.println("Enter product name");
			String product = sc.next();
			System.out.println("Enter quantity you want to purchase");
			int quant = sc.nextInt();
			for(SellProducts sp : productList)
				if(sp.getProductName().equalsIgnoreCase(product))
				{
					if(sp.getQuantityAvail()>=quant)
					{
						sp.setQuantityAvail(sp.getQuantityAvail()-quant);
						System.out.println("Total amount is: "+(sp.getPrice()*quant));
						System.out.println("--------Thank you for purchasing😊--------");
					}
					else
						System.out.println("--------Product quantity available is "+sp.getQuantityAvail()+"--------");
				}
				else
					System.out.println("--------Product not found--------");
		}
		
	}
	
	
	
		
}
