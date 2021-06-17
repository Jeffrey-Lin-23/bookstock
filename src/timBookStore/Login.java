package timBookStore;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connection = null;
	private JTextField textUser;
	private JPasswordField passwordField;
	
	public Login() {
		initialize();
		connection = ConnectToDB.dbConnerctor();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("UserName");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setBounds(30, 92, 84, 22);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(30, 155, 59, 22);
		frame.getContentPane().add(lblPassword);
		
		textUser = new JTextField();
		textUser.setBounds(121, 92, 118, 28);
		frame.getContentPane().add(textUser);
		textUser.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String qry = "select * from user where name=? and password=? ";
					PreparedStatement pst=connection.prepareStatement(qry);
					pst.setString(1, textUser.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count =0;
					while(rs.next()) {
						count++;
					}
					if(count!=0) {
						JOptionPane.showMessageDialog(null, "Login successful");
						frame.dispose();
						Menu m = new Menu();
						m.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "Username or Password is incorrect. Try again");
					}
					rs.close();
					pst.close();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(93, 211, 98, 28);
		frame.getContentPane().add(btnLogin);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(52, 10, 198, 72);
		frame.getContentPane().add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 155, 118, 28);
		frame.getContentPane().add(passwordField);
	}
	public void updateData() {
		try {
			Statement st = connection.createStatement();
			int rowsUpdated = st.executeUpdate("UPDATE user SET Password='abc' WHERE Name='tim'");
			
			
		}catch(Exception e) {
			
		}
		
	}
}
