package Home;
import java.awt.EventQueue;
import mobile.*;
import report.StatisticalFrame;
import tour.Swing;

import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.LineBorder;

import car.test02.HomeCar;

import javax.swing.Box;

public class TrangChuGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane; 
	private static TrangChuGUI frame;
	public static User currentUser = new User();
	
	/**
	 * get user from loginGUI
	 * @throws IOException 
	 * 
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TrangChuGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public TrangChuGUI() throws IOException {
		setBackground(new Color(233, 252, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 589);
		contentPane = new JLayeredPane();
		contentPane.setBackground(new Color(233, 252, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BufferedImage homeBufferedImage = ImageIO.read(new File("D:\\Java_School\\home.jpg"));		
		JLabel homeImageJLabel = new JLabel(new ImageIcon( 
				homeBufferedImage.getScaledInstance(1000, 170,Image.SCALE_SMOOTH)));
		 
		homeImageJLabel.setLocation(-11, 63);
		homeImageJLabel.setSize(1009, 139);
		contentPane.add(homeImageJLabel);
		
		BufferedImage logoBufferedImage = ImageIO.read(new File("D:\\Java_School\\logo.png"));		
		JLabel logoImageJLabel = new JLabel(new ImageIcon( 
				logoBufferedImage.getScaledInstance(35, 35,Image.SCALE_SMOOTH)));
		
		logoImageJLabel.setLocation(25, 10);
		logoImageJLabel.setSize(35, 35);
		contentPane.add(logoImageJLabel);
		
		JLabel groupName = new JLabel("Nhóm 3");
		groupName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		groupName.setBounds(75, 10, 144, 43);
		contentPane.add(groupName);
		
		JButton btnLogOut = new JButton("Đăng xuất");
		btnLogOut.setBackground(new Color(255, 255, 255));
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogOut.setBounds(790, 10, 128, 43);
		btnLogOut.setFocusable(false);
		btnLogOut.setFocusPainted(false);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentUser = new User();
				Window loginWindow = new login();
				loginWindow.show();
				dispose();
			}
		});
		
		// car manage
		JPanel carPanel = new JPanel();
		carPanel.setBorder(new LineBorder(new Color(87, 87, 87), 2));
		carPanel.setBackground(new Color(255, 255, 255));
		carPanel.setBounds(146, 327, 144, 98);
		contentPane.add(carPanel);
		
		BufferedImage carBufferedImage = ImageIO.read(new File("D:\\Java_School\\car_icon.png"));		
		carPanel.setLayout(null);
		JLabel carName = new JLabel("Ô tô");
		carName.setForeground(new Color(87, 87, 87));
		carName.setHorizontalAlignment(SwingConstants.CENTER);
		carName.setFont(new Font("Arial", Font.BOLD, 25));
		carName.setBounds(0, 53, 144, 45);
		carPanel.add(carName);
		JLabel carImageJLabel = new JLabel(new ImageIcon( 
				carBufferedImage.getScaledInstance(45,45,Image.SCALE_SMOOTH)));
		carImageJLabel.setBounds(0, 0, 144, 55);
		carPanel.add(carImageJLabel);
		
		// mobile manage
		JPanel mobilePanel = new JPanel();
		mobilePanel.setLayout(null);
		mobilePanel.setBorder(new LineBorder(new Color(87, 87, 87), 2));
		mobilePanel.setBackground(Color.WHITE);
		mobilePanel.setBounds(687, 327, 144, 98);
		contentPane.add(mobilePanel);
		mobilePanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Window homeWindow = null;
				try {
					homeWindow = new HomeGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				homeWindow.show();
				
			}
		});
		
		JLabel mobileName = new JLabel("Điện thoại");
		mobileName.setHorizontalAlignment(SwingConstants.CENTER);
		mobileName.setForeground(new Color(87, 87, 87));
		mobileName.setFont(new Font("Arial", Font.BOLD, 25));
		mobileName.setBounds(0, 53, 144, 45);
		mobilePanel.add(mobileName);
		
		BufferedImage mobileBufferedImage = ImageIO.read(new File("D:\\Java_School\\mobile_icon.png"));		
		mobilePanel.setLayout(null);		
		JLabel mobileImageJLabel = new JLabel(new ImageIcon( 
				mobileBufferedImage.getScaledInstance(45,45,Image.SCALE_SMOOTH)));
		mobileImageJLabel.setBounds(0, 0, 144, 55);
		mobilePanel.add(mobileImageJLabel);
		
		// tour manage
		JPanel tourPanel = new JPanel();
		tourPanel.setLayout(null);
		tourPanel.setBorder(new LineBorder(new Color(87, 87, 87), 2));
		tourPanel.setBackground(Color.WHITE);
		tourPanel.setBounds(417, 327, 144, 98);
		contentPane.add(tourPanel);
		tourPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Window swing = null;
				try {
					swing = new Swing();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				swing.show();
				
			}
		});
		
		carPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Window car = null;
				try {
					car = new HomeCar();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				car.show();
				
			}
		});
		
		JLabel tourName = new JLabel("Tour");
		tourName.setHorizontalAlignment(SwingConstants.CENTER);
		tourName.setForeground(new Color(87, 87, 87));
		tourName.setFont(new Font("Arial", Font.BOLD, 25));
		tourName.setBounds(0, 53, 144, 45);
		tourPanel.add(tourName);
		
		BufferedImage tourBufferedImage = ImageIO.read(new File("D:\\Java_School\\tour_icon.png"));		
		tourPanel.setLayout(null);		
		JLabel tourImageJLabel = new JLabel(new ImageIcon( 
				tourBufferedImage.getScaledInstance(45,45,Image.SCALE_SMOOTH)));
		tourImageJLabel.setBounds(0, 0, 144, 55);
		tourPanel.add(tourImageJLabel);
		
		JPanel connectPanel = new JPanel();
		connectPanel.setBackground(new Color(255, 255, 255));
		connectPanel.setForeground(new Color(255, 255, 255));
		connectPanel.setBounds(-11, 483, 991, 92);
		contentPane.add(connectPanel);
		connectPanel.setLayout(null);
		
		JLabel sdt = new JLabel("SĐT: 0352601794");
		sdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sdt.setForeground(new Color(87, 87, 87));
		sdt.setBounds(44, 0, 166, 36);
		connectPanel.add(sdt);
		
		JLabel email = new JLabel("Email: trieuvino.1@gmail.com");
		email.setForeground(new Color(87, 87, 87));
		email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		email.setBounds(42, 32, 245, 36);
		connectPanel.add(email);
		
		JLabel lblQunLSn = new JLabel("Quản lý sản phẩm");
		lblQunLSn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLSn.setFont(new Font("Arial", Font.BOLD, 42));
		lblQunLSn.setBounds(300, 241, 384, 54);
		contentPane.add(lblQunLSn);
		
		JLabel lblChoMngNg = new JLabel("Chào mừng "+currentUser.getEmail()+" đến với phần mềm");
		lblChoMngNg.setFont(new Font("Arial", Font.ITALIC, 17));
		lblChoMngNg.setBounds(10, 201, 567, 43);
		contentPane.add(lblChoMngNg);
		
		JButton btnReport = new JButton("Thống kê");
		btnReport.setBackground(new Color(255, 250, 240));
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReport.setBounds(803, 212, 114, 32);
		contentPane.add(btnReport);
		btnReport.setFocusable(false);
		btnReport.setFocusPainted(false);
		btnReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
	}
}
