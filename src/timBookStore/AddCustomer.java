package timBookStore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddCustomer extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textName;
	private JTextField textBirth;
	private JTextField textPhone;
	private JTextField textAddress;

	private String name;
	private String gender;
	private String birth;
	private String phone;
	private String address;
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public AddCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(42, 53, 45, 13);
		contentPane.add(lblName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(42, 100, 45, 13);
		contentPane.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setSelected(true);
		rdbtnMale.setToolTipText("");
		rdbtnMale.setBounds(109, 98, 54, 21);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(165, 98, 103, 21);
		contentPane.add(rdbtnFemale);
		
		textName = new JTextField();
		textName.setBounds(109, 52, 121, 19);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBirthday.setBounds(42, 147, 59, 18);
		contentPane.add(lblBirthday);
		
		textBirth = new JTextField();
		textBirth.setColumns(10);
		textBirth.setBounds(109, 149, 121, 19);
		contentPane.add(textBirth);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(42, 200, 59, 18);
		contentPane.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(109, 202, 121, 19);
		contentPane.add(textPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(42, 251, 59, 18);
		contentPane.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(109, 253, 205, 19);
		contentPane.add(textAddress);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name = textName.getText();
				if(rdbtnMale.isSelected()){
					gender = "Male";
				}
				if(rdbtnFemale.isSelected()) {
					gender = "Female";
				}
				birth = textBirth.getText();
				phone = textPhone.getText();
				address = textAddress.getText();
				
				connection = ConnectToDB.dbConnerctor();
				String qry1 = "select * from customer Where name='"+name+"'";
				String qry2 = "INSERT into customer(Name,Gender,Birthday,Phone,Address) VALUES ('" + name+"','"+gender+"','"+birth+"','"+phone+"','"+address+"')";
				try {
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery(qry1);
					int count =0;
					while(rs.next()) {
						count++;
					}
					if(count!=0) {
						JOptionPane.showMessageDialog(null, "The customer has been exist");
						
						
					}else {
						int rowsupdate = st.executeUpdate(qry2);
						if(rowsupdate == 1) {
							JOptionPane.showMessageDialog(null, "submit successful");
						}
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
						
			}
		});
		btnSubmit.setBounds(197, 299, 85, 21);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ShowCustomer s = new ShowCustomer();
				s.setVisible(true);
			}
		});
		btnCancel.setBounds(42, 299, 85, 21);
		contentPane.add(btnCancel);
	}
}
