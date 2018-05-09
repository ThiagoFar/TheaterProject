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

import thiago.theater.control.ConecBanco;

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


public class CommandScreen {
	
	

	  
	 
		
	protected JFrame frame;
	private JTextField textField;
	private JTable table;

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
		frame.setBounds(100, 100, 450, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JLabel lblCustomselect = new JLabel("CustomSelect:");
		
		textField = new JTextField();
		textField.setColumns(10);
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent arg0) {
				JFrame jf = new JFrame();
				
				try {
					ConecBanco.getInstance().executaComando(textField.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 Vector columnNamesVector = new Vector();
			        Vector dataVector = new Vector();

			        for (int i = 0; i < ConecBanco.getInstance().RetornaData().size(); i++)
			        {
			            ArrayList subArray = (ArrayList)ConecBanco.getInstance().RetornaData().get(i);
			            Vector subVector = new Vector();
			            for (int j = 0; j < subArray.size(); j++)
			            {
			                subVector.add(subArray.get(j));
			            }
			            dataVector.add(subVector);
			        }

			        for (int i = 0; i < ConecBanco.getInstance().retornaColumnNames().size(); i++ )
			            columnNamesVector.add(ConecBanco.getInstance().retornaColumnNames().get(i));

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
			        
			        ConecBanco.getInstance().setArrays();
				
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
					fj.add(img);
					fj.setLocationRelativeTo(null);
				    fj.setVisible(true);
			
				
			}
		});
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(156)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnViewModel)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCustomselect)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
							.addComponent(btnExecute)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCustomselect)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addComponent(btnViewModel)
					.addGap(8)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(80))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
