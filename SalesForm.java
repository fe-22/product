package my_product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SalesForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

    // Construtor da classe
    public SalesForm() {
        // Configuração da janela
        super("Sistema de Vendas - Formulário"); // Título da janela
        setSize(400, 300); // Tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ação ao fechar a janela
        setLayout(null); // Layout da janela

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

        // Configuração dos componentes gráficos
        labelNome.setBounds(20, 20, 120, 20); // Posição e tamanho do label nome
        textFieldNome.setBounds(150, 20, 200, 20); // Posição e tamanho do campo de texto nome
        labelPreco.setBounds(20, 60, 120, 20); // Posição e tamanho do label preço
        textFieldPreco.setBounds(150, 60, 200, 20); // Posição e tamanho do campo de texto preço
        labelPagamento.setBounds(20, 100, 120, 20); // Posição e tamanho do label pagamento
        comboBoxPagamento.setBounds(150, 100, 200, 20); // Posição e tamanho da caixa de combinação pagamento
        labelParcelas.setBounds(20, 140, 120, 20); // Posição e tamanho do label parcelas
        textFieldParcelas.setBounds(150, 140, 200, 20); // Posição e tamanho do campo de texto parcelas
        buttonFinalizar.setBounds(150, 180, 150, 30); // Posição e tamanho do botão finalizar

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

        // Adição dos listeners e handlers para os eventos dos componentes gráficos
        buttonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para finalizar a compra quando o botão for clicado

                try {
                    // Obtém os dados dos componentes gráficos
                    String nome = textFieldNome.getText();
                    double preco = Double.parseDouble(textFieldPreco.getText());
                    String pagamento = (String) comboBoxPagamento.getSelectedItem();
                    int parcelas = Integer.parseInt(textFieldParcelas.getText());

                    // Valida os dados obtidos
                    if (nome.isEmpty()) {
                        throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
                    }
                    if (preco <= 0) {
                        throw new IllegalArgumentException("O preço do produto deve ser positivo.");
                    }
                    if (pagamento.equals("Crédito") && parcelas <= 0) {
                        throw new IllegalArgumentException("O número de parcelas deve ser positivo.");
                    }

                    // Calcula o valor da parcela se for crédito
                    double valorParcela = pagamento.equals("Crédito") ? preco / parcelas : preco;

                    // Exibe uma mensagem de confirmação com os dados da compra
                    JOptionPane.showMessageDialog(SalesForm.this,
                            "Compra finalizada com sucesso!\n" +
                            "Nome do produto: " + nome + "\n" +
                            "Preço do produto: R$ " + preco + "\n" +
                            "Pagamento: " + pagamento + "\n" +
                            "Número de parcelas: " + parcelas + "\n" +
                            "Valor da parcela: R$ " + valorParcela,
                            "Confirmação",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Limpa os campos de texto
                    textFieldNome.setText("");
                    textFieldPreco.setText("");
                    textFieldParcelas.setText("");

                } catch (NumberFormatException ex) {
                    // Exibe uma mensagem de erro se os dados não forem numéricos
                    JOptionPane.showMessageDialog(SalesForm.this,
                            "Os dados devem ser numéricos.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    // Exibe uma mensagem de erro se os dados não forem válidos
                    JOptionPane.showMessageDialog(SalesForm.this,
                            ex.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

  
       


    