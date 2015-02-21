import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextPane;


public class MyMachine {

	private JFrame frame;
	private JButton btnNewButton = new JButton("Enter");
	private JLabel lblNewLabel = new JLabel("Please enter your account number and password:");
	private static String account, password;
	private static JPanel panel = new JPanel();
	private static JLabel lblMainMenu = new JLabel("Main Menu");
	private final JButton btnNewButton_1 = new JButton("Deposit");
	private final JButton btnExit = new JButton("Exit");
	private final JButton btnCheckBalance = new JButton("Check Balance");
	private final JButton btnWithdraw = new JButton("Withdraw");
	private static JTextField textField = new JTextField();
	private static JPasswordField passwordField = new JPasswordField();
	private static double balance = 1000;
	private static JPanel CheckBalance = new JPanel();
	private static JLabel lblNewLabel_1 = new JLabel("Check Balance");
	public static void main(String[] args) {
		lblMainMenu.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblMainMenu.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMainMenu.setVisible(false);
		panel.setVisible(false);
		JOptionPane.showMessageDialog(null, "Welcome To Bank of CST141 \n " +
				"533 College Road \n Selden, NY 11784 \n \n Press OK to proceed", null, JOptionPane.PLAIN_MESSAGE);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMachine window = new MyMachine();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MyMachine() {
		initialize();
	
	}

	private void initialize() {
		
		
		signIn();
		MainMenu(true);
		btnExit();
		btnCheckBalance();
		btnDeposit();
		btnWithdraw();

		
		
		
		
		
	
		
	
		
	
	}
	private void signIn(){

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField.setBounds(112, 114, 226, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		lblNewLabel.setBounds(174, 12, 102, 20);
		frame.getContentPane().add(lblNewLabel);
		passwordField.setBounds(112, 155, 226, 27);
		frame.getContentPane().add(passwordField);
		
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("TakaoPGothic", Font.BOLD, 18));
		btnNewButton.setBounds(125, 199, 200, 40);
		frame.getContentPane().add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				account = textField.getText();
				password = passwordField.getText();
				if (account.equals("12345678")&&password.equals("SecretWord")){
					lblMainMenu.setVisible(true);
					panel.setVisible(true);
					textField.setVisible(false);
					passwordField.setVisible(false);
					btnNewButton.setVisible(false);
					lblNewLabel.setVisible(false);
				}
				else {
					frame.setVisible(false);
					JOptionPane.showMessageDialog(null, "Username/Password incorrect please try again",null, JOptionPane.ERROR_MESSAGE);
					frame.setVisible(true);
				}
			}
		});
	}
	private void MainMenu(boolean a){
		panel.setBounds(0, 0, 448, 269);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		
		lblNewLabel_1.setBounds(151, 5, 147, 22);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setVisible(a);
		

		lblMainMenu.setBounds(174, 12, 102, 20);
		panel.add(lblMainMenu);


		lblMainMenu.setVisible(a);
		btnWithdraw.setVisible(a);
		btnNewButton_1.setVisible(a);
		btnCheckBalance.setVisible(a);
		btnExit.setVisible(a);
		
	}
	private void btnWithdraw(){
		btnWithdraw.setForeground(new Color(0, 128, 0));
		btnWithdraw.setFont(new Font("Dialog", Font.BOLD, 18));
		btnWithdraw.setBounds(225, 39, 225, 118);
		
		panel.add(btnWithdraw);
	}
	private void btnDeposit(){
		btnNewButton_1.setForeground(new Color(107, 142, 35));
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton_1.setBounds(0, 157, 225, 118);
		panel.add(btnNewButton_1);
	}
	private void btnExit(){
	
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Dialog", Font.BOLD, 18));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "Have a nice day!",null, JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});
		btnExit.setBounds(225, 157, 225, 118);
		panel.add(btnExit);
	}
	private void btnCheckBalance(){
		btnCheckBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu(false);
				CheckBalance.setBounds(0, 0, 450, 275);
				panel.add(CheckBalance);
				CheckBalance.setLayout(null);
				CheckBalance.add(lblNewLabel_1);
				String vary;
				JTextPane textPane = new JTextPane();
				textPane.setFont(new Font("Dialog", Font.PLAIN, 51));
				textPane.setBounds(115, 53, 220, 70);
				CheckBalance.add(textPane);
				textPane.setText(vary = Double.toString(balance));
				JLabel lblNewLabel_2 = new JLabel("$");
				lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 51));
				lblNewLabel_2.setBounds(77, 49, 70, 70);
				CheckBalance.add(lblNewLabel_2);
			}
		});
		btnCheckBalance.setForeground(new Color(0, 255, 0));
		btnCheckBalance.setFont(new Font("Dialog", Font.BOLD, 18));
		btnCheckBalance.setBounds(0, 39, 225, 118);
		panel.add(btnCheckBalance);
		
		
	}
}