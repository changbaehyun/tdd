package com.currency.demo;


class Money implements Expression{

	protected int amount;
	protected String currency;
	

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	 String currency() {
		 return currency;
	 };

	static Money dollar(int amount) {
		return new Money(amount,"USD");
	}
	static Money france(int amount) {
		return new Money(amount,"CHF");
	}
	
	Money times(int multiplier) {
		return new Money(amount * multiplier, currency); 
	}	 
	public boolean equals(Object object) {
		Money monney = (Money) object;
		return amount == monney.amount
				&& currency().equals(monney.currency());
	}
	
	Money plus(Money addend) {
		return new Money(amount + addend.amount, currency);
		
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
	
}
