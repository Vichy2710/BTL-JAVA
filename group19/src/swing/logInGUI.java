package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class logInGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JPasswordField passwordField;
	private JTextField tfMatKhau;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logInGUI frame = new logInGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public logInGUI() {
		setResizable(false);
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(320, 38, 126, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email / SĐT:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(188, 113, 88, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(188, 166, 88, 25);
		contentPane.add(lblNewLabel_1_1);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(289, 110, 255, 35);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBackground(new Color(152, 251, 152));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDangNhap.setBounds(332, 237, 114, 35);
		contentPane.add(btnDangNhap);
		
		//bat su kien dang nhap
		btnDangNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				signUpGUI suGui = new signUpGUI();
				String email = tfEmail.getText();
				String password = tfMatKhau.getText();
				User user = new User(email,password);

				for(int i=0;i<suGui.list.size();i++) {
					if(suGui.list.get(i).getUserName().equals(email)
							&& suGui.list.get(i).getPassword().equals(password)) {
						dispose();
						Window home = new homeGUI();
						home.show();
					}
				}
				
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Bạn chưa có tài khoản?");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(289, 311, 149, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDangKy = new JLabel("Đăng ký");
		lblDangKy.setForeground(new Color(0, 139, 139));
		lblDangKy.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDangKy.setBounds(440, 311, 71, 23);
		contentPane.add(lblDangKy);
		
		tfMatKhau = new JTextField();
		tfMatKhau.setColumns(10);
		tfMatKhau.setBounds(286, 156, 255, 35);
		contentPane.add(tfMatKhau);
		
		// bat su kien sang trang dang ky
		lblDangKy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				dispose();
				Window signUp = new signUpGUI();
				signUp.show();
				
			}
		});
		
	}
}
