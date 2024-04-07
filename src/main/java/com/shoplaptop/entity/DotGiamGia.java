package com.shoplaptop.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DotGiamGia {
	private String maDotGiam;
	private String tenDotGiamGia;
	private Date han;
	private BigDecimal giaGiam;
	private BigDecimal dieuKien;
	private String moTa; 

	public DotGiamGia() {
		
	}

	public DotGiamGia(String maDotGiam, String tenDotGiamGia, Date han, BigDecimal giaGiam, BigDecimal dieuKien,
			String moTa) {
		this.maDotGiam = maDotGiam;
		this.tenDotGiamGia = tenDotGiamGia;
		this.han = han;
		this.giaGiam = giaGiam;
		this.dieuKien = dieuKien;
		this.moTa = moTa;
	}

	public String getMaDotGiam() {
		return maDotGiam;
	}

	public void setMaDotGiam(String maDotGiam) {
		this.maDotGiam = maDotGiam;
	}

	public String getTenDotGiamGia() {
		return tenDotGiamGia;
	}

	public void setTenDotGiamGia(String tenDotGiamGia) {
		this.tenDotGiamGia = tenDotGiamGia;
	}

	public Date getHan() {
		return han;
	}

	public void setHan(Date han) {
		this.han = han;
	}

	public BigDecimal getGiaGiam() {
		return giaGiam;
	}

	public void setGiaGiam(BigDecimal giaGiam) {
		this.giaGiam = giaGiam;
	}

	public BigDecimal getDieuKien() {
		return dieuKien;
	}

	public void setDieuKien(BigDecimal dieuKien) {
		this.dieuKien = dieuKien;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "DotGiamGia [maDotGiam=" + maDotGiam + ", tenDotGiamGia=" + tenDotGiamGia + ", han=" + han + ", giaGiam="
				+ giaGiam + ", dieuKien=" + dieuKien + ", moTa=" + moTa + "]";
	}
	
	
	
}