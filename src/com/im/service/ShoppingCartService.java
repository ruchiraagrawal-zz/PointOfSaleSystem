package com.im.service;

import java.math.BigDecimal;
import java.util.Map;

import com.im.enums.Products;
import com.im.model.Product;

/**
 * 
 * @author ragrawal Below class is the representation of shoppingCart Service
 *         class This class does the operation of adding scanned items and
 *         getting a total
 */
public class ShoppingCartService {

	private static final int DEFAULT_COUNT = 1;

	/**
	 * 
	 * @param productName
	 * @param itemsInCart
	 *          It takes in productName and itemsInCart hashMap and then checks if
	 *          item exists in hashMap then increment the count else simply adds
	 *          the product and default count=1 in hashMap
	 */
	public void addItem(String productName, Map<Product, Integer> itemsInCart) throws UnsupportedOperationException {
		Product product = Products.INSTANCE.getProduct(productName);
		// The below exception is thrown to gracefully handle the scenario if
		// product does not exist in the store
		if (product == null) {
			throw new UnsupportedOperationException("Product " + productName + " is not in our store");
		}
		if (itemsInCart.containsKey(product)) {
			itemsInCart.put(product, itemsInCart.get(product) + 1);
		} else {
			itemsInCart.put(product, DEFAULT_COUNT);
		}
	}

	/**
	 * 
	 * @param itemsInShoppingCart
	 * @return Total of all the shopping cart Items This method checks if a
	 *         product is attributed as volumePrice=true, then it considers volume
	 *         price to be taken in account else it simply calculates price using
	 *         per unit price or regular price
	 */
	public BigDecimal shoppingCartTotal(Map<Product, Integer> itemsInShoppingCart) {
		BigDecimal total = BigDecimal.ZERO;
		if (itemsInShoppingCart != null) {
			for (Product product : itemsInShoppingCart.keySet()) {
				int countOfProduct = itemsInShoppingCart.containsKey(product) ? itemsInShoppingCart.get(product) : 0;
				if (product.isVolumePrice()) {
					BigDecimal priceForBulk = product.getPrice().getVolumePrice().multiply(new BigDecimal(countOfProduct / product.getPrice().getVolumeQuantity()));
					BigDecimal priceForUnits = product.getPrice().getRegularPrice().multiply(new BigDecimal(countOfProduct % product.getPrice().getVolumeQuantity()));
					total = priceForBulk.add(priceForUnits).add(total);
				} else {
					total = product.getPrice().getRegularPrice().multiply(new BigDecimal(countOfProduct)).add(total);
				}
			}
		}
		return total;
	}

}
