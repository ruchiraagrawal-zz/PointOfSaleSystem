package com.im.main;

import java.util.Scanner;
import com.im.enums.Products;
import com.im.service.Terminal;

/**
 * 
 * @author ragrawal The below class has a main method which accepts all the
 *         items and then based on charArray the terminal scans and prints the
 *         total This class is just created to run from the command line In
 *         ideal case each product would be scanned by the terminal
 */

public class PointOfSale {

	public static void main(String[] args) {
		Terminal terminal = new Terminal();
		setPricing(terminal);
		terminal = getItemsToBeScanned(terminal, "");
		System.out.println("The total is: " + terminal.total());
	}

	private static Terminal getItemsToBeScanned(Terminal terminal, String input) {
		System.out.println("Enter item in your shopping cart (enter exit to stop adding): ");
		if (!"exit".equalsIgnoreCase(input)) {
			Scanner scanner = new Scanner(System.in);
			input = scanner.next();
			try {
				if (input.equalsIgnoreCase("exit")) {
					return terminal;
				}
				terminal.scan(input);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			getItemsToBeScanned(terminal, input);

		}
		return terminal;
	}

	public static void setPricing(Terminal terminal) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product name:");
		String productName = scanner.next();
		System.out.println("Enter regular price:");
		String regularPrice = scanner.next();
		System.out.println("Enter volume price (enter 0 if it's not to be sold in volume):");
		String volumePrice = scanner.next();
		System.out.println("Enter volume quantity (enter 0 if it's not to be sold in volume):");
		Integer volumeQuantity = Integer.parseInt(scanner.next());

		terminal.setPricing(productName, regularPrice, volumePrice, volumeQuantity);

		getDecisionToAddNewPricing(terminal, scanner);

	}

	private static void getDecisionToAddNewPricing(Terminal terminal, Scanner scanner) {
		System.out.println("Any more items to add (yes/no):");
		String decision = scanner.next();
		if (decision.equalsIgnoreCase("yes")) {
			setPricing(terminal);
		} else if (decision.equalsIgnoreCase("no")) {
			return;
		} else {
			getDecisionToAddNewPricing(terminal, scanner);
		}
	}

}
