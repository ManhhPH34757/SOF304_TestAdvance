package com.shoplaptop.entity;

import java.util.Objects;

public class HinhThucThanhToan {
	int id;
	String hinhThuc;

	public HinhThucThanhToan() {

	}

	public HinhThucThanhToan(int id, String hinhThuc) {

		this.id = id;
		this.hinhThuc = hinhThuc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHinhthuc() {
		return hinhThuc;
	}

	public void setHinhthuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(hinhThuc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HinhThucThanhToan other = (HinhThucThanhToan) obj;
		return Objects.equals(hinhThuc, other.hinhThuc);
	}

	@Override
	public String toString() {
		return hinhThuc;
	}

}