package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;

import com.shoplaptop.dao.PhieuGiamGiaDAO;
import com.shoplaptop.entity.PhieuGiamGia;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XImage;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ThongKePhieuGiamUI extends JDialog {
	private JTable tblHoaDon;
	public static  DefaultTableModel model;
	public static  JTextField txtMaPhieuGiam;
	public static  JTextField txtTenPhieuGiam;
	public static  JTextField txtHanSuDung;
	public static  JTextField txtSoLuong;
	public static  JTextField txtGiaGiam;
	public static  JTextField txtDieuKien;
	public static PhieuGiamGiaDAO phieuGiamGiaDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKePhieuGiamUI dialog = new ThongKePhieuGiamUI();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ThongKePhieuGiamUI() {
		setBounds(100, 100, 975, 675);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setIconImage(XImage.getAppIcon());
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 384, 941, 198);
		getContentPane().add(scrollPane_1);
		
		model = new DefaultTableModel();
		String[] cols = {"Mã HĐ","Mã KH","Ngày tạo","Mã NV"};
		model.setColumnIdentifiers(cols);
		
		tblHoaDon = new JTable(model);
		tblHoaDon.setRowMargin(3);
		tblHoaDon.setRowHeight(25);
		tblHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane_1.setViewportView(tblHoaDon);
		
		JLabel lblNewLabel = new JLabel("Phiếu giảm giá");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 57, 198, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblHan = new JLabel("Hóa đơn");
		lblHan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHan.setBounds(10, 361, 198, 21);
		getContentPane().add(lblHan);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 91, 941, 231);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtMaPhieuGiam = new JTextField();
		txtMaPhieuGiam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaPhieuGiam.setBounds(160, 10, 277, 32);
		panel.add(txtMaPhieuGiam);
		txtMaPhieuGiam.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Phiếu Giảm:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(0, 15, 129, 21);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Phiếu Giảm:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(0, 93, 129, 21);
		panel.add(lblNewLabel_1_2);
		
		txtTenPhieuGiam = new JTextField();
		txtTenPhieuGiam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenPhieuGiam.setColumns(10);
		txtTenPhieuGiam.setBounds(160, 88, 277, 32);
		panel.add(txtTenPhieuGiam);
		
		txtHanSuDung = new JTextField();
		txtHanSuDung.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtHanSuDung.setColumns(10);
		txtHanSuDung.setBounds(160, 159, 277, 32);
		panel.add(txtHanSuDung);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hạn Sử Dụng:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(0, 164, 129, 21);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Số Lượng:");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(494, 15, 99, 21);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Giá Giảm:");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_3.setBounds(494, 93, 99, 21);
		panel.add(lblNewLabel_1_1_3);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(633, 10, 284, 32);
		panel.add(txtSoLuong);
		
		txtGiaGiam = new JTextField();
		txtGiaGiam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtGiaGiam.setColumns(10);
		txtGiaGiam.setBounds(633, 88, 284, 32);
		panel.add(txtGiaGiam);
		
		txtDieuKien = new JTextField();
		txtDieuKien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDieuKien.setColumns(10);
		txtDieuKien.setBounds(633, 159, 284, 32);
		panel.add(txtDieuKien);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Điều Kiện:");
		lblNewLabel_1_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_3_1.setBounds(494, 170, 99, 21);
		panel.add(lblNewLabel_1_1_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("THỐNG KÊ PHIẾU GIẢM GIÁ");
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_1.setBounds(260, 0, 415, 40);
		getContentPane().add(lblNewLabel_1);

	}
	
	public static void setForm(PhieuGiamGia phieuGiamGia) {
		txtMaPhieuGiam.setText(phieuGiamGia.getMaPG());
		txtTenPhieuGiam.setText(phieuGiamGia.getTenPhieu());
		txtHanSuDung.setText(XDate.toString(phieuGiamGia.getHan(), "yyyy-MM-dd HH:mm:ss"));
		txtSoLuong.setText(phieuGiamGia.getSoLuong()+"");
		txtGiaGiam.setText(decimalFormat(phieuGiamGia.getGiaGiam().multiply(BigDecimal.valueOf(100)))+" %");
		txtDieuKien.setText(decimalFormat(phieuGiamGia.getDieuKienGiam()));
	}
	
	public static void fillTableHD() {
		
	}
	
	public static String decimalFormat(BigDecimal number) {        
        DecimalFormat decimalFormat = new DecimalFormat("0.####################");
        String formattedNumber = decimalFormat.format(number);
        return formattedNumber;
	}
	
	
}
