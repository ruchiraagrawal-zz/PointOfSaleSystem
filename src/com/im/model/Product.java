package com.im.model;

import java.util.UUID;

/**
 * 
 * @author ragrawal Product represents the product object of a POS system It has
 *         a UUID which would differentiate every product in database (later on)
 *         It has Price object as an attribute
 */
public class Product {

	public String productName;
	public String productUuid;
	public Price price;
	public boolean volumePrice = false; // This attribute determines if a product
																			// is sold in bulk

	/**
	 * 
	 * @param productName
	 * @param price
	 * @param volumePrice
	 *          The below constructor returns a Product Object with productName,
	 *          price, volumPrice being set And productUUID is created using
	 *          Java's UUID utitlity to create a unique identifier
	 */
	public Product(String productName, Price price, boolean volumePrice) {
		this.productName = productName;
		this.price = price;
		this.volumePrice = volumePrice;
		productUuid = UUID.randomUUID().toString();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductUuid() {
		return productUuid;
	}

	public void setProductUuid(String productUuid) {
		this.productUuid = productUuid;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public boolean isVolumePrice() {
		return volumePrice;
	}

	public void setVolumePrice(boolean volumePrice) {
		this.volumePrice = volumePrice;
	}

	/**
	 * HashCode and Equals has been overidden so that when we do hash operations
	 * we get the correct Product objects everytime
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productUuid == null) ? 0 : productUuid.hashCode());
		return result;
	}

	/**
	 * The Equals method has been overriden so that we get the correct object from
	 * hashMap everytime
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productUuid == null) {
			if (other.productUuid != null)
				return false;
		} else if (!productUuid.equals(other.productUuid))
			return false;
		return true;
	}

}
