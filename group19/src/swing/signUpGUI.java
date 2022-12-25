package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class signUpGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmailSDT;
	
	public static ArrayList<User> list = new ArrayList<>();
	private JTextField tfMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUpGUI frame = new signUpGUI();
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
	public signUpGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfEmailSDT = new JTextField();
		tfEmailSDT.setColumns(10);
		tfEmailSDT.setBounds(281, 108, 255, 35);
		contentPane.add(tfEmailSDT);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(180, 164, 88, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Email / SĐT:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(180, 111, 88, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnDangKy = new JButton("Đăng ký");
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDangKy.setBackground(new Color(152, 251, 152));
		btnDangKy.setBounds(326, 235, 107, 35);
		contentPane.add(btnDangKy);
		
		btnDangKy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User(tfEmailSDT.getText(),tfMatKhau.getText());
				list.add(user);
				System.out.println(list);
				dispose();
				Window dangNhap = new logInGUI();
				dangNhap.show();
				
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Bạn đã có tài khoản?");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(284, 309, 134, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDangNhap = new JLabel("Đăng nhập");
		lblDangNhap.setForeground(new Color(0, 139, 139));
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDangNhap.setBounds(428, 309, 93, 23);
		contentPane.add(lblDangNhap);
		
		lblDangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Window dangNhap = new logInGUI();
				dangNhap.show();
			}
		});
		
		JLabel lblngK = new JLabel("Đăng ký");
		lblngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblngK.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblngK.setBounds(307, 28, 126, 47);
		contentPane.add(lblngK);
		
		tfMatKhau = new JTextField();
		tfMatKhau.setColumns(10);
		tfMatKhau.setBounds(281, 153, 255, 35);
		contentPane.add(tfMatKhau);
	}

}
