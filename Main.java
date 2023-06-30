package my_product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {
	
	private static double calcularValorParcela(double valorTotal, int numParcelas) {
		return valorTotal / numParcelas;
	}

	public static void main(String[] args) {
		
		SalesForm formulario = new SalesForm();
		formulario.setVisible(true);
    


		double finalValue = 0;
		char opcao = 0;
		int numParcelas = 0;

		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:SS");
		String dataFormatada = dataAtual.format(formato);

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("-----------Sistema de Venda-------------");
		
	
		
		List<String>produtosComprados = new ArrayList<>();
		
		
	    String resposta;

		do {
			System.out.println("Digite o nome do Produto..................:");
			String name = sc.nextLine().trim();
			System.out.println("Digite o preço do produto..................:");
			String priceStr = sc.nextLine().trim();
			double price = Double.parseDouble(priceStr);

			System.out.println("É um pagamento á vista? (S/N)");
			resposta = sc.nextLine().trim();

			Payment payment = null;

			if (resposta.equalsIgnoreCase("S")) {
				CashPayment cashPayment = new CashPayment();
				cashPayment.value = price;
				cashPayment.discount = 0.10;
				payment = cashPayment;
			} else {
				System.out.println("Digite o numero de parcelas...............:");
				String parcelasStr = sc.nextLine().trim();
				numParcelas = Integer.parseInt(parcelasStr);
				CreditPayment creditPayment = new CreditPayment();
				creditPayment.value = price;
				payment = creditPayment;
			}
			if(payment instanceof CreditPayment) {
				double parcela = calcularValorParcela(payment.value, numParcelas);
				System.out.println("Numero de parcelas" + numParcelas);
				System.out.println("Valor da parcela R$" + parcela);
			}
		

			System.out.println("Nome do produto:" + name);
			System.out.println("Preço do produto: R$" + payment.value);

			if (payment instanceof CashPayment) {
				double discount = payment.value * ((CashPayment) payment).discount;
				double discountValue = payment.value - discount;

				System.out.println("Valor do produto com desconto: R$" + discountValue);
				finalValue += discountValue;
			} else {
				System.out.println("Valor do produto: R$" + payment.value);
				finalValue += payment.value;
			}

			System.out.println("Deseja entra com mais algum produto(S/N)?");

			try {
				opcao = sc.nextLine().charAt(0);
			} catch (StringIndexOutOfBoundsException e) {

			}
		} while (opcao == 'S' || opcao == 's');
		
        System.out.println("\n------Resumo da Compra-----------");
        
    	for(String produto : produtosComprados) {
			System.out.println(produto);
		}
    	
    

        System.out.println("\nProdutos Comprados:");
		System.out.println("Valor total da compra: R$" + finalValue);
		
	
		System.out.println("Data da compra:" + dataFormatada);
		
		

		sc.close();

	}

}
			
		


