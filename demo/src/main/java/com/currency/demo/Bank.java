package com.currency.demo;


public class Bank {
	Money reduce(Expression source, String to) {
//		if (source instanceof Money)
			return source.reduce(to);
//		Sum sum = (Sum) source;
//		int amount = sum.augend.amount + sum.addend.amount;
//		return new Money(amount, to);
//		return sum.reduce(to);
	}

}
