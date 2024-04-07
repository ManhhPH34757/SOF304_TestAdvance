package com.shoplaptop.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.shoplaptop.dao.DotGiamGiaDAO;
import com.shoplaptop.entity.DotGiamGia;
import com.shoplaptop.utils.MsgBox;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XImage;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DotgiamgiaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTimKiem;
	private JTable tblDotGiamGia;
	private DefaultTableModel model;
	public List<DotGiamGia> list = new ArrayList<DotGiamGia>();
	private JTextField txtMaDotGiam;
	private JTextField txtTenDotGiam;
	private JTextField txtHan;
	private JTextField txtGiaGiam;
	private JTextField txtMoTa;
	private JTextField txtDieuKienGiam;
	String SelectByTenDGG = "SELECT * FROM dbo.DotGiamGia WHERE TenDG Like ?";
	public DotGiamGiaDAO dotGiamGiaDAO = new DotGiamGiaDAO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DotgiamgiaView dialog = new DotgiamgiaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DotgiamgiaView() {
		setBounds(100, 100, 975, 675);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setIconImage(XImage.getAppIcon());
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 941, 587);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm Kiếm");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(20, 39, 152, 33);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 128, 128)));
		panel_1.setBounds(10, 71, 570, 57);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtTimKiem.setBounds(10, 10, 442, 34);
		panel_1.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.setBounds(473, 7, 85, 34);
		panel_1.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindByTenDGG();
			}
		});
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 580, 329);
		panel.add(scrollPane);
			
		model = new DefaultTableModel();
		String[] cols = {"Mã Đợt Giảm Giá","Tên Đợt Giảm Giá","Hạn","Giá Giảm","Điều Kiện Giảm","Mô Tả"};
		model.setColumnIdentifiers(cols);
		
		tblDotGiamGia = new JTable(model);
		tblDotGiamGia.setRowMargin(3);
		tblDotGiamGia.setRowHeight(25);
		tblDotGiamGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tblDotGiamGia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int chon = tblDotGiamGia.getSelectedRow();
				setForm(new DotGiamGiaDAO().selectById((String) tblDotGiamGia.getValueAt(chon, 0)));
			}
		});
		scrollPane.setViewportView(tblDotGiamGia);
		
		JButton btnThemMoi = new JButton("Thêm Mới");
		btnThemMoi.setBounds(10, 520, 157, 44);
		panel.add(btnThemMoi);
		btnThemMoi.setIcon(new ImageIcon(DotgiamgiaView.class.getResource("/com/shoplaptop/icon/1024px-OOjs_UI_icon_add.svg.png")));
		btnThemMoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setBounds(174, 520, 140, 45);
		panel.add(btnCapNhat);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (MsgBox.confirm(getContentPane(), "Bạn có muốn sửa không ?")){
						MsgBox.alert(getContentPane(), new DotGiamGiaDAO().update(getForm()));
						fillTable(new DotGiamGiaDAO().selectAll());
						clearForm();
						txtMaDotGiam.setText(generateAutoCode());
					}
				} catch (Exception e2) {
					MsgBox.alert(getContentPane(), "Nhập đầy đủ thông tin");
				}
			}
		});
		btnCapNhat.setIcon(new ImageIcon(DotgiamgiaView.class.getResource("/com/shoplaptop/icon/update-12.png")));
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (MsgBox.confirm(getContentPane(), "Bạn có muốn xóa không ?")){
						MsgBox.alert(getContentPane(), new DotGiamGiaDAO().delete(txtMaDotGiam.getText()));
						fillTable(new DotGiamGiaDAO().selectAll());
						clearForm();
						txtMaDotGiam.setText(generateAutoCode());
					}
				} catch (Exception e2) {
					
				}
			}
		});
		btnXoa.setBounds(324, 520, 123, 45);
		panel.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(DotgiamgiaView.class.getResource("/com/shoplaptop/icon/2891491.png")));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnClear = new JButton("Refresh");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
				txtMaDotGiam.setText(generateAutoCode());
				fillTable(new DotGiamGiaDAO().selectAll());
			}
		});
		btnClear.setBounds(457, 520, 123, 44);
		panel.add(btnClear);
		btnClear.setIcon(new ImageIcon(DotgiamgiaView.class.getResource("/com/shoplaptop/icon/Refresh.png")));
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(593, 10, 338, 567);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Đợt Giảm Giá");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 174, 33);
		panel_2.add(lblNewLabel);
		
		txtMaDotGiam = new JTextField();
		txtMaDotGiam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMaDotGiam.setColumns(10);
		txtMaDotGiam.setBounds(10, 53, 314, 33);
		panel_2.add(txtMaDotGiam);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Đợt Giảm Giá");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 94, 197, 33);
		panel_2.add(lblNewLabel_1);
		
		txtTenDotGiam = new JTextField();
		txtTenDotGiam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtTenDotGiam.setColumns(10);
		txtTenDotGiam.setBounds(10, 138, 314, 33);
		panel_2.add(txtTenDotGiam);
		
		JLabel lblNewLabel_2 = new JLabel("Hạn");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 186, 116, 27);
		panel_2.add(lblNewLabel_2);
		
		txtHan = new JTextField();
		txtHan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtHan.setColumns(10);
		txtHan.setBounds(10, 223, 314, 33);
		panel_2.add(txtHan);
		
		JLabel lblNewLabel_3 = new JLabel("Giá Giảm");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 277, 116, 27);
		panel_2.add(lblNewLabel_3);
		
		txtGiaGiam = new JTextField();
		txtGiaGiam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtGiaGiam.setColumns(10);
		txtGiaGiam.setBounds(10, 318, 314, 33);
		panel_2.add(txtGiaGiam);
		
		JLabel lblNewLabel_4 = new JLabel("Điều Kiện ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 369, 142, 27);
		panel_2.add(lblNewLabel_4);
		
		txtDieuKienGiam = new JTextField();
		txtDieuKienGiam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtDieuKienGiam.setColumns(10);
		txtDieuKienGiam.setBounds(10, 412, 314, 33);
		panel_2.add(txtDieuKienGiam);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mô Tả");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(10, 466, 142, 27);
		panel_2.add(lblNewLabel_4_1);
		
		txtMoTa = new JTextField();
		txtMoTa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(10, 504, 314, 33);
		panel_2.add(txtMoTa);
		btnThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (MsgBox.confirm(getContentPane(), "Bạn có muốn thêm không ??")) {
						MsgBox.alert(getContentPane(), new DotGiamGiaDAO().insert(getForm()));
						fillTable(new DotGiamGiaDAO().selectAll());
						clearForm();
						txtMaDotGiam.setText(generateAutoCode());
					}
				} catch (Exception e2) {
					MsgBox.alert(getContentPane(), "Nhập lại thông tin");
				}
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Đợt Giảm Giá");
		lblNewLabel_6.setIcon(new ImageIcon(DotgiamgiaView.class.getResource("/com/shoplaptop/icon/sale.jpg")));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(10, 10, 157, 21);
		contentPanel.add(lblNewLabel_6);
		
		txtMaDotGiam.setText(generateAutoCode());
		
		fillTable(new DotGiamGiaDAO().selectAll());
	}
	
	public void fillTable(List<DotGiamGia> list) {
		model.setRowCount(0);
		for(DotGiamGia dotGiamGia : list) {
			Object[] rows = new Object[] {
					dotGiamGia.getMaDotGiam(),
					dotGiamGia.getTenDotGiamGia(),
					XDate.toString(dotGiamGia.getHan(), "yyyy-MM-dd HH:mm:ss"),
					decimalFormat(dotGiamGia.getGiaGiam()),
					decimalFormat(dotGiamGia.getDieuKien()),
					dotGiamGia.getMoTa()
			};
			model.addRow(rows);
		}
		
	}
	
	public DotGiamGia getForm() {
		DotGiamGia dgg = new DotGiamGia();
		dgg.setMaDotGiam(txtMaDotGiam.getText());
		dgg.setTenDotGiamGia(txtTenDotGiam.getText());
		dgg.setHan(XDate.toDate(txtHan.getText(), "yyyy-MM-dd HH:mm:ss"));
		dgg.setGiaGiam(BigDecimal.valueOf(Double.valueOf(txtGiaGiam.getText())));
		dgg.setDieuKien(BigDecimal.valueOf(Double.valueOf(txtDieuKienGiam.getText())));
		dgg.setMoTa(txtMoTa.getText());
		
		return dgg;
	}
	
	public void setForm(DotGiamGia dgg) {
		txtMaDotGiam.setText(dgg.getMaDotGiam());
		txtTenDotGiam.setText(dgg.getTenDotGiamGia());
		txtHan.setText(XDate.toString(dgg.getHan(),"yyyy-MM-dd HH:mm:ss"));
		txtGiaGiam.setText(decimalFormat(dgg.getGiaGiam()));
		txtDieuKienGiam.setText(decimalFormat(dgg.getDieuKien()));
		txtMoTa.setText(dgg.getMoTa());
		
	}
	public void clearForm() {
		txtMaDotGiam.setText(null);
		txtTenDotGiam.setText(null);
		txtHan.setText(null);
		txtGiaGiam.setText(null);
		txtDieuKienGiam.setText(null);
		txtMoTa.setText(null);
		txtTimKiem.setText(null);
	}
	
	public static String decimalFormat(BigDecimal number) {
		DecimalFormat decimalFormat = new DecimalFormat("0.####################");
		String formattedNumber = decimalFormat.format(number);
		return formattedNumber;
	}
	public String generateAutoCode() {
		String uppercaseLetters = "PD";
		String numbers = "0123456789";

		Random random = new Random();
		StringBuilder codeBuilder = new StringBuilder();

		codeBuilder.append(uppercaseLetters);

		for (int i = 0; i < 5; i++) {
			int randomIndex = random.nextInt(numbers.length());
			codeBuilder.append(numbers.charAt(randomIndex));
		}

		return codeBuilder.toString();
	}
	
	public void FindByTenDGG() {
		String TenDGG = txtTimKiem.getText();
		if (TenDGG.trim().isEmpty()) {
			TenDGG = "%%";
			MsgBox.alert(getContentPane(),"Không tìm thấy");
		}
		List<DotGiamGia> list = new ArrayList<DotGiamGia>();
		list = dotGiamGiaDAO.selectBySQL(SelectByTenDGG, "%"+TenDGG+"%");
		fillTable(list);
	}

}
