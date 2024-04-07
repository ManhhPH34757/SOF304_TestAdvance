package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.PhieuDoi;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XJdbc;

public class PhieuDoiDAO implements ShopLaptop365DAO<PhieuDoi, String>{
		
	String InsertPhieuDoi_SQL = "INSERT dbo.PhieuDoi(MaPhieuDoi,MaKH,MaNV,NgayTao)VALUES( ?,?,?,?  )";
	String DeletePhieuDoi_SQL = "DELETE FROM dbo.PhieuDoi WHERE MaPhieuDoi = ?";
	String SelectPhieuDoiAll_SQL = "SELECT * FROM dbo.PhieuDoi";
	String SelectPhieuDoiSetForm_SQL = "SELECT dbo.PhieuDoi.ID , dbo.PhieuDoi.MaPhieuDoi  , dbo.PhieuDoi.MaKH, dbo.KhachHang.HoTen AS 'HoTenKhachHang',\r\n"
			+ "		dbo.KhachHang.SoDienThoai,dbo.PhieuDoi.MaNV , dbo.NhanVien.HoTen AS 'HoTenNhanVien', NgayTao\r\n"
			+ "		FROM dbo.PhieuDoi JOIN dbo.KhachHang ON KhachHang.MaKH = PhieuDoi.MaKH\r\n"
			+ "		JOIN dbo.NhanVien ON NhanVien.MaNV = PhieuDoi.MaNV";
	
	String SelectPhieuDoiByMaPD = "SELECT dbo.PhieuDoi.ID , dbo.PhieuDoi.MaPhieuDoi  , dbo.PhieuDoi.MaKH, dbo.KhachHang.HoTen AS 'HoTenKhachHang',\r\n"
			+ "		dbo.KhachHang.SoDienThoai,dbo.PhieuDoi.MaNV , dbo.NhanVien.HoTen AS 'HoTenNhanVien', NgayTao\r\n"
			+ "	FROM dbo.PhieuDoi JOIN dbo.KhachHang ON KhachHang.MaKH = PhieuDoi.MaKH\r\n"
			+ "		JOIN dbo.NhanVien ON NhanVien.MaNV = PhieuDoi.MaNV "
			+ "WHERE MaPhieuDoi = ?";
	
	
	
	@Override
	public String insert(PhieuDoi phieuDoi) {
		try {
			XJdbc.update(InsertPhieuDoi_SQL, phieuDoi.getMaPhieuDoi(),phieuDoi.getMaKH(),phieuDoi.getMaNV(),phieuDoi.getNgayTao());
			return "Insert Thành Công";
		} catch (Exception e) {
			return "Insert Thất Bại";
		}
		
	}
	
	@Override
	public String update(PhieuDoi phieuDoi) {
		return null;
		
	}
	
	@Override
	public String delete(String MaPhieuDoi) {
		try {
			XJdbc.update(DeletePhieuDoi_SQL, MaPhieuDoi);
			return "Delete Thành Công";
		} catch (Exception e) {
			return "Delete Thất Bại";
		}
	}
	
	@Override
	public PhieuDoi selectById(String id) {
		List<PhieuDoi> list = this.selectBySQLSetForm(SelectPhieuDoiByMaPD, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<PhieuDoi> selectAll() {
		return this.selectBySQL(SelectPhieuDoiAll_SQL);
	}
	
	@Override
	public List<PhieuDoi> selectBySQL(String sql, Object... args) {
		List<PhieuDoi> list = new ArrayList<PhieuDoi>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while(rs.next()) {
				PhieuDoi phieuDoi = new PhieuDoi();
				phieuDoi.setID(rs.getInt("ID"));
				phieuDoi.setMaPhieuDoi(rs.getString("MaPhieuDoi"));
				phieuDoi.setMaKH(rs.getString("MaKH"));
				phieuDoi.setMaNV(rs.getString("MaNV"));
				phieuDoi.setNgayTao(XDate.toDate(rs.getString("NgayTao"), "yyyy-MM-dd HH:mm:ss"));
				list.add(phieuDoi);				
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<PhieuDoi> selectAllSetForm() {
		return this.selectBySQLSetForm(SelectPhieuDoiSetForm_SQL);
	}
	
	public List<PhieuDoi> selectBySQLSetForm(String sql, Object... args) {
		List<PhieuDoi> list = new ArrayList<PhieuDoi>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while(rs.next()) {
				PhieuDoi phieuDoi = new PhieuDoi();
				phieuDoi.setID(rs.getInt("ID"));
				phieuDoi.setMaPhieuDoi(rs.getString("MaPhieuDoi"));
				phieuDoi.setMaKH(rs.getString("MaKH"));
				phieuDoi.setTenKH(rs.getString("HoTenKhachHang"));
				phieuDoi.setSoDienThoai(rs.getString("SoDienThoai"));
				phieuDoi.setMaNV(rs.getString("MaNV"));
				phieuDoi.setTenNV(rs.getString("HoTenNhanVien"));
				phieuDoi.setNgayTao(XDate.toDate(rs.getString("NgayTao"), "yyyy-MM-dd HH:mm:ss"));
				list.add(phieuDoi);				
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	
	
	
	
}
