package TestKhachHang;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.shoplaptop.dao.KhachHangDAO;
import com.shoplaptop.entity.KhachHang;

public class test {
	KhachHangDAO khachHangDAO = new KhachHangDAO();
	public List<KhachHang> list = new ArrayList<>();

	
	String[][] khachHangNull = new String[][] {
		{null,"Trần Thị Mỹ Duyên","0979093601","2004-02-11","true","duyen@gmail.com","Phu Tho"},
		{"KH001",null,"0979093601","2004-02-11","true","duyen@gmail.com","Phu Tho"},
		{"KH001","Trần Thị Mỹ Duyên",null,"2004-02-11","true","duyen@gmail.com","Phu Tho"},
		{"KH001","Trần Thị Mỹ Duyên","0979093601",null,"true","duyen@gmail.com","Phu Tho"},
		{"KH001","Trần Thị Mỹ Duyên","0979093601","2004-02-11",null,"duyen@gmail.com","Phu Tho"},
		{"KH001","Trần Thị Mỹ Duyên","0979093601","2004-02-11","true",null,"Phu Tho"},
		{"KH001","Trần Thị Mỹ Duyên","0979093601","2004-02-11","true","duyen@gmail.com",null},
		
	};
	String[][] khachHangSpace = new String[][] {
		{" ","Trần Thị Mỹ Duyên","0979093601","2004-02-11","true","duyen@gmail.com","Phu Tho"},
		{"KH001"," ","0979093601","2004-02-11","true","duyen@gmail.com","Phu Tho"},
		{"KH001","Trần Thị Mỹ Duyên"," ","2004-02-11","true","duyen@gmail.com","Phu Tho"},
		{"KH001","Trần Thị Mỹ Duyên","0979093601"," ","true","duyen@gmail.com","Phu Tho"},
		{"KH001","Trần Thị Mỹ Duyên","0979093601","2004-02-11"," ","duyen@gmail.com","Phu Tho"},
		{"KH001","Trần Thị Mỹ Duyên","0979093601","2004-02-11","true"," ","Phu Tho"},
		{"KH001","Trần Thị Mỹ Duyên","0979093601","2004-02-11","true","duyen@gmail.com"," "},
		
	};
	String[][] khachHangDaTonTai = new String[][] {
		{"KH001","Trần Thị Mỹ Duyên","0979093601","2004-02-11","true","duyen@gmail.com","Phu Tho"},
	};
	String[][] khachHangGioiTinh = new String[][] {
		{"KH001","Trần Thị Mỹ Duyên","0979093601","2004-02-11","truee","duyen@gmail.com","Phu Tho"},
	};
	String[][] khachHangSDTKHL = new String[][] {
		{"KH001","Trần Thị Mỹ Duyên","09790936011","2004-02-11","true","duyen@gmail.com","Phu Tho"},
	};
	String[][] khachHangValid = new String[][] {
		{"KH002","Trần Thị Mỹ Duyên","0979093601","2004-02-11","true","duyen@gmail.com","Phu Tho"},
	};
	String[][] khachHangUpdateValid = new String[][] {
		{"KH002","Trần Thị Mỹ Duyênnnnn","0979093601","2004-02-11","true","duyen@gmail.com","Phu Tho"},
	};
	String[][] khachHangUpdateGioiTinh = new String[][] {
		{"KH002","Trần Thị Mỹ Duyênnnnn","0979093601","2004-02-11","truee","duyen@gmail.com","Phu Tho"},
	};
	String[][] khachHangUpdateSDT = new String[][] {
		{"KH002","Trần Thị Mỹ Duyênnnnn","09790936","2004-02-11","truee","duyen@gmail.com","Phu Tho"},
	};
	String[] deleteNull = new String[] 
			{" ",null, ""};
	String[] deleteSuccess = new String[]
			{"KH003"};

	//addddddddddddd
	@Test(expected = IllegalArgumentException.class)
	public void addNull() {
		for (int i = 0; i < khachHangNull.length; i++) {
			khachHangDAO.insert(khachHangDAO.getKhachHang(khachHangNull[i][0], khachHangNull[i][1], khachHangNull[i][2], khachHangNull[i][3], khachHangNull[i][4], khachHangNull[i][5], khachHangNull[i][6]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void addSpace() {
		for (int i = 0; i < khachHangSpace.length; i++) {
			khachHangDAO.insert(khachHangDAO.getKhachHang(khachHangSpace[i][0], khachHangSpace[i][1], khachHangSpace[i][2], khachHangSpace[i][3], khachHangSpace[i][4], khachHangSpace[i][5], khachHangSpace[i][6]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void addKHDaTonTai() {
		for (int i = 0; i < khachHangDaTonTai.length; i++) {
			khachHangDAO.insert(khachHangDAO.getKhachHang(khachHangDaTonTai[i][0], khachHangDaTonTai[i][1], khachHangDaTonTai[i][2], khachHangDaTonTai[i][3], khachHangDaTonTai[i][4], khachHangDaTonTai[i][5], khachHangDaTonTai[i][6]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void addGioiTinh() {
		for (int i = 0; i < khachHangGioiTinh.length; i++) {
			khachHangDAO.insert(khachHangDAO.getKhachHang(khachHangGioiTinh[i][0], khachHangGioiTinh[i][1], khachHangGioiTinh[i][2], khachHangGioiTinh[i][3], khachHangGioiTinh[i][4], khachHangGioiTinh[i][5], khachHangGioiTinh[i][6]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void addSoDienThoai() {
		for (int i = 0; i < khachHangSDTKHL.length; i++) {
			khachHangDAO.insert(khachHangDAO.getKhachHang(khachHangSDTKHL[i][0], khachHangSDTKHL[i][1], khachHangSDTKHL[i][2], khachHangSDTKHL[i][3], khachHangSDTKHL[i][4], khachHangSDTKHL[i][5], khachHangSDTKHL[i][6]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void addValid() {
		for (int i = 0; i < khachHangValid.length; i++) {
			khachHangDAO.insert(khachHangDAO.getKhachHang(khachHangValid[i][0], khachHangValid[i][1], khachHangValid[i][2], khachHangValid[i][3], khachHangValid[i][4], khachHangValid[i][5], khachHangValid[i][6]));
		}
	}
	//updateeeeeeeeee
	@Test(expected = IllegalArgumentException.class)
	public void updateNull() {
		for (int i = 0; i < khachHangNull.length; i++) {
			khachHangDAO.update(khachHangDAO.getKhachHang(khachHangNull[i][0], khachHangNull[i][1], khachHangNull[i][2], khachHangNull[i][3], khachHangNull[i][4], khachHangNull[i][5], khachHangNull[i][6]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void updateSpace() {
		for (int i = 0; i < khachHangSpace.length; i++) {
			khachHangDAO.update(khachHangDAO.getKhachHang(khachHangSpace[i][0], khachHangSpace[i][1], khachHangSpace[i][2], khachHangSpace[i][3], khachHangSpace[i][4], khachHangSpace[i][5], khachHangSpace[i][6]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void updateValid() {
		for (int i = 0; i < khachHangValid.length; i++) {
			khachHangDAO.update(khachHangDAO.getKhachHang(khachHangUpdateValid[i][0], khachHangUpdateValid[i][1], khachHangUpdateValid[i][2], khachHangUpdateValid[i][3], khachHangUpdateValid[i][4], khachHangUpdateValid[i][5], khachHangUpdateValid[i][6]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void updateInValidGioiTinh() {
		for (int i = 0; i < khachHangUpdateGioiTinh.length; i++) {
			khachHangDAO.update(khachHangDAO.getKhachHang(khachHangUpdateGioiTinh[i][0], khachHangUpdateGioiTinh[i][1], khachHangUpdateGioiTinh[i][2], khachHangUpdateGioiTinh[i][3], khachHangUpdateGioiTinh[i][4], khachHangUpdateGioiTinh[i][5], khachHangUpdateGioiTinh[i][6]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void updateInValidSDT() {
		for (int i = 0; i < khachHangUpdateSDT.length; i++) {
			khachHangDAO.update(khachHangDAO.getKhachHang(khachHangUpdateSDT[i][0], khachHangUpdateSDT[i][1], khachHangUpdateSDT[i][2], khachHangUpdateSDT[i][3], khachHangUpdateSDT[i][4], khachHangUpdateSDT[i][5], khachHangUpdateSDT[i][6]));
		}
	}
	//deleteeeeeeeeeeeee
	@Test(expected = NullPointerException.class)
	public void deleteNull() {
		for (int i = 0; i < deleteNull.length; i++) {
			khachHangDAO.delete(deleteNull[i]);
		}
	}
	@Test
	public void deleteValid() {
		assertEquals("Xóa khách hàng thành công", khachHangDAO.delete(deleteSuccess[0]));
	
	}

}
