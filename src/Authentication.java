import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Authentication extends JFrame {

	Connection conn;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JPasswordField fieldPassword;
	private JTextField fieldAccNo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentication frame = new Authentication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Authentication() {
		conn = JavaConnection.ConnerDb();
		setTitle("Bank Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Account NO.");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 21));
		lblNewLabel.setBounds(23, 61, 163, 32);
		contentPane.add(lblNewLabel);

		JLabel lblPin = new JLabel("         Pin");
		lblPin.setFont(new Font("Calibri", Font.BOLD, 21));
		lblPin.setBounds(23, 140, 163, 32);
		contentPane.add(lblPin);

		fieldPassword = new JPasswordField();
		fieldPassword.setBounds(241, 140, 132, 32);
		contentPane.add(fieldPassword);

		fieldAccNo = new JTextField();
		fieldAccNo.setBounds(241, 61, 132, 32);
		contentPane.add(fieldAccNo);
		fieldAccNo.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT * FROM account WHERE acc_no=? and pin=?";
				try {
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString(1, fieldAccNo.getText());
					preparedStatement.setString(2, fieldPassword.getText());
					rs = preparedStatement.executeQuery();
					if (rs.next()) {
						setVisible(false);
						MyPage ob = new MyPage();
						ob.setVisible(true);
						rs.close();
						preparedStatement.close();
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Credential!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				} finally {
					try {
						rs.close();
						preparedStatement.close();
					} catch (Exception e3) {
					}
				}
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton.setBounds(85, 203, 121, 32);
		contentPane.add(btnNewButton);

		JButton btnNewAccount = new JButton("New Account");
		btnNewAccount.setBackground(SystemColor.activeCaption);
		btnNewAccount.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Account ob = new Account();
				ob.setVisible(true);
			}
		});
		btnNewAccount.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewAccount.setBounds(252, 203, 121, 32);
		contentPane.add(btnNewAccount);
	}
}
