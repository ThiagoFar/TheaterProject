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

import forms.AddMovie;
import forms.CreateSession;
import forms.PurchaseTicket;
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
import javax.swing.ImageIcon;
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
		
		JLabel lblFormulrios = new JLabel("Forms and Views");
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
				frame.dispose();
				CreateSession form = new CreateSession();
				form.frame.setVisible(true);
			}
		});
		
		JButton btnPurshase = new JButton("Purchase Ticket");
		btnPurshase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PurchaseTicket form = new PurchaseTicket();
				form.frame.setVisible(true);
			}
		});
		
		JButton btnAddNew = new JButton("Add new Movie");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddMovie form = new AddMovie();
				form.frame.setVisible(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JButton btnView = new JButton("");
		btnView.setToolTipText("View: Dinheiro Arrecadado Por Cliente");
		btnView.setIcon(new ImageIcon(SelectionScreen.class.getResource("/PackageOne/coins.png")));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comand="select * from Valor_Pago_Por_Cliente";
				visualizar(comand);
				
			}
		});
		
		JButton btnView_1 = new JButton("");
		btnView_1.setToolTipText("Clientes que nunca fizeram reserva");
		btnView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comand="select * from Clientes_Nunca_Fizeram_Reserva";
				visualizar(comand);
			}
		});
		btnView_1.setIcon(new ImageIcon(SelectionScreen.class.getResource("/PackageOne/tickets.png")));
		
		JButton btnView_2 = new JButton("");
		btnView_2.setToolTipText("View: Filme visto por Cliente");
		btnView_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comand="select * from Filme_Visto_Por_Cliente";
				visualizar(comand);
			}
		});
		btnView_2.setIcon(new ImageIcon(SelectionScreen.class.getResource("/PackageOne/popcorn.png")));
		btnView_2.setSelectedIcon(null);
		
		JButton btnView_3 = new JButton("");
		btnView_3.setIcon(new ImageIcon(SelectionScreen.class.getResource("/PackageOne/video-camera.png")));
		
		JSeparator separator_2 = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(120)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnPurshase, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAddNew, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCreateNew, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnView_1)
								.addComponent(btnView)
								.addComponent(btnView_2)
								.addComponent(btnView_3)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(98)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(143)
							.addComponent(lblFormulrios))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(180)
							.addComponent(btnSelect)))
					.addContainerGap(125, Short.MAX_VALUE))
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
						.addComponent(btnView))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateNew)
						.addComponent(btnView_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddNew)
						.addComponent(btnView_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPurshase)
						.addComponent(btnView_3))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSelect)
					.addGap(19))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
