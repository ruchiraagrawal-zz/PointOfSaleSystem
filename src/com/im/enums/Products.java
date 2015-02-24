package com.im.enums;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import com.im.model.Price;
import com.im.model.Product;

/**
 * 
 * @author ragrawal The below class is used to create a static products HashMap.
 *         This would be replaced with the actual data coming from DB.
 *
 */

public enum Products {

	INSTANCE;
	Map<String, Product> productsMap = new HashMap<String, Product>();

	/**
	 * This is made private so that no other object instantiates it
	 */

	private Products() {
	}

	/**
	 * 
	 * @param productName
	 * @return Product object from the productsMap
	 */
	public Product getProduct(String productName) {
		return productsMap.get(productName.toLowerCase());
	}

	public void addProductToProductMap(String productName, String regularPrice, String volumePrice, Integer volumeQty) {
		Price price = new Price(new BigDecimal(regularPrice), new BigDecimal(volumePrice), volumeQty);
		boolean hasVolumePrice = false;
		if (volumeQty > 0 && volumePrice != null) {
			hasVolumePrice = true;
		}
		productsMap.put(productName.toLowerCase(), new Product(productName, price, hasVolumePrice));
	}
}