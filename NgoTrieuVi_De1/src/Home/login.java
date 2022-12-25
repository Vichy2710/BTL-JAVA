package Home;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);

					frame.setLocationRelativeTo(null);

					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		ListUsers.init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 370);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(233, 252, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblLogIn.setBounds(336, 10, 110, 56);
		contentPane.add(lblLogIn);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(124, 116, 111, 16);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setBounds(280, 101, 223, 33);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(124, 178, 111, 16);
		contentPane.add(lblPassword);
		

		textFieldPassword = new JPasswordField();
		textFieldPassword.setToolTipText("\r\n");
		textFieldPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPassword.setBounds(280, 163, 223, 33);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ListUsers.checkUser(textFieldEmail.getText(), textFieldPassword.getText()) == null) {
					JOptionPane.showMessageDialog(contentPane, "Log in unsuccessful");
					return;
				}
				TrangChuGUI trangChuGUI;
				try {
					trangChuGUI = new TrangChuGUI();
					User user = new User(textFieldEmail.getText(),textFieldPassword.getText());
					new TrangChuGUI().currentUser = user;
					dispose();
					Window trangchuWindow = new TrangChuGUI();
					trangchuWindow.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSubmit.setBounds(336, 252, 110, 33);
		contentPane.add(btnSubmit);
		
		
		
		
	}
}
