package forms;

import java.awt.EventQueue;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;

import PackageOne.SelectionScreen;
import theaterControl.ConectionControl;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterClient {

	public JFrame frame;
	private JTextField text_primeiroNome;
	private JTextField text_ultimoNome;
	private JLabel lblEmail;
	private JTextField text_senha;
	private JLabel lblSenha;
	private JTextField text_email;
	private JLabel lblPhone;
	private JTextField text_numero;
    private int phonecount;
	/**
	 * Launch the application.
	

	/**
	 * Create the application.
	 */
	public RegisterClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JLabel lblName = new JLabel("First Name:");
		
		text_primeiroNome = new JTextField();
		text_primeiroNome.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		
		text_ultimoNome = new JTextField();
		text_ultimoNome.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		
		text_senha = new JTextField();
		text_senha.setColumns(10);
		
		lblSenha = new JLabel("Password:");
		
		text_email = new JTextField();
		text_email.setColumns(10);
		
		lblPhone = new JLabel("Phone:");
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ValidaEmail
				String phone = text_numero.getText();
				phone=phone.substring(1, 3)+phone.substring(4);
				String email = text_email.getText();
				 InternetAddress emailAddr;
				 boolean emailValid = true;
				try {
					emailAddr = new InternetAddress(email);
					 emailAddr.validate();
					
						
					
				} catch (AddressException e1) {
					emailValid=false;
					JOptionPane.showMessageDialog(null, "Email typed is not valid");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//validaSenha
				boolean passValid=false;
				if((text_senha.getText().length()>6)) {
					passValid=true;
				}else {
					JOptionPane.showMessageDialog(null, "Password must contain a minimum of six digits");
				}
			      
				
				String comand= "INSERT INTO `Cliente` VALUES (null,'"+text_email.getText()+"','"+text_senha.getText()+"','"+text_primeiroNome.getText()+"','"+text_ultimoNome.getText()+"','"+phone+"')";
				
				
				boolean allValid=false;
				if (emailValid && passValid) {
					allValid=true;
				}
				if(allValid) {
					try {
						ConectionControl.getInstance().executaUpdate(comand);
						JOptionPane.showMessageDialog(null, "Execution Sucess");
					} catch (SQLException ez) {
						// TODO Auto-generated catch block
						ez.printStackTrace();
					}
				frame.dispose();
				SelectionScreen window = new SelectionScreen();
				
				String comand2="select * from Cliente";
			 window.visualizar(comand2);
				window.frame.setVisible(true);
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SelectionScreen window = new SelectionScreen();
				window.frame.setVisible(true);
				
			}
		});
		
		
		
		JLabel lblRegisterClient = new JLabel("Register Client");
		lblRegisterClient.setFont(new Font("Arial", Font.PLAIN, 30));
		
		text_numero = new JTextField();
		text_numero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				phonecount++;
				
				 if(text_numero.getText().length()==0) {
					 text_numero.setText("("+text_numero.getText());
					 
				 }
				
			 if(text_numero.getText().length()==3) {
				 text_numero.setText(text_numero.getText()+")");
				 
			 }
				
			
			}
		});
		
			
		
		text_numero.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblName)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_primeiroNome, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblLastName)
											.addComponent(lblSenha)
											.addComponent(lblEmail))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(text_senha, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
											.addComponent(text_ultimoNome)
											.addComponent(text_email, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
											.addComponent(text_numero, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
								.addComponent(lblPhone)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(153)
							.addComponent(btnSave)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addComponent(lblRegisterClient)))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRegisterClient)
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(text_primeiroNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(text_ultimoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(text_senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(text_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhone)
						.addComponent(text_numero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnSave))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
