package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import PackageOne.SelectionScreen;
import theaterControl.ConectionControl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddMovie {

	public JFrame frame;
	private JTextField titulo;
	private JTextField descricao;
	private JTextField duracao;



	/**
	 * Create the application.
	 */
	public AddMovie() {
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
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SelectionScreen window = new SelectionScreen();
				window.frame.setVisible(true);
			}
		});
		
		JLabel lblDescription = new JLabel("Description:");
		
		JLabel lblTitle = new JLabel("Movie Title:");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBackground(Color.WHITE);
		
		titulo = new JTextField();
		titulo.setColumns(10);
		
		descricao = new JTextField();
		descricao.setColumns(10);
		
		JComboBox genreBox = new JComboBox();
		genreBox.addItem("ação");
		genreBox.addItem("animação");
		genreBox.addItem("aventura");
		genreBox.addItem("comédia");
		genreBox.addItem("cult");
		genreBox.addItem("dança");
		genreBox.addItem("documentário");
		genreBox.addItem("drama");
		genreBox.addItem("fantasia");
		genreBox.addItem("faroeste");
		genreBox.addItem("ficção");
		genreBox.addItem("guerra");
		genreBox.addItem("infantil");
		genreBox.addItem("noir");
		genreBox.addItem("policial");
		genreBox.addItem("romance");
		genreBox.addItem("suspense");
		genreBox.addItem("terror");
	
		
		
		JLabel lblG = new JLabel("Genre:");
		
		JLabel lblRating = new JLabel("Rating:");
		
		JComboBox ratingBox = new JComboBox();
		
		ratingBox.addItem("L");
		ratingBox.addItem("12");
		ratingBox.addItem("14");
		ratingBox.addItem("16");
		ratingBox.addItem("18");
		
		JLabel lblDuration_1 = new JLabel("Duration:");
		
		duracao = new JTextField();
		duracao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			if(duracao.getText().length()==2) {
				duracao.setText(duracao.getText()+":");
			}
			}
		});
		duracao.setColumns(10);
		
		JLabel lblAddMovie = new JLabel("Add Movie");
		lblAddMovie.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
String comand= "INSERT INTO `Filme` VALUES (null,'"+descricao.getText()+"','"+titulo.getText()+"','"+duracao.getText()+"','"+ratingBox.getSelectedItem()+"','"+genreBox.getSelectedItem()+"')";
System.out.println(comand);
				
				try {
					ConectionControl.getInstance().executaUpdate(comand);
					JOptionPane.showMessageDialog(null, "Execution Sucess");
				} catch (SQLException ez) {
					// TODO Auto-generated catch block
					ez.printStackTrace();
				}
				
				frame.dispose();
				SelectionScreen window = new SelectionScreen();
				
				String comand2="select * from Filme";
			 window.visualizar(comand2);
				window.frame.setVisible(true);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitle)
						.addComponent(lblDescription))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(descricao)
						.addComponent(titulo, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
						.addComponent(ratingBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(genreBox, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(duracao, Alignment.LEADING)))
					.addGap(71))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblG)
					.addContainerGap(391, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRating)
					.addContainerGap(389, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDuration_1)
					.addContainerGap(379, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(136, Short.MAX_VALUE)
					.addComponent(btnSave)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBack)
					.addGap(148))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(145)
					.addComponent(lblAddMovie)
					.addContainerGap(149, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddMovie)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescription)
						.addComponent(descricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblG)
						.addComponent(genreBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRating)
						.addComponent(ratingBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuration_1)
						.addComponent(duracao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnSave))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
