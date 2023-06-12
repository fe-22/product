# product
Introdução de um projeto de PDV

package my_product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = dataAtual.format(formato);
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
	
		System.out.println("1º Produto............:");
		String nome1 = sc.next();
		System.out.println("Preço do 1º Produto..........:");
		double preco1 = sc.nextDouble();
		FirstProduct P1 = new FirstProduct(nome1, preco1, preco1);
		
		
		
		System.out.println("2º Produto............:");
		String nome2 = sc.next();
		System.out.println("Preço do 2º Produto..........:");
		double preco2 = sc.nextDouble();
		FirstProduct P2 = new FirstProduct(nome2, preco2, preco2);
		
		System.out.println("Nome do Produto:" + P1.nome);
		System.out.println("Valor Unitário:" + P1.preco);
		
		System.out.println("Nome do Produto:" + P2.nome);
		System.out.println("Valor Unitário:" + P2.preco);
		
		double PrecoFinal = P1.preco + P2.preco;
		System.out.println("Valor Total da Compra:" + PrecoFinal);
		
		System.out.println("Data da compra:" + dataFormatada);
		
		sc.close();

	}

}
