package DotGiamGia;

import static org.testng.Assert.assertThrows;

import java.util.Iterator;

import org.apache.batik.css.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import com.shoplaptop.dao.DotGiamGiaDAO;

@org.testng.annotations.Test
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
	//String[][] addSuccess = new String[][]{ {"DGG012","Mung ngay mung 8/3","2024-05-10 00:00:00","400000","2000000","Khong co gi"}};
	String[][] dggNgayKiTu = new String[][] {
		{"DGG005","Mung ngay mung 8/3","acb","400000","2000000","Khong co gi"},
	
	};
	String[] dggDeleteNull = new String[] {null, "", " "};
	//String[] dggDeleteSuccess = new String[] {"DGG012"};

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
	
	@Test
	public void test_add_nullBlank() {
		for(int i = 0; i< dggNull.length; i++) {
			final int currenIndex = i;
			assertThrows(NullPointerException.class, () -> {
				dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggNull[currenIndex][0], dggNull[currenIndex][1], dggNull[currenIndex][2], dggNull[currenIndex][3], dggNull[currenIndex][4], dggNull[currenIndex][5]
						));
			});
		}
	}
	
	@Test
	public void test_add_MaDGGTrung() {
		for(int i =0; i<dggMaTrung.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggMaTrung[currenIndex][0], dggMaTrung[currenIndex][1], dggMaTrung[currenIndex][2], dggMaTrung[currenIndex][3], dggMaTrung[currenIndex][4], dggMaTrung[currenIndex][5]));

			});
		}
	}
	
	@Test
	public void test_add_HanNhoHonNgayHTai() {
		for(int i = 0; i<dggHanNHoHonNgayHienTai.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggHanNHoHonNgayHienTai[currenIndex][0], dggHanNHoHonNgayHienTai[currenIndex][1], dggHanNHoHonNgayHienTai[currenIndex][2], dggHanNHoHonNgayHienTai[currenIndex][3], dggHanNHoHonNgayHienTai[currenIndex][4], dggHanNHoHonNgayHienTai[currenIndex][5]));

			});
		}
	}
	
	@Test
	public void test_add_HanLonHonNam2100() {
		for(int i = 0; i<dggHanLonHonNam2100.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggHanLonHonNam2100[currenIndex][0], dggHanLonHonNam2100[currenIndex][1], dggHanLonHonNam2100[currenIndex][2], dggHanLonHonNam2100[currenIndex][3], dggHanLonHonNam2100[currenIndex][4], dggHanLonHonNam2100[currenIndex][5]));
			});
		}
	}
	@Test
	public void test_add_GiaGiamLaAm() {
		for(int i = 0; i<dggGiaGiamLaAm.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamLaAm[currenIndex][0], dggGiaGiamLaAm[currenIndex][1], dggGiaGiamLaAm[currenIndex][2], dggGiaGiamLaAm[currenIndex][3], dggGiaGiamLaAm[currenIndex][4], dggGiaGiamLaAm[currenIndex][5]));

			});
		}
	}
	@Test
	public void test_add_DieuKienLaAm() {
		for(int i = 0; i<dggDKLaAm.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggDKLaAm[currenIndex][0], dggDKLaAm[currenIndex][1], dggDKLaAm[currenIndex][2], dggDKLaAm[currenIndex][3], dggDKLaAm[currenIndex][4], dggDKLaAm[currenIndex][5]));

			});
		}
	}
	@Test
	public void test_add_GiaGiamLonHonDieuKien() {
		for(int i = 0; i < dggGiaGiamLonHonDK.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamLonHonDK[currenIndex][0], dggGiaGiamLonHonDK[currenIndex][1], dggGiaGiamLonHonDK[currenIndex][2], dggGiaGiamLonHonDK[currenIndex][3], dggGiaGiamLonHonDK[currenIndex][4], dggGiaGiamLonHonDK[currenIndex][5]));

			});
		}
	}
	
	@Test
	public void test_add_NgayChuaKiTu() {
		for(int i = 0; i < dggNgayKiTu.length;i++) {
			final int currenIndex = i;
			assertThrows(RuntimeException.class, () -> {
				dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggNgayKiTu[currenIndex][0], dggNgayKiTu[currenIndex][1], dggNgayKiTu[currenIndex][2], dggNgayKiTu[currenIndex][3], dggNgayKiTu[currenIndex][4], dggNgayKiTu[currenIndex][5]));
			});
		}
	}
	@Test
	public void test_add_GiaGiamDKChuaKiTu() {
		for(int i = 0 ; i < dggGiaGiamDKKiTu.length; i ++) {
			final int currenIndex = i;
			assertThrows(NumberFormatException.class, () -> {
				dotGiamGiaDAO.insert(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamDKKiTu[currenIndex][0], dggGiaGiamDKKiTu[currenIndex][1], dggGiaGiamDKKiTu[currenIndex][2], dggGiaGiamDKKiTu[currenIndex][3], dggGiaGiamDKKiTu[currenIndex][4], dggGiaGiamDKKiTu[currenIndex][5]));

			});
		}
	}
	
	//UPdate
	
	@Test
	public void test_update_nullBlank() {
		for(int i = 0; i< dggNull.length; i++) {
			final int currenIndex = i;
			assertThrows(NullPointerException.class, () -> {
				dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggNull[currenIndex][0], dggNull[currenIndex][1], dggNull[currenIndex][2], dggNull[currenIndex][3], dggNull[currenIndex][4], dggNull[currenIndex][5]
						));
			});
		}
	}
	
	@Test
	public void test_update_MaDGGTrung() {
		for(int i =0; i<dggMaTrung.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggMaTrung[currenIndex][0], dggMaTrung[currenIndex][1], dggMaTrung[currenIndex][2], dggMaTrung[currenIndex][3], dggMaTrung[currenIndex][4], dggMaTrung[currenIndex][5]));

			});
		}
	}
	
	@Test
	public void test_update_HanNhoHonNgayHTai() {
		for(int i = 0; i<dggHanNHoHonNgayHienTai.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggHanNHoHonNgayHienTai[currenIndex][0], dggHanNHoHonNgayHienTai[currenIndex][1], dggHanNHoHonNgayHienTai[currenIndex][2], dggHanNHoHonNgayHienTai[currenIndex][3], dggHanNHoHonNgayHienTai[currenIndex][4], dggHanNHoHonNgayHienTai[currenIndex][5]));

			});
		}
	}
	
	@Test
	public void test_update_HanLonHonNam2100() {
		for(int i = 0; i<dggHanLonHonNam2100.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggHanLonHonNam2100[currenIndex][0], dggHanLonHonNam2100[currenIndex][1], dggHanLonHonNam2100[currenIndex][2], dggHanLonHonNam2100[currenIndex][3], dggHanLonHonNam2100[currenIndex][4], dggHanLonHonNam2100[currenIndex][5]));
			});
		}
	}
	@Test
	public void test_update_GiaGiamLaAm() {
		for(int i = 0; i<dggGiaGiamLaAm.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamLaAm[currenIndex][0], dggGiaGiamLaAm[currenIndex][1], dggGiaGiamLaAm[currenIndex][2], dggGiaGiamLaAm[currenIndex][3], dggGiaGiamLaAm[currenIndex][4], dggGiaGiamLaAm[currenIndex][5]));

			});
		}
	}
	@Test
	public void test_update_DieuKienLaAm() {
		for(int i = 0; i<dggDKLaAm.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggDKLaAm[currenIndex][0], dggDKLaAm[currenIndex][1], dggDKLaAm[currenIndex][2], dggDKLaAm[currenIndex][3], dggDKLaAm[currenIndex][4], dggDKLaAm[currenIndex][5]));

			});
		}
	}
	@Test
	public void test_update_GiaGiamLonHonDieuKien() {
		for(int i = 0; i < dggGiaGiamLonHonDK.length;i++) {
			final int currenIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamLonHonDK[currenIndex][0], dggGiaGiamLonHonDK[currenIndex][1], dggGiaGiamLonHonDK[currenIndex][2], dggGiaGiamLonHonDK[currenIndex][3], dggGiaGiamLonHonDK[currenIndex][4], dggGiaGiamLonHonDK[currenIndex][5]));

			});
		}
	}
	
	@Test
	public void test_update_NgayChuaKiTu() {
		for(int i = 0; i < dggNgayKiTu.length;i++) {
			final int currenIndex = i;
			assertThrows(RuntimeException.class, () -> {
				dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggNgayKiTu[currenIndex][0], dggNgayKiTu[currenIndex][1], dggNgayKiTu[currenIndex][2], dggNgayKiTu[currenIndex][3], dggNgayKiTu[currenIndex][4], dggNgayKiTu[currenIndex][5]));
			});
		}
	}
	@Test
	public void test_update_GiaGiamDKChuaKiTu() {
		for(int i = 0 ; i < dggGiaGiamDKKiTu.length; i ++) {
			final int currenIndex = i;
			assertThrows(NumberFormatException.class, () -> {
				dotGiamGiaDAO.update(dotGiamGiaDAO.getDotGiamGia(dggGiaGiamDKKiTu[currenIndex][0], dggGiaGiamDKKiTu[currenIndex][1], dggGiaGiamDKKiTu[currenIndex][2], dggGiaGiamDKKiTu[currenIndex][3], dggGiaGiamDKKiTu[currenIndex][4], dggGiaGiamDKKiTu[currenIndex][5]));

			});
		}
	}
	
	@Test
	public void test_delete_null() {
		for(int i = 0; i< dggDeleteNull.length; i++) {
			final int currenIndex = i;
			assertThrows(NullPointerException.class, () -> {
				dotGiamGiaDAO.delete(dggDeleteNull[currenIndex]);
			});
			
		}
	}
//	@Test
//	public void test_delete_success() {
//		Assert.assertEquals("Delete Thành Công",dotGiamGiaDAO.delete(dggDeleteSuccess[0]));
//	}
	
	
	
	
	
}
