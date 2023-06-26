package my_product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		double finalValue = 0;
		char opcao = 0;

		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:SS");
		String dataFormatada = dataAtual.format(formato);

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Digite o nome do produto.......................:");
			String name = sc.nextLine().trim();
			System.out.println("Digite o preço do produto.......................:");
			String priceStr = sc.nextLine().trim();
			double price = Double.parseDouble(priceStr);

			System.out.println("É um pagamento à vista? (S/N)");
			String resposta = sc.nextLine().trim();

			Payment payment = null;

			if (resposta.equalsIgnoreCase("S")) {
				CashPayment cashPayment = new CashPayment();
				cashPayment.value = price;
				cashPayment.discount = 0.1;
				payment = cashPayment;
			}else {
				CreditPayment creditPayment = new CreditPayment();
				creditPayment.value = price;
				payment = creditPayment;
			}

			System.out.println("Nome do Produto:" + name);
			System.out.println("Preço do Produto: R$" + payment.value);

			if (payment instanceof CashPayment) {
				double discount = payment.value * ((CashPayment) payment).discount;
				double discountValue = payment.value - discount;
				System.out.println("Valor do Produto com desconto: R$" + discountValue);
				finalValue += discountValue;
			} else {
				System.out.println("Valor do Produto: R$" + payment.value);
				finalValue += payment.value;
			}

			System.out.println("Deseja entrar com mais algum pedido (S/N)?");
			try {

				opcao = sc.nextLine().charAt(0);

			} catch (StringIndexOutOfBoundsException e) {

			}

		} while (opcao == 'S' || opcao == 's');

		System.out.println("Valor Total da Compra: R$" + finalValue);
		System.out.println("Data da Compra" + dataFormatada);

		sc.close();

	}

}
			
		


