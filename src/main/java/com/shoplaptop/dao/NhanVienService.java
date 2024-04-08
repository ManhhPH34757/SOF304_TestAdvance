package com.shoplaptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shoplaptop.entity.NhanVien;
import com.shoplaptop.entity.TaiKhoan;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XJdbc;

public class NhanVienService implements ShopLaptop365DAO<NhanVien, String>{
	
	Connection connection = new XJdbc().Connect();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
 	String Insert_SQL = "INSERT INTO NhanVien (MaNV,HoTen,SoDienThoai,NgaySinh,GioiTinh,Email,Hinh,DiaChi) VALUES (?,?,?,?,?,?,?,?) ";
					
	String Delete_SQL = "DELETE FROM dbo.NhanVien WHERE MaNV = ?";
			
	String Update_SQL = "UPDATE dbo.NhanVien SET HoTen =? , SoDienThoai =? , NgaySinh =? , GioiTinh =? , Email =? , Hinh =? , DiaChi =? WHERE MaNV =? ";
			
	String SelectById_SQL = "SELECT NhanVien.MaNV,HoTen,SoDienThoai,NgaySinh,GioiTinh,Email,Hinh,DiaChi,VaiTro FROM dbo.NhanVien JOIN dbo.TaiKhoan ON TaiKhoan.MaNV = NhanVien.MaNV Where NhanVien.MaNV = ?";
		
	String selectAll = "SELECT NhanVien.MaNV,HoTen,SoDienThoai,NgaySinh,GioiTinh,Email,Hinh,DiaChi,VaiTro FROM dbo.NhanVien JOIN dbo.TaiKhoan ON TaiKhoan.MaNV = NhanVien.MaNV";
	
	String Update_sql = "UPDATE dbo.TaiKhoan SET VaiTro =? WHERE MaNV =?";
	
	String query = "\r\n"
			+ "SELECT * FROM\r\n"
			+ "    (SELECT ROW_NUMBER() OVER (ORDER BY  NhanVien.MaNV DESC) AS rownum,   NhanVien.MaNV,HoTen,SoDienThoai,NgaySinh,GioiTinh,Email,Hinh,DiaChi,VaiTro FROM dbo.NhanVien JOIN dbo.TaiKhoan ON TaiKhoan.MaNV = NhanVien.MaNV)\r\n"
			+ "    AS temp\r\n"
			+ "    WHERE rownum BETWEEN ? AND ?";
	String SelectByTenDangNhap = "SELECT NhanVien.MaNV,HoTen,SoDienThoai,NgaySinh,GioiTinh,Email,Hinh,DiaChi,VaiTro FROM dbo.NhanVien JOIN dbo.TaiKhoan ON TaiKhoan.MaNV = NhanVien.MaNV Where tendangnhap = ?";
	
		
	public String insert(NhanVien entity) {
		try {
			XJdbc.update(Insert_SQL, entity.getMaNV(),entity.getHoTen(),entity.getSoDienThoai(),entity.getNgaySinh(),entity.isGioiTinh(),entity.getEmail(),entity.getHinh(),entity.getDiaChi());
			return "Add thành công";
		} catch (Exception e) {
			return "Add k thành công";
		}
		
	}

	
	public String update(NhanVien entity) {
		try {
			XJdbc.update(Update_SQL, entity.getHoTen(),entity.getSoDienThoai(),entity.getNgaySinh(),entity.isGioiTinh(),entity.getEmail(),entity.getHinh(),entity.getDiaChi(),entity.getMaNV());
			return "Update thành công";
		} catch (Exception e) {
			return "Update k thành công";
		}
		
	}
	
	
	
	public String updateTK(NhanVien nhanVien) {
		try {
			XJdbc.update(Update_sql, nhanVien.isVaiTro(),nhanVien.getMaNV());
			return "Update thành công";
		} catch (Exception e) {
			return "Update k thành công";
		}
		
	}

	
	public String delete(String id) {
		if (id == null || id.trim().isEmpty()) {
			throw new NullPointerException();
		}
		try {
			XJdbc.update(Delete_SQL, id);
			return "Xóa thành công";
		} catch (SQLException e) {
			return "Xóa k thành công";
		}
		
	}

	
	public NhanVien selectById(String id) {
		List<NhanVien> list = this.selectBySQL(SelectById_SQL, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public NhanVien selectByTenDangNhap(String id) {
		List<NhanVien> list = this.selectBySQL(SelectByTenDangNhap, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public List<NhanVien> selectAll() {
		return selectBySQL(selectAll);
	}

	
	public List<NhanVien> selectBySQL(String sql, Object... args) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNV(rs.getString("MaNv"));
				nhanVien.setHoTen(rs.getString("HoTen"));
				nhanVien.setSoDienThoai(rs.getString("SoDienThoai"));
				nhanVien.setGioiTinh(rs.getBoolean("GioiTinh"));
				nhanVien.setEmail(rs.getString("Email"));
				nhanVien.setHinh(rs.getString("Hinh"));
				nhanVien.setDiaChi(rs.getString("DiaChi"));
				nhanVien.setNgaySinh(XDate.toDate(rs.getString("NgaySinh"), "yyyy-MM-dd"));
				nhanVien.setVaiTro(rs.getBoolean("VaiTro"));
				list.add(nhanVien);		
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public List<NhanVien> sellectAllNhanVien(int count) {
		return selectBySQL(query, count,count+2);
	}
	
	public NhanVien getNhanVien(String _manv,String _hoTen,String _sdt, String _ngaySinh,String _goiTinh,String _Email,String _hinhString,String _diaChi, String _vaiTro, String _tenDangNhap,String _matKhau) {
		try {
			
			String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
			String regex1 = "\\d{10}";
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
			TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
			List<NhanVien> list = selectAll();
			List<TaiKhoan> list2 = taiKhoanDAO.selectAll();
			
			if( _manv == null || _manv.trim().isEmpty() || _hoTen == null || _hoTen.trim().isEmpty()
				|| _sdt == null || _sdt.trim().isEmpty() || _ngaySinh == null || _ngaySinh.trim().isEmpty()
				|| _goiTinh == null ||_goiTinh.trim().isEmpty() || _Email == null || _Email.trim().isEmpty()
				|| _hinhString == null || _hinhString.trim().isEmpty() || _diaChi == null || _diaChi.trim().isEmpty()
				|| _vaiTro == null || _vaiTro.trim().isEmpty() || _tenDangNhap == null || _tenDangNhap.trim().isEmpty()
				|| _matKhau == null || _matKhau.trim().isEmpty()) {
				
				throw new NullPointerException();
				
			}
			
			for (NhanVien nhanVien : list) {
				if (nhanVien.getMaNV().equals(_manv)) {
					throw new IllegalArgumentException("Mã nhân viên trùng");
				}
			}
			
			if (!_sdt.matches(regex1)) {
				throw new IllegalArgumentException("Số điện thoại không hợp lệ");
			}
			
			if (!_Email.matches(regex)) {
				throw new IllegalArgumentException("Email không đúng định dạng");
			}
			
			boolean gioiTinh = Boolean.parseBoolean(_goiTinh);
			boolean vaiTro = Boolean.parseBoolean(_vaiTro);
			
			
			Date date = XDate.toDate(_ngaySinh, "yyyy-MM-dd");
			
			if (!_goiTinh.equals("true")  && !_goiTinh.equals("false") ) {
				throw new IllegalArgumentException("Giới tính không hợp lệ");
			}
			
			if (_vaiTro.equals("true") && _vaiTro.equals("false")) {
				throw new IllegalArgumentException("Vai trò không hợp lệ");
			}
			
			
			
			for (TaiKhoan taiKhoan : list2) {
				if (taiKhoan.getTenDangNhap() == _tenDangNhap) {
					throw new IllegalArgumentException("Tên đăng nhập đã tồn tại");
				}
			}
			
			return new NhanVien(_manv, _hoTen, _sdt, date, gioiTinh, _Email, _hinhString, _diaChi, vaiTro);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
	}
	
	
	
}
