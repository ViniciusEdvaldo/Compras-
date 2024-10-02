package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class JPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
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
	public JPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
	
		
		JButton bCadastrados = new JButton("Cadastrados");
		bCadastrados.setBackground(SystemColor.control);
		bCadastrados.setForeground(new Color(0, 0, 0));
		bCadastrados.setFont(new Font("Tahoma", Font.BOLD, 13));
		bCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastrados c = new Cadastrados();
				c.setVisible(true);
				dispose();
			}
		});
		bCadastrados.setBounds(547, 275, 125, 35);
		contentPane.add(bCadastrados);
		
		JLabel lblNewLabel_1 = new JLabel("O melhor sistema de supermecado da região!!!!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(184, 354, 463, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(JPrincipal.class.getResource("/imagens/carrinho-virado2 (1).png")));
		lblNewLabel.setBounds(-168, 302, 380, 254);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(JPrincipal.class.getResource("/imagens/bem vindo2.png")));
		lblNewLabel_2.setBounds(86, -32, 703, 314);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(JPrincipal.class.getResource("/imagens/carrinho-virado2 (1).png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(627, -53, 400, 264);
		contentPane.add(lblNewLabel_3);
		
		JButton bVoltar = new JButton("Voltar");
		bVoltar.setBackground(SystemColor.control);
		bVoltar.setBounds(367, 460, 99, 23);
		contentPane.add(bVoltar);
		bVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				jlogin j = new jlogin();
				
				j.setLocationRelativeTo(bVoltar);
				
				j.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Caixa");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setBounds(356, 275, 125, 35);
		contentPane.add(btnNewButton_1);	
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Caixa c = new view.Caixa(); 
			        c.setVisible(true);
			        dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Registro");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(184, 275, 112, 35);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro c = new Registro();
				c.setVisible(true);
				dispose();
			}
		});
	}
}
