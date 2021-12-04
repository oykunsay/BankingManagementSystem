import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JTable;
import javax.swing.JPasswordField;

public class MyPage extends JFrame {

	Connection conn;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fieldUser;
	private JTextField fieldName;
	private JTextField fieldDateOfBirth;
	private JTextField fieldGender;
	private JTextField fieldAccNo;
	private JTextField fieldAccType;
	private JTextField fieldMobile;
	private JTextField fieldSecQ;
	private JTextField fieldUser1;
	private JTextField fieldName1;
	private JTextField fieldAccNo1;
	private JTextField fieldAvailableBalance;
	private JTextField fieldDepositAmount;
	private JTextField fieldDepositAmount1;
	private JTextField fieldUser2;
	private JTextField fieldName2;
	private JTextField fieldAccNo2;
	private JTextField fieldAvailableBalance2;
	private JTextField fieldTransferAmount;
	private JTextField fieldTransferAmount1;
	private JTextField fieldCreditAcc;
	private JTextField fieldCreditAcc1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage frame = new MyPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public MyPage() {
		setTitle("Bank Management System");
		conn = JavaConnection.ConnerDb();
		Account();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel.setBounds(508, 22, 83, 22);
		contentPane.add(lblNewLabel);

		fieldUser = new JTextField();
		fieldUser.setBounds(586, 20, 108, 22);
		contentPane.add(fieldUser);
		fieldUser.setColumns(10);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 105, 693, 311);
		contentPane.add(tabbedPane);

		JPanel panelProfile = new JPanel();
		panelProfile.setBackground(Color.WHITE);
		tabbedPane.addTab("Profile", null, panelProfile, null);

		JPanel panelDeposit = new JPanel();
		panelDeposit.setBackground(Color.WHITE);
		panelProfile.setBackground(Color.WHITE);
		tabbedPane.addTab("Deposit", null, panelDeposit, null);
		panelDeposit.setLayout(null);

		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Calibri", Font.BOLD, 18));
		lblUser.setBounds(25, 23, 130, 32);
		panelDeposit.add(lblUser);

		fieldUser1 = new JTextField();
		fieldUser1.setColumns(10);
		fieldUser1.setBackground(Color.WHITE);
		fieldUser1.setBounds(171, 23, 130, 32);
		panelDeposit.add(fieldUser1);

		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Calibri", Font.BOLD, 18));
		lblName_1.setBounds(25, 157, 130, 32);
		panelDeposit.add(lblName_1);

		fieldName1 = new JTextField();
		fieldName1.setEditable(false);
		fieldName1.setColumns(10);
		fieldName1.setBackground(Color.WHITE);
		fieldName1.setBounds(171, 157, 130, 32);
		panelDeposit.add(fieldName1);

		JLabel lblAccountNo = new JLabel("Account NO.");
		lblAccountNo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAccountNo.setBounds(25, 221, 130, 32);
		panelDeposit.add(lblAccountNo);

		fieldAccNo1 = new JTextField();
		fieldAccNo1.setEditable(false);
		fieldAccNo1.setColumns(10);
		fieldAccNo1.setBackground(Color.WHITE);
		fieldAccNo1.setBounds(171, 221, 130, 32);
		panelDeposit.add(fieldAccNo1);

		JLabel lblAvailableBalance = new JLabel("Available Balance");
		lblAvailableBalance.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAvailableBalance.setBounds(25, 86, 148, 32);
		panelDeposit.add(lblAvailableBalance);

		fieldAvailableBalance = new JTextField();
		fieldAvailableBalance.setEditable(false);
		fieldAvailableBalance.setColumns(10);
		fieldAvailableBalance.setBackground(Color.WHITE);
		fieldAvailableBalance.setBounds(171, 86, 130, 32);
		panelDeposit.add(fieldAvailableBalance);

		JLabel lblDepositAmount = new JLabel("Deposit Amount");
		lblDepositAmount.setFont(new Font("Calibri", Font.BOLD, 18));
		lblDepositAmount.setBounds(368, 81, 247, 32);
		panelDeposit.add(lblDepositAmount);

		fieldDepositAmount = new JTextField();
		fieldDepositAmount.setColumns(10);
		fieldDepositAmount.setBackground(Color.WHITE);
		fieldDepositAmount.setBounds(371, 123, 269, 32);
		panelDeposit.add(fieldDepositAmount);

		fieldDepositAmount1 = new JTextField();
		fieldDepositAmount1.setEditable(false);
		fieldDepositAmount1.setColumns(10);
		fieldDepositAmount1.setBackground(Color.WHITE);
		fieldDepositAmount1.setBounds(374, 169, 264, 32);
		panelDeposit.add(fieldDepositAmount1);

		JButton buttonTotal = new JButton("Total");
		buttonTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String availableBalance = fieldAvailableBalance.getText();
					String depositAmount = fieldDepositAmount.getText();
					int intSum = Integer.parseInt(availableBalance) + Integer.parseInt(depositAmount);
					String stringSum = String.valueOf(intSum);
					fieldDepositAmount1.setText(stringSum);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		buttonTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonTotal.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonTotal.setBackground(SystemColor.activeCaption);
		buttonTotal.setBounds(372, 221, 108, 32);
		panelDeposit.add(buttonTotal);

		JButton buttonDeposit = new JButton("Deposit");
		buttonDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String user = fieldUser1.getText();
					String depositAmount1 = fieldDepositAmount1.getText();
					String sql = "UPDATE balances SET balance='" + depositAmount1 + "' WHERE name='" + user + "'";
					String query = "UPDATE account SET balance='" + depositAmount1 + "'WHERE name='" + user + "'";
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.execute(sql);
					preparedStatement.execute(query);
					JOptionPane.showMessageDialog(null, "Successfully deposited!");
					fieldUser1.setText("");
					fieldAccNo1.setText("");
					fieldAvailableBalance.setText("");
					fieldName1.setText("");
					fieldDepositAmount.setText("");
					fieldDepositAmount1.setText("");

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		buttonDeposit.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonDeposit.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonDeposit.setBackground(SystemColor.activeCaption);
		buttonDeposit.setBounds(530, 221, 108, 32);
		panelDeposit.add(buttonDeposit);

		JButton buttonSearch = new JButton("Search");
		buttonSearch.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT * FROM balances WHERE name=?";
				try {
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement.setString(1, fieldUser1.getText());
					rs = preparedStatement.executeQuery();
					if (rs.next()) {
						String add1 = rs.getString("name");
						fieldName1.setText(add1);
						String add2 = rs.getString("acc_no");
						fieldAccNo1.setText(add2);
						String add3 = rs.getString("balance");
						fieldAvailableBalance.setText(add3);
						rs.close();
						preparedStatement.close();
					} else {
						JOptionPane.showMessageDialog(null, "Enter correct name!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				} finally {
					try {
						rs.close();
						preparedStatement.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		
		
		buttonSearch.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonSearch.setBackground(SystemColor.activeCaption);
		buttonSearch.setBounds(366, 24, 128, 27);
		panelDeposit.add(buttonSearch);

		JPanel panelTransfer = new JPanel();
		panelTransfer.setBackground(Color.WHITE);
		panelProfile.setBackground(Color.WHITE);
		tabbedPane.addTab("Transfer", null, panelTransfer, null);
		panelTransfer.setLayout(null);

		JLabel label_2 = new JLabel("User");
		label_2.setFont(new Font("Calibri", Font.BOLD, 18));
		label_2.setBounds(10, 25, 130, 32);
		panelTransfer.add(label_2);

		fieldUser2 = new JTextField();
		fieldUser2.setColumns(10);
		fieldUser2.setBackground(Color.WHITE);
		fieldUser2.setBounds(156, 25, 130, 32);
		panelTransfer.add(fieldUser2);

		JLabel label_3 = new JLabel("Name");
		label_3.setFont(new Font("Calibri", Font.BOLD, 18));
		label_3.setBounds(10, 88, 130, 32);
		panelTransfer.add(label_3);

		fieldName2 = new JTextField();
		fieldName2.setEditable(false);
		fieldName2.setColumns(10);
		fieldName2.setBackground(Color.WHITE);
		fieldName2.setBounds(156, 88, 130, 32);
		panelTransfer.add(fieldName2);

		JLabel label_4 = new JLabel("Account NO.");
		label_4.setFont(new Font("Calibri", Font.BOLD, 18));
		label_4.setBounds(10, 152, 130, 32);
		panelTransfer.add(label_4);

		fieldAccNo2 = new JTextField();
		fieldAccNo2.setEditable(false);
		fieldAccNo2.setColumns(10);
		fieldAccNo2.setBackground(Color.WHITE);
		fieldAccNo2.setBounds(156, 152, 130, 32);
		panelTransfer.add(fieldAccNo2);

		JLabel label_5 = new JLabel("Available Balance");
		label_5.setFont(new Font("Calibri", Font.BOLD, 18));
		label_5.setBounds(10, 217, 148, 32);
		panelTransfer.add(label_5);

		fieldAvailableBalance2 = new JTextField();
		fieldAvailableBalance2.setEditable(false);
		fieldAvailableBalance2.setColumns(10);
		fieldAvailableBalance2.setBackground(Color.WHITE);
		fieldAvailableBalance2.setBounds(156, 217, 130, 32);
		panelTransfer.add(fieldAvailableBalance2);

		JButton buttonSearch1 = new JButton("Search");
		buttonSearch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT * FROM balances WHERE name=?";
				try {
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement.setString(1, fieldUser2.getText());
					rs = preparedStatement.executeQuery();
					if (rs.next()) {
						String add1 = rs.getString("name");
						fieldName2.setText(add1);
						String add2 = rs.getString("acc_no");
						fieldAccNo2.setText(add2);
						String add3 = rs.getString("balance");
						fieldAvailableBalance2.setText(add3);
						rs.close();
						preparedStatement.close();
					} else {
						JOptionPane.showMessageDialog(null, "Enter correct name!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				} finally {
					try {
						rs.close();
						preparedStatement.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		buttonSearch1.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonSearch1.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonSearch1.setBackground(SystemColor.activeCaption);
		buttonSearch1.setBounds(492, 28, 128, 27);
		panelTransfer.add(buttonSearch1);

		JLabel lblTransferAmount = new JLabel("Transfer Amount");
		lblTransferAmount.setFont(new Font("Calibri", Font.BOLD, 15));
		lblTransferAmount.setBounds(316, 66, 107, 32);
		panelTransfer.add(lblTransferAmount);

		fieldTransferAmount = new JTextField();
		fieldTransferAmount.setColumns(10);
		fieldTransferAmount.setBackground(Color.WHITE);
		fieldTransferAmount.setBounds(433, 66, 107, 27);
		panelTransfer.add(fieldTransferAmount);

		JButton buttonTotal2 = new JButton("Total");
		buttonTotal2.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonTotal2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String availableBalance = fieldAvailableBalance2.getText();
					String transferAmount = fieldTransferAmount.getText();
					int sum = Integer.parseInt(availableBalance) - Integer.parseInt(transferAmount);
					String sum1 = String.valueOf(sum);
					fieldTransferAmount1.setText(sum1);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		buttonTotal2.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonTotal2.setBackground(SystemColor.activeCaption);
		buttonTotal2.setBounds(492, 109, 128, 27);
		panelTransfer.add(buttonTotal2);

		fieldTransferAmount1 = new JTextField();
		fieldTransferAmount1.setEditable(false);
		fieldTransferAmount1.setColumns(10);
		fieldTransferAmount1.setBackground(Color.WHITE);
		fieldTransferAmount1.setBounds(559, 66, 107, 27);
		panelTransfer.add(fieldTransferAmount1);

		JLabel lblCreditAccount = new JLabel("Credit Account");
		lblCreditAccount.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCreditAccount.setBounds(316, 150, 107, 32);
		panelTransfer.add(lblCreditAccount);


		
		comboboxCreditAccount.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				try {
					String a1 = (String) comboboxCreditAccount.getSelectedItem();
					String sql = "SELECT * FROM balances WHERE acc_no=?";
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement.setString(1, a1);
					rs = preparedStatement.executeQuery();
					if(rs.next()) {
						String add = rs.getString("balance");
						fieldCreditAcc.setText(add);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
			

			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				
			}

			public void popupMenuCanceled(PopupMenuEvent e) {
				
			}
		
		});
		
		
		comboboxCreditAccount.setBackground(SystemColor.activeCaption);
		comboboxCreditAccount.setBounds(433, 154, 107, 28);
		panelTransfer.add(comboboxCreditAccount);

		fieldCreditAcc = new JTextField();
		fieldCreditAcc.setEditable(false);
		fieldCreditAcc.setColumns(10);
		fieldCreditAcc.setBackground(Color.WHITE);
		fieldCreditAcc.setBounds(571, 155, 107, 32);
		panelTransfer.add(fieldCreditAcc);

		fieldCreditAcc1 = new JTextField();
		fieldCreditAcc1.setEditable(false);
		fieldCreditAcc1.setColumns(10);
		fieldCreditAcc1.setBackground(Color.WHITE);
		fieldCreditAcc1.setBounds(433, 200, 107, 32);
		panelTransfer.add(fieldCreditAcc1);

		JButton buttonShow = new JButton("Show");
		buttonShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String transferAmount = fieldTransferAmount.getText();
					String creditAccount = fieldCreditAcc.getText();
					int sum = Integer.parseInt(creditAccount) + Integer.parseInt(transferAmount);
					String sum1 = String.valueOf(sum);
					fieldCreditAcc1.setText(sum1);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		
		
		buttonShow.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonShow.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonShow.setBackground(SystemColor.activeCaption);
		buttonShow.setBounds(571, 200, 107, 27);
		panelTransfer.add(buttonShow);

		JButton buttonTransfer = new JButton("Transfer");
		buttonTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferD();
				TransferC();
			}

			
			public void TransferC() {
				try {
					String value1 = (String) comboboxCreditAccount.getSelectedItem();
					String value2 = fieldCreditAcc1.getText();
					String sql = "UPDATE balances SET balance='" + value2 + "' WHERE acc_no='" + value1 + "'";
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null, "Successfully Transfered!");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
			}

			public void TransferD() {
				try {
					String value1 = fieldUser2.getText();
					String value2 = fieldCreditAcc.getText();
					String sql = "UPDATE balances SET balance='" + value2 + "' WHERE name='" + value1 + "'"; 
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement.execute();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		buttonTransfer.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonTransfer.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonTransfer.setBackground(SystemColor.activeCaption);
		buttonTransfer.setBounds(492, 245, 128, 27);
		panelTransfer.add(buttonTransfer);

		JPanel panelWithdrawl = new JPanel();
		panelWithdrawl.setBackground(Color.WHITE);
		panelProfile.setBackground(Color.WHITE);
		tabbedPane.addTab("Withdrawl", null, panelWithdrawl, null);
		panelWithdrawl.setLayout(null);
		
		JLabel label_6 = new JLabel("User");
		label_6.setFont(new Font("Calibri", Font.BOLD, 18));
		label_6.setBounds(23, 11, 130, 32);
		panelWithdrawl.add(label_6);
		
		fieldUser3 = new JTextField();
		fieldUser3.setColumns(10);
		fieldUser3.setBackground(Color.WHITE);
		fieldUser3.setBounds(169, 11, 130, 32);
		panelWithdrawl.add(fieldUser3);
		
		JLabel label_7 = new JLabel("Name");
		label_7.setFont(new Font("Calibri", Font.BOLD, 18));
		label_7.setBounds(23, 74, 130, 32);
		panelWithdrawl.add(label_7);
		
		fieldName3 = new JTextField();
		fieldName3.setEditable(false);
		fieldName3.setColumns(10);
		fieldName3.setBackground(Color.WHITE);
		fieldName3.setBounds(169, 74, 130, 32);
		panelWithdrawl.add(fieldName3);
		
		JLabel label_8 = new JLabel("Account NO.");
		label_8.setFont(new Font("Calibri", Font.BOLD, 18));
		label_8.setBounds(23, 138, 130, 32);
		panelWithdrawl.add(label_8);
		
		fieldAccNo3 = new JTextField();
		fieldAccNo3.setEditable(false);
		fieldAccNo3.setColumns(10);
		fieldAccNo3.setBackground(Color.WHITE);
		fieldAccNo3.setBounds(169, 138, 130, 32);
		panelWithdrawl.add(fieldAccNo3);
		
		JLabel label_9 = new JLabel("Available Balance");
		label_9.setFont(new Font("Calibri", Font.BOLD, 18));
		label_9.setBounds(23, 203, 148, 32);
		panelWithdrawl.add(label_9);
		
		fieldAvailableBalance3 = new JTextField();
		fieldAvailableBalance3.setEditable(false);
		fieldAvailableBalance3.setColumns(10);
		fieldAvailableBalance3.setBackground(Color.WHITE);
		fieldAvailableBalance3.setBounds(169, 203, 130, 32);
		panelWithdrawl.add(fieldAvailableBalance3);
		
		JButton buttonSearchWithdraw = new JButton("Search");
		buttonSearchWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT * FROM balances WHERE name=?";
				try {
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement.setString(1, fieldUser3.getText());
					rs = preparedStatement.executeQuery();
					if (rs.next()) {
						String add1 = rs.getString("name");
						fieldName3.setText(add1);
						String add2 = rs.getString("acc_no");
						fieldAccNo3.setText(add2);
						String add3 = rs.getString("balance");
						fieldAvailableBalance3.setText(add3);
						rs.close();
						preparedStatement.close();
					} else {
						JOptionPane.showMessageDialog(null, "Enter correct name!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				} finally {
					try {
						rs.close();
						preparedStatement.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		buttonSearchWithdraw.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonSearchWithdraw.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonSearchWithdraw.setBackground(SystemColor.activeCaption);
		buttonSearchWithdraw.setBounds(428, 14, 128, 27);
		panelWithdrawl.add(buttonSearchWithdraw);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAmount.setBounds(336, 68, 160, 44);
		panelWithdrawl.add(lblAmount);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Calibri", Font.BOLD, 18));
		lblTotal.setBounds(336, 132, 160, 44);
		panelWithdrawl.add(lblTotal);
		
		JButton buttonShow3 = new JButton("Show");
		buttonShow3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String availableBalance = fieldAvailableBalance3.getText();
					String amount = fieldAmount.getText();
					int sum = Integer.parseInt(availableBalance) - Integer.parseInt(amount);
					String sum1 = String.valueOf(sum);
					fieldTotal.setText(sum1);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		buttonShow3.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonShow3.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonShow3.setBackground(SystemColor.activeCaption);
		buttonShow3.setBounds(371, 206, 107, 27);
		panelWithdrawl.add(buttonShow3);
		
		JButton buttonWithdraw = new JButton("Withdraw");
		buttonWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String a1 = fieldUser3.getText();
					String a2 = fieldTotal.getText();
					String sql = "UPDATE balances SET balance='" + a2 + "' WHERE name='" + a1 + "'";
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement.execute(sql);
					JOptionPane.showMessageDialog(null, "Withdraw Successful!");
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
		buttonWithdraw.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonWithdraw.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonWithdraw.setBackground(SystemColor.activeCaption);
		buttonWithdraw.setBounds(521, 206, 128, 27);
		panelWithdrawl.add(buttonWithdraw);
		
		fieldAmount = new JTextField();
		fieldAmount.setColumns(10);
		fieldAmount.setBackground(Color.WHITE);
		fieldAmount.setBounds(521, 73, 130, 32);
		panelWithdrawl.add(fieldAmount);
		
		fieldTotal = new JTextField();
		fieldTotal.setEditable(false);
		fieldTotal.setColumns(10);
		fieldTotal.setBackground(Color.WHITE);
		fieldTotal.setBounds(521, 137, 130, 32);
		panelWithdrawl.add(fieldTotal);
		panelProfile.setBackground(Color.WHITE);
		panelProfile.setBackground(Color.WHITE);

		JPanel panelViewBalance = new JPanel();
		panelViewBalance.setBackground(Color.WHITE);
		panelProfile.setBackground(Color.WHITE);
		tabbedPane.addTab("View Balance", null, panelViewBalance, null);
		panelViewBalance.setLayout(null);
		
		JLabel label_10 = new JLabel("User");
		label_10.setFont(new Font("Calibri", Font.BOLD, 18));
		label_10.setBounds(28, 24, 130, 32);
		panelViewBalance.add(label_10);
		
		fieldUser4 = new JTextField();
		fieldUser4.setColumns(10);
		fieldUser4.setBackground(Color.WHITE);
		fieldUser4.setBounds(174, 24, 130, 32);
		panelViewBalance.add(fieldUser4);
		
		fieldName4 = new JTextField();
		fieldName4.setEditable(false);
		fieldName4.setColumns(10);
		fieldName4.setBackground(Color.WHITE);
		fieldName4.setBounds(174, 87, 130, 32);
		panelViewBalance.add(fieldName4);
		
		fieldAccNo4 = new JTextField();
		fieldAccNo4.setEditable(false);
		fieldAccNo4.setColumns(10);
		fieldAccNo4.setBackground(Color.WHITE);
		fieldAccNo4.setBounds(174, 151, 130, 32);
		panelViewBalance.add(fieldAccNo4);
		
		fieldAvailableBalance4 = new JTextField();
		fieldAvailableBalance4.setEditable(false);
		fieldAvailableBalance4.setColumns(10);
		fieldAvailableBalance4.setBackground(Color.WHITE);
		fieldAvailableBalance4.setBounds(174, 216, 130, 32);
		panelViewBalance.add(fieldAvailableBalance4);
		
		JLabel label_11 = new JLabel("Available Balance");
		label_11.setFont(new Font("Calibri", Font.BOLD, 18));
		label_11.setBounds(28, 216, 148, 32);
		panelViewBalance.add(label_11);
		
		JLabel label_12 = new JLabel("Account NO.");
		label_12.setFont(new Font("Calibri", Font.BOLD, 18));
		label_12.setBounds(28, 151, 130, 32);
		panelViewBalance.add(label_12);
		
		JLabel label_13 = new JLabel("Name");
		label_13.setFont(new Font("Calibri", Font.BOLD, 18));
		label_13.setBounds(28, 87, 130, 32);
		panelViewBalance.add(label_13);
		
		JButton buttonSearchViewBalance = new JButton("Search");
		buttonSearchViewBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT * FROM balances WHERE name=?";
				try {
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement.setString(1, fieldUser4.getText());
					rs = preparedStatement.executeQuery();
					if(rs.next()) {
						String add1 = rs.getString("name");
						fieldUser4.setText(add1);
						String add2 = rs.getString("acc_no");
						fieldAccNo4.setText(add2);
						String add3 = rs.getString("balance");
						fieldAvailableBalance4.setText(add3);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		buttonSearchViewBalance.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonSearchViewBalance.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonSearchViewBalance.setBackground(SystemColor.activeCaption);
		buttonSearchViewBalance.setBounds(370, 28, 128, 27);
		panelViewBalance.add(buttonSearchViewBalance);

		JPanel panelChangePin = new JPanel();
		panelChangePin.setBackground(Color.WHITE);
		panelProfile.setBackground(Color.WHITE);
		tabbedPane.addTab("Change Pin", null, panelChangePin, null);
		panelChangePin.setLayout(null);
		
		JLabel lblEnterOldPin = new JLabel("Enter Old Pin");
		lblEnterOldPin.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEnterOldPin.setBounds(153, 51, 152, 32);
		panelChangePin.add(lblEnterOldPin);
		
		JLabel lblEnterNewPin = new JLabel("Enter New Pin");
		lblEnterNewPin.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEnterNewPin.setBounds(153, 112, 152, 32);
		panelChangePin.add(lblEnterNewPin);
		
		JButton buttonChange = new JButton("Change");
		buttonChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String value1 = fieldOldPin.getText();
					String value2 = fieldNewPin.getText();
					String sql = "UPDATE account SET pin='" + value2 + "' WHERE pin'" + value1 + "'";
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null, "Successfully changed!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		buttonChange.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonChange.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonChange.setBackground(SystemColor.activeCaption);
		buttonChange.setBounds(315, 164, 179, 27);
		panelChangePin.add(buttonChange);
		
		JButton buttonClear = new JButton("Clear");
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldOldPin.setText("");
				fieldNewPin.setText("");
			}
		});
		buttonClear.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonClear.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonClear.setBackground(SystemColor.activeCaption);
		buttonClear.setBounds(315, 210, 179, 27);
		panelChangePin.add(buttonClear);
		
		fieldOldPin = new JPasswordField();
		fieldOldPin.setBounds(315, 51, 179, 32);
		panelChangePin.add(fieldOldPin);
		
		fieldNewPin = new JPasswordField();
		fieldNewPin.setBounds(315, 111, 179, 32);
		panelChangePin.add(fieldNewPin);
		panelProfile.setBackground(Color.WHITE);
		panelProfile.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Calibri", Font.BOLD, 18));
		lblName.setBounds(10, 30, 130, 32);
		panelProfile.add(lblName);

		fieldName = new JTextField();
		fieldName.setBackground(Color.WHITE);
		fieldName.setEditable(false);
		fieldName.setColumns(10);
		fieldName.setBounds(156, 30, 130, 32);
		panelProfile.add(fieldName);

		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Calibri", Font.BOLD, 18));
		lblDateOfBirth.setBounds(10, 85, 130, 32);
		panelProfile.add(lblDateOfBirth);

		fieldDateOfBirth = new JTextField();
		fieldDateOfBirth.setBackground(Color.WHITE);
		fieldDateOfBirth.setEditable(false);
		fieldDateOfBirth.setColumns(10);
		fieldDateOfBirth.setBounds(156, 85, 130, 32);
		panelProfile.add(fieldDateOfBirth);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Calibri", Font.BOLD, 18));
		lblGender.setBounds(10, 149, 130, 32);
		panelProfile.add(lblGender);

		fieldGender = new JTextField();
		fieldGender.setBackground(Color.WHITE);
		fieldGender.setEditable(false);
		fieldGender.setColumns(10);
		fieldGender.setBounds(156, 149, 130, 32);
		panelProfile.add(fieldGender);

		JLabel label = new JLabel("Account NO.");
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(10, 213, 130, 32);
		panelProfile.add(label);

		fieldAccNo = new JTextField();
		fieldAccNo.setBackground(Color.WHITE);
		fieldAccNo.setEditable(false);
		fieldAccNo.setColumns(10);
		fieldAccNo.setBounds(156, 213, 130, 32);
		panelProfile.add(fieldAccNo);

		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAccountType.setBounds(349, 30, 130, 32);
		panelProfile.add(lblAccountType);

		fieldAccType = new JTextField();
		fieldAccType.setBackground(Color.WHITE);
		fieldAccType.setEditable(false);
		fieldAccType.setColumns(10);
		fieldAccType.setBounds(495, 30, 130, 32);
		panelProfile.add(fieldAccType);

		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Calibri", Font.BOLD, 18));
		lblMobile.setBounds(349, 85, 130, 32);
		panelProfile.add(lblMobile);

		fieldMobile = new JTextField();
		fieldMobile.setBackground(Color.WHITE);
		fieldMobile.setEditable(false);
		fieldMobile.setColumns(10);
		fieldMobile.setBounds(495, 85, 130, 32);
		panelProfile.add(fieldMobile);

		fieldSecQ = new JTextField();
		fieldSecQ.setEditable(false);
		fieldSecQ.setBackground(Color.WHITE);
		fieldSecQ.setColumns(10);
		fieldSecQ.setBounds(495, 149, 130, 32);
		panelProfile.add(fieldSecQ);

		JLabel label_1 = new JLabel("Security Question\r\n");
		label_1.setFont(new Font("Calibri", Font.BOLD, 17));
		label_1.setBounds(349, 149, 130, 32);
		panelProfile.add(label_1);

		JButton buttonEdit = new JButton("Edit");
		buttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldName.setEditable(true);
				fieldMobile.setEditable(true);
				fieldGender.setEditable(true);
				fieldSecQ.setEditable(true);
			}
		});
		buttonEdit.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonEdit.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonEdit.setBackground(SystemColor.activeCaption);
		buttonEdit.setBounds(349, 217, 130, 28);
		panelProfile.add(buttonEdit);

		JButton buttonSave = new JButton("Save");
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = fieldName.getText();
					String gender = fieldGender.getText();
					String accNo = fieldAccNo.getText();
					String mobile = fieldMobile.getText();
					String secQ = fieldSecQ.getText();
					String sql = "UPDATE account SET name='" + name + "',gender='" + gender + "',acc_no='" + accNo
							+ "',mobile='" + mobile + "',sec_q='" + secQ + "' WHERE name='" + fieldUser.getText() + "'";
					String query = "UPDATE balances SET name='" + name + "',acc_no='" + accNo + "'WHERE name='"
							+ fieldUser.getText() + "'";
					preparedStatement = conn.prepareStatement(sql);
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.execute(sql);
					preparedStatement.execute(query);
					JOptionPane.showMessageDialog(null, "Profile updated!");
				} catch (Exception e2) {
					System.out.println(e2);
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		buttonSave.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonSave.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonSave.setBackground(SystemColor.activeCaption);
		buttonSave.setBounds(495, 217, 130, 28);
		panelProfile.add(buttonSave);

		JLabel lblNewLabel_1 = new JLabel("WELCOME!");
		lblNewLabel_1.setFont(new Font("Euphorigenic", Font.PLAIN, 70));
		lblNewLabel_1.setBounds(34, 22, 330, 72);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Open");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT * FROM account WHERE name=?";
				try {
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString(1, fieldUser.getText());
					rs = preparedStatement.executeQuery();
					if (rs.next()) {
						String add1 = rs.getString("name");
						fieldName.setText(add1);
						String add2 = rs.getString("DOB");
						fieldDateOfBirth.setText(add2);
						String add3 = rs.getString("gender");
						fieldGender.setText(add3);
						String add4 = rs.getString("acc_no");
						fieldAccNo.setText(add4);
						String add5 = rs.getString("acc_type");
						fieldAccType.setText(add5);
						String add6 = rs.getString("mobile");
						fieldMobile.setText(add6);
						String add7 = rs.getString("sec_q");
						fieldSecQ.setText(add7);
						rs.close();
						preparedStatement.close();
					} else {
						JOptionPane.showMessageDialog(null, "Enter correct name please.");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e);
				} finally {
					try {
						rs.close();
						preparedStatement.close();
					} catch (Exception e3) {
					}
				}
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(586, 60, 108, 23);
		contentPane.add(btnNewButton);
		
	}

	final JComboBox comboboxCreditAccount = new JComboBox();
	private JTextField fieldUser3;
	private JTextField fieldName3;
	private JTextField fieldAccNo3;
	private JTextField fieldAvailableBalance3;
	private JTextField fieldAmount;
	private JTextField fieldTotal;
	private JTextField fieldUser4;
	private JTextField fieldName4;
	private JTextField fieldAccNo4;
	private JTextField fieldAvailableBalance4;
	private JPasswordField fieldOldPin;
	private JPasswordField fieldNewPin;
	public void Account() {
		try {
			String sql = "SELECT * FROM balances";
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String account = rs.getString("acc_no");
				comboboxCreditAccount.addItem(account);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
}
