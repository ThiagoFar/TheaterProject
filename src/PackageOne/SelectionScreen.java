package PackageOne;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import forms.RegisterClient;
import theaterControl.ConectionControl;

import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JSeparator;
public class SelectionScreen {
	
	public void visualizar(String comand) {
		JFrame jf = new JFrame();
		
		try {
			ConectionControl.getInstance().executaComando(comand);
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
	        jf.setLocationRelativeTo(null);
	        jf.pack();
	        
	        jf.setVisible(true);
	        
	        ConectionControl.getInstance().setArrays();
		
	}
		
		
	

	public JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public SelectionScreen() {
		initialize();
	}
  
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JButton btnSelect = new JButton("Execute Custom Query");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				CommandScreen window = new CommandScreen();
				window.frame.setVisible(true);
			}
		});
		
		JLabel lblFormulrios = new JLabel("Forms");
		lblFormulrios.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JButton btnNewButton = new JButton("Register Client");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RegisterClient form = new RegisterClient();
				form.frame.setVisible(true);
				
				
				
			}
		});
		
		JButton btnCreateNew = new JButton("Create new Session");
		btnCreateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnPurshase = new JButton("Purchase Ticket");
		
		JButton btnSeeClientTable = new JButton("See Client Table");
		btnSeeClientTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comand="select * from Cliente";
				visualizar(comand);
				
			}
		});
		
		JButton btnSeeSessionTable = new JButton("See Session Table");
		btnSeeSessionTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comand="select * from Sessao";
				visualizar(comand);
				
			}
		});
		
		JButton btnSeeMovieTable = new JButton("See Movie Table");
		btnSeeMovieTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comand="select * from Filme";
				visualizar(comand);
				
			}
		});
		
		JButton btnSeeTicketTable = new JButton("See Ticket Table");
		btnSeeTicketTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comand="select * from Ingresso";
				visualizar(comand);
				
			}
		});
		
		JButton btnAddNew = new JButton("Add new Movie");
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(174, Short.MAX_VALUE)
					.addComponent(btnSelect)
					.addGap(217))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnPurshase, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddNew, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCreateNew, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSeeSessionTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSeeMovieTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSeeTicketTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSeeClientTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(145))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(205)
					.addComponent(lblFormulrios)
					.addContainerGap(245, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(132)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(178, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(120)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(160, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFormulrios)
					.addGap(34)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnSeeClientTable))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateNew)
						.addComponent(btnSeeSessionTable))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSeeMovieTable)
						.addComponent(btnAddNew))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPurshase)
						.addComponent(btnSeeTicketTable))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSelect)
					.addGap(24))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
