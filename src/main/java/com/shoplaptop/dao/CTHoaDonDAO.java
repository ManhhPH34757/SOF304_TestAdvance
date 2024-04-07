package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.CTHoaDon;
import com.shoplaptop.utils.XJdbc;

public class CTHoaDonDAO implements ShopLaptop365DAO<CTHoaDon, Integer>{
	String SelectCTHoaDon_SQL = "SELECT CTHoaDon.ID, dbo.HoaDon.ID AS [ID_HoaDon], dbo.HoaDon.MaHD, dbo.CTHoaDon.ID_Serial, dbo.Serial.SerialNumber, dbo.Laptop.TenLaptop, dbo.BienThe.Gia FROM dbo.CTHoaDon JOIN dbo.HoaDon ON HoaDon.ID = CTHoaDon.MaHD JOIN dbo.Serial ON Serial.ID = CTHoaDon.ID_Serial JOIN dbo.BienThe ON BienThe.ID = Serial.ID_BienThe JOIN dbo.Laptop ON Laptop.ID = BienThe.ID_Laptop WHERE HoaDon.MaHD = ?";
	String SelectCTHoaDon = "SELECT CTHoaDon.ID, dbo.HoaDon.ID AS [ID_HoaDon], dbo.HoaDon.MaHD, dbo.CTHoaDon.ID_Serial, dbo.Serial.SerialNumber, dbo.Laptop.TenLaptop, dbo.BienThe.Gia FROM dbo.CTHoaDon JOIN dbo.HoaDon ON HoaDon.ID = CTHoaDon.MaHD JOIN dbo.Serial ON Serial.ID = CTHoaDon.ID_Serial JOIN dbo.BienThe ON BienThe.ID = Serial.ID_BienThe JOIN dbo.Laptop ON Laptop.ID = BienThe.ID_Laptop WHERE CTHoaDon.ID = ?";
	
	String insert = "INSERT INTO CTHoaDon(MaHD, ID_Serial) \r\n"
			+ "VALUES (?, ?)";
	
	String SelectBySDTSerial_SQL = "SELECT dbo.CTHoaDon.ID,dbo.CTHoaDon.MaHD AS 'ID_HoaDon',dbo.CTHoaDon.ID_Serial, dbo.HoaDon.MaHD , dbo.Laptop.TenLaptop, dbo.Serial.SerialNumber, dbo.BienThe.Gia\r\n"
			+ "		FROM dbo.HoaDon JOIN dbo.CTHoaDon ON CTHoaDon.MaHD = HoaDon.ID\r\n"
			+ "		JOIN dbo.Serial ON Serial.ID = CTHoaDon.ID_Serial\r\n"
			+ "		JOIN dbo.BienThe ON BienThe.ID = Serial.ID_BienThe\r\n"
			+ "		JOIN dbo.Laptop ON Laptop.ID = BienThe.ID_Laptop\r\n"
			+ "		JOIN dbo.KhachHang ON KhachHang.MaKH = HoaDon.MaKH\r\n"
			+ "		WHERE SerialNumber = ? AND SoDienThoai = ?;";
	
	@Override
	public String insert(CTHoaDon entity) {
		try {
			XJdbc.update(insert, entity.getId_HoaDon(), entity.getId_Serial());
			return "";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public String update(CTHoaDon entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTHoaDon selectById(Integer id) {
		List<CTHoaDon> list = this.selectBySQL(SelectCTHoaDon, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<CTHoaDon> selectAll() {
		
		return null;
	}
	
	public CTHoaDon selectBySerialSDT(String Serial, String SDT) {
		List<CTHoaDon> list = this.selectBySQL(SelectBySDTSerial_SQL, Serial,SDT);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public List<CTHoaDon> selectHoaDonByMaHoaDon(String MaHD) {
		return this.selectBySQL(SelectCTHoaDon_SQL,MaHD);
	}

	@Override
	public List<CTHoaDon> selectBySQL(String sql, Object... args) {
		List<CTHoaDon> list = new ArrayList<CTHoaDon>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while(rs.next()) {
				CTHoaDon ctHoaDon = new CTHoaDon();
				ctHoaDon.setId(rs.getInt("ID"));
				ctHoaDon.setId_HoaDon(rs.getInt("ID_HoaDon"));
				ctHoaDon.setMaHD(rs.getString("MaHD"));
				ctHoaDon.setId_Serial(rs.getInt("ID_Serial"));
				ctHoaDon.setSerialNumber(rs.getString("SerialNumber"));
				ctHoaDon.setTenLaptop(rs.getString("TenLaptop"));
				ctHoaDon.setGia(rs.getBigDecimal("Gia"));
				list.add(ctHoaDon);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
