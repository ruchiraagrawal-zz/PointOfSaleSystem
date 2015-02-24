package com.im.model;

import java.math.BigDecimal;

/**
 * 
 * @author ragrawal Price class represents the price model for Product object
 *         Price can be perUnit or perVolume This is a POJO and this would be an
 *         attribute of Product object The below class can be extended if prices
 *         are required by weight in the later stages
 */
public class Price {

	public BigDecimal regularPrice; // price Per Unit
	public BigDecimal volumePrice; // price per Volume
	public Integer volumeQuantity; // size of Volume

	/**
	 * 
	 * @param regularPrice
	 * @param volumePrice
	 * @param volumeQuantity
	 *          Constructor for Price with the above set attributes
	 */
	public Price(BigDecimal regularPrice, BigDecimal volumePrice, Integer volumeQuantity) {
		this.regularPrice = regularPrice;
		this.volumePrice = volumePrice;
		this.volumeQuantity = volumeQuantity;
	}

	public BigDecimal getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(BigDecimal regularPrice) {
		this.regularPrice = regularPrice;
	}

	public BigDecimal getVolumePrice() {
		return volumePrice;
	}

	public void setVolumePrice(BigDecimal volumePrice) {
		this.volumePrice = volumePrice;
	}

	public Integer getVolumeQuantity() {
		return volumeQuantity;
	}

	public void setVolumeQuantity(Integer volumeQuantity) {
		this.volumeQuantity = volumeQuantity;
	}

}
