import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Account extends JFrame {

	Connection conn;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fieldAccountNo;
	private JPasswordField fieldPin;
	private JTextField fieldAmount;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField fieldName;
	private JTextField fieldMobile;
	private JTextField fieldAnswer;

	public void Balance() {
		String query = "INSERT INTO balances " + "(name, acc_no, balance) VALUES" + "(?,?,?)";
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, fieldName.getText());
			preparedStatement.setString(2, fieldAccountNo.getText());
			preparedStatement.setString(3, fieldAmount.getText());
			preparedStatement.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account frame = new Account();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Account() {
		setTitle("Bank Management System");
		conn = JavaConnection.ConnerDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Account NO.");
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(27, 39, 130, 32);
		contentPane.add(label);

		JLabel lblPin = new JLabel("Pin");
		lblPin.setFont(new Font("Calibri", Font.BOLD, 18));
		lblPin.setBounds(27, 97, 130, 32);
		contentPane.add(lblPin);

		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAccountType.setBounds(27, 161, 130, 32);
		contentPane.add(lblAccountType);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Calibri", Font.BOLD, 18));
		lblGender.setBounds(27, 228, 130, 32);
		contentPane.add(lblGender);

		JLabel lblAddress = new JLabel("Amount");
		lblAddress.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAddress.setBounds(27, 299, 130, 32);
		contentPane.add(lblAddress);

		fieldAccountNo = new JTextField();
		fieldAccountNo.setBounds(173, 39, 130, 32);
		contentPane.add(fieldAccountNo);
		fieldAccountNo.setColumns(10);

		fieldPin = new JPasswordField();
		fieldPin.setBounds(173, 97, 130, 32);
		contentPane.add(fieldPin);

		fieldAmount = new JTextField();
		fieldAmount.setColumns(10);
		fieldAmount.setBounds(173, 299, 130, 32);
		contentPane.add(fieldAmount);

		final JComboBox comboboxAccType = new JComboBox();
		comboboxAccType.setModel(new DefaultComboBoxModel(new String[] { "Select", "Current", "Saving" }));
		comboboxAccType.setBounds(175, 161, 128, 32);
		contentPane.add(comboboxAccType);

		final JComboBox comboboxSecQ = new JComboBox();
		comboboxSecQ.setModel(new DefaultComboBoxModel(
				new String[] { "Select", "What is your nickname?", "What is your mother's name?" }));
		comboboxSecQ.setBounds(519, 228, 144, 32);
		contentPane.add(comboboxSecQ);

		final JRadioButton buttonMale = new JRadioButton("Male");
		buttonGroup.add(buttonMale);
		buttonMale.setBackground(Color.WHITE);
		buttonMale.setBounds(170, 232, 73, 23);
		contentPane.add(buttonMale);

		final JRadioButton buttonFemale = new JRadioButton("Female");
		buttonGroup.add(buttonFemale);
		buttonFemale.setBackground(Color.WHITE);
		buttonFemale.setBounds(250, 232, 66, 23);
		contentPane.add(buttonFemale);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Calibri", Font.BOLD, 18));
		lblName.setBounds(373, 39, 130, 32);
		contentPane.add(lblName);

		fieldName = new JTextField();
		fieldName.setColumns(10);
		fieldName.setBounds(519, 39, 144, 32);
		contentPane.add(fieldName);

		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Calibri", Font.BOLD, 18));
		lblMobile.setBounds(373, 161, 130, 32);
		contentPane.add(lblMobile);

		fieldMobile = new JTextField();
		fieldMobile.setColumns(10);
		fieldMobile.setBounds(519, 161, 144, 32);
		contentPane.add(fieldMobile);

		JLabel lblSecurityQuestion = new JLabel("Security Question\r\n");
		lblSecurityQuestion.setFont(new Font("Calibri", Font.BOLD, 17));
		lblSecurityQuestion.setBounds(373, 232, 130, 32);
		contentPane.add(lblSecurityQuestion);

		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Calibri", Font.BOLD, 18));
		lblDateOfBirth.setBounds(373, 97, 130, 32);
		contentPane.add(lblDateOfBirth);

		final JDateChooser dateOfBirth = new JDateChooser();
		dateOfBirth.setBounds(519, 98, 144, 31);
		contentPane.add(dateOfBirth);

		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAnswer.setBounds(373, 303, 130, 32);
		contentPane.add(lblAnswer);

		fieldAnswer = new JTextField();
		fieldAnswer.setColumns(10);
		fieldAnswer.setBounds(519, 303, 144, 32);
		contentPane.add(fieldAnswer);

		JButton buttonCreate = new JButton("Create");
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String date = "";
				String query = "INSERT INTO account "
						+ "(acc_no, name, DOB, pin, acc_type, gender, mobile, sec_q, sec_a, balance) VALUES"
						+ "(?,?,?,?,?,?,?,?,?,?)";
				try {
					date = sdf.format(dateOfBirth.getDate());
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString(1, fieldAccountNo.getText());
					preparedStatement.setString(2, fieldName.getText());
					preparedStatement.setString(3, date);
					preparedStatement.setString(4, fieldPin.getText());
					preparedStatement.setString(5, (String) comboboxAccType.getSelectedItem());

					buttonMale.setActionCommand("Male");
					buttonFemale.setActionCommand("Female");
					preparedStatement.setString(6, buttonGroup.getSelection().getActionCommand());
					preparedStatement.setString(7, fieldMobile.getText());
					preparedStatement.setString(8, (String) comboboxSecQ.getSelectedItem());
					preparedStatement.setString(9, fieldAnswer.getText());
					preparedStatement.setString(10, fieldAmount.getText());
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null, "Congratulations, your account has created.");
					Balance();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		buttonCreate.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonCreate.setFont(new Font("Calibri", Font.BOLD, 15));
		buttonCreate.setBackground(SystemColor.activeCaption);
		buttonCreate.setBounds(64, 379, 156, 32);
		contentPane.add(buttonCreate);

		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Authentication ob = new Authentication();
				ob.setVisible(true);
			}
		});
		buttonBack.setFont(new Font("Calibri", Font.BOLD, 15));
		buttonBack.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonBack.setBackground(SystemColor.activeCaption);
		buttonBack.setBounds(285, 379, 156, 32);
		contentPane.add(buttonBack);

		JButton buttonClear = new JButton("Clear");
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldAccountNo.setText("");
				fieldAmount.setText("");
				fieldAnswer.setText("");
				fieldMobile.setText("");
				fieldName.setText("");
				fieldPin.setText("");
			}
		});
		buttonClear.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonClear.setFont(new Font("Calibri", Font.BOLD, 15));
		buttonClear.setBackground(SystemColor.activeCaption);
		buttonClear.setBounds(507, 379, 156, 32);
		contentPane.add(buttonClear);

	}
}
