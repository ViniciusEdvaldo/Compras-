package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import model.Mercado;
import model.ModeloTabelaProduto;
import model.ModeloTabelaValorTotal;

import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class Caixa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codProdutoRemover;
	private JTextField codProdutoAdd;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caixa frame = new Caixa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Caixa() {
		
		Mercado mercado = new Mercado();  //instancia de mercado para puxar seus metodos.
		
		ModeloTabelaProduto modeloTabelaProdutos = new ModeloTabelaProduto(Mercado.getListaCompra());  //instancia do modelo da tabela de produtos para setar como modelo para aparecer na tela
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Caixa.class.getResource("/imagens/Sebuy.png")));
		lblNewLabel_1.setBounds(354, -32, 617, 197);
		contentPane.add(lblNewLabel_1);
		
		codProdutoRemover = new JTextField();
		codProdutoRemover.setBounds(78, 251, 149, 20);
		contentPane.add(codProdutoRemover);
		codProdutoRemover.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("REMOVER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 229, 144, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("C / PRODUTO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(89, 152, 127, 14);
		contentPane.add(lblNewLabel_2);
		
		codProdutoAdd = new JTextField();
		codProdutoAdd.setBounds(78, 176, 149, 20);
		contentPane.add(codProdutoAdd);
		codProdutoAdd.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(503, 147, 276, 303);
		contentPane.add(scrollPane);
		
		JTable tableListaCompra = new JTable();
		scrollPane.setViewportView(tableListaCompra);
		tableListaCompra.setModel(modeloTabelaProdutos);
		
		JButton bFinalizarCompra = new JButton("Finalizar Compra");
		bFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!mercado.getListaCompra().isEmpty()) {
					FormaDePagamento formaPagamento = new FormaDePagamento();
					formaPagamento.setVisible(true);
					formaPagamento.setLocationRelativeTo(bFinalizarCompra);
					dispose();
				}else {
					JOptionPane.showMessageDialog(bFinalizarCompra, "A lista deve ter pelo menos um item!");
				}
			}
		});
		bFinalizarCompra.setForeground(new Color(0, 0, 0));
		bFinalizarCompra.setBackground(SystemColor.control);
		bFinalizarCompra.setFont(new Font("Tahoma", Font.BOLD, 11));
		bFinalizarCompra.setBounds(122, 388, 185, 23);
		contentPane.add(bFinalizarCompra);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(79, 312, 286, 47);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"VALOR TOTAL:"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton bAdicionar = new JButton("Adicionar");
		bAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//botao de adicionar um produto a compra.
				
				List<Double> valores = new ArrayList<Double>();  //instancia de um array<Double> para servir de modelo para a tabela de valor total.
				
				valores.add(mercado.adicionarACompra(Integer.parseInt(codProdutoAdd.getText())));  //adiciona o valor do novo produto ao valor total...
																			//ao mesmo tempo que soma ao valor antigo.
				
				ModeloTabelaValorTotal modeloTabelaValor = new ModeloTabelaValorTotal(valores);  //cria o modelo a ser usado na tabela passando a lista...
																					//de valores como parametro, para ja pegar o valor.

				table_1 = new JTable();  //cria a tabela dentro do proprio botao pra ele ser atualizado sempre que um produto for adicionado.
				
				table_1.setModel(modeloTabelaValor);  //seleciona o modelo que a tabela usara para exibir as informações.
				scrollPane_1.setViewportView(table_1);  //faz a tabela ficar visivel no scrollPane
				scrollPane.setViewportView(tableListaCompra);

				
				codProdutoAdd.setText(null);  //faz com que o campo se limpe apos o produto ser adicionado a compra.
					
			}
		});
		
		JButton bRemover = new JButton("Remover ");
		bRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		bRemover.setBackground(SystemColor.activeCaptionBorder);
		bRemover.setForeground(new Color(0, 0, 0));
		bRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//botao de remover um produto da compra.
				
				List<Double> valores = new ArrayList<Double>();  //instancia de um array<Double> para servir de modelo para a tabela de valor total.
				
				
				valores.add(mercado.removerDaCompra(Integer.parseInt(codProdutoRemover.getText())));  //retira o valor do novo produto ao valor total. ao mesmo tempo que subtrai do valor antigo.
				
				ModeloTabelaValorTotal modeloTabelaValor = new ModeloTabelaValorTotal(valores);  //cria o modelo a ser usado na tabela passando a lista...
																					//de valores como parametro, para ja pegar o valor.

				table_1 = new JTable();  //cria a tabela dentro do proprio botao pra ele ser atualizado sempre que um produto for adicionado.
				
				table_1.setModel(modeloTabelaValor);  //seleciona o modelo que a tabela usara para exibir as informações.
				scrollPane_1.setViewportView(table_1);  //faz a tabela ficar visivel no scrollPane
				scrollPane.setViewportView(tableListaCompra);

				
				codProdutoRemover.setText(null);  //faz com que o campo se limpe apos o produto ser adicionado a compra.
				
				
			}
		});
		bRemover.setBounds(237, 249, 128, 23);
		contentPane.add(bRemover);
		
		bAdicionar.setBackground(SystemColor.activeCaptionBorder);
		bAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		bAdicionar.setBounds(237, 175, 128, 21);
		contentPane.add(bAdicionar);
	}
}
