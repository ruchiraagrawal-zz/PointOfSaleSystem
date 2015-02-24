package com.im.service;

import java.util.HashMap;
import java.util.Map;

import com.im.enums.Products;
import com.im.model.Product;

/**
 * 
 * @author ragrawal The below class is the main interface which a view would be
 *         connecting to
 */
public class Terminal {

	private static final String DEFAULT_CURRENCY = "$";
	/**
	 * The below hashMap represents the items with productName and count,
	 * basically its the representation of shopping cart
	 */

	Map<Product, Integer> itemsInShoppingCart = new HashMap<Product, Integer>();
	ShoppingCartService shoppingCart = new ShoppingCartService();

	/**
	 * 
	 * @param productName
	 *          Scans every item in the shopping cart and adds in the hashMap
	 */
	public void scan(String productName) {
		try {
			shoppingCart.addItem(productName, itemsInShoppingCart);
		} catch (UnsupportedOperationException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * 
	 * @return Total price of items in shopping cart Calls the shoppingCartTotal
	 *         method of ShoppingCart by passing the hashMap created by scanning
	 *         object
	 */
	public String total() {
		return DEFAULT_CURRENCY + shoppingCart.shoppingCartTotal(itemsInShoppingCart).toString();
	}

	/**
	 * 
	 * @param productName
	 * @param regularPrice
	 * @param volumePrice
	 * @param volumeQty
	 *          Below method adds new Product pricing in the hashMap
	 */
	public void setPricing(String productName, String regularPrice, String volumePrice, Integer volumeQty) {
		Products.INSTANCE.addProductToProductMap(productName, regularPrice, volumePrice, volumeQty);
	}
}
