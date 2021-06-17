package timBookStore;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowCustomer extends JFrame {
	Connection connection = null;
	private JPanel contentPane;
	private final JTable tbCustomer = new JTable();

	
	/**
	 * Create the frame.
	 */
	public ShowCustomer() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 77, 687, 315);
		contentPane.add(scrollPane);
		tbCustomer.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Gender", "Birthday", "Phone", "Address"
			}
		));
		scrollPane.setViewportView(tbCustomer);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Menu m = new Menu();
				m.setVisible(true);
			}
		});
		btnMenu.setBounds(10, 27, 85, 21);
		contentPane.add(btnMenu);
		
		JButton btnAdd = new JButton("Add ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddCustomer a = new AddCustomer();
				a.setVisible(true);
			}
		});
		btnAdd.setBounds(131, 27, 85, 21);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DeleteCustomer d = new DeleteCustomer();
				d.setVisible(true);
			}
		});
		btnDelete.setBounds(255, 27, 85, 21);
		contentPane.add(btnDelete);
		displayData();
	}
	/**
	 * Create CustomerList
	 */
	public ArrayList<Customer> getCustomerList(){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		connection = ConnectToDB.dbConnerctor();
		try {
			
			String qry = "select * from customer";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(qry);
			
			Customer cus;
			while(rs.next()) {
				cus = new Customer( rs.getInt("CID"), rs.getString("Name"),rs.getString("Gender"),rs.getString("Birthday"),rs.getString("Phone"),rs.getString("Address"));
				customerList.add(cus);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		return customerList;
	}
	/**
	 * Display
	 */
	public void displayData() {
		ArrayList<Customer> list = getCustomerList();
		DefaultTableModel model = (DefaultTableModel)tbCustomer.getModel();
		
		Object[] row = new Object[6];
		for(int i =0;i< list.size();i++) {
			row[0] = list.get(i).getID();
			row[1] = list.get(i).getName();
			row[2] = list.get(i).getGender();
			row[3] = list.get(i).getBirthday();
			row[4] = list.get(i).getPhone();
			row[5] = list.get(i).getAddress();
			
			model.addRow(row);
			
		}
	}
	
}
