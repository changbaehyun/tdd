package com.currency.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DollarTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	@Test
	public void testMultiplication() {
//		Dollar five = new Dollar(5);
//		Dollar product = five.times(2);
		//five.times(2);
//		assertEquals(10, product.amount);
//		product=five.times(3);
//		assertEquals(15, product.amount);
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}
	
	@Test
	public void testFranceMultiplication() {
		Money five = Money.france(5);
		assertEquals(Money.france(10), five.times(2));
		assertEquals(Money.france(15), five.times(3));
	}
	
	@Test
	public void testEqulity() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.france(5).equals(Money.dollar(5)));
	}

	@Test
	public void testCurrency() {
		assertEquals("USD",Money.dollar(10).currency());
		assertEquals("CHF",Money.france(10).currency());
	}
	
	@Test
	public void testDifferentClassEquality() {
		assertTrue(new Money(10, "CHF").equals(new France(10, "CHF")));
	}
	
	@Test
	public void testSimpleAddition() {
//		Money sum= Money.dollar(5).plus(Money.dollar(5));
//		assertEquals(Money.dollar(10), sum);
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum,"USD");
		assertEquals(Money.dollar(10), reduced);
		
	}
	
	@Test
	public void testPlusReturnSum() {
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum)result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
	}
	
	@Test
	public void testReduceSum() {
		Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(7), result);
	}
	@Test
	public void testReduceMoney() {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(1), "USD");
		assertEquals(Money.dollar(1), result);
	}
	
	@Test
	public void testReduceMoneyDifferentCurrency() {
		Bank bank = new Bank();
		bank.addRate("CHF","USD",2);
		Money result = bank.reduce(Money.france(2), "USD");
		assertEquals(Money.dollar(1), result);
	}
	@Test
	public void testIdentityRate() {
		assertEquals(1, new Bank().rate("USD", "USD"));
	}
	
	@Test
	public void testMixedAddition() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.france(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(Money.dollar(10), result);
	}
	
	@Test
	public void testSumPlusMoney() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrance = Money.france(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrance).plus(fiveBucks);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(15), result);
		
	}
	
	@Test
	public void testSumTimes() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrance = Money.france(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrance).times(2);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(20), result);	
	}
/*	
	@Test
	public void testPlusSameCurrencyReturnsMoney() {
		Expression sum = Money.dollar(1).plus(Money.dollar(1));
		assertTrue(sum instanceof Money);
	}
	*/
}
