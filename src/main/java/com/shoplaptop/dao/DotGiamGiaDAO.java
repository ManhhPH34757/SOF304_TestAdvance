package com.shoplaptop.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.archivers.zip.X7875_NewUnix;

import com.shoplaptop.entity.DotGiamGia;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XJdbc;

public class DotGiamGiaDAO implements ShopLaptop365DAO<DotGiamGia, String>{
	
	String selectDG = "SELECT * FROM DotGiamGia WHERE Han >= GETDATE() AND DieuKienHoaDon <= ? ORDER BY GiaGiam DESC ";
	String SelectAll_SQL = "SELECT * FROM dbo.DotGiamGia";
	String InsertSQL = "INSERT dbo.DotGiamGia(MaDG,TenDG,Han,GiaGiam,DieuKienHoaDon,MoTa)VALUES(?,?,?,?,?,?)";
	String UpdateSQL = "UPDATE dbo.DotGiamGia SET TenDG = ?, Han =?, GiaGiam = ?,DieuKienHoaDon = ?, MoTa = ? WHERE MaDG = ?";
	String DeleteSQL = "DELETE FROM dbo.DotGiamGia WHERE MaDG = ?";
	String SelectByMaDGG = "SELECT * FROM dbo.DotGiamGia WHERE MaDG = ?";
	
	
	public DotGiamGia getDotGiamGia(String maDotGiam, String tenDotGiamGia, String _han, String _giaGiam,String _dieuKien,String moTa){
		try {
			List<DotGiamGia > dgg = selectAll();
			
			if(maDotGiam == null || maDotGiam.trim().isEmpty()
				|| tenDotGiamGia == null || tenDotGiamGia.trim().isEmpty()
				|| _han == null || _han.trim().isEmpty() || _giaGiam == null || _giaGiam.trim().isEmpty()
				|| _dieuKien == null || _dieuKien.trim().isEmpty()) {
				
				throw new NullPointerException();
			}
			java.util.Date han =  XDate.toDate(_han, "yyyy-MM-dd HH:mm:ss");
			BigDecimal giaGiam = new BigDecimal(_giaGiam);
			BigDecimal dieuKien = new BigDecimal(_dieuKien);
			
			for(DotGiamGia dotGiamGia : dgg) {
				if (dotGiamGia.getMaDotGiam().equals(maDotGiam)) {
					throw new IllegalArgumentException("Mã Đợt Giảm Giá không hợp lệ");
				}
			}
			
			java.util.Date ngayHienTai = new java.util.Date();
			if(han.getYear()+1900 < ngayHienTai.getYear()+1900 || han.getYear()+1900 > 2100 ) {
				throw new IllegalArgumentException("Hạn phải lớn hơn hoặc bằng ngày hiện tại và không được quá năm 2100");
				
			}
			if(giaGiam.compareTo(BigDecimal.ZERO) < 0  ) {
				throw new IllegalArgumentException("Giá giảm phải lớn hơn 0");
			}
			if(giaGiam.compareTo(dieuKien) > 0) {
				throw new IllegalArgumentException("Giá giảm phải nhỏ hơn điều kiện giảm");
				
			}
			if(dieuKien.compareTo(BigDecimal.ZERO) < 0) {
				throw new IllegalArgumentException("Điều kiện giảm phải lớn hơn 0");
			}
			
		return new DotGiamGia(maDotGiam, tenDotGiamGia, han, giaGiam, dieuKien, moTa);	
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
	}

	
	
	@Override
	public String insert(DotGiamGia dgg) {
		try {
			XJdbc.update(InsertSQL, dgg.getMaDotGiam(),dgg.getTenDotGiamGia(),dgg.getHan(),dgg.getGiaGiam(),dgg.getDieuKien(),dgg.getMoTa());
			return "Lưu Thành Công";
		} catch (Exception e) {
			return "Lưu Thất Bại";
	
		}
	}

	@Override
	public String update(DotGiamGia dgg) {
		try {
			XJdbc.update(UpdateSQL,dgg.getTenDotGiamGia(),dgg.getHan(),dgg.getGiaGiam(),dgg.getDieuKien(),dgg.getMoTa(),dgg.getMaDotGiam() );
			return "Update Thành Công";
		} catch (Exception e) {
			return "Update Thất Bại";
		}
	}

	@Override
	public String delete(String maDotGiam) {
		try {
			if(maDotGiam == null || maDotGiam.trim().isEmpty()) {
				throw new NullPointerException();
			}
			XJdbc.update(DeleteSQL, maDotGiam);
			return "Delete Thành Công";
} catch ( SQLException e) {
			return "Delete Thất Bại";
		}
	}
	

	@Override
	public DotGiamGia selectById(String id) {
		List<DotGiamGia> list = this.selectBySQL(SelectByMaDGG, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public DotGiamGia selectDGG(BigDecimal dkHoaDon) {
		List<DotGiamGia> list = this.selectBySQL(selectDG, dkHoaDon);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<DotGiamGia> selectAll() {
		
		return this.selectBySQL(SelectAll_SQL);
	}

	@Override
	public List<DotGiamGia> selectBySQL(String sql, Object... args) {
		List<DotGiamGia> list = new ArrayList<DotGiamGia>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				DotGiamGia dotGiamGia = new DotGiamGia();
				dotGiamGia.setMaDotGiam(rs.getString("MaDG"));
				dotGiamGia.setTenDotGiamGia(rs.getString("TenDG"));
				dotGiamGia.setHan(XDate.toDate(rs.getString("Han"), "yyyy-MM-dd HH:mm:ss"));
				dotGiamGia.setGiaGiam(rs.getBigDecimal("GiaGiam"));
				dotGiamGia.setDieuKien(rs.getBigDecimal("DieuKienHoaDon"));
				dotGiamGia.setMoTa(rs.getString("MoTa"));
				list.add(dotGiamGia);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
