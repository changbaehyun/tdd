package com.currency.demo;

 class Money {

	protected int amount;
	protected String currency;
	

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	 String currency() {
		 return currency;
	 };

	static Dollar dollar(int amount) {
		return new Dollar(amount,"USD");
	}
	static France france(int amount) {
		return new France(amount,"CHF");
	}
	
	Money times(int multiplier) {
		return new Money(amount * multiplier, currency); 
	}	 
	public boolean equals(Object object) {
		Money monney = (Money) object;
		return amount == monney.amount
				&& currency().equals(monney.currency());
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
	
}
