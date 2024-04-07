package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shoplaptop.entity.DongLaptop;
import com.shoplaptop.entity.Laptop;
import com.shoplaptop.entity.PhanLoai;
import com.shoplaptop.utils.XJdbc;

public class LaptopDAO implements ShopLaptop365DAO<Laptop, String>{
	
	DongLaptopDAO dongLaptopDAO = new DongLaptopDAO();
	PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
	
	String selectAll_SQL = "SELECT Laptop.ID, MaLaptop, TenLaptop, PhanLoai.ID AS PhanLoai, PhanLoai.Tenloai, Hang.ID AS Hang, Hang.TenHang, DongLaptop.ID AS DongLaptop, DongLaptop.TenDong, NamSanXuat  FROM Laptop JOIN PhanLoai ON Laptop.PhanLoai = PhanLoai.ID JOIN DongLaptop ON Laptop.DongLaptop = DongLaptop.ID JOIN Hang ON Hang.ID = DongLaptop.Hang";
	String insertLaptop = "INSERT INTO Laptop(MaLaptop, TenLaptop, PhanLoai, DongLaptop, NamSanXuat) VALUES (?,?,?,?,?)";
	String updateLaptop = "UPDATE Laptop SET TenLaptop = ?, PhanLoai = ?, DongLaptop = ?, NamSanXuat = ? WHERE MaLaptop = ?";
	String deleteLaptop = "DELETE FROM Laptop WHERE MaLaptop = ?";
	String selectByID_SQL = "SELECT Laptop.ID, MaLaptop, TenLaptop, PhanLoai.ID AS PhanLoai, PhanLoai.Tenloai, Hang.ID AS Hang, Hang.TenHang, DongLaptop.ID AS DongLaptop, DongLaptop.TenDong, NamSanXuat  FROM Laptop JOIN PhanLoai ON Laptop.PhanLoai = PhanLoai.ID JOIN DongLaptop ON Laptop.DongLaptop = DongLaptop.ID JOIN Hang ON Hang.ID = DongLaptop.Hang WHERE MaLaptop = ?";
	String selectLaptop = "SELECT * FROM\r\n"
			+ "    (SELECT ROW_NUMBER() OVER (ORDER BY MaLaptop DESC) AS rownum, Laptop.ID, MaLaptop, TenLaptop, PhanLoai.ID AS PhanLoai, PhanLoai.Tenloai, Hang.ID AS Hang, Hang.TenHang, DongLaptop.ID AS DongLaptop, DongLaptop.TenDong, NamSanXuat  FROM Laptop JOIN PhanLoai ON Laptop.PhanLoai = PhanLoai.ID JOIN DongLaptop ON Laptop.DongLaptop = DongLaptop.ID JOIN Hang ON Hang.ID = DongLaptop.Hang)\r\n"
			+ "    AS temp\r\n"
			+ "    WHERE rownum BETWEEN ? AND ?";
	String selectByLaptop = "";
	
	String selectBySerial_SQL = "SELECT Laptop.ID, MaLaptop, TenLaptop, PhanLoai.ID AS PhanLoai, PhanLoai.Tenloai, Hang.ID AS Hang, Hang.TenHang, DongLaptop.ID AS DongLaptop, DongLaptop.TenDong, NamSanXuat  \r\n"
			+ "		FROM Laptop JOIN PhanLoai ON Laptop.PhanLoai = PhanLoai.ID JOIN DongLaptop ON Laptop.DongLaptop = DongLaptop.ID JOIN Hang ON Hang.ID = DongLaptop.Hang JOIN dbo.BienThe ON BienThe.ID_Laptop = Laptop.ID JOIN dbo.Serial ON Serial.ID_BienThe = BienThe.ID\r\n"
			+ "		WHERE dbo.Serial.SerialNumber = ?";
	
	public String regex = "^[\\p{L}\\p{Nd}\\s]+$";
	
	public Laptop getLaptop(String maLaptop, String tenLaptop, String _dongLaptop, String _phanLoai, String _namSanXuat) {
		
		try {
			
			List<Laptop> laptops = selectAll();
			List<DongLaptop> dongLaptops = dongLaptopDAO.selectAll();
			List<PhanLoai> phanLoais = phanLoaiDAO.selectAll();
			
			if ( maLaptop == null || maLaptop.trim().isEmpty() || 
					tenLaptop == null || tenLaptop.trim().isEmpty() || 
					_dongLaptop == null || _dongLaptop.trim().isEmpty() || 
					_phanLoai == null || _phanLoai.trim().isEmpty() ||
					_namSanXuat == null || _namSanXuat.trim().isEmpty()) {
				
				throw new NullPointerException();
				
			}
			
			int dongLaptop = Integer.parseInt(_dongLaptop);
			int phanLoai = Integer.parseInt(_phanLoai);
			int namSanXuat = Integer.parseInt(_namSanXuat);
			
			for (Laptop laptop : laptops) {
				if (laptop.getMaLaptop().equals(maLaptop)) {
					throw new IllegalArgumentException("Mã Laptop không hợp lệ!");
				}
			}
			
			if (!isValid(tenLaptop)) {
				throw new IllegalArgumentException("Tên Laptop không hợp lệ");
			}
			
			if (namSanXuat < 1945 || namSanXuat > 2024) {
				throw new IllegalArgumentException("Năm sản xuất không hợp lệ");
			}
			
			int indexDongLaptop = -1;
			for (int i = 0; i < dongLaptops.size(); i++) {
				if (dongLaptops.get(i).getId() == dongLaptop) {
					indexDongLaptop = i;
					break;
				}
			}
			
			if (indexDongLaptop == -1) {
				throw new IllegalArgumentException("Không tìm thấy dòng Laptop");
			}
			
			int indexPhanLoaiLaptop = -1;
			for (int i = 0; i < phanLoais.size(); i++) {
				if (phanLoais.get(i).getId() == phanLoai) {
					indexPhanLoaiLaptop = i;
					break;
				}
			}
			
			if (indexPhanLoaiLaptop == -1) {
				throw new IllegalArgumentException("Không tìm thấy loại Laptop");
			}
			
			return new Laptop(maLaptop, tenLaptop, dongLaptop, phanLoai, namSanXuat);
		
		} catch (NumberFormatException e) {
			
			throw new NumberFormatException();
			
		}
		
	}
	
	public String maLaptop(String maLaptop) {
		if (maLaptop == null || maLaptop.trim().isEmpty()) {
			throw new NullPointerException();
		}
		return maLaptop;
	}
	
	private boolean isValid(String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
	
	public String insert(Laptop laptop) {
		try {
			XJdbc.update(insertLaptop,  laptop.getMaLaptop(),  laptop.getTenLaptop(),  laptop.getPhanLoai(),  laptop.getDongLaptop(),  laptop.getNamSanXuat());
			return "Add thành công";
		} catch (SQLException e) {
			return "Add thất bại";
		}
	}

	public String update(Laptop laptop) {
		try {
			XJdbc.update(updateLaptop,  laptop.getTenLaptop(),  laptop.getPhanLoai(),  laptop.getDongLaptop(),  laptop.getNamSanXuat(),  laptop.getMaLaptop());
			return "Update thành công";
		} catch (SQLException e) {
			return "Update thất bại";
			
		}
	}

	public String delete(String string) {
		try {
			XJdbc.update(deleteLaptop,  string);
			return "Xóa thành công";
		} catch (SQLException e) {
			return "Xóa thất bại";
			
		}
	}
	
	public Laptop selectBySerial(String serial) {
		List<Laptop> list = this.selectBySQL(selectBySerial_SQL, serial);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public Laptop selectById(String id) {
		List<Laptop> list = this.selectBySQL(selectByID_SQL, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public List<Laptop> selectAll() {
		return selectBySQL(selectAll_SQL);
	}
	
	public List<Laptop> selectAllLaptop(int count) {
		return selectBySQL(selectLaptop,count,count+7);
	}
	
	public List<Laptop> selectBySQL(String sql, Object... args) {
		List<Laptop> list = new ArrayList<Laptop>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				Laptop laptop = new Laptop();
				laptop.setId(rs.getInt("ID"));
				laptop.setMaLaptop(rs.getString("MaLaptop"));
				laptop.setTenLaptop(rs.getString("TenLaptop"));
				laptop.setPhanLoai(rs.getInt("PhanLoai"));
				laptop.setTenLoai(rs.getString("TenLoai"));
				laptop.setHang(rs.getInt("Hang"));
				laptop.setTenHang(rs.getString("TenHang"));
				laptop.setDongLaptop(rs.getInt("DongLaptop"));
				laptop.setTenDong(rs.getString("TenDong"));
				laptop.setNamSanXuat(rs.getInt("NamSanXuat"));
				list.add(laptop);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
