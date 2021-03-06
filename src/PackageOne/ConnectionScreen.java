package PackageOne;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import theaterControl.ConectionControl;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.font.ShapeGraphicAttribute;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.SystemColor;

public class ConnectionScreen {

	private JFrame frame;
	private JTextField usertxt;
	private JTextField urltxt;
	private JPasswordField passtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectionScreen window = new ConnectionScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnectionScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		
		
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblUsurio = new JLabel("User:");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblSenha = new JLabel("Pass:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		usertxt = new JTextField();
		usertxt.setText("ThiagoFar");
		usertxt.setColumns(10);
		
		urltxt = new JTextField();
		urltxt.setBackground(Color.WHITE);
		
	            BevelBorder bevel = new BevelBorder(1);
				urltxt.setBorder(bevel);
				usertxt.setBorder(bevel);

		
	    
		urltxt.setText("theater.copvvyciryyd.sa-east-1.rds.amazonaws.com/TheaterData");
		urltxt.setColumns(10);
		
		passtxt = new JPasswordField();
		passtxt.setText("");
		
		passtxt.setBorder(bevel);
		
		JButton btnConectar = new JButton("Connect");
		
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String pass = new String(passtxt.getPassword());
				
				ConectionControl.getInstance().setDadosLogin(urltxt.getText(), usertxt.getText(), pass);
				
				try {
					ConectionControl.getInstance().Concta();
					ConectionControl.getInstance().fechaConec();
					frame.dispose();
					SelectionScreen window = new SelectionScreen();
					window.frame.setVisible(true);
					System.out.println("Connection Sucessfull");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Connection Error");
				}
				
				

			}
		});
	
		JLabel lblTheater = new JLabel("Theater");
		lblTheater.setFont(new Font("Arial", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUsurio)
										.addComponent(lblUrl))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(urltxt, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(passtxt, Alignment.LEADING)
											.addComponent(usertxt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.RELATED, 340, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(189)
							.addComponent(lblTheater))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(168)
							.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblTheater)
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUrl)
						.addComponent(urltxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsurio)
						.addComponent(usertxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(passtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
}
