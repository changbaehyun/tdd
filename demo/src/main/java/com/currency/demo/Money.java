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
	
	public Expression times(int multiplier) {
		return new Money(amount * multiplier, currency); 
	}	 
	public boolean equals(Object object) {
		Money monney = (Money) object;
		return amount == monney.amount
				&& currency().equals(monney.currency());
	}
	
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
		
	}
	
	public Money reduce(Bank bank, String to) {
//		return this;
//		int rate  = (currency.equals("CHF") && to.equals("USD"))
//				? 2
//				: 1 ;
		int rate  =  bank.rate(currency, to);
		return new Money (amount / rate, to);
		
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
	
}
