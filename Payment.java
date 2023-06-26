package my_product;

public class Payment {
	
	double value;

}

class CashPayment extends Payment{
	String type = "À vista";
	double discount;
			
}

class CreditPayment extends Payment{
	String tipo = "Crédito";
	int installments;
}
