package TestKhachHang;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.shoplaptop.dao.KhachHangDAO;
import com.shoplaptop.entity.KhachHang;
@org.testng.annotations.Test
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
		{"KH102","Trần Thị Mỹ Duyên","0979093601","2004-02-11","true","duyen@gmail.com","Phu Tho"},
	};
	String[][] khachHangGioiTinh = new String[][] {
		{"KH001","Trần Thị Mỹ Duyên","0979093601","2004-02-11","truee","duyen@gmail.com","Phu Tho"},
	};
	String[][] khachHangSDTKHL = new String[][] {
		{"KH001","Trần Thị Mỹ Duyên","09790936011","2004-02-11","true","duyen@gmail.com","Phu Tho"},
	};
	String[][] khachHangValid = new String[][] {
		{"KH105","Trần Thị Mỹ Duyên","0979093601","2004-02-11","true","duyen@gmail.com","Phu Tho"},
	};
	String[][] khachHangValidUpdate = new String[][] {
		{"KH104","Trần Thị Mỹ Duyên","0979093602","2004-02-11","true","duyen@gmail.com","Phu Tho"},
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
	@Test
	public void addNull() {
		for (int i = 0; i < khachHangNull.length; i++) {
			final int currentIndex = i;
			assertThrows(NullPointerException.class, () ->{
				khachHangDAO.insert(khachHangDAO.getKhachHang(
						khachHangNull[currentIndex][0],
						khachHangNull[currentIndex][1],
						khachHangNull[currentIndex][2],
						khachHangNull[currentIndex][3],
						khachHangNull[currentIndex][4],
						khachHangNull[currentIndex][5],
						khachHangNull[currentIndex][6]));
			});
		}
	}
	@Test
	public void addSpace() {
		for (int i = 0; i < khachHangSpace.length; i++) {
			final int currentIndex = i;
			assertThrows(NullPointerException.class, () -> {
				khachHangDAO.insert(khachHangDAO.getKhachHang(
						khachHangSpace[currentIndex][0],
						khachHangSpace[currentIndex][1],
						khachHangSpace[currentIndex][2],
						khachHangSpace[currentIndex][3],
						khachHangSpace[currentIndex][4],
						khachHangSpace[currentIndex][5],
						khachHangSpace[currentIndex][6]));
			});
		}
	}
	@Test
	public void addKHDaTonTai() {
		for (int i = 0; i < khachHangDaTonTai.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				khachHangDAO.insert(khachHangDAO.getKhachHang(khachHangDaTonTai[currentIndex][0],
						khachHangDaTonTai[currentIndex][1],
						khachHangDaTonTai[currentIndex][2],
						khachHangDaTonTai[currentIndex][3],
						khachHangDaTonTai[currentIndex][4],
						khachHangDaTonTai[currentIndex][5],
						khachHangDaTonTai[currentIndex][6]));
				
			});
		}
	}
	@Test
	public void addGioiTinh() {
		for (int i = 0; i < khachHangGioiTinh.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				khachHangDAO.insert(khachHangDAO.getKhachHang(khachHangGioiTinh[currentIndex][0],
						khachHangGioiTinh[currentIndex][1],
						khachHangGioiTinh[currentIndex][2],
						khachHangGioiTinh[currentIndex][3],
						khachHangGioiTinh[currentIndex][4],
						khachHangGioiTinh[currentIndex][5],
						khachHangGioiTinh[currentIndex][6]));
				
			});
		}
	}
	@Test
	public void addSoDienThoai() {
		for (int i = 0; i < khachHangSDTKHL.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				khachHangDAO.insert(khachHangDAO.getKhachHang(khachHangSDTKHL[currentIndex][0],
						khachHangSDTKHL[currentIndex][1],
						khachHangSDTKHL[currentIndex][2],
						khachHangSDTKHL[currentIndex][3],
						khachHangSDTKHL[currentIndex][4],
						khachHangSDTKHL[currentIndex][5],
						khachHangSDTKHL[currentIndex][6]));
				
			});
		}
	}
	@Test
	public void addValid() {
			assertEquals("Thêm khách hàng thành công", khachHangDAO.insert(khachHangDAO.getKhachHang(
					khachHangValid[0][0],
					khachHangValid[0][1],
					khachHangValid[0][2],
					khachHangValid[0][3],
					khachHangValid[0][4],
					khachHangValid[0][5],
					khachHangValid[0][6]
					)));

		}
	
	//updateeeeeeeeee
	@Test
	public void updateNull() {
		for (int i = 0; i < khachHangNull.length; i++) {
			final int currentIndex = i;
			assertThrows(NullPointerException.class, () ->{
				khachHangDAO.update(khachHangDAO.getKhachHangUpdate(khachHangSpace[currentIndex][0],
						khachHangSpace[currentIndex][1],
						khachHangSpace[currentIndex][2],
						khachHangSpace[currentIndex][3],
						khachHangSpace[currentIndex][4],
						khachHangSpace[currentIndex][5],
						khachHangSpace[currentIndex][6]));
			});
		}
	}
	@Test
	public void updateSpace() {
		for (int i = 0; i < khachHangSpace.length; i++) {
			final int currentIndex = i;
			assertThrows(NullPointerException.class, () ->{
				khachHangDAO.update(khachHangDAO.getKhachHangUpdate(khachHangSpace[currentIndex][0],
						khachHangSpace[currentIndex][1],
						khachHangSpace[currentIndex][2],
						khachHangSpace[currentIndex][3],
						khachHangSpace[currentIndex][4],
						khachHangSpace[currentIndex][5],
						khachHangSpace[currentIndex][6]));
			});
		}
	}
	@Test
	public void updateValid() {
		assertEquals("Sửa khách hàng thành công", khachHangDAO.update(khachHangDAO.getKhachHangUpdate(
				khachHangValid[0][0],
				khachHangValid[0][1],
				khachHangValid[0][2],
				khachHangValid[0][3],
				khachHangValid[0][4],
				khachHangValid[0][5],
				khachHangValid[0][6]
				)));
	}
	@Test
	public void updateInValidGioiTinh() {
		for (int i = 0; i < khachHangUpdateGioiTinh.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				khachHangDAO.insert(khachHangDAO.getKhachHangUpdate(khachHangUpdateGioiTinh[currentIndex][0],
						khachHangUpdateGioiTinh[currentIndex][1],
						khachHangUpdateGioiTinh[currentIndex][2],
						khachHangUpdateGioiTinh[currentIndex][3],
						khachHangUpdateGioiTinh[currentIndex][4],
						khachHangUpdateGioiTinh[currentIndex][5],
						khachHangUpdateGioiTinh[currentIndex][6]));
				
			});
		}
	}
	@Test
	public void updateInValidSDT() {
		for (int i = 0; i < khachHangUpdateSDT.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				khachHangDAO.insert(khachHangDAO.getKhachHangUpdate(khachHangUpdateSDT[currentIndex][0],
						khachHangUpdateSDT[currentIndex][1],
						khachHangUpdateSDT[currentIndex][2],
						khachHangUpdateSDT[currentIndex][3],
						khachHangUpdateSDT[currentIndex][4],
						khachHangUpdateSDT[currentIndex][5],
						khachHangUpdateSDT[currentIndex][6]));
				
			});
		}
	}
	//deleteeeeeeeeeeeee
	@Test
	public void deleteNull() {
		for (int i = 0; i < deleteNull.length; i++) {
			final int currentIndex = i;
			assertThrows(NullPointerException.class, () -> {
				khachHangDAO.delete(deleteNull[currentIndex]);
			});
		}
	}
	@Test
	public void deleteValid() {
		assertEquals("Xóa khách hàng thành công", khachHangDAO.delete("KH003"));
	
	}

}
