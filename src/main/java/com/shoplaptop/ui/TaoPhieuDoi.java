package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.shoplaptop.dao.BienTheDAO;
import com.shoplaptop.dao.CTHoaDonDAO;
import com.shoplaptop.dao.CTPhieuDoiDAO;
import com.shoplaptop.dao.HoaDonDAO;
import com.shoplaptop.dao.KhachHangDAO;
import com.shoplaptop.dao.LS_PhieuDoiDao;
import com.shoplaptop.dao.LaptopDAO;
import com.shoplaptop.dao.PhieuDoiDAO;
import com.shoplaptop.dao.SerialNumberDAO;
import com.shoplaptop.entity.BaoCao_LS_PhieuDoi;
import com.shoplaptop.entity.CTHoaDon;
import com.shoplaptop.entity.CTPhieuDoi;
import com.shoplaptop.entity.HoaDon;
import com.shoplaptop.entity.KhachHang;
import com.shoplaptop.entity.PhieuDoi;
import com.shoplaptop.utils.Auth;
import com.shoplaptop.utils.MsgBox;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XImage;

import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TaoPhieuDoi extends JDialog {
	private JTextField txtTimKiemSDTKH;
	private JTextField txtTimKiemSerial;
	private JTextField txtSerialNumber_New;
	private JTextArea txtLiDo;
	private JTable tblSanPhamDoi;
	private JButton btnLuuPhieuDoi;
	private JLabel lblMaPhieuDoi;
	private JButton btnAdd;
	private JLabel lblHan;
	private JLabel lblGia;
	private JLabel lblSerialNumber_Cu;
	private JLabel lblTenLapTop;
	private JLabel lblMaHoaDon;
	private JLabel lblDiaChi;
	private JLabel lblTenKH;
	private JLabel lblMaKH;
	private JButton btnTimSDTKH;
	private JButton btnTimSerial;
	private JComboBox<String> cboTrangThai;
	private List<CTPhieuDoi> CTPD_REPO = new ArrayList<CTPhieuDoi>();
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TaoPhieuDoi dialog = new TaoPhieuDoi();
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
	public TaoPhieuDoi() {
		setBounds(100, 100, 996, 738);
		setLocationRelativeTo(this);
		getContentPane().setLayout(null);
		setIconImage(XImage.getAppIcon());

		JLabel lblNewLabel = new JLabel("TẠO PHIẾU ĐỔI");
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 10, 264, 47);
		getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 103, 468, 47);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtTimKiemSDTKH = new JTextField();
		txtTimKiemSDTKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTimKiemSDTKH.setBounds(10, 10, 356, 28);
		panel.add(txtTimKiemSDTKH);
		txtTimKiemSDTKH.setColumns(10);

		btnTimSDTKH = new JButton("Tìm");
		btnTimSDTKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindBySoDienThoaiKhachHang();
			}
		});
		btnTimSDTKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTimSDTKH.setBounds(377, 8, 78, 32);
		panel.add(btnTimSDTKH);

		JLabel lblNewLabel_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_1.setBounds(10, 77, 115, 28);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 170, 468, 159);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("MaKH      :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 10, 88, 28);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Họ Tên     :");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 62, 88, 28);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Địa Chỉ     :");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(10, 116, 88, 28);
		panel_1.add(lblNewLabel_1_1_2);

		lblMaKH = new JLabel("---");
		lblMaKH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaKH.setBounds(111, 10, 347, 28);
		panel_1.add(lblMaKH);

		lblTenKH = new JLabel("---");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenKH.setBounds(111, 62, 347, 28);
		panel_1.add(lblTenKH);

		lblDiaChi = new JLabel("---");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDiaChi.setBounds(111, 116, 347, 28);
		panel_1.add(lblDiaChi);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(504, 102, 468, 47);
		getContentPane().add(panel_2);

		txtTimKiemSerial = new JTextField();
		txtTimKiemSerial.setColumns(10);
		txtTimKiemSerial.setBounds(10, 10, 356, 28);
		panel_2.add(txtTimKiemSerial);

		btnTimSerial = new JButton("Tìm");
		btnTimSerial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindByHoaDonTheoSerialandSDT();
			}
		});
		btnTimSerial.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTimSerial.setBounds(377, 8, 78, 32);
		panel_2.add(btnTimSerial);

		JLabel lblNewLabel_1_2 = new JLabel("SerialNumber");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(504, 77, 115, 28);
		getContentPane().add(lblNewLabel_1_2);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(504, 171, 468, 266);
		getContentPane().add(panel_1_1);

		JLabel lblNewLabel_1_1_3 = new JLabel("MaHD           :");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_3.setBounds(10, 10, 120, 28);
		panel_1_1.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tên LapTop   :");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(10, 63, 120, 28);
		panel_1_1.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("SerialNumber  :");
		lblNewLabel_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1.setBounds(10, 116, 120, 28);
		panel_1_1.add(lblNewLabel_1_1_2_1);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Giá                 :");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1_1.setBounds(10, 169, 120, 28);
		panel_1_1.add(lblNewLabel_1_1_2_1_1);

		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Hạn                :");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1_1_1.setBounds(10, 222, 120, 28);
		panel_1_1.add(lblNewLabel_1_1_2_1_1_1);

		lblMaHoaDon = new JLabel("---");
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaHoaDon.setBounds(140, 10, 318, 28);
		panel_1_1.add(lblMaHoaDon);

		lblTenLapTop = new JLabel("---");
		lblTenLapTop.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenLapTop.setBounds(140, 63, 318, 28);
		panel_1_1.add(lblTenLapTop);

		lblSerialNumber_Cu = new JLabel("---");
		lblSerialNumber_Cu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSerialNumber_Cu.setBounds(140, 116, 318, 28);
		panel_1_1.add(lblSerialNumber_Cu);

		lblGia = new JLabel("---");
		lblGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGia.setBounds(140, 169, 318, 28);
		panel_1_1.add(lblGia);

		lblHan = new JLabel("---");
		lblHan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHan.setBounds(140, 222, 318, 28);
		panel_1_1.add(lblHan);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Trạng Thái");
		lblNewLabel_1_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2.setBounds(10, 347, 115, 28);
		getContentPane().add(lblNewLabel_1_1_2_2);

		cboTrangThai = new JComboBox<String>();
		cboTrangThai.setModel(new DefaultComboBoxModel<String>(new String[] { "Còn Mới 100%", "Lỗi" }));
		cboTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cboTrangThai.setBounds(135, 347, 343, 30);
		getContentPane().add(cboTrangThai);

		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Lí Do");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2_1.setBounds(10, 402, 115, 28);
		getContentPane().add(lblNewLabel_1_1_2_2_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 395, 343, 42);
		getContentPane().add(scrollPane);

		txtLiDo = new JTextArea();
		txtLiDo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(txtLiDo);

		JLabel lblNewLabel_1_1_2_2_1_1 = new JLabel("Serial New");
		lblNewLabel_1_1_2_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2_1_1.setBounds(10, 457, 115, 28);
		getContentPane().add(lblNewLabel_1_1_2_2_1_1);

		txtSerialNumber_New = new JTextField();
		txtSerialNumber_New.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSerialNumber_New.setColumns(10);
		txtSerialNumber_New.setBounds(135, 457, 343, 30);
		getContentPane().add(txtSerialNumber_New);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (lblHan.getText().equals("Còn Hạn")) {
						CTPD_REPO.add(getFormCtPhieuDoi());
						fillTableSPDoi();
						clearFormAdd();
					}else {
						if (lblHan.getText().equals("Hết Hạn")) {
							MsgBox.alert(getContentPane(), "Laptop hết hạn đổi trả");
						}
					}
				} catch (Exception e2) {
					MsgBox.alert(getContentPane(), "SerialNew nhập không hợp lệ");
				}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAdd.setBounds(502, 456, 83, 33);
		getContentPane().add(btnAdd);

		JLabel lblNewLabel_1_1_3_1 = new JLabel("Mã Phiếu Đổi  :");
		lblNewLabel_1_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_3_1.setBounds(504, 35, 122, 28);
		getContentPane().add(lblNewLabel_1_1_3_1);

		lblMaPhieuDoi = new JLabel("---");
		lblMaPhieuDoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaPhieuDoi.setBounds(636, 35, 311, 28);
		getContentPane().add(lblMaPhieuDoi);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh S\u00E1ch S\u1EA3n Ph\u1EA9m \u0110\u1ED5i", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3.setBounds(10, 495, 962, 196);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 942, 175);
		panel_3.add(scrollPane_1);

		tblSanPhamDoi = new JTable();
		scrollPane_1.setViewportView(tblSanPhamDoi);

		btnLuuPhieuDoi = new JButton("Lưu Phiếu Đổi");
		btnLuuPhieuDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MsgBox.alert(getContentPane(), new PhieuDoiDAO().insert(insertPD()));
					insertCTPD(new PhieuDoiDAO().selectById(lblMaPhieuDoi.getText()));
					
					List<CTPhieuDoi> list = new CTPhieuDoiDAO().selectAllCTPhieuDoiByMaPhieuDoi(lblMaPhieuDoi.getText());
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).isTrangThai()) {
							new SerialNumberDAO().updateSerial(list.get(i).getSerialNumber_Old());
						}
					}
					
					new HoaDonManager().setVisible(true);
					
					HoaDon hoaDon = new HoaDon();
					hoaDon.setMaHD(HoaDonManager.generateAutoCode());
					hoaDon.setMaKH(lblMaKH.getText());
					hoaDon.setMaNV(Auth.user.getMaNV());
					hoaDon.setTrangThai("Chờ thanh toán");
					
					HoaDonManager.HOA_DON_REPO.add(hoaDon);
					
					HoaDonManager.Hoa_Don_Wait = HoaDonManager.HOA_DON_REPO.stream().filter(hd -> hd.getTrangThai().equals("Chờ thanh toán"))
							.collect(Collectors.toList());
					
					HoaDonManager.loadHoaDon_Wait(HoaDonManager.Hoa_Don_Wait);
					
					BigDecimal tongTien = BigDecimal.valueOf(0);
					
					for (int i = 0; i < list.size(); i++) {
						CTHoaDon ctHoaDon = new CTHoaDon();
						ctHoaDon.setMaHD(hoaDon.getMaHD());
						ctHoaDon.setTenLaptop(new LaptopDAO().selectBySerial(list.get(i).getSerialNumber_New()).getTenLaptop());
						ctHoaDon.setSerialNumber(list.get(i).getSerialNumber_New());
						ctHoaDon.setGia(list.get(i).getGiaMoi().subtract(list.get(i).getGiaCu()));
						tongTien = tongTien.add(ctHoaDon.getGia());
						HoaDonManager.HDCT_REPO.add(ctHoaDon);
					}
					
					HoaDonManager.loadCTHoaDon(hoaDon.getMaHD());
					HoaDonManager.tienGiamDots = BigDecimal.valueOf(0);
					HoaDonManager.tienGiamPhieus = BigDecimal.valueOf(0);
					HoaDonManager.txtDotGiamGia.setText(null);
					HoaDonManager.tongTiens = tongTien;
					HoaDonManager.txtTongTien.setText(decimalFormat(HoaDonManager.tongTiens));
					HoaDonManager.txtTienGiam.setText("0");
					
					BaoCao_LS_PhieuDoi baoCao_LS_PhieuDoi = new BaoCao_LS_PhieuDoi();
					baoCao_LS_PhieuDoi.setManv(Auth.user.getMaNV());
					baoCao_LS_PhieuDoi.setPhieuDoi(new PhieuDoiDAO().selectById(lblMaPhieuDoi.getText()).getID());
					baoCao_LS_PhieuDoi.setLS("Tạo phiếu đổi");
					
					new LS_PhieuDoiDao().insert(baoCao_LS_PhieuDoi);
					
					clearFormLuuPhieuDoi();
					lblMaPhieuDoi.setText(generateAutoCode());
					
				} catch (Exception e2) {
					MsgBox.alert(getContentPane(), "Nhập thông tin đầy đủ");
				}
			}
		});
		btnLuuPhieuDoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLuuPhieuDoi.setBounds(735, 456, 150, 33);
		getContentPane().add(btnLuuPhieuDoi);

		cboTrangThai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboTrangThai.getSelectedItem() == "Lỗi") {
					txtLiDo.setEditable(true);
				}
			}
		});

		lblMaPhieuDoi.setText(generateAutoCode());

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = tblSanPhamDoi.getSelectedRow();
					CTPD_REPO.remove(index);
					fillTableSPDoi();
				} catch (Exception e2) {
					
				}
			}
		});
		btnRemove.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRemove.setBounds(595, 456, 130, 33);
		getContentPane().add(btnRemove);

	}

	public void FindBySoDienThoaiKhachHang() {
		String SDT = txtTimKiemSDTKH.getText();
		if (SDT.trim().isEmpty()) {
			MsgBox.alert(getContentPane(), "Vui lòng nhập Số điện thoại");
		} else {
			KhachHang khachHang = new KhachHangDAO().selectBySoDienThoai(SDT);
			if (khachHang != null) {
				lblMaKH.setText(khachHang.getMaKH());
				lblTenKH.setText(khachHang.getHoTen());
				lblDiaChi.setText(khachHang.getDiaChi());
			} else {
				MsgBox.alert(getContentPane(), "Số điện thoại không tồn tại");
			}
		}

	}

	public void FindByHoaDonTheoSerialandSDT() {
		String Serial = txtTimKiemSerial.getText();
		if (Serial.trim().isEmpty() || txtTimKiemSDTKH.getText().trim().isEmpty()) {
			MsgBox.alert(getContentPane(), "Vui lòng nhập serial/Số Điện Thoại");
		} else {
			CTHoaDon ctHoaDon = new CTHoaDonDAO().selectBySerialSDT(Serial, txtTimKiemSDTKH.getText());
			if (ctHoaDon != null) {
				setFormSanPhamCTHoaDon(ctHoaDon);
				lblHan.setText(new HoaDonDAO().Han(Serial, txtTimKiemSDTKH.getText()));
			} else {
				MsgBox.alert(getContentPane(), "Sản Phẩm không thuộc hóa đơn");
			}

		}

	}

	public void setFormSanPhamCTHoaDon(CTHoaDon ctHoaDon) {
		lblMaHoaDon.setText(ctHoaDon.getMaHD());
		lblTenLapTop.setText(ctHoaDon.getTenLaptop());
		lblSerialNumber_Cu.setText(ctHoaDon.getSerialNumber());
		lblGia.setText(decimalFormat(ctHoaDon.getGia()));
	}

	public static String decimalFormat(BigDecimal number) {
		DecimalFormat decimalFormat = new DecimalFormat("0.####################");
		String formattedNumber = decimalFormat.format(number);
		return formattedNumber;
	}

	public void fillTableSPDoi() {
		model = (DefaultTableModel) tblSanPhamDoi.getModel();
		model.setColumnCount(0);
		model.addColumn("Mã hóa đơn");
		model.addColumn("Serial_Cũ");
		model.addColumn("Tên Laptop_Cũ");
		model.addColumn("Giá Cũ");
		model.addColumn("Serial_Mới");
		model.addColumn("Tên Laptop_Mới");
		model.addColumn("Giá mới");
		model.addColumn("Trạng thái");
		model.addColumn("Lí do");

		model.setRowCount(0);
		for (CTPhieuDoi ctPhieuDoi : CTPD_REPO) {
			Object[] row = new Object[] { 
					ctPhieuDoi.getMaHoaDon(), 
					ctPhieuDoi.getSerialNumber_Old(),
					ctPhieuDoi.getTenLapCu(), 
					decimalFormat(ctPhieuDoi.getGiaCu()), 
					ctPhieuDoi.getSerialNumber_New(),
					ctPhieuDoi.getTenLapMoi(), 
					decimalFormat(ctPhieuDoi.getGiaMoi()),
					ctPhieuDoi.isTrangThai() ? "Còn Mới 100%" : "Lỗi", 
					ctPhieuDoi.getLiDo() };
					model.addRow(row);
		}
	}

	public CTPhieuDoi getFormCtPhieuDoi() {
			CTPhieuDoi ctPhieuDoi = new CTPhieuDoi();
			ctPhieuDoi.setMaHoaDon(lblMaHoaDon.getText());
			ctPhieuDoi.setSerialNumber_Old(lblSerialNumber_Cu.getText());
			ctPhieuDoi.setTenLapCu(lblTenLapTop.getText());
			ctPhieuDoi.setGiaCu(BigDecimal.valueOf(Double.valueOf(lblGia.getText())));
			ctPhieuDoi.setSerialNumber_New(txtSerialNumber_New.getText());
			ctPhieuDoi.setTenLapMoi(new LaptopDAO().selectBySerial(txtSerialNumber_New.getText()).getTenLaptop());
			ctPhieuDoi.setGiaMoi(new BienTheDAO().selectBySerial(txtSerialNumber_New.getText()).getGia());
			ctPhieuDoi.setTrangThai(cboTrangThai.getSelectedItem() == "Còn Mới 100%" ? true : false);
			ctPhieuDoi.setLiDo(txtLiDo.getText());
			return ctPhieuDoi;
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

	public PhieuDoi insertPD() {
		PhieuDoi phieuDoi = new PhieuDoi();
		phieuDoi.setMaPhieuDoi(lblMaPhieuDoi.getText());
		phieuDoi.setMaKH(lblMaKH.getText());
		phieuDoi.setMaNV(Auth.user.getMaNV());
		phieuDoi.setNgayTao(XDate.toDate(XDate.toString(new Date(), "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));
		return phieuDoi;
	}
	
	public void insertCTPD(PhieuDoi phieuDoi) {
		try {
			for (int i = 0; i < CTPD_REPO.size(); i++) {
				CTPD_REPO.get(i).setID_PhieuDoi(phieuDoi.getID());
				CTPD_REPO.get(i).setID_HoaDon(new HoaDonDAO().selectById(CTPD_REPO.get(i).getMaHoaDon()).getId());
				CTPD_REPO.get(i).setID_Serial_Old(
						new SerialNumberDAO().selectById(CTPD_REPO.get(i).getSerialNumber_Old()).getId());
				CTPD_REPO.get(i).setID_Serial_New(
						new SerialNumberDAO().selectById(CTPD_REPO.get(i).getSerialNumber_New()).getId());
				new CTPhieuDoiDAO().insert(CTPD_REPO.get(i));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void clearFormAdd() {
		txtTimKiemSerial.setText(null);
		lblMaHoaDon.setText(null);
		lblTenLapTop.setText(null);
		lblSerialNumber_Cu.setText(null);
		lblGia.setText(null);
		lblHan.setText(null);
		cboTrangThai.setSelectedIndex(-1);
		txtLiDo.setText(null);
		txtSerialNumber_New.setText(null);
	}
	
	public void clearFormLuuPhieuDoi() {
		lblMaPhieuDoi.setText(null);
		txtTimKiemSDTKH.setText(null);
		lblMaKH.setText(null);
		lblTenKH.setText(null);
		lblDiaChi.setText(null);
		txtTimKiemSerial.setText(null);
		lblMaHoaDon.setText(null);
		lblTenLapTop.setText(null);
		lblSerialNumber_Cu.setText(null);
		lblGia.setText(null);
		lblHan.setText(null);
		cboTrangThai.setSelectedIndex(-1);
		txtLiDo.setText(null);
		txtSerialNumber_New.setText(null);
		model.setRowCount(0);
	}

}
