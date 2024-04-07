package com.shoplaptop.entity;

import java.util.Date;

public class PhieuDoi {
	private  int ID;
	private  String maPhieuDoi;
	private  String MaKH ;
	private  String TenKH;
	private  String MaNV ;
	private  String TenNV;
	private   Date NgayTao;
	private String SoDienThoai;
	
	
	public PhieuDoi() {
		// TODO Auto-generated constructor stub
	}

	public PhieuDoi(int iD, String maPhieuDoi, String maKH, String tenKH, String maNV, String tenNV, Date ngayTao,
			String soDienThoai) {
		
		ID = iD;
		this.maPhieuDoi = maPhieuDoi;
		MaKH = maKH;
		TenKH = tenKH;
		MaNV = maNV;
		TenNV = tenNV;
		NgayTao = ngayTao;
		SoDienThoai = soDienThoai;
	}

	public PhieuDoi(int iD, String maPhieuDoi, String maKH, String tenKH, String maNV, String tenNV, Date ngayTao) {
		ID = iD;
		this.maPhieuDoi = maPhieuDoi;
		MaKH = maKH;
		TenKH = tenKH;
		MaNV = maNV;
		TenNV = tenNV;
		NgayTao = ngayTao;
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

	@Override
	public String toString() {
		return "PhieuDoi [ID=" + ID + ", maPhieuDoi=" + maPhieuDoi + ", MaKH=" + MaKH + ", TenKH=" + TenKH + ", MaNV="
				+ MaNV + ", TenNV=" + TenNV + ", NgayTao=" + NgayTao + ", SoDienThoai=" + SoDienThoai + "]";
	}

	
	
}
