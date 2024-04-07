package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.shoplaptop.dao.CTPhieuDoiDAO;
import com.shoplaptop.dao.PhieuDoiDAO;
import com.shoplaptop.entity.CTPhieuDoi;
import com.shoplaptop.entity.PhieuDoi;
import com.shoplaptop.utils.MsgBox;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XImage;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("serial")
public class FormDanhSachPhieuDoi extends JDialog {
	public DefaultTableModel model ;
	public DefaultTableModel model2;
	PhieuDoiDAO phieuDoiDAO = new PhieuDoiDAO();
	CTPhieuDoiDAO ctPhieuDoiDAO = new CTPhieuDoiDAO();
	List<PhieuDoi> list = new ArrayList<PhieuDoi>();
	PhieuDoi phieuDoi;
	private JTextField txtTimKiem;
	private JTable tblDanhSachPhieuDoi;
	private JTable tblDanhSachPhieuDoiChiTiet;
	private int row = -1;
	private String maPhieuDoi = "";
	private int id_phieuDoi;
	String SelectPhieuDoiByMaPhieuDoi = "SELECT * FROM dbo.PhieuDoi WHERE MaPhieuDoi LIKE ?";

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDanhSachPhieuDoi dialog = new FormDanhSachPhieuDoi();
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
	public FormDanhSachPhieuDoi() {
		setBounds(100, 100, 975, 675);
		setLocationRelativeTo(this);
		getContentPane().setLayout(null);
		setIconImage(XImage.getAppIcon());
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH PHIẾU ĐỔI");
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 21, 367, 40);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm Phiếu Đổi");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(33, 81, 169, 28);
		getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 215, 215));
		panel.setBounds(33, 119, 893, 64);
		getContentPane().add(panel);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(10, 10, 679, 44);
		panel.add(txtTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(new Color(64, 0, 0));
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTimKiem.setBackground(new Color(255, 128, 128));
		btnTimKiem.setBounds(743, 9, 106, 45);
		panel.add(btnTimKiem);
		
		JLabel lblNewLabel_2 = new JLabel("Danh Sách Phiếu Đổi");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(33, 206, 176, 19);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnDeletePhieuDoi = new JButton("Delete");
		btnDeletePhieuDoi.setForeground(new Color(64, 0, 0));
		btnDeletePhieuDoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnDeletePhieuDoi.setBackground(new Color(255, 191, 191));
		btnDeletePhieuDoi.setBounds(841, 206, 85, 32);
		getContentPane().add(btnDeletePhieuDoi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 248, 893, 158);
		getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
		String[] cols = {"MaPhieuDoi","MaKH","MaNV","NgayTao"};
		model.setColumnIdentifiers(cols);
		
		tblDanhSachPhieuDoi = new JTable(model);
		tblDanhSachPhieuDoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tblDanhSachPhieuDoi.setRowMargin(3);
		tblDanhSachPhieuDoi.setRowHeight(25);
		scrollPane.setViewportView(tblDanhSachPhieuDoi);
		
		JLabel lblNewLabel_2_1 = new JLabel("Danh Sách Chi Tiết Phiếu Đổi");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(35, 427, 265, 28);
		getContentPane().add(lblNewLabel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 465, 893, 158);
		getContentPane().add(scrollPane_1);
		
		model2 = new DefaultTableModel();
		String[] colS = {"Mã phiếu đổi","MaHD","Serial_Old","Giá cũ","Serial_New","Giá mới","Trạng Thái","Lí Do"};
		model2.setColumnIdentifiers(colS);
		
		tblDanhSachPhieuDoiChiTiet = new JTable(model2);
		tblDanhSachPhieuDoiChiTiet.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tblDanhSachPhieuDoiChiTiet.setRowMargin(3);
		tblDanhSachPhieuDoiChiTiet.setRowHeight(25);
		scrollPane_1.setViewportView(tblDanhSachPhieuDoiChiTiet);
		
		JButton btnNewButton = new JButton("Xuất file Excel");
		btnNewButton.setBackground(new Color(255, 202, 202));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<PhieuDoi> list_phieudoi = phieuDoiDAO.selectAll();					
					XuatFile(list_phieudoi);
					MsgBox.alert(getContentPane(), "Xuất file thành công");
				} catch (Exception e2) {
					MsgBox.alert(getContentPane(), "Xuất file thất bại");
				}
				
				
			}
		});
		btnNewButton.setBounds(766, 40, 152, 34);
		getContentPane().add(btnNewButton);
		
		tblDanhSachPhieuDoiChiTiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					int index = tblDanhSachPhieuDoiChiTiet.getSelectedRow(); 
					new ChiTietPhieuDoiView().setVisible(true);
					setFormPhieuDoi(new PhieuDoiDAO().selectById(String.valueOf(tblDanhSachPhieuDoiChiTiet.getValueAt(index, 0))));
					fillTableCTPhieuDoi2(maPhieuDoi);
					
			}
		});
		fillTablePhieuDoi(new PhieuDoiDAO().selectAll());
		tblDanhSachPhieuDoi.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					row = tblDanhSachPhieuDoi.getSelectedRow();
					maPhieuDoi = (String) tblDanhSachPhieuDoi.getValueAt(row, 0);
					fillTableCTPhieuDoi(maPhieuDoi);
					PhieuDoi phieuDoi = new PhieuDoiDAO().selectById(maPhieuDoi);
					id_phieuDoi = phieuDoi.getID();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnDeletePhieuDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int config = JOptionPane.showConfirmDialog(getContentPane(), "Bạn có chắc chắn muốn xóa không?");
				if (config == JOptionPane.YES_OPTION) {
					new CTPhieuDoiDAO().delete(id_phieuDoi);
					MsgBox.alert(getContentPane(), new PhieuDoiDAO().delete(maPhieuDoi));
					fillTablePhieuDoi(new PhieuDoiDAO().selectAll());
					model2.setRowCount(0);
				}
			}
		});
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindByMaPhieuDoi();
			}
		});
	}

	public void fillTablePhieuDoi(List<PhieuDoi> list) {
		model.setRowCount(0);
		for(PhieuDoi phieuDoi : list) {
			Object[] row = new Object[] {
					phieuDoi.getMaPhieuDoi(),
					phieuDoi.getMaKH(),
					phieuDoi.getMaNV(), 
					XDate.toString(phieuDoi.getNgayTao(), "yyyy-MM-dd HH:mm:ss"),
			};
			model.addRow(row);
		}
		
	}
	public void fillTableCTPhieuDoi(String MaPhieuDoi) {
		try {
			model2.setRowCount(0);
			List<CTPhieuDoi> list = new CTPhieuDoiDAO().selectAllCTPhieuDoiByMaPhieuDoi(MaPhieuDoi);
			for(CTPhieuDoi pDoi : list) {
				Object[] rows = new Object[] {
					pDoi.getMaPhieuDoi(),
					pDoi.getMaHoaDon(),
					pDoi.getSerialNumber_Old(),
					pDoi.getGiaCu(),
					pDoi.getSerialNumber_New(),
					pDoi.getGiaMoi(),
					pDoi.isTrangThai() ? "Còn Mới 100%" : "Lỗi",
					pDoi.getLiDo()
				};
				model2.addRow(rows);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void fillTableCTPhieuDoi2(String MaPhieuDoi) {
		try {
			ChiTietPhieuDoiView.model3.setRowCount(0);
			List<CTPhieuDoi> list = new CTPhieuDoiDAO().selectAllCTPhieuDoiByMaPhieuDoi(MaPhieuDoi);
			for(CTPhieuDoi ctPhieuDoi : list) {
				Object[] rows = new Object[] {
						ctPhieuDoi.getMaPhieuDoi(),
						ctPhieuDoi.getMaHoaDon(), 
						ctPhieuDoi.getSerialNumber_Old(),
						ctPhieuDoi.getTenLapCu(), 
						decimalFormat(ctPhieuDoi.getGiaCu()), 
						ctPhieuDoi.getSerialNumber_New(),
						ctPhieuDoi.getTenLapMoi(), 
						decimalFormat(ctPhieuDoi.getGiaMoi()),
						ctPhieuDoi.isTrangThai() ? "Còn Mới 100%" : "Lỗi", 
						ctPhieuDoi.getLiDo() 
						
				};
				ChiTietPhieuDoiView.model3.addRow(rows);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void FindByMaPhieuDoi() {
		String MaPhieuDoi = txtTimKiem.getText();
		if (MaPhieuDoi.trim().isEmpty()) {
			MaPhieuDoi = "%%";
			MsgBox.alert(getContentPane(),"Không tìm thấy");
		}
		List<PhieuDoi> list = new ArrayList<PhieuDoi>();
		list = phieuDoiDAO.selectBySQL(SelectPhieuDoiByMaPhieuDoi, "%"+MaPhieuDoi+"%");
		fillTablePhieuDoi(list);
		
	}
	
	public static void setFormPhieuDoi(PhieuDoi phieuDoi) {
		ChiTietPhieuDoiView.txtMaPhieuDoi.setText(phieuDoi.getMaPhieuDoi());
		ChiTietPhieuDoiView.txtMaKhachHang.setText(phieuDoi.getMaKH());
		ChiTietPhieuDoiView.txtTenKhachHang.setText(phieuDoi.getTenKH());
		ChiTietPhieuDoiView.txtSoDienThoai.setText(phieuDoi.getSoDienThoai());
		ChiTietPhieuDoiView.txtMaNhanVien.setText(phieuDoi.getMaNV());
		ChiTietPhieuDoiView.txtTenNhanVien.setText(phieuDoi.getTenNV());
		ChiTietPhieuDoiView.txtNgayTao.setText(XDate.toString(phieuDoi.getNgayTao(),"yyyy-MM-dd HH:mm:ss"));
		
	}

	
	public static String decimalFormat(BigDecimal bigDecimal) {        
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        String formattedNumber = decimalFormat.format(bigDecimal);
        return formattedNumber;
	}
	
	public void XuatFile(List<PhieuDoi> list_phieudoi) {
		JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xls", "xlsx");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showSaveDialog(getContentPane()) == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xlsx") && !filePath.toLowerCase().endsWith(".xls")) {
                fileToSave = new File(filePath + ".xlsx");
            }

            Workbook workbook = new XSSFWorkbook(); 
            Sheet sheet1 = workbook.createSheet("Danh sách Phieu Doi"); 
           
            Row headerRow = sheet1.createRow(0);
            headerRow.createCell(0).setCellValue("MaPhieuDoi");
            headerRow.createCell(1).setCellValue("MaKH");
            headerRow.createCell(2).setCellValue("MaNV");
            headerRow.createCell(3).setCellValue("NgayTao");

            

            for (int i = 0; i < list_phieudoi.size(); i++) {
                PhieuDoi phieuDoi = list_phieudoi.get(i);
                Row row = sheet1.createRow(i + 1);                
            	    row.createCell(0).setCellValue(phieuDoi.getMaPhieuDoi());
	                row.createCell(1).setCellValue(phieuDoi.getMaKH());
	                row.createCell(2).setCellValue(phieuDoi.getMaNV());
	                row.createCell(3).setCellValue(XDate.toString(phieuDoi.getNgayTao(), "yyyy-MM-dd HH:mm:ss"));
	                
            }
            
            Sheet sheet2 = workbook.createSheet("Danh sách Chi Tiet Phieu Doi"); 
       
            Row headerRow2 = sheet2.createRow(0);
            headerRow2.createCell(0).setCellValue("Mã phiếu đổi");
            headerRow2.createCell(1).setCellValue("MãHD");
            headerRow2.createCell(2).setCellValue("Serial_Old");
            headerRow2.createCell(3).setCellValue("Giá cũ");
            headerRow2.createCell(4).setCellValue("Serial_New");
            headerRow2.createCell(5).setCellValue("Giá mới");
            headerRow2.createCell(6).setCellValue("Trạng Thái");
            headerRow2.createCell(7).setCellValue("Lí Do");
            
            
            List<CTPhieuDoi> list_ctphieudoi = ctPhieuDoiDAO.selectAll();

            for (int i = 0; i < list_ctphieudoi.size(); i++) {
                CTPhieuDoi ctPhieuDoi = list_ctphieudoi.get(i);
                Row row = sheet2.createRow(i + 1);
                row.createCell(0).setCellValue(ctPhieuDoi.getMaPhieuDoi());
                row.createCell(1).setCellValue(ctPhieuDoi.getMaPhieuDoi());
                row.createCell(2).setCellValue(ctPhieuDoi.getSerialNumber_Old());
                row.createCell(3).setCellValue(decimalFormat(ctPhieuDoi.getGiaCu()));
                row.createCell(4).setCellValue(ctPhieuDoi.getSerialNumber_New());
                row.createCell(5).setCellValue(decimalFormat(ctPhieuDoi.getGiaMoi()));
                row.createCell(6).setCellValue(ctPhieuDoi.isTrangThai()? "Còn Mới 100%":"Lỗi");
                row.createCell(7).setCellValue(ctPhieuDoi.getLiDo());
                
                
            }


            try (FileOutputStream outputStream = new FileOutputStream(fileToSave)) { 
                workbook.write(outputStream); 
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                workbook.close(); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	

}

