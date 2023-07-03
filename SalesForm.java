package my_product;

// Importação das classes necessárias
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.lang.Double; // Importação da classe Double
import java.lang.Integer; // Importação da classe Integer
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;

public class SalesForm extends JFrame {

	// Declaração dos componentes gráficos
	private JLabel labelNome;
	private JLabel labelPreco;
	private JLabel labelPagamento;
	private JLabel labelParcelas;
	private JTextField textFieldNome;
	private JTextField textFieldPreco;
	private JTextField textFieldParcelas;
	private JComboBox<String> comboBoxPagamento;
	private JButton buttonFinalizar;

	private List<FirstProduct> produtos; // Declaração da lista de produtos
	private DefaultListModel<String> modelProdutos;
	
	// Construtor da classe
	public SalesForm() {
    	
        // Configuração da janela
        super("Sistema de Vendas - Formulário"); // Título da janela
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        setBounds(0,0,dim.width,dim.height); // Posição e tamanho da janela
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ação ao fechar a janela
        
        setLayout(null); // Define o layout da janela como nulo

        // Inicialização da lista de produtos
        produtos = new ArrayList<>(); // Usa o operador de atribuição para inicializar a lista
        modelProdutos = new DefaultListModel<>();

        // Criação dos componentes gráficos
        labelNome = new JLabel("Nome do Produto:");
        
        labelPreco = new JLabel("Preço do Produto:");
        
        labelPagamento = new JLabel("Pagamento:");
        
        labelParcelas = new JLabel("Número de Parcelas:");
        
        textFieldNome = new JTextField();
        
        textFieldPreco = new JTextField();
        
        textFieldParcelas = new JTextField();
        
        comboBoxPagamento = new JComboBox<>(new String[] {"À vista", "Crédito"});
        
        buttonFinalizar = new JButton("Finalizar Compra");
       
        
      //criação do componente grafico JList
        JList<String>listProdutos = new JList<>();
        
        // criação do modelo de dados DefaultListModel
        DefaultListModel<String>ModelProdutos = new DefaultListModel<String>();
        
        //Associação do modelo de dados à instância de classe JList
        listProdutos.setModel(ModelProdutos);
        
        //criação do componente gráfico JChecKBox
        JCheckBox checkBoxFinalizar = new JCheckBox("Finalizar Compra");

        // Configuração dos componentes gráficos
        labelNome.setBounds(10, 20, 120, 20); // Posição e tamanho do label nome
        
        textFieldNome.setBounds(150, 20, 200, 20); // Posição e tamanho do campo de texto nome
        
        labelPreco.setBounds(20, 60, 120, 20); // Posição e tamanho do label preço
        
        textFieldPreco.setBounds(150, 60, 200, 20); // Posição e tamanho do campo de texto preço
        
        labelPagamento.setBounds(20, 100, 120, 20); // Posição e tamanho do label pagamento
        
        comboBoxPagamento.setBounds(150, 100, 200, 20); // Posição e tamanho da caixa de combinação pagamento
        
        labelParcelas.setBounds(20, 140, 120, 20); // Posição e tamanho do label parcelas
        
        textFieldParcelas.setBounds(150, 140, 200, 20); // Posição e tamanho do campo de texto parcelas
        
        buttonFinalizar.setBounds(150, 180, 150, 30); // Posição e tamanho do botão finalizar
        
        
        //Configuração do componente gráfico JList
        listProdutos.setBounds(400,20,300,300);//Posição do tamanho da lista na janela
        listProdutos.setVisible(true);//Define a lista como visível
        
        //Configuração do componente gráfico JCheckBox
        checkBoxFinalizar.setBounds(150,220,150,30);//Posição e tamanho do checkBox na janela
        checkBoxFinalizar.setVisible(true);
        
     
        // Adição dos componentes gráficos na janela
        add(labelNome);
        add(textFieldNome);
        add(labelPreco);
        add(textFieldPreco);
        add(labelPagamento);
        add(comboBoxPagamento);
        add(labelParcelas);
        add(textFieldParcelas);
        add(buttonFinalizar);
        add(listProdutos);
        add(checkBoxFinalizar);

        setVisible(true); // Define a janela como visível

        // Adição dos listeners e handlers para os eventos dos componentes gráficos
       buttonFinalizar.addActionListener(new ActionListener() {
    	   
       
    	   
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para finalizar a compra quando o botão for clicado

                try {
                    // Obtém os dados dos componentes gráficos
                    String nome = textFieldNome.getText();
                    double preco = Double.parseDouble(textFieldPreco.getText()); // Usa o método parseDouble da classe Double
                    String pagamento = (String) comboBoxPagamento.getSelectedItem(); // Faz um cast para String no objeto retornado pelo método getSelectedItem
                    int parcelas = Integer.parseInt(textFieldParcelas.getText()); // Usa o método parseInt da classe Integer

                    // Cria um objeto da classe FirstProduct com os dados obtidos
                    FirstProduct produto = new FirstProduct(nome, preco, pagamento, parcelas);

                    // Adiciona o objeto na lista de produtos
                    produtos.add(produto); // Usa o método add da lista para adicionar o objeto
                    
                    //adiciona o nome do produto no modelo de dados da lista gráfica
                    ModelProdutos.addElement(produto.getNome());
                    

                    // Mostra uma mensagem de confirmação com os dados da compra
                    JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!\n" +
                    "Nome do produto: " + produto.getNome() + "\n" +
                    "Preço do produto: R$ " + produto.getPreco() + "\n" +
                    "Pagamento: " + produto.getPagamento() + "\n" +
                    "Número de parcelas: " + produto.getParcelas()); // Usa os atributos do objeto produto para mostrar os dados da compra

                } catch (NumberFormatException ex) {
                    // Mostra uma mensagem de erro se algum dado não for válido
                    JOptionPane.showMessageDialog(null, "Dados inválidos. Por favor, digite valores numéricos para o preço e o número de parcelas.");
                }
            }
        });
    
                        //Adição do listener e do handler para o evento do checkbox
                  checkBoxFinalizar.addActionListener(new ActionListener() {
                	  
                  
                  @Override
                    public void actionPerformed(ActionEvent e) {
                	  
                  
     // Lógica para finalizar a compra quando o checkbox for marcado

     // Verifica se o checkbox está marcado
     if (checkBoxFinalizar.isSelected()) {
    	 
     
         // Calcula o preço final da compra com desconto ou parcelas
         double precoFinal = 0;
         
         for (FirstProduct p : produtos) { // Percorre a lista de produtos
             if (p.getPagamento().equals("À vista")) { // Se o pagamento for à vista, aplica um desconto de 10%
                 precoFinal += p.getPreco() * 0.9;
                 
             } else { // Se o pagamento for a crédito, divide o preço pelo número de parcelas
                 precoFinal += p.getPreco() / p.getParcelas();
             }
         }

         // Mostra uma mensagem com o resultado da compra
         JOptionPane.showMessageDialog(null, "Compra finalizada com sucesso!\n" +
         "Produtos comprados: " + produtos.size() + "\n" +
         "Preço final: R$ " + precoFinal);

         // Limpa os componentes gráficos e as listas de produtos
         textFieldNome.setText("");
         textFieldPreco.setText("");
         textFieldParcelas.setText("");
         comboBoxPagamento.setSelectedIndex(0);
         checkBoxFinalizar.setSelected(false);
         produtos.clear();
         modelProdutos.clear();
            }
     
        }
                  
    });
                  
	}
	
}
 
