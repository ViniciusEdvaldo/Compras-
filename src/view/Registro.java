package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.Mercado;
import model.ModeloTabelaProduto;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		
		Mercado mercado = new Mercado();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(21, 138, 255));
		contentPane.setForeground(new Color(21, 138, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bRegistroProduto = new JLabel("Registro");
		bRegistroProduto.setForeground(new Color(255, 255, 255));
		bRegistroProduto.setFont(new Font("Tahoma", Font.BOLD, 90));
		bRegistroProduto.setBounds(32, 12, 456, 136);
		contentPane.add(bRegistroProduto);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(350, 162, 509, 216);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Valor", "ID"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeloTabelaProduto modeloTabelaProduto= new ModeloTabelaProduto(mercado.getListaAdicionados());
				
				if(textField.getText() != null && !textField.getText().isEmpty()) {
					if(textField_1.getText() != null && !textField_1.getText().isEmpty()) {
						 if(mercado.registrarProduto(textField.getText(), textField_1.getText()) == true) {
							 table = new JTable();
							table.setModel(modeloTabelaProduto);
							scrollPane.setViewportView(table);
							 JOptionPane.showMessageDialog(btnNewButton_1, "Produto adicionado!");
						 }else
							 JOptionPane.showMessageDialog(btnNewButton_1, "falha ao adicionar produto!\nProduto ja existe no sistema!");
						 
					}else {
						JOptionPane.showMessageDialog(btnNewButton_1, "Informe um preço ao produto!");
					}
				}else {
					JOptionPane.showMessageDialog(btnNewButton_1, "Informe um nome ao produto");
				}
				
				
			
				
			}
		});
		
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(32, 285, 94, 23);
		contentPane.add(btnNewButton_1);
		
		JButton bRemoverProduto = new JButton("Remover");
		bRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeloTabelaProduto modeloTabelaProduto= new ModeloTabelaProduto(mercado.getListaAdicionados());
				if(textField.getText() != null && !textField.getText().isEmpty()) {
					if(mercado.removerProduto(textField.getText()) == true)
						JOptionPane.showMessageDialog(bRemoverProduto,  "Produto " + textField.getText() + " removido!");
					else 
						JOptionPane.showMessageDialog(bRemoverProduto, "Falha ao remover!");
		  			table = new JTable();
					table.setModel(modeloTabelaProduto);
					scrollPane.setViewportView(table);
				}else {
					JOptionPane.showMessageDialog(bRemoverProduto, "Infrome o nome do produto!");
				}
			}
		});
		
		bRemoverProduto.setForeground(new Color(0, 0, 0));
		bRemoverProduto.setBackground(new Color(255, 255, 255));
		bRemoverProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		bRemoverProduto.setBounds(154, 285, 94, 23);
		contentPane.add(bRemoverProduto);
		
		textField = new JTextField();
		textField.setBounds(32, 159, 219, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(32, 227, 219, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(32, 206, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(32, 134, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(379, 459, 109, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JPrincipal c = new JPrincipal(); 
			        c.setVisible(true);
			        dispose();
			}
		});
		
	}

}
