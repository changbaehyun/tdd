package com.currency.demo;

import java.util.Hashtable;

public class Bank {
	
	private Hashtable<Object, Integer> rates = new Hashtable<>();
	
	Money reduce(Expression source, String to) {
//		if (source instanceof Money)
			return source.reduce(this,to);
//		Sum sum = (Sum) source;
//		int amount = sum.augend.amount + sum.addend.amount;
//		return new Money(amount, to);
//		return sum.reduce(to);
	}
	
	int rate (String from, String to ) {
//		return (from.equals("CHF")&&to.equals("USD"))
//				? 2
//				: 1;
		if(from.equals(to)) return 1;
		Integer	rate = (Integer) rates.get(new Pair(from, to));
		return rate.intValue();
	}

	public void addRate(String from, String to, int rate) {
		// TODO Auto-generated method stub
		rates.put(new Pair(from, to), new Integer(rate));
	}

}
