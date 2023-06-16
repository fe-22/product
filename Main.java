package my_product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import my_product.FirstProduct;

public class Main {

	public static void main(String[] args) {
		
		
		
		
		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = dataAtual.format(formato);
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double precoFinal = 0;
		char opcao;
		
		do {
			
			System.out.println("Digite o produto...........:");
			String nome = sc.next();
			System.out.println("Digite o preço do produto............:");
			double preco = sc.nextDouble();
			FirstProduct p = new FirstProduct(nome, preco, 0.1);
			
			System.out.println("Nome do produto:" + p.nome);
			System.out.println("Preço do produto:" + p.preco);
			System.out.println("Valor com desconto:" + p.precoComDesconto());
			
			precoFinal += p.precoComDesconto();
			
			System.out.println("Deseja entrar com mais pedido (S/N)?");
			opcao = sc.next().charAt(0);
		}while(opcao == 'S'|| opcao == 's');
		
		System.out.println("Valor total da compra:" + "R$" + precoFinal);
		
		System.out.println("Data da compra:" + dataFormatada);
		
		
			sc.close();
		
		
	}
	
}
		
          
