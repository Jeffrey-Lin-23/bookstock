package timBookStore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Menu extends JFrame {
	
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public Menu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShowCustomer = new JButton("Show Customer List");
		btnShowCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ShowCustomer s = new ShowCustomer();
				s.setVisible(true);
			}
		});
		btnShowCustomer.setBounds(41, 40, 150, 34);
		contentPane.add(btnShowCustomer);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddCustomer a = new AddCustomer();
				a.setVisible(true);
			}
		});
		btnAddCustomer.setBounds(208, 40, 130, 34);
		contentPane.add(btnAddCustomer);
		
		JButton btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DeleteCustomer d = new DeleteCustomer();
				d.setVisible(true);
			}
		});
		btnDeleteCustomer.setBounds(348, 40, 150, 34);
		contentPane.add(btnDeleteCustomer);
		
		JButton btnShowBookList = new JButton("Show Book List");
		btnShowBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ShowBook m = new ShowBook();
				m.setVisible(true);
			}
		});
		btnShowBookList.setBounds(41, 94, 150, 34);
		contentPane.add(btnShowBookList);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(208, 94, 130, 34);
		contentPane.add(btnAddBook);
		
		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setBounds(348, 94, 150, 34);
		contentPane.add(btnDeleteBook);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.setBounds(41, 148, 150, 34);
		contentPane.add(btnCheckOut);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblMenu.setBounds(255, 10, 62, 20);
		contentPane.add(lblMenu);
	}
}
