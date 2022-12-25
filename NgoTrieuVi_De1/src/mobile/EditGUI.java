package mobile;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import file.FileWork;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class EditGUI extends JFrame implements MobileManager{

	static FileWork fileWork = new FileWork();
	public ArrayList<Mobile> list = fileWork.readMobiles();

	public static Mobile mobileEdit = new Mobile();
	
	private JPanel contentPane;
	private JTextField editName;
	private JTextField editPrice;
	private JTextField editTotal; 
	private JTextField editBrand;
	private JTextField editBattery;
	private JTextField editMemory;
	private static EditGUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new EditGUI();
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
	 */
	public EditGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setBackground(new Color(233, 252, 250));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEditAMobile = new JLabel("Edit a mobile");
		lblEditAMobile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEditAMobile.setBounds(339, 23, 180, 32);
		contentPane.add(lblEditAMobile);

		editName = new JTextField();
		editName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editName.setColumns(10);
		editName.setBounds(287, 89, 328, 25);
		contentPane.add(editName);

		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(200, 92, 70, 19);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Price:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(200, 135, 70, 19);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Total:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(200, 182, 70, 19);
		contentPane.add(lblNewLabel_1_3);

		editPrice = new JTextField();
		editPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editPrice.setColumns(10);
		editPrice.setBounds(287, 137, 328, 25);
		contentPane.add(editPrice);

		editTotal = new JTextField();
		editTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editTotal.setColumns(10);
		editTotal.setBounds(287, 182, 328, 25);
		contentPane.add(editTotal);

		editBrand = new JTextField();
		editBrand.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editBrand.setColumns(10);
		editBrand.setBounds(287, 227, 328, 25);
		contentPane.add(editBrand);

		editBattery = new JTextField();
		editBattery.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editBattery.setColumns(10);
		editBattery.setBounds(287, 273, 328, 25);
		contentPane.add(editBattery);

		editMemory = new JTextField();
		editMemory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editMemory.setColumns(10);
		editMemory.setBounds(287, 315, 328, 25);
		contentPane.add(editMemory);

		JLabel lblNewLabel_1_5 = new JLabel("Battery:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(200, 273, 70, 19);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_4 = new JLabel("Brand:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(200, 230, 70, 19);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_6 = new JLabel("Memory:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_6.setBounds(200, 318, 70, 19);
		contentPane.add(lblNewLabel_1_6);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBackground(new Color(128, 255, 128));
		btnSave.setBounds(318, 384, 99, 32);
		contentPane.add(btnSave);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mobileEdit.setProduct_name(editName.getText());
				mobileEdit.setProduct_price(Double.parseDouble(editPrice.getText()));
				mobileEdit.setProduct_total(Integer.parseInt(editTotal.getText()));
				mobileEdit.setMobile_brand(editBrand.getText());
				mobileEdit.setMobile_battery(Double.parseDouble(editBattery.getText()));
				mobileEdit.setMobile_memory(Integer.parseInt(editMemory.getText()));
				
				new EditGUI().editMobile(mobileEdit);
				
				Window homeWindow = null;
				try {
					homeWindow = new HomeGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				homeWindow.show();
				dispose();
				
			}
		});
	}

	@Override
	public boolean addMobile(Mobile m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editMobile(Mobile m) {
		int index=0;
		for (Mobile mobile : list) {
			if(m.getProduct_id().equals(mobile.getProduct_id())) {
				index = list.indexOf(mobile);
				System.out.println(index);
				break;
			}
		}
		
		// set mobile at index by m
		
		list.set(index, m);
		try {
			fileWork.writeMobile(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (list.get(index).equals(m)) ? true : false;
	}

	@Override
	public boolean delMobile(Mobile m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Mobile> searchMobile(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mobile> sortedMobile(double price) {
		// TODO Auto-generated method stub
		return null;
	}

}
