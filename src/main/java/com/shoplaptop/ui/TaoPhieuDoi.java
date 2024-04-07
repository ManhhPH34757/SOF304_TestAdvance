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

import org.apache.poi.hpsf.Decimal;

import com.shoplaptop.dao.BienTheDAO;
import com.shoplaptop.dao.CTHoaDonDAO;
import com.shoplaptop.dao.CTPhieuDoiDAO;
import com.shoplaptop.dao.HangDAO;
import com.shoplaptop.dao.HinhThucThanhToanDAO;
import com.shoplaptop.dao.HinhThucVanChuyenDAO;
import com.shoplaptop.dao.HoaDonDAO;
import com.shoplaptop.dao.KhachHangDAO;
import com.shoplaptop.dao.LS_PhieuDoiDao;
import com.shoplaptop.dao.LaptopDAO;
import com.shoplaptop.dao.PhieuDoiDAO;
import com.shoplaptop.dao.SerialNumberDAO;
import com.shoplaptop.entity.BaoCao_LS_PhieuDoi;
import com.shoplaptop.entity.CTHoaDon;
import com.shoplaptop.entity.CTPhieuDoi;
import com.shoplaptop.entity.Hang;
import com.shoplaptop.entity.HinhThucThanhToan;
import com.shoplaptop.entity.HinhThucVanChuyen;
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
	private JTextField txtTongTien;
	private JComboBox<HinhThucVanChuyen> cboVanChuyen;
	private JComboBox<HinhThucThanhToan> cboThanhToan;
	private BigDecimal tongTiens = BigDecimal.valueOf(0);

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
		panel_1.setBounds(10, 170, 468, 124);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("MaKH      :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 10, 88, 28);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Họ Tên     :");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 48, 88, 28);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Địa Chỉ     :");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(10, 86, 88, 28);
		panel_1.add(lblNewLabel_1_1_2);

		lblMaKH = new JLabel("---");
		lblMaKH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaKH.setBounds(111, 10, 347, 28);
		panel_1.add(lblMaKH);

		lblTenKH = new JLabel("---");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenKH.setBounds(111, 48, 347, 28);
		panel_1.add(lblTenKH);

		lblDiaChi = new JLabel("---");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDiaChi.setBounds(111, 86, 347, 28);
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
		panel_1_1.setBounds(504, 171, 468, 205);
		getContentPane().add(panel_1_1);

		JLabel lblNewLabel_1_1_3 = new JLabel("MaHD           :");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_3.setBounds(10, 10, 120, 28);
		panel_1_1.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tên LapTop   :");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(10, 48, 120, 28);
		panel_1_1.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("SerialNumber  :");
		lblNewLabel_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1.setBounds(10, 86, 120, 28);
		panel_1_1.add(lblNewLabel_1_1_2_1);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Giá                 :");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1_1.setBounds(10, 124, 120, 28);
		panel_1_1.add(lblNewLabel_1_1_2_1_1);

		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Hạn                :");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1_1_1.setBounds(10, 162, 120, 28);
		panel_1_1.add(lblNewLabel_1_1_2_1_1_1);

		lblMaHoaDon = new JLabel("---");
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaHoaDon.setBounds(140, 10, 318, 28);
		panel_1_1.add(lblMaHoaDon);

		lblTenLapTop = new JLabel("---");
		lblTenLapTop.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenLapTop.setBounds(140, 48, 318, 28);
		panel_1_1.add(lblTenLapTop);

		lblSerialNumber_Cu = new JLabel("---");
		lblSerialNumber_Cu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSerialNumber_Cu.setBounds(140, 86, 318, 28);
		panel_1_1.add(lblSerialNumber_Cu);

		lblGia = new JLabel("---");
		lblGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGia.setBounds(140, 124, 318, 28);
		panel_1_1.add(lblGia);

		lblHan = new JLabel("---");
		lblHan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHan.setBounds(140, 162, 318, 28);
		panel_1_1.add(lblHan);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Trạng Thái");
		lblNewLabel_1_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2.setBounds(10, 304, 115, 28);
		getContentPane().add(lblNewLabel_1_1_2_2);

		cboTrangThai = new JComboBox<String>();
		cboTrangThai.setModel(new DefaultComboBoxModel<String>(new String[] { "Còn Mới 100%", "Lỗi" }));
		cboTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboTrangThai.setBounds(135, 304, 343, 30);
		getContentPane().add(cboTrangThai);

		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Lí Do");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2_1.setBounds(10, 342, 115, 34);
		getContentPane().add(lblNewLabel_1_1_2_2_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 344, 343, 35);
		getContentPane().add(scrollPane);

		txtLiDo = new JTextArea();
		txtLiDo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(txtLiDo);

		JLabel lblNewLabel_1_1_2_2_1_1 = new JLabel("Serial New");
		lblNewLabel_1_1_2_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2_1_1.setBounds(10, 391, 115, 28);
		getContentPane().add(lblNewLabel_1_1_2_2_1_1);

		txtSerialNumber_New = new JTextField();
		txtSerialNumber_New.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSerialNumber_New.setColumns(10);
		txtSerialNumber_New.setBounds(135, 389, 343, 30);
		getContentPane().add(txtSerialNumber_New);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (lblHan.getText().equals("Còn Hạn")) {
						CTPD_REPO.add(getFormCtPhieuDoi());
						fillTableSPDoi();
						BigDecimal tongTien = BigDecimal.valueOf(0);
						for (CTPhieuDoi ctPhieuDoi : CTPD_REPO) {
							tongTien = tongTien.add(ctPhieuDoi.getGiaMoi().subtract(ctPhieuDoi.getGiaCu()));
						}
						tongTiens = tongTien;
						txtTongTien.setText(decimalFormat(tongTiens));
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
		btnAdd.setBounds(95, 443, 83, 33);
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
		panel_3.setBounds(10, 494, 962, 171);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 942, 140);
		panel_3.add(scrollPane_1);

		tblSanPhamDoi = new JTable();
		scrollPane_1.setViewportView(tblSanPhamDoi);

		btnLuuPhieuDoi = new JButton("Lưu Phiếu Đổi");
		btnLuuPhieuDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					BigDecimal tienNhan = BigDecimal.valueOf(Double.valueOf(MsgBox.prompt(getContentPane(), "Nhập tiền nhận: ")));
					
					if (tienNhan.compareTo(tongTiens) < 0) {
						MsgBox.alert(getContentPane(), "Tiền nhận nhỏ hơn tổng tiền");
					}else {
						MsgBox.alert(getContentPane(), "Tiền thừa: " + decimalFormat(tienNhan.subtract(tongTiens)));
						MsgBox.alert(getContentPane(), new PhieuDoiDAO().insert(insertPD()));
						insertCTPD(new PhieuDoiDAO().selectById(lblMaPhieuDoi.getText()));
						
						List<CTPhieuDoi> list = new CTPhieuDoiDAO().selectAllCTPhieuDoiByMaPhieuDoi(lblMaPhieuDoi.getText());
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i).isTrangThai()) {
								new SerialNumberDAO().updateSerial(list.get(i).getSerialNumber_Old());
							}
						}
						
						clearFormLuuPhieuDoi();
						lblMaPhieuDoi.setText(generateAutoCode());
						
					}
					
				} catch (NullPointerException e2) {
					MsgBox.alert(getContentPane(), "Nhập lại thông tin");
				}catch (NumberFormatException e3) {
					MsgBox.alert(getContentPane(), "Nhập lại tiền nhận");
				}
			}
		});
		btnLuuPhieuDoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLuuPhieuDoi.setBounds(328, 443, 150, 33);
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
		btnRemove.setBounds(188, 443, 130, 33);
		getContentPane().add(btnRemove);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2.setBounds(504, 386, 468, 99);
		getContentPane().add(panel_1_2);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Vận chuyển");
		lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_4.setBounds(10, 10, 107, 28);
		panel_1_2.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Thanh toán");
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_2.setBounds(10, 61, 107, 28);
		panel_1_2.add(lblNewLabel_1_1_1_2);
		
		cboVanChuyen = new JComboBox<HinhThucVanChuyen>();
		cboVanChuyen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboVanChuyen.setBounds(127, 10, 331, 28);
		panel_1_2.add(cboVanChuyen);
		fillcboHTVC();
		cboVanChuyen.setSelectedIndex(-1);
		cboVanChuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HinhThucVanChuyen hinhThucVanChuyen = (HinhThucVanChuyen) cboVanChuyen.getSelectedItem();
				tongTiens = tongTiens.add(hinhThucVanChuyen.getGiaVC());
				txtTongTien.setText(decimalFormat(tongTiens));
			}
		});
		cboThanhToan = new JComboBox<HinhThucThanhToan>();
		cboThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboThanhToan.setBounds(127, 61, 331, 28);
		panel_1_2.add(cboThanhToan);
		fillcboHTTT();
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Tổng tiền :");
		lblNewLabel_1_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_5.setBounds(679, 665, 88, 28);
		getContentPane().add(lblNewLabel_1_1_5);
		
		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(777, 665, 184, 28);
		getContentPane().add(txtTongTien);
		

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
		HinhThucVanChuyen hThucVanChuyen = (HinhThucVanChuyen) cboVanChuyen.getSelectedItem();
		phieuDoi.setID_HinhThucVanChuyen(hThucVanChuyen.getId());
		HinhThucThanhToan hThanhToan = (HinhThucThanhToan) cboThanhToan.getSelectedItem();
		phieuDoi.setID_HinhThucThanhToan(hThanhToan.getId());
		phieuDoi.setTongTien(tongTiens);
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
		cboVanChuyen.setSelectedIndex(-1);
		cboThanhToan.setSelectedIndex(-1);
		txtTongTien.setText(null);
	}
	public void fillcboHTVC() {
		DefaultComboBoxModel<HinhThucVanChuyen> model = (DefaultComboBoxModel<HinhThucVanChuyen>) cboVanChuyen.getModel();
		model.removeAllElements();
		List<HinhThucVanChuyen> list = new HinhThucVanChuyenDAO().selectAll();
		for (HinhThucVanChuyen hinhThucVanChuyen : list) {
			model.addElement(hinhThucVanChuyen);
		}
	}
	
	public void fillcboHTTT() {
		DefaultComboBoxModel<HinhThucThanhToan> model = (DefaultComboBoxModel<HinhThucThanhToan>) cboThanhToan.getModel();
		model.removeAllElements();
		List<HinhThucThanhToan> list = new HinhThucThanhToanDAO().selectAll();
		for (HinhThucThanhToan hinhThucThanhToan : list) {
			model.addElement(hinhThucThanhToan);
		}
	}
	
}
