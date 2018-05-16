package PackageOne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import theaterControl.ConectionControl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;


public class CommandScreen {
	
	

	  
	 
		
	protected JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public CommandScreen() {
		initialize();
	}
	
	
   
    	
    	  

    	 
    
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JLabel lblCustomselect = new JLabel("CustomSelect:");
		
		textField = new JTextField();
		textField.setColumns(10);
		JButton btnExecute = new JButton("");
		btnExecute.setIcon(new ImageIcon(CommandScreen.class.getResource("/PackageOne/raio.png")));
		btnExecute.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent arg0) {
				JFrame jf = new JFrame();
				
				try {
					ConectionControl.getInstance().executaComando(textField.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 Vector columnNamesVector = new Vector();
			        Vector dataVector = new Vector();

			        for (int i = 0; i < ConectionControl.getInstance().RetornaData().size(); i++)
			        {
			            ArrayList subArray = (ArrayList)ConectionControl.getInstance().RetornaData().get(i);
			            Vector subVector = new Vector();
			            for (int j = 0; j < subArray.size(); j++)
			            {
			                subVector.add(subArray.get(j));
			            }
			            dataVector.add(subVector);
			        }

			        for (int i = 0; i < ConectionControl.getInstance().retornaColumnNames().size(); i++ )
			            columnNamesVector.add(ConectionControl.getInstance().retornaColumnNames().get(i));

			        //  Create table with database data    
			        JTable table = new JTable(dataVector, columnNamesVector)
			        {
			            public Class getColumnClass(int column)
			            {
			                for (int row = 0; row < getRowCount(); row++)
			                {
			                    Object o = getValueAt(row, column);

			                    if (o != null)
			                    {
			                        return o.getClass();
			                    }
			                }

			                return Object.class;
			            }
			        };

			        JScrollPane scrollPane = new JScrollPane( table );
			        jf.getContentPane().add( scrollPane );

			        JPanel buttonPanel = new JPanel();
			        jf.getContentPane().add( buttonPanel, BorderLayout.SOUTH );
			        
			        jf.pack();
			        
			        jf.setVisible(true);
			        
			        ConectionControl.getInstance().setArrays();
				
			}
			
		})
		
		;
		
		table = new JTable();
		
		JButton btnViewModel = new JButton("View Model");
		btnViewModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					JFrame fj = new JFrame();
					JLabel img = new JLabel();
					img.setIcon(new ImageIcon(CommandScreen.class.getResource("/PackageOne/model.jpg")));
				 
					fj.setSize(1000,900);
					fj.getContentPane().add(img);
					fj.setLocationRelativeTo(null);
				    fj.setVisible(true);
			
				
			}
		});
		
		JLabel lblModifydata = new JLabel("ModifyingData:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnExecute_1 = new JButton("");
		btnExecute_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ConectionControl.getInstance().executaUpdate(textField_1.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnExecute_1.setIcon(new ImageIcon(CommandScreen.class.getResource("/PackageOne/raio.png")));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				SelectionScreen window = new SelectionScreen();
				window.frame.setVisible(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JLabel lblCustomQuerys = new JLabel("Custom Querys");
		lblCustomQuerys.setFont(new Font("Arial", Font.PLAIN, 30));
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(45)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(10)
													.addComponent(btnExecute_1))
												.addComponent(lblModifydata))
											.addGap(18)
											.addComponent(textField_1, 239, 239, 239))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCustomselect)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(10)
													.addComponent(btnExecute)))
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCustomQuerys)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(112)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)))
							.addGap(286)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(166)
							.addComponent(btnViewModel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblCustomQuerys)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCustomselect)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExecute))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblModifydata)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExecute_1))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnViewModel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(46))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
