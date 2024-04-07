package com.shoplaptop.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.poi.hpsf.Decimal;

public class PhieuDoi {
	private  int ID;
	private  String maPhieuDoi;
	private  String MaKH ;
	private  String TenKH;
	private  String MaNV ;
	private  String TenNV;
	private   Date NgayTao;
	private String SoDienThoai;
	private int ID_HinhThucVanChuyen;
	private String HinhThucVanChuyen;
	private int ID_HinhThucThanhToan;
	private String HinhThucThanhToan;
	private BigDecimal TongTien;
	
	public PhieuDoi() {
		// TODO Auto-generated constructor stub
	}
	

	public PhieuDoi(int iD, String maPhieuDoi, String maKH, String tenKH, String maNV, String tenNV, Date ngayTao,
			String soDienThoai, int iD_HinhThucVanChuyen, String hinhThucVanChuyen, int iD_HinhThucThanhToan,
			String hinhThucThanhToan, BigDecimal tongTien) {
		
		ID = iD;
		this.maPhieuDoi = maPhieuDoi;
		MaKH = maKH;
		TenKH = tenKH;
		MaNV = maNV;
		TenNV = tenNV;
		NgayTao = ngayTao;
		SoDienThoai = soDienThoai;
		ID_HinhThucVanChuyen = iD_HinhThucVanChuyen;
		HinhThucVanChuyen = hinhThucVanChuyen;
		ID_HinhThucThanhToan = iD_HinhThucThanhToan;
		HinhThucThanhToan = hinhThucThanhToan;
		TongTien = tongTien;
	}
 


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getMaPhieuDoi() {
		return maPhieuDoi;
	}


	public void setMaPhieuDoi(String maPhieuDoi) {
		this.maPhieuDoi = maPhieuDoi;
	}


	public String getMaKH() {
		return MaKH;
	}


	public void setMaKH(String maKH) {
		MaKH = maKH;
	}


	public String getTenKH() {
		return TenKH;
	}


	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}


	public String getMaNV() {
		return MaNV;
	}


	public void setMaNV(String maNV) {
		MaNV = maNV;
	}


	public String getTenNV() {
		return TenNV;
	}


	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}


	public Date getNgayTao() {
		return NgayTao;
	}


	public void setNgayTao(Date ngayTao) {
		NgayTao = ngayTao;
	}


	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	
	

	public int getID_HinhThucVanChuyen() {
		return ID_HinhThucVanChuyen;
	}

	public void setID_HinhThucVanChuyen(int iD_HinhThucVanChuyen) {
		ID_HinhThucVanChuyen = iD_HinhThucVanChuyen;
	}

	public String getHinhThucVanChuyen() {
		return HinhThucVanChuyen;
	}


	public void setHinhThucVanChuyen(String hinhThucVanChuyen) {
		HinhThucVanChuyen = hinhThucVanChuyen;
	}

	public int getID_HinhThucThanhToan() {
		return ID_HinhThucThanhToan;
	}

	public void setID_HinhThucThanhToan(int iD_HinhThucThanhToan) {
		ID_HinhThucThanhToan = iD_HinhThucThanhToan;
	}

	public String getHinhThucThanhToan() {
		return HinhThucThanhToan;
	}

	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		HinhThucThanhToan = hinhThucThanhToan;
	}
	

	public BigDecimal getTongTien() {
		return TongTien;
	}



	public void setTongTien(BigDecimal tongTien) {
		TongTien = tongTien;
	}



	@Override
	public String toString() {
		return "PhieuDoi [ID=" + ID + ", maPhieuDoi=" + maPhieuDoi + ", MaKH=" + MaKH + ", TenKH=" + TenKH + ", MaNV="
				+ MaNV + ", TenNV=" + TenNV + ", NgayTao=" + NgayTao + ", SoDienThoai=" + SoDienThoai
				+ ", ID_HinhThucVanChuyen=" + ID_HinhThucVanChuyen + ", HinhThucVanChuyen=" + HinhThucVanChuyen
				+ ", ID_HinhThucThanhToan=" + ID_HinhThucThanhToan + ", HinhThucThanhToan=" + HinhThucThanhToan
				+ ", TongTien=" + TongTien + "]";
	}
	



	
}
