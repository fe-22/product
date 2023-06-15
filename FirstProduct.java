package my_product;



public class FirstProduct {

	String nome;
	double preco;
	double taxaDeDesconto;


	
	public FirstProduct(String nome, double preco, double taxaDeDesconto ) {
	
		this.nome = nome;
		this.preco = preco;
		this.taxaDeDesconto = taxaDeDesconto;
		
		
		}
	
	public double precoComDesconto() {
		return preco * (1-taxaDeDesconto);
	}
	
	public double valorFinal() {
		return precoComDesconto();
	}
	
}
	

