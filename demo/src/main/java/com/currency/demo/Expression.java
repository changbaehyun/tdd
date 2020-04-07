package com.currency.demo;

public interface Expression {
	Money reduce(Bank bank, String to);

}
