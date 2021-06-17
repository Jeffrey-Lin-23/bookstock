package timBookStore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class ShowBook extends JFrame {

	private JPanel contentPane;
	private JTable tbBook;
	Connection connection = null;
	

	/**
	 * Create the frame.
	 */
	public ShowBook() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Menu m = new Menu();
				m.setVisible(true);
			}
		});
		btnMenu.setBounds(37, 36, 85, 21);
		contentPane.add(btnMenu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 75, 595, 250);
		contentPane.add(scrollPane);
		
		tbBook = new JTable();
		tbBook.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"BID", "Name", "Author", "PublishDate", "BuyPrice", "SellPrice", "Amount"
			}
		));
		scrollPane.setViewportView(tbBook);
		displayData();
	}

	/**
	 * Create CustomerList
	 */
	public ArrayList<Book> getBookList(){
		ArrayList<Book> bookList = new ArrayList<Book>();
		connection = ConnectToDB.dbConnerctor();
		try {
			
			String qry = "select * from book";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(qry);
			
			Book b;
			while(rs.next()) {
				b = new Book(rs.getInt("BID"), rs.getString("Name"),rs.getString("author"),rs.getString("PublishDate"),rs.getDouble("BuyPrice"),rs.getDouble("SellPrice"),rs.getInt("Amount"));
				bookList.add(b);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		return bookList;
	}
	/**
	 * Display
	 */
	public void displayData() {
		ArrayList<Book> list = getBookList();
		DefaultTableModel model = (DefaultTableModel)tbBook.getModel();
		
		Object[] row = new Object[7];
		for(int i =0;i< list.size();i++) {
			row[0] = list.get(i).getID();
			row[1] = list.get(i).getName();
			row[2] = list.get(i).getAuthor();
			row[3] = list.get(i).getPublishDate();
			row[4] = list.get(i).getBuy();
			row[5] = list.get(i).getSell();
			row[6] = list.get(i).getAmount();
			model.addRow(row);
			
		}
	}
}
