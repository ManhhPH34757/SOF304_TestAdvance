package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.HoaDon;
import com.shoplaptop.utils.XJdbc;

public class HoaDonDAO implements ShopLaptop365DAO<HoaDon, String> {
	String SelectAll_SQL = "SELECT HoaDon.ID, dbo.HoaDon.MaHD, HoaDon.MaKH,dbo.HinhThucVanChuyen.ID AS 'ID_HinhThucVanChuyen', dbo.HinhThucVanChuyen.HinhThuc AS 'HinhThucVanChuyen',dbo.HinhThucThanhToan.ID AS 'ID_HinhThucThanhToan',\r\n"
			+ "	dbo.HinhThucThanhToan.HinhThuc AS 'HinhThucThanhToan',\r\n"
			+ "	dbo.PhieuGiamGia.ID AS 'ID_PhieuGiamGia', PhieuGiamGia.MaPG, dbo.HoaDon.DotGiamGia,\r\n"
			+ "	HoaDon.MaNV,\r\n"
			+ "	dbo.HoaDon.NgayTao, dbo.HoaDon.TongTien, dbo.HoaDon.TienGiam, dbo.HoaDon.ThanhTien\r\n"
			+ "FROM dbo.HoaDon JOIN  dbo.KhachHang ON KhachHang.MaKH = HoaDon.MaKH\r\n"
			+ "			JOIN dbo.HinhThucVanChuyen ON HinhThucVanChuyen.ID = HoaDon.HinhThucVanChuyen\r\n"
			+ "			JOIN dbo.HinhThucThanhToan ON HinhThucThanhToan.ID = HoaDon.HinhThucThanhToan\r\n"
			+ "			LEFT JOIN dbo.PhieuGiamGia ON PhieuGiamGia.ID = HoaDon.PhieuGiamGia\r\n"
			+ "			LEFT JOIN dbo.DotGiamGia ON DotGiamGia.MaDG = dbo.HoaDon.DotGiamGia\r\n"
			+ "			JOIN dbo.NhanVien ON NhanVien.MaNV = HoaDon.MaNV";

	String selectHoaDonByMaHoaDon = "SELECT HoaDon.ID, dbo.HoaDon.MaHD, HoaDon.MaKH,dbo.HinhThucVanChuyen.ID AS 'ID_HinhThucVanChuyen', dbo.HinhThucVanChuyen.HinhThuc AS 'HinhThucVanChuyen',dbo.HinhThucThanhToan.ID AS 'ID_HinhThucThanhToan',\r\n"
			+ "	dbo.HinhThucThanhToan.HinhThuc AS 'HinhThucThanhToan',\r\n"
			+ "	dbo.PhieuGiamGia.ID AS 'ID_PhieuGiamGia', PhieuGiamGia.MaPG, dbo.HoaDon.DotGiamGia,\r\n"
			+ "	HoaDon.MaNV,\r\n"
			+ "	dbo.HoaDon.NgayTao, dbo.HoaDon.TongTien, dbo.HoaDon.TienGiam, dbo.HoaDon.ThanhTien\r\n"
			+ "FROM dbo.HoaDon JOIN  dbo.KhachHang ON KhachHang.MaKH = HoaDon.MaKH\r\n"
			+ "			JOIN dbo.HinhThucVanChuyen ON HinhThucVanChuyen.ID = HoaDon.HinhThucVanChuyen\r\n"
			+ "			JOIN dbo.HinhThucThanhToan ON HinhThucThanhToan.ID = HoaDon.HinhThucThanhToan\r\n"
			+ "			LEFT JOIN dbo.PhieuGiamGia ON PhieuGiamGia.ID = HoaDon.PhieuGiamGia\r\n"
			+ "			LEFT JOIN dbo.DotGiamGia ON DotGiamGia.MaDG = dbo.HoaDon.DotGiamGia\r\n"
			+ "			JOIN dbo.NhanVien ON NhanVien.MaNV = HoaDon.MaNV " + "WHERE dbo.HoaDon.MaHD = ?";

	String insert = "INSERT INTO HoaDon(MaHD, MaKH, HinhThucVanChuyen, HinhThucThanhToan, PhieuGiamGia, DotGiamGia, MaNV, NgayTao, TongTien, TienGiam, ThanhTien) \r\n"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	String select_Han_LT = "SELECT IIF(DATEDIFF(DAY,dbo.HoaDon.NgayTao,GETDATE()) <= 15,N'Còn Hạn',N'Hết Hạn')  AS 'Hạn'\r\n"
			+ "	FROM dbo.HoaDon JOIN dbo.CTHoaDon ON CTHoaDon.MaHD = HoaDon.ID\r\n"
			+ "	JOIN dbo.Serial ON Serial.ID = CTHoaDon.ID_Serial\r\n"
			+ "	JOIN dbo.BienThe ON BienThe.ID = Serial.ID_BienThe\r\n"
			+ "	JOIN dbo.Laptop ON Laptop.ID = BienThe.ID_Laptop\r\n"
			+ "	JOIN dbo.KhachHang ON KhachHang.MaKH = HoaDon.MaKH\r\n"
			+ "	WHERE SerialNumber = ? AND SoDienThoai = ?;";
	
	String selectMaKH = "SELECT HoaDon.ID, dbo.HoaDon.MaHD, HoaDon.MaKH,dbo.HinhThucVanChuyen.ID AS 'ID_HinhThucVanChuyen', dbo.HinhThucVanChuyen.HinhThuc AS 'HinhThucVanChuyen',dbo.HinhThucThanhToan.ID AS 'ID_HinhThucThanhToan',\r\n"
			+ "	dbo.HinhThucThanhToan.HinhThuc AS 'HinhThucThanhToan',\r\n"
			+ "	dbo.PhieuGiamGia.ID AS 'ID_PhieuGiamGia', PhieuGiamGia.MaPG, dbo.HoaDon.DotGiamGia,\r\n"
			+ "	HoaDon.MaNV,\r\n"
			+ "	dbo.HoaDon.NgayTao, dbo.HoaDon.TongTien, dbo.HoaDon.TienGiam, dbo.HoaDon.ThanhTien\r\n"
			+ "FROM dbo.HoaDon JOIN  dbo.KhachHang ON KhachHang.MaKH = HoaDon.MaKH\r\n"
			+ "			JOIN dbo.HinhThucVanChuyen ON HinhThucVanChuyen.ID = HoaDon.HinhThucVanChuyen\r\n"
			+ "			JOIN dbo.HinhThucThanhToan ON HinhThucThanhToan.ID = HoaDon.HinhThucThanhToan\r\n"
			+ "			LEFT JOIN dbo.PhieuGiamGia ON PhieuGiamGia.ID = HoaDon.PhieuGiamGia\r\n"
			+ "			LEFT JOIN dbo.DotGiamGia ON DotGiamGia.MaDG = dbo.HoaDon.DotGiamGia\r\n"
			+ "			JOIN dbo.NhanVien ON NhanVien.MaNV = HoaDon.MaNV "
			+ "WHERE dbo.HoaDon.MaKH = ?";

	private String han;

	@Override
	public String insert(HoaDon entity) {
		try {
			XJdbc.update(insert, entity.getMaHD(), entity.getMaKH(), entity.getId_HinhThucVanChuyen(),
					entity.getId_HinhThucThanhToan(), entity.getId_PhieuGiamGia(), entity.getDotGiamGia(),
					entity.getMaNV(), entity.getNgayTao(), entity.getTongTien(), entity.getTienGiam(),
					entity.getThanhTien());
			return "";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String update(HoaDon entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HoaDon> selectByMaKH(String maKH) {

		return this.selectBySQL(selectMaKH, maKH);

	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoaDon selectById(String id) {
		List<HoaDon> list = this.selectBySQL(selectHoaDonByMaHoaDon, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public String Han(String serial, String sdt) {
		try {
			ResultSet rs = XJdbc.query(select_Han_LT, serial, sdt);
			while (rs.next()) {
				han = rs.getString("Hạn");
			}
			return han;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<HoaDon> selectAll() {

		return this.selectBySQL(SelectAll_SQL);
	}

	@Override
	public List<HoaDon> selectBySQL(String sql, Object... args) {
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setId(rs.getInt("ID"));
				hoaDon.setMaHD(rs.getString("MaHD"));
				hoaDon.setMaKH(rs.getString("MaKH"));
				hoaDon.setId_HinhThucVanChuyen(rs.getInt("ID_HinhThucVanChuyen"));
				hoaDon.setHinhThucVanChuyen(rs.getString("HinhThucVanChuyen"));
				hoaDon.setId_HinhThucThanhToan(rs.getInt("ID_HinhThucThanhToan"));
				hoaDon.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
				hoaDon.setId_PhieuGiamGia(rs.getInt("ID_PhieuGiamGia"));
				hoaDon.setPhieuGiamGia(rs.getString("MaPG"));
				hoaDon.setDotGiamGia(rs.getString("DotGiamGia"));
				hoaDon.setMaNV(rs.getString("MaNV"));
				hoaDon.setNgayTao(rs.getDate("NgayTao"));
				hoaDon.setTongTien(rs.getBigDecimal("TongTien"));
				hoaDon.setTienGiam(rs.getBigDecimal("TienGiam"));
				hoaDon.setThanhTien(rs.getBigDecimal("ThanhTien"));
				list.add(hoaDon);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
