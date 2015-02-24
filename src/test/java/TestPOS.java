package test.java;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.im.enums.Products;
import com.im.service.Terminal;

public class TestPOS {
	Terminal terminal = null;

	@Before
	public void beforeClass() {
		terminal = new Terminal();
		terminal.setPricing("A", "2.00", "7.00", 4);
		terminal.setPricing("B", "12.00", "0", 0);
		terminal.setPricing("C", "1.25", "6.00", 6);
		terminal.setPricing("D", "0.15", "0", 0);
	}

	@Test
	public void testSetPricing() {
		terminal.setPricing("R", "13.00", "15.00", 2);
		assertNotNull(Products.INSTANCE.getProduct("R"));
	}

	@Test
	public void testProductNotExists() {
		assertNull(Products.INSTANCE.getProduct("R"));
	}

	@Test
	public void testMultipleOccurenceOfAProduct() {
		// ABCDABAA
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("A");
		terminal.scan("A");

		assertEquals("$" + new BigDecimal("32.40").toString(), terminal.total());
	}

	@Test
	public void testSameProducts() {
		// CCCCCCC
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");

		assertEquals("$" + new BigDecimal("7.25").toString(), terminal.total());
	}

	@Test
	public void testAllDifferentProdcut() {
		// ABCD
		Terminal terminal = new Terminal();
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");

		assertEquals("$" + new BigDecimal("15.40").toString(), terminal.total());
	}

	@Test
	public void testIfProductNotExists() {
		// ABCD
		Terminal terminal = new Terminal();
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		terminal.scan("P");
		terminal.scan("Q");

		assertEquals("$" + new BigDecimal("15.40").toString(), terminal.total());
	}

}
