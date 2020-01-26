package net.franckbenault.jodamoney;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.money.format.MoneyFormatterBuilder;

public class Main {

	public static void main(String[] args) {
		  // create a monetary value
		  Money money = Money.parse("EUR 23.87");
		  System.out.println("money "+ money);
		  
		  // add another amount with safe double conversion
		  CurrencyUnit usd = CurrencyUnit.ofNumericCode("978");
		  money = money.plus(Money.of(usd, 12.43d));
		  
		  // subtracts an amount in dollars
		  money = money.minusMajor(2);
		  
		  // multiplies by 3.5 with rounding
		  money = money.multipliedBy(3.5d, RoundingMode.DOWN);
		  
		  System.out.println("money "+ money);
		  
		  String formatAmount = new MoneyFormatterBuilder().
	               appendAmountLocalized(). 
	               appendCurrencySymbolLocalized().
	               toFormatter().
	               withLocale(new Locale("en", "GB")).
	               print(Money.of(CurrencyUnit.GBP, 12.23));

		System.out.println(formatAmount);
		
		 formatAmount = new MoneyFormatterBuilder().
	               appendAmountLocalized(). 
	               appendCurrencySymbolLocalized().
	               toFormatter().
	               withLocale(new Locale("es", "ES")).
	               print(Money.of(CurrencyUnit.EUR, 12.23));

		System.out.print(formatAmount);
		  


	}

}
