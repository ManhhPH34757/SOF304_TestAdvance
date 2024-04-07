package com.shoplaptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.NhanVien;
import com.shoplaptop.entity.TaiKhoan;
import com.shoplaptop.utils.XJdbc;

public class TaiKhoanDAO implements ShopLaptop365DAO<TaiKhoan, String> {
	
	
	Connection connection = new XJdbc().Connect();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String Insert_sql = "INSERT INTO dbo.TaiKhoan( MaNV,TenDangNhap, MatKhau,VaiTro)VALUES( ?,?,?,? )";

	String Update_sql = "UPDATE dbo.TaiKhoan SET VaiTro =? WHERE MaNV =?";
	
	String Update_sql_matkhau = "UPDATE dbo.TaiKhoan SET matkhau =? WHERE MaNV =?";
	
	String DeleteString_sql = "DELETE FROM dbo.TaiKhoan WHERE MaNV =?";
	
	String SelectById_SQL = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ?";
	
	String SelectById_SQL_1 = "SELECT TaiKhoan.MaNv,TenDangNhap,MatKhau,VaiTro FROM dbo.NhanVien JOIN dbo.TaiKhoan ON TaiKhoan.MaNV = NhanVien.MaNV Where NhanVien.MaNV = ?";
	
	String sellectAll = "SELECT * FROM dbo.TaiKhoan";
	
	String selectByTenDangNhap = "SELECT Tendangnhap,matkhau FROM TaiKhoan where manv = ?";
	
	String SelectByVaiTro = "SELECT * FROM TaiKhoan where manv = ?";	
	
	
	public String insert(TaiKhoan taiKhoan) {
		try {
			XJdbc.update(Insert_sql, taiKhoan.getMaNV(),taiKhoan.getTenDangNhap(),taiKhoan.getMatKhau(),taiKhoan.isVaiTro());
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	public String update(TaiKhoan taiKhoan) {
		try {
			XJdbc.update(Update_sql, taiKhoan.isVaiTro(),taiKhoan.getMaNV());
			
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public String updateMatKhau(TaiKhoan taiKhoan) {
		try {
			XJdbc.update(Update_sql_matkhau, taiKhoan.getMatKhau(),taiKhoan.getMaNV());
			return "Update thành công";
		} catch (Exception e) {
			return "Update không thành công";
		}
		
	}

	
	public String delete(String MaNV) {
		try {
			XJdbc.update(DeleteString_sql, MaNV);
		} catch (Exception e) {
			
		}
		return null;
	}

	public TaiKhoan selectbymanhanvien(String manv) {
		List<TaiKhoan> list = this.selectBySQL(SelectById_SQL_1, manv);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public TaiKhoan selectbyvaitro(String manv) {
		List<TaiKhoan> list = this.selectBySQL(SelectByVaiTro, manv);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public TaiKhoan selectByTenDangNhap(String id) {
		List<TaiKhoan> list = this.selectBySQL(selectByTenDangNhap, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public TaiKhoan selectById(String tenDangNhap) {
		List<TaiKhoan> list = this.selectBySQL(SelectById_SQL, tenDangNhap);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	
	public List<TaiKhoan> selectAll() {
		return selectBySQL(sellectAll);
	}

	
	public List<TaiKhoan> selectBySQL(String sql, Object... args) {
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				TaiKhoan taiKhoan = new TaiKhoan();
				taiKhoan.setMaNV(rs.getString("MaNV"));
				taiKhoan.setTenDangNhap(rs.getString("TenDangNhap"));
				taiKhoan.setMatKhau(rs.getString("MatKhau"));
				taiKhoan.setVaiTro(rs.getBoolean("VaiTro"));
				list.add(taiKhoan);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public TaiKhoan getTaiKhoan(String _maNV,String _tenDangNhap,String _matKhau, String _vaiTro) {
		try {
			NhanVienService nhanVienService = new NhanVienService();
			List<TaiKhoan> list2 = selectAll();
			List<NhanVien> list = nhanVienService.selectAll();
			boolean vaiTro = Boolean.parseBoolean(_vaiTro);
			
			if (vaiTro != true || vaiTro != false) {
				throw new IllegalArgumentException("Vai trò không hợp lệ");
			}
			
			for (TaiKhoan taiKhoan : list2) {
				if (taiKhoan.getTenDangNhap() == _tenDangNhap) {
					throw new IllegalArgumentException("Tên đăng nhập đã tồn tại");
				}
			}
			
			for (NhanVien nhanVien : list) {
				if (nhanVien.getMaNV().equals(_maNV)) {
					throw new IllegalArgumentException("Mã nhân viên trùng");
				}
			}
			return new TaiKhoan(_maNV, _tenDangNhap, _matKhau, vaiTro);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
	}
}
