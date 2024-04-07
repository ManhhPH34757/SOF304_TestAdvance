package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.shoplaptop.utils.XImage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
@SuppressWarnings("serial")
public class ChiTietPhieuDoiView extends JDialog {
	public static JTextField txtMaPhieuDoi;
	public static JTextField txtNgayTao;
	public static JTextField txtMaKhachHang;
	public static JTextField txtTenKhachHang;
	public static JTextField txtTenNhanVien;
	public static JTable tblChiTietPhieuDoi2;
	public static DefaultTableModel model3 ;
	public static JTextField txtMaNhanVien;
	public static JTextField txtSoDienThoai;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietPhieuDoiView dialog = new ChiTietPhieuDoiView();
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
	public ChiTietPhieuDoiView() {
		setBounds(100, 100, 975, 675);
		setLocationRelativeTo(this);
		getContentPane().setLayout(null);
		setIconImage(XImage.getAppIcon());
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT PHIẾU ĐỔI");
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 10, 365, 52);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 88, 459, 284);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMaPhieuDoi = new JLabel("Mã Phiếu Đổi");
		lblMaPhieuDoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaPhieuDoi.setBounds(25, 36, 111, 24);
		panel.add(lblMaPhieuDoi);
		
		txtMaPhieuDoi = new JTextField();
		txtMaPhieuDoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaPhieuDoi.setBounds(152, 33, 268, 32);
		panel.add(txtMaPhieuDoi);
		txtMaPhieuDoi.setColumns(10);
		
		JLabel lblNgayTao = new JLabel("Ngày Tạo");
		lblNgayTao.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgayTao.setBounds(25, 98, 111, 24);
		panel.add(lblNgayTao);
		
		txtNgayTao = new JTextField();
		txtNgayTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgayTao.setColumns(10);
		txtNgayTao.setBounds(152, 95, 268, 32);
		panel.add(txtNgayTao);
		
		JLabel lblMNhnVin = new JLabel("Mã Nhân Viên");
		lblMNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMNhnVin.setBounds(25, 162, 111, 24);
		panel.add(lblMNhnVin);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(152, 159, 268, 32);
		panel.add(txtMaNhanVien);
		
		JLabel lblMaKH_1_1 = new JLabel("Tên Nhân Viên");
		lblMaKH_1_1.setBounds(22, 229, 114, 24);
		panel.add(lblMaKH_1_1);
		lblMaKH_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setBounds(152, 221, 268, 32);
		panel.add(txtTenNhanVien);
		txtTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenNhanVien.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(506, 88, 435, 284);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã Khách Hàng");
		lblMaKH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaKH.setBounds(10, 28, 136, 24);
		panel_2.add(lblMaKH);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(156, 27, 258, 32);
		panel_2.add(txtMaKhachHang);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTnKhchHng.setBounds(10, 94, 136, 24);
		panel_2.add(lblTnKhchHng);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(156, 91, 258, 32);
		panel_2.add(txtTenKhachHang);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại");
		lblSinThoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSinThoi.setBounds(10, 162, 136, 24);
		panel_2.add(lblSinThoi);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(156, 159, 258, 32);
		panel_2.add(txtSoDienThoai);
		
		JButton btnNewButton = new JButton("Xuất file PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(804, 29, 137, 37);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 394, 931, 234);
		getContentPane().add(scrollPane);
		
		model3 = new DefaultTableModel();
		String[] colS = {"Mã phiếu đổi","MaHD","Serial_Old","Tên Lap Cũ","Giá cũ","Serial_New","Tên Lap Mới","Giá mới","Trạng Thái","Lí Do"};
		model3.setColumnIdentifiers(colS);
		
		tblChiTietPhieuDoi2 = new JTable(model3);
		tblChiTietPhieuDoi2.setRowMargin(3);
		tblChiTietPhieuDoi2.setRowHeight(25);
		tblChiTietPhieuDoi2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(tblChiTietPhieuDoi2);

	}
}


