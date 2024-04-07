package com.shoplaptop.ui;

import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.shoplaptop.dao.NhanVienService;
import com.shoplaptop.entity.NhanVien;
import com.shoplaptop.entity.TaiKhoan;
import com.shoplaptop.utils.Auth;
import com.shoplaptop.utils.MsgBox;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XImage;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ThongTinNhanVien extends JDialog {
	public static JTextField txtsodienthoai;
	public static JTextField txttennhanvien;
	public static JTextField txtmanhanvien;
	public static JTextField txtngaysinh;
	public static JRadioButton rdonam;
	public static JRadioButton rdonu;
	public static ButtonGroup buttonGroup;
	public static JRadioButton rdoquanly;
	public static JRadioButton rdonhanvien;
	public ButtonGroup buttonGroup_1;
	public static JLabel lblimage;
	public static JButton btncapnhat;
	public static JTextField txtdiachi;
	private NhanVienService service = new NhanVienService();
	public static JTextField txtemail;
	private ShopLaptop365 shopLaptop365;

	/**
	 * Create the dialog.
	 */
	public ThongTinNhanVien(ShopLaptop365 shopLaptop365) {
		this.shopLaptop365 = shopLaptop365;
		setBounds(100, 100, 841, 655);
		setLocationRelativeTo(null);
		setIconImage(XImage.getAppIcon());
		getContentPane().setLayout(null);
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 63, 807, 2);
		getContentPane().add(separator);

		JLabel lblNewLabel = new JLabel("Thông Tin Nhân Viên ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setIcon(new ImageIcon(ThongTinNhanVien.class.getResource("/com/shoplaptop/icon/User.png")));
		lblNewLabel.setBounds(279, 22, 292, 31);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 275, 109, 21);
		getContentPane().add(lblNewLabel_1);

		txtsodienthoai = new JTextField();
		txtsodienthoai.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtsodienthoai.setBounds(10, 375, 346, 28);
		getContentPane().add(txtsodienthoai);
		txtsodienthoai.setColumns(10);

		txttennhanvien = new JTextField();
		txttennhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txttennhanvien.setColumns(10);
		txttennhanvien.setBounds(442, 145, 346, 28);
		getContentPane().add(txttennhanvien);

		JLabel lblNewLabel_1_1 = new JLabel("Tên Nhân Viên");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(442, 114, 109, 21);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Số Điện Thoại");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(10, 344, 109, 21);
		getContentPane().add(lblNewLabel_1_2);

		txtmanhanvien = new JTextField();
		txtmanhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtmanhanvien.setColumns(10);
		txtmanhanvien.setBounds(10, 306, 346, 28);
		getContentPane().add(txtmanhanvien);

		txtngaysinh = new JTextField();
		txtngaysinh.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtngaysinh.setColumns(10);
		txtngaysinh.setBounds(442, 224, 346, 28);
		getContentPane().add(txtngaysinh);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày Sinh");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(442, 193, 109, 21);
		getContentPane().add(lblNewLabel_1_1_1);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 94, 142, 171);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblimage = new JLabel("                       Image");
		lblimage.setBounds(0, 0, 143, 169);
		panel.add(lblimage);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giới Tính");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1.setBounds(442, 275, 109, 21);
		getContentPane().add(lblNewLabel_1_1_1_1);

		rdonam = new JRadioButton("Nam");
		rdonam.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdonam.setBounds(442, 309, 103, 21);
		getContentPane().add(rdonam);

		rdonu = new JRadioButton("Nữ ");
		rdonu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdonu.setBounds(610, 311, 103, 21);
		getContentPane().add(rdonu);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdonam);
		buttonGroup.add(rdonu);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Vai Trò");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1_1.setBounds(10, 420, 109, 21);
		getContentPane().add(lblNewLabel_1_1_1_1_1);

		rdoquanly = new JRadioButton("Quản Lý");
		rdoquanly.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdoquanly.setBounds(10, 456, 103, 21);
		getContentPane().add(rdoquanly);

		rdonhanvien = new JRadioButton("Nhân Viên");
		rdonhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdonhanvien.setBounds(195, 456, 103, 21);
		getContentPane().add(rdonhanvien);

		buttonGroup_1 = new ButtonGroup();
		buttonGroup_1.add(rdonhanvien);
		buttonGroup_1.add(rdoquanly);

		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("Địa Chỉ ");
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_2_1_1.setBounds(442, 344, 109, 21);
		getContentPane().add(lblNewLabel_1_1_1_2_1_1);

		txtdiachi = new JTextField();
		txtdiachi.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(442, 375, 346, 28);
		getContentPane().add(txtdiachi);

		JLabel lblNewLabel_1_1_1_2_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_2_1_1_1.setBounds(452, 420, 109, 21);
		getContentPane().add(lblNewLabel_1_1_1_2_1_1_1);

		btncapnhat = new JButton("Cập Nhật");
		btncapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MsgBox.alert(getContentPane(), service.update(getForm()));
				if (!Auth.isManager()) {
					if (rdoquanly.isSelected()) {
						MsgBox.alert(getContentPane(), "Bạn không có quyền sửa vai trò");
					}
				} else {
					service.updateTK(getForm());
					ThongTinNhanVien.this.shopLaptop365.dispose();
					ShopLaptop365 shopLaptop365_1 = new ShopLaptop365();
					shopLaptop365_1.setVisible(true);
				}					
				dispose();
			}

		});
		btncapnhat.setEnabled(false);
		btncapnhat.setIcon(new ImageIcon(ThongTinNhanVien.class.getResource("/com/shoplaptop/icon/Edit.png")));
		btncapnhat.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btncapnhat.setBounds(665, 575, 123, 33);
		getContentPane().add(btncapnhat);

		txtemail = new JTextField();
		txtemail.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtemail.setColumns(10);
		txtemail.setBounds(442, 456, 346, 28);
		getContentPane().add(txtemail);

	}

	public NhanVien getForm() {
		NhanVien nhanVien = new NhanVien();
		nhanVien.setHinh(lblimage.getToolTipText());
		nhanVien.setMaNV(txtmanhanvien.getText());
		nhanVien.setHoTen(txttennhanvien.getText());
		nhanVien.setDiaChi(txtdiachi.getText());
		nhanVien.setEmail(txtemail.getText());
		nhanVien.setNgaySinh(XDate.toDate(txtngaysinh.getText(), "yyyy-MM-dd"));
		nhanVien.setGioiTinh(rdonam.isSelected());
		nhanVien.setSoDienThoai(txtsodienthoai.getText());
		nhanVien.setVaiTro(rdoquanly.isSelected());
		return nhanVien;

	}

	public TaiKhoan getFormTaiKhoan() {
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setMaNV(txtmanhanvien.getText());
		return taiKhoan;
	}
}
