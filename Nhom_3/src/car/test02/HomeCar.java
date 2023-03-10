package car.test02;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Home.TrangChuGUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import car.test01.*;


public class HomeCar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTextField textFieldTotal;
	private JTextField textFieldCylinder;
	private JTextField textFieldSeat;
	private CarManagerImpl carManagerImpl = new CarManagerImpl();
	private List<Car> list = new ArrayList<>();
	private static int idSelected;
	private JTextField textFieldSearch;
	private JTextField textFieldSort;

	public static final String LOCAL_PATH = TrangChuGUI.LOCAL_PATH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeCar frame = new HomeCar();
					frame.setLocationRelativeTo(null);
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
	public HomeCar() throws Exception, ClassNotFoundException {
		carManagerImpl.init(20);
		list = FileCar.InOutFile(carManagerImpl.getList());
		
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1165, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 252, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		scrollPane.setBounds(389, 54, 752, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"ID", "Name", "Price", "Total", "Cylinder Capacity", "Seat"
			}
		));
		
		
		
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		showTable(list);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				textFieldName.setText((String) table.getValueAt(row, 1));
				textFieldPrice.setText(String.valueOf(table.getValueAt(row, 2)));
				textFieldTotal.setText(String.valueOf(table.getValueAt(row, 3)));
				textFieldCylinder.setText(String.valueOf(table.getValueAt(row, 4)));
				textFieldSeat.setText(String.valueOf(table.getValueAt(row, 5)));
				idSelected =  (int) table.getValueAt(row, 0);
			}
		});
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(0, 0, 255));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setBackground(new Color(0, 0, 0));
		lblName.setBounds(10, 336, 90, 13);
		contentPane.add(lblName);
		
		textFieldName = new JTextField(); 
		textFieldName.setBounds(215, 334, 177, 19);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(new Color(0, 0, 255));
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(10, 378, 90, 13);
		contentPane.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(215, 375, 177, 21);
		contentPane.add(textFieldPrice);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(new Color(0, 0, 255));
		lblTotal.setBounds(10, 429, 90, 13);
		contentPane.add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(215, 427, 177, 19);
		contentPane.add(textFieldTotal);
		
		JLabel lblCylinder = new JLabel("CYLINDER CAPACITY");
		lblCylinder.setForeground(new Color(0, 0, 255));
		lblCylinder.setHorizontalAlignment(SwingConstants.CENTER);
		lblCylinder.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCylinder.setBounds(23, 477, 177, 13);
		contentPane.add(lblCylinder);
		
		textFieldCylinder = new JTextField();
		textFieldCylinder.setColumns(10);
		textFieldCylinder.setBounds(215, 475, 177, 19);
		contentPane.add(textFieldCylinder);
		
		JLabel lblSeat = new JLabel("SEAT");
		lblSeat.setForeground(new Color(0, 0, 255));
		lblSeat.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSeat.setBounds(6, 517, 90, 13);
		contentPane.add(lblSeat);
		
		textFieldSeat = new JTextField();
		textFieldSeat.setColumns(10);
		textFieldSeat.setBounds(215, 515, 177, 19);
		contentPane.add(textFieldSeat);
		
		JPanel backPanel = new JPanel();
		backPanel.setBounds(23, 15, 165, 35);
		backPanel.setBackground(new Color(233, 252, 250));
		contentPane.add(backPanel);
		BufferedImage backBufferedImage = ImageIO.read(new File(LOCAL_PATH+"back_icon.png"));		
		backPanel.setLayout(null);		
		JLabel backImageJLabel = new JLabel((Icon) new ImageIcon( 
				backBufferedImage.getScaledInstance(35,35,Image.SCALE_SMOOTH)));
		backImageJLabel.setSize(35,35);
		backPanel.add(backImageJLabel);
		
		JLabel lblHome = new JLabel("Back to Home");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHome.setBounds(45, 0, 124, 35);
		backPanel.add(lblHome);
		
		backPanel.addMouseListener((MouseListener) new MouseListener() {
			
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

				TrangChuGUI trangChuGUI = null;
				try {
					trangChuGUI = new TrangChuGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				trangChuGUI.show();
				dispose();
				
			}
		});
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 128, 255));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkValue()) return;
				Car car = new Car(list.get(list.size()-1).getProduct_id() + 1, textFieldName.getText(),
						Double.parseDouble(textFieldPrice.getText()), Integer.parseInt(textFieldTotal.getText()),
						Double.parseDouble(textFieldCylinder.getText()), Integer.parseInt(textFieldSeat.getText())
						);
				if(!checkCar(car, list))	return;
				list.add(car);
				fillTable();
			}
		});
		btnAdd.setBounds(10, 217, 124, 42);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setForeground(new Color(255, 255, 255));
		btnEdit.setBackground(new Color(0, 128, 255));
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0 ; i < list.size(); i++) {
					if(list.get(i).getProduct_id() == idSelected) {
						list.set(i, editCar());
					}		
				}
				fillTable();
			}
		});
		btnEdit.setBounds(182, 216, 124, 44);
		contentPane.add(btnEdit);
		
		JButton btnDel = new JButton("DELETE");
		btnDel.setForeground(new Color(255, 255, 255));
		btnDel.setBackground(new Color(0, 128, 255));
		btnDel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0 ; i < list.size(); i++) {
					if(list.get(i).getProduct_id() == idSelected) {
						list.remove(i);
					}		
				}
				resetId(list);
				fillTable();

			}
		});
		btnDel.setBounds(182, 104, 124, 42);
		contentPane.add(btnDel);
		
		JLabel lblNewLabel = new JLabel("TYPE OF SEARCH");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(422, 378, 155, 13);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxTypeSearch = new JComboBox();
		comboBoxTypeSearch.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxTypeSearch.setModel(new DefaultComboBoxModel(new String[] {"T??n ?? t??", "Gi?? ?? t??", "S??? l?????ng ?? t??", "Dung t??ch xylanh ?? t??", "S??? ch??? ng???i ?? t??"}));
		comboBoxTypeSearch.setBounds(586, 378, 177, 20);
		contentPane.add(comboBoxTypeSearch);
		
		JLabel lblNewLabel_1 = new JLabel("VALUE SEARCH");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(422, 477, 124, 13);
		contentPane.add(lblNewLabel_1);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(586, 471, 177, 19);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(0, 128, 255));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Car> listSearch = new ArrayList<>();
				String valueSearch = comboBoxTypeSearch.getSelectedItem().toString();
				String typeSearch = textFieldSearch.getText();
				if(valueSearch.trim().toLowerCase().equals(comboBoxTypeSearch.getItemAt(0).toString().toLowerCase())) {
					if(typeSearch.equals("")) {
						inValidValue();
					}
					listSearch = carManagerImpl.searchCar(typeSearch);
					showTable(listSearch);
				} 
				
				else if(valueSearch.trim().toLowerCase().equals(comboBoxTypeSearch.getItemAt(1).toString().toLowerCase())) {
					try {
						double price = Double.parseDouble(typeSearch);
						if(price < 0) {
							inValidValue();
						}
						listSearch = carManagerImpl.searchCar(price);
						showTable(listSearch);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(contentPane, "S??? li???u nh???p v??o kh??ng h???p l???!");
					}
				} 
				
				else if(valueSearch.trim().toLowerCase().equals(comboBoxTypeSearch.getItemAt(2).toString().toLowerCase())) {
					try {
						int total = Integer.parseInt(typeSearch);
						if(total < 0) {
							inValidValue();
						}
						listSearch = carManagerImpl.searchCar(total);
						showTable(listSearch);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(contentPane, "S??? li???u nh???p v??o kh??ng h???p l???!");
					}
				} 
				
				else if(valueSearch.trim().toLowerCase().equals(comboBoxTypeSearch.getItemAt(3).toString().toLowerCase())) {
					try {
						double cylinder = Double.parseDouble(typeSearch);
						if(cylinder < 0) {
							inValidValue();
						}
						listSearch = carManagerImpl.searchCarByCylinder(cylinder);
						showTable(listSearch);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(contentPane, "S??? li???u nh???p v??o kh??ng h???p l???!");
					}
				} 
				
				else if(valueSearch.trim().toLowerCase().equals(comboBoxTypeSearch.getItemAt(4).toString().toLowerCase())) {
					try {
						int seat = Integer.parseInt(typeSearch);
						if(seat < 0)
							inValidValue();
						listSearch = carManagerImpl.searchCarBySeat(seat);
						showTable(listSearch);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(contentPane, "S??? li???u nh???p v??o kh??ng h???p l???!");
					}
				}
				
			}
		});
		btnSearch.setBounds(513, 546, 124, 38);
		contentPane.add(btnSearch);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(0, 128, 255));
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(10, 104, 124, 42);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_2 = new JLabel("TYPE OF SORT");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(813, 382, 113, 13);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBoxTypeSort = new JComboBox();
		comboBoxTypeSort.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxTypeSort.setModel(new DefaultComboBoxModel(new String[] {"S???p x???p theo gi??", "S???p x???p theo dung t??ch xylanh"}));
		comboBoxTypeSort.setBounds(964, 378, 177, 19);
		contentPane.add(comboBoxTypeSort);
		
		JComboBox comboBoxSort = new JComboBox();
		comboBoxSort.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxSort.setModel(new DefaultComboBoxModel(new String[] {"T??ng d???n", "Gi???m d???n"}));
		comboBoxSort.setBounds(964, 425, 177, 21);
		contentPane.add(comboBoxSort);
		
		textFieldSort = new JTextField();
		textFieldSort.setBounds(964, 475, 177, 19);
		contentPane.add(textFieldSort);
		textFieldSort.setColumns(10);
		
		JButton btnSort = new JButton("SORT");
		btnSort.setForeground(new Color(255, 255, 255));
		btnSort.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSort.setBackground(new Color(0, 128, 255));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Car> listSort = new ArrayList<>();
				String valueSort = comboBoxTypeSort.getSelectedItem().toString();
				String valueINC = comboBoxSort.getSelectedItem().toString();
				boolean isINC =  true;
				if(valueINC.equals("Gi???m d???n"))
					isINC = false;
				String typeSort = textFieldSort.getText();

				
				if(valueSort.trim().toLowerCase().equals(comboBoxTypeSort.getItemAt(0).toString().toLowerCase())) {
					try {
						double price = Double.parseDouble(typeSort);
						if(price < 0) {
							inValidValue();
						}
						listSort = carManagerImpl.sortedCar(price, isINC);
						showTable(listSort);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "S??? li???u nh???p v??o kh??ng h???p l???!");
					}
				} else if(valueSort.trim().toLowerCase().equals(comboBoxTypeSort.getItemAt(1).toString().toLowerCase())) {
					try {
						double cylinder = Double.parseDouble(typeSort);
						if(cylinder < 0) {
							inValidValue();
						}
						listSort = carManagerImpl.sortedCarByCylinder(cylinder, isINC);
						showTable(listSort);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "S??? li???u nh???p v??o kh??ng h???p l???!");
					}
				}
			}
		});
		btnSort.setBounds(914, 546, 124, 38);
		contentPane.add(btnSort);
		
		JLabel lblNewLabel_3 = new JLabel("INPUT INFORMATION");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(72, 569, 277, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("VALUE SORT");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(820, 474, 106, 19);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CAR MANAGEMENT PROGRAME");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(350, 10, 436, 34);
		contentPane.add(lblNewLabel_5);
	}
	
	public boolean checkCar(Car c, List<Car> list) {
		for (Car car : list) {
			if(car.equals(c)) {
				JOptionPane.showMessageDialog(contentPane, "???? t???n t???i!", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	public boolean checkValue() {
		if(!checkEmptyValue()) return false;
		StringBuilder strb = new StringBuilder();
		if(Double.parseDouble(textFieldPrice.getText()) < 0)
			strb.append("S??? ti???n kh??ng h???p l???!\n");
		if(Integer.parseInt(textFieldTotal.getText())  < 0)
			strb.append("S??? l?????ng kh??ng h???p l???!\n");
		if(Double.parseDouble(textFieldCylinder.getText()) < 0)
			strb.append("Dung t??ch xylanh kh??ng h???p l???!\n");
		if(Integer.parseInt(textFieldSeat.getText()) < 0)
			strb.append("S??? ch??? ng???i kh??ng h???p l???!\n");
		if(strb.length() > 0) {
			JOptionPane.showMessageDialog(contentPane, strb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false; 
		}
		return true;
	}
	
	public boolean checkEmptyValue() {
		StringBuilder strb = new StringBuilder();
		if(textFieldName.getText().equals(""))
			strb.append("T??n kh??ng ???????c ????? tr???ng!\n");
		if(textFieldPrice.getText().equals(""))
			strb.append("Gi?? kh??ng ???????c b??? tr???ng!\n");
		if(textFieldTotal.getText().equals(""))
			strb.append("S??? l????ng kh??ng ???????c b??? tr???ng!\n");
		if(textFieldCylinder.getText().equals(""))
			strb.append("Dung t??ch xylanh kh??ng ???????c ????? tr???ng!\n");
		if(textFieldSeat.getText().equals(""))
			strb.append("S??? ch??? ng???i kh??ng ???????c ????? tr???ng!\n");
		if(strb.length() > 0) {
			JOptionPane.showMessageDialog(contentPane, strb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;		
	}
	
	public void inValidValue() {
		JOptionPane.showMessageDialog(contentPane, "S??? li???u nh???p v??o kh??ng h???p l???!");
		return;
	}

	public void resetId(List<Car> list) {
		int i = 0;
		for(Car car: list) {
			car.setProduct_id(++i);
		}
	}
	
	public void reset() {
		resetTextField();
		fillTable();
	}
	
	public void resetTextField() {
		textFieldName.setText("");
		textFieldPrice.setText("");
		textFieldTotal.setText("");
		textFieldCylinder.setText("");
		textFieldSeat.setText("");
	}
	
	public void fillTable() {
		try {
			list = FileCar.InOutFile(list);
			showTable(list);
			resetTextField();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public void showTable(List<Car> list) {
		model.setRowCount(0);
		for(Car car : list) {
			model.addRow(new Object[] { car.getProduct_id(), car.getProduct_name(), car.getProduct_price(),
					car.getProduct_total(), car.getCylinderCapacity(), car.getSeat() });
		}
	}

	
	public Car editCar() {
		Car car = new Car();
		car.setProduct_id(idSelected);
			car.setProduct_name(textFieldName.getText());
			car.setProduct_price(Double.parseDouble(textFieldPrice.getText()));
			car.setProduct_total(Integer.parseInt(textFieldTotal.getText()));
			car.setCylinderCapacity(Double.parseDouble(textFieldCylinder.getText()));
			car.setSeat(Integer.parseInt(textFieldSeat.getText()));
		return car;
	}
	
	
}
