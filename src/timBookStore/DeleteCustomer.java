package timBookStore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textInput;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Connection connection = null;
	

	/**
	 * Create the frame.
	 */
	public DeleteCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteVia = new JLabel("Delete via");
		lblDeleteVia.setBounds(40, 45, 45, 13);
		contentPane.add(lblDeleteVia);
		
		JRadioButton rdbtnId = new JRadioButton("ID");
		buttonGroup.add(rdbtnId);
		rdbtnId.setSelected(true);
		rdbtnId.setBounds(35, 64, 45, 21);
		contentPane.add(rdbtnId);
		
		JRadioButton rdbtnName = new JRadioButton("Name");
		buttonGroup.add(rdbtnName);
		rdbtnName.setBounds(100, 64, 71, 21);
		contentPane.add(rdbtnName);
		
		textInput = new JTextField();
		textInput.setBounds(40, 91, 162, 27);
		contentPane.add(textInput);
		textInput.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String input = textInput.getText();
			connection = ConnectToDB.dbConnerctor();
			String search = null;
			if(rdbtnId.isSelected()) {
				search = "CID='"+input+"'";
			}else if(rdbtnName.isSelected()) {
				search = "name='"+input+"'";
			}
			
			try {
				String qry1 = "select * from customer Where "+search;
				String qry2 = "delete from customer Where "+search;
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(qry1);
				int count =0;
				while(rs.next()) {
					count++;
				}
				if(count!=0) {
					JOptionPane.showMessageDialog(null, "Delete successful");
					int rowsupdate = st.executeUpdate(qry2);
					
				}else {
					JOptionPane.showMessageDialog(null, "The customer do not exist");
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			
			
			}
		});
		btnDelete.setBounds(117, 128, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ShowCustomer s = new ShowCustomer();
				s.setVisible(true);
			}
		});
		btnCancel.setBounds(22, 128, 85, 21);
		contentPane.add(btnCancel);
	}

}
