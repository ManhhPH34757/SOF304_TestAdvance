package DotGiamGia;

import java.util.Iterator;

import org.apache.batik.css.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import com.shoplaptop.dao.DotGiamGiaDAO;

public class TestDotGiamGia {
	DotGiamGiaDAO dotGiamGiaDAO = new DotGiamGiaDAO();
	
	String[][] dggNull = new String[][] {
		{null,"Mung ngay mung 8/3","2024-05-10 00:00:00","400000","2000000","Khong co gi"},
		{"DGG005",null,"2024-05-10 00:00:00","400000","2000000","Khong co gi"},
		{"DGG005","Mung ngay mung 8/3",null,"400000","2000000","Khong co gi"},
		{"DGG005","Mung ngay mung 8/3","2024-05-10 00:00:00",null,"2000000","Khong co gi"},
		{"DGG005","Mung ngay mung 8/3","2024-05-10 00:00:00","400000",null,"Khong co gi"},
		{" ","Mung ngay mung 8/3","2024-05-10 00:00:00","400000","2000000","Khong co gi"},
		{"DGG005"," ","2024-05-10 00:00:00","400000","2000000","Khong co gi"},
		{"DGG005","Mung ngay mung 8/3"," ","400000","2000000","Khong co gi"},
		{"DGG005","Mung ngay mung 8/3","2024-05-10 00:00:00"," ","2000000","Khong co gi"},
		{"DGG005","Mung ngay mung 8/3","2024-05-10 00:00:00","400000"," ","Khong co gi"},
		
	};
	//String[][] addSuccess = new String[][]{ {"DGG011","Mung ngay mung 8/3","2024-05-10 00:00:00","400000","2000000","Khong co gi"}};
	String[][] dggNgayKiTu = new String[][] {
		{"DGG005","Mung ngay mung 8/3","acb","400000","2000000","Khong co gi"},
	
	};
	String[] dggDeleteNull = new String[] {" ","",null,"400000","2000000","Khong co gi"};
	//String[] dggDeleteSuccess = new String[] {"DGG011"};

	String[][] dggGiaGiamDKKiTu = new String[][] {
		{"DGG005","Mung ngay mung 8/3","2024-05-10 00:00:00","hshhs","2000000","Khong co gi"},
		{"DGG005","Mung ngay mung 8/3","2024-05-10 00:00:00","400000","shshhs","Khong co gi"},
		
	};
	
	
	String[][] dggMaTrung = new String[][] {
		{"DGG001","Mung ngay mung 8/3","2024-05-10 00:00:00","400000","2000000","Khong co gi"},
	};
	String[][] dggHanNHoHonNgayHienTai = new String[][] {
		{"DGG005","Mung ngay mung 8/3","2024-04-06 00:00:00","400000","2000000","Khong co gi"},
		{"DGG006","Mung ngay mung 8/3","2101-01-01 00:00:00","400000","2000000","Khong co gi"},
	};
	String[][] dggHanLonHonNam2100 = new String[][] {
		{"DGG006","Mung ngay mung 8/3","2101-01-01 00:00:00","400000","2000000","Khong co gi"},
	};
	String[][] dggGiaGiamLaAm = new String[][] {
		{"DGG006","Mung ngay mung 8/3","2024-05-10 00:00:00","-1","2000000","Khong co gi"},
	};
	String[][] dggDKLaAm = new String[][] {
		{"DGG006","Mung ngay mung 8/3","2024-05-10 00:00:00","400000","-1","Khong co gi"},
	};
	String[][] dggGiaGiamLonHonDK = new String[][] {
		{"DGG006","Mung ngay mung 8/3","2024-05-10 00:00:00","2100000","2000000","Khong co gi"},
	};
	
//	@Test
//	public void test_add_success() {
//		for(int i = 0; i< addSuccess.length; i++) {
//			Assert.assertEquals("Lưu Thành Công", dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(addSuccess[i][0], addSuccess[i][1], addSuccess[i][2], addSuccess[i][3], addSuccess[i][4], addSuccess[i][5])));
//		}
//	}
	
	@Test(expected = NullPointerException.class)
	public void test_add_nullBlank() {
		for(int i = 0; i< dggNull.length; i++) {
			dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggNull[i][0], dggNull[i][1], dggNull[i][2], dggNull[i][3], dggNull[i][4], dggNull[i][5]));
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_add_MaDGGTrung() {
		for(int i =0; i<dggMaTrung.length;i++) {
			dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggMaTrung[i][0], dggMaTrung[i][1], dggMaTrung[i][2], dggMaTrung[i][3], dggMaTrung[i][4], dggMaTrung[i][5]));
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_add_HanNhoHonNgayHTai() {
		for(int i = 0; i<dggHanNHoHonNgayHienTai.length;i++) {
			dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggHanNHoHonNgayHienTai[i][0], dggHanNHoHonNgayHienTai[i][1], dggHanNHoHonNgayHienTai[i][2], dggHanNHoHonNgayHienTai[i][3], dggHanNHoHonNgayHienTai[i][4], dggHanNHoHonNgayHienTai[i][5]));
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_add_HanLonHonNam2100() {
		for(int i = 0; i<dggHanLonHonNam2100.length;i++) {
			dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggHanLonHonNam2100[i][0], dggHanLonHonNam2100[i][1], dggHanLonHonNam2100[i][2], dggHanLonHonNam2100[i][3], dggHanLonHonNam2100[i][4], dggHanLonHonNam2100[i][5]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_add_GiaGiamLaAm() {
		for(int i = 0; i<dggGiaGiamLaAm.length;i++) {
			dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamLaAm[i][0], dggGiaGiamLaAm[i][1], dggGiaGiamLaAm[i][2], dggGiaGiamLaAm[i][3], dggGiaGiamLaAm[i][4], dggGiaGiamLaAm[i][5]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_add_DieuKienLaAm() {
		for(int i = 0; i<dggDKLaAm.length;i++) {
			dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggDKLaAm[i][0], dggDKLaAm[i][1], dggDKLaAm[i][2], dggDKLaAm[i][3], dggDKLaAm[i][4], dggDKLaAm[i][5]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_add_GiaGiamLonHonDieuKien() {
		for(int i = 0; i < dggGiaGiamLonHonDK.length;i++) {
			dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamLonHonDK[i][0], dggGiaGiamLonHonDK[i][1], dggGiaGiamLonHonDK[i][2], dggGiaGiamLonHonDK[i][3], dggGiaGiamLonHonDK[i][4], dggGiaGiamLonHonDK[i][5]));
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void test_add_NgayChuaKiTu() {
		for(int i = 0; i < dggNgayKiTu.length;i++) {
			dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggNgayKiTu[i][0], dggNgayKiTu[i][1], dggNgayKiTu[i][2], dggNgayKiTu[i][3], dggNgayKiTu[i][4], dggNgayKiTu[i][5]));
		}
	}
	@Test(expected = NumberFormatException.class)
	public void test_add_GiaGiamDKChuaKiTu() {
		for(int i = 0 ; i < dggGiaGiamDKKiTu.length; i ++) {
			dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamDKKiTu[i][0], dggGiaGiamDKKiTu[i][1], dggGiaGiamDKKiTu[i][2], dggGiaGiamDKKiTu[i][3], dggGiaGiamDKKiTu[i][4], dggGiaGiamDKKiTu[i][5]));
		}
	}
	
	//UPdate
	
	@Test(expected = NullPointerException.class)
	public void test_update_nullBlank() {
		for(int i = 0; i< dggNull.length; i++) {
			dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggNull[i][0], dggNull[i][1], dggNull[i][2], dggNull[i][3], dggNull[i][4], dggNull[i][5]));
		}
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void test_update_HanNhoHonNgayHTai() {
		for(int i = 0; i<dggHanNHoHonNgayHienTai.length;i++) {
			dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggHanNHoHonNgayHienTai[i][0], dggHanNHoHonNgayHienTai[i][1], dggHanNHoHonNgayHienTai[i][2], dggHanNHoHonNgayHienTai[i][3], dggHanNHoHonNgayHienTai[i][4], dggHanNHoHonNgayHienTai[i][5]));
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_update_HanLonHonNam2100() {
		for(int i = 0; i<dggHanLonHonNam2100.length;i++) {
			dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggHanLonHonNam2100[i][0], dggHanLonHonNam2100[i][1], dggHanLonHonNam2100[i][2], dggHanLonHonNam2100[i][3], dggHanLonHonNam2100[i][4], dggHanLonHonNam2100[i][5]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_update_GiaGiamLaAm() {
		for(int i = 0; i<dggGiaGiamLaAm.length;i++) {
			dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamLaAm[i][0], dggGiaGiamLaAm[i][1], dggGiaGiamLaAm[i][2], dggGiaGiamLaAm[i][3], dggGiaGiamLaAm[i][4], dggGiaGiamLaAm[i][5]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_update_DieuKienLaAm() {
		for(int i = 0; i<dggDKLaAm.length;i++) {
			dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggDKLaAm[i][0], dggDKLaAm[i][1], dggDKLaAm[i][2], dggDKLaAm[i][3], dggDKLaAm[i][4], dggDKLaAm[i][5]));
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_update_GiaGiamLonHonDieuKien() {
		for(int i = 0; i < dggGiaGiamLonHonDK.length;i++) {
			dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamLonHonDK[i][0], dggGiaGiamLonHonDK[i][1], dggGiaGiamLonHonDK[i][2], dggGiaGiamLonHonDK[i][3], dggGiaGiamLonHonDK[i][4], dggGiaGiamLonHonDK[i][5]));
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void test_update_NgayChuaKiTu() {
		for(int i = 0; i < dggNgayKiTu.length;i++) {
			dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggNgayKiTu[i][0], dggNgayKiTu[i][1], dggNgayKiTu[i][2], dggNgayKiTu[i][3], dggNgayKiTu[i][4], dggNgayKiTu[i][5]));
		}
	}
	
	@Test(expected = NumberFormatException.class)
	public void test_update_GiaGiamDKChuaKiTu() {
		for(int i = 0 ; i < dggGiaGiamDKKiTu.length; i ++) {
			dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamDKKiTu[i][0], dggGiaGiamDKKiTu[i][1], dggGiaGiamDKKiTu[i][2], dggGiaGiamDKKiTu[i][3], dggGiaGiamDKKiTu[i][4], dggGiaGiamDKKiTu[i][5]));
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void test_delete_null() {
		for(int i = 0; i< dggDeleteNull.length; i++) {
			dotGiamGiaDAO.delete(dggDeleteNull[i]);
		}
	}
//	@Test
//	public void test_delete_success() {
//		Assert.assertEquals("Delete Thành Công",dotGiamGiaDAO.delete(dggDeleteSuccess[0]));
//	}
	
	
	
	
	
}
