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
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:SS");
		String dataFormatada = dataAtual.format(formato);

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Digite o nome do produto.........................:");
			String name = sc.nextLine().trim();
			System.out.println("Digite o preço do produto.........................:");
			String precoStr = sc.nextLine().trim();
			double price = Double.parseDouble(precoStr);
			FirstProduct P = new FirstProduct(name, price, 10);

			System.out.println("Nome do produto:" + P.name);
			System.out.println("Preço do produto:" + "R$" + P.price);
			System.out.println("Valor com desconto:" + "R$" + P.discontePrice);

			finalValue += P.discontePrice;

			System.out.println("Deseja entrar com mais pedidos (S/N)?");
			try {

				opcao = sc.nextLine().charAt(0);
			} catch (StringIndexOutOfBoundsException e) {
				

			}

		} while (opcao == 'S' || opcao == 's');

		System.out.println("Valor total da compra:" + "R$" + finalValue);
		System.out.println("Data da compra:" + dataFormatada);

		sc.close();

	}

}
			
		


