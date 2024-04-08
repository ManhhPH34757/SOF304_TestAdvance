package NhanVienTest;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.junit.Test;

import com.shoplaptop.dao.NhanVienService;
import com.shoplaptop.dao.TaiKhoanDAO;

@org.testng.annotations.Test
public class TestNhanVienService {

	NhanVienService nhanVienService = new NhanVienService();
	TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

	String[][] nhanVienNullStrings = new String[][] {
			{ null, "hoten01", "0336389543", "2004-08-28", "true", "khaildph34641@fpt.edu.vn", "khai.png", "Nam ĐỊnh",
					"true", "giang", "giang123" },
			{ "NV11", null, "0336389543", "2004-08-28", "true", "khaildph34641@fpt.edu.vn", "khai.png", "Nam ĐỊnh",
					"true", "giang", "giang123" },
			{ "NV11", "hoten01", null, "2004-08-28", "true", "khaildph34641@fpt.edu.vn", "khai.png", "Nam ĐỊnh", "true",
					"giang", "giang123" },
			{ "NV11", "hoten01", "0336389543", " ", "true", "khaildph34641@fpt.edu.vn", "khai.png", "Nam ĐỊnh", "true",
					"giang", "giang123" },
			{ "NV11", "hoten01", "0336389543", "2004-08-28", " ", "khaildph34641@fpt.edu.vn", "khai.png", "Nam ĐỊnh",
					"true", "giang", "giang123" },
			{ "NV11", "hoten01", "0336389543", "2004-08-28", "true", null, "khai.png", "Nam ĐỊnh", "true", "giang",
					"giang123" },
			{ "NV11", "hoten01", "0336389543", "2004-08-28", "true", "khaildph34641@fpt.edu.vn", null, "Nam ĐỊnh",
					"true", "giang", "giang123" },
			{ "NV11", "hoten01", "0336389543", "2004-08-28", "true", "khaildph34641@fpt.edu.vn", "khai.png", null,
					"true", "giang", "giang123" },
			{ "NV11", "hoten01", "0336389543", "2004-08-28", "true", "khaildph34641@fpt.edu.vn", "khai.png", "Nam ĐỊnh",
					null, "giang", "giang123" },
			{ "NV11", "hoten01", "0336389543", "2004-08-28", "true", "khaildph34641@fpt.edu.vn", "khai.png", "Nam ĐỊnh",
					"true", null, "giang123" },
			{ "NV11", "hoten01", "0336389543", "2004-08-28", "true", "khaildph34641@fpt.edu.vn", "khai.png", "Nam ĐỊnh",
					"true", "giang", null }, };

	String[][] nhanVienExit = new String[][] { { "NV013", "hoten01", "0336389543", "2004-08-28", "true",
			"khaildph34641@fpt.edu.vn", "khai.png", "Nam ĐỊnh", "true", "giang", "giang123" },

	};

	String[][] phoneNotmaches = new String[][] { { "NV021", "hoten01", "03363", "2004-08-28", "true",
			"khaildph34641@fpt.edu.vn", "khai.png", "Nam ĐỊnh", "true", "giang", "giang123" }, };

	String[][] emailNotmaches = new String[][] { { "NV022", "hoten01", "0336389543", "2004-08-28", "true",
			"khaildph34641fpt.edu.vn", "khai.png", "Nam ĐỊnh", "true", "giang", "giang123" }, };
	String[][] gioiTinhnotformat = new String[][] { { "NV023", "hoten01", "0336389543", "2004-08-28", "abc",
			"khaildph34641fpt.edu.vn", "khai.png", "Nam ĐỊnh", "true", "giang", "giang123" }, };

	String[][] vaiTroTinhnotformat = new String[][] { { "NV023", "hoten01", "0336389543", "2004-08-28", "true",
			"khaildph34641fpt.edu.vn", "khai.png", "Nam ĐỊnh", "abc", "giang", "giang123" }, };

	String[][] ngaysinhnotformat = new String[][] { { "NV024", "hoten01", "0336389543", "28-08-2004", "true",
			"khaildph34641fpt.edu.vn", "khai.png", "Nam ĐỊnh", "true", "giang", "giang123" }, };
	String[][] tenDangNhapExit = new String[][] { { "NV025", "hoten01", "0336389543", "28-08-2004", "true",
			"khaildph34641fpt.edu.vn", "khai.png", "Nam ĐỊnh", "true", "giang", "giang123" }, };
	String[][] addsucesss = new String[][] { { "NV030", "hoten01", "0336389543", "2004-08-28", "true",
			"khaildph34641@fpt.edu.vn", "abc.png", "Nam ĐỊnh", "true", "khai", "khai123" }, };
	String[][] updatesucesss = new String[][] { { "NV030", "hoten02", "0949432583", "2009-08-28", "true",
			"khaildph34641@fpt.edu.vn", "abc.png", "HN", "true", "khai", "123456789" },

	};
	String[] checknulldelete = new String[] {  null };
	String[] deletesuccess = new String[] { "NV005", "Lương Duy Khải", "0336389543", "2009-08-28", "true",
			"khaildph34641@fpt.edu.vn", "abc.png", "HN", "true", "khai", "123456789" };
	// Add

	@Test(expected = NullPointerException.class)
	public void Addnull() {
		for (int i = 0; i < nhanVienNullStrings.length; i++) {
			final int currentIndex = i;
			assertThrows(NullPointerException.class, () -> {
				nhanVienService.insert(nhanVienService.getNhanVien(nhanVienNullStrings[currentIndex][0],
						nhanVienNullStrings[currentIndex][1], nhanVienNullStrings[currentIndex][2],
						nhanVienNullStrings[currentIndex][3], nhanVienNullStrings[currentIndex][4],
						nhanVienNullStrings[currentIndex][5], nhanVienNullStrings[currentIndex][6],
						nhanVienNullStrings[currentIndex][7], nhanVienNullStrings[currentIndex][8],
						nhanVienNullStrings[currentIndex][9], nhanVienNullStrings[currentIndex][10]));
			});

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddMaNVExits() {
		for (int i = 0; i < nhanVienExit.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				nhanVienService.insert(nhanVienService.getNhanVien(nhanVienExit[currentIndex][0],
						nhanVienExit[currentIndex][1], nhanVienExit[currentIndex][2], nhanVienExit[currentIndex][3],
						nhanVienExit[currentIndex][4], nhanVienExit[currentIndex][5], nhanVienExit[currentIndex][6],
						nhanVienExit[currentIndex][7], nhanVienExit[currentIndex][8], nhanVienExit[currentIndex][9],
						nhanVienExit[currentIndex][10]

				));
			});

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddPhonenotmaches() {

		for (int i = 0; i < phoneNotmaches.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				nhanVienService.insert(nhanVienService.getNhanVien(phoneNotmaches[currentIndex][0],
						phoneNotmaches[currentIndex][1], phoneNotmaches[currentIndex][2],
						phoneNotmaches[currentIndex][3], phoneNotmaches[currentIndex][4],
						phoneNotmaches[currentIndex][5], phoneNotmaches[currentIndex][6],
						phoneNotmaches[currentIndex][7], phoneNotmaches[currentIndex][8],
						phoneNotmaches[currentIndex][9], phoneNotmaches[currentIndex][10]));
			});

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddEmailnotmaches() {
		for (int i = 0; i < emailNotmaches.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				nhanVienService.insert(nhanVienService.getNhanVien(emailNotmaches[currentIndex][0],
						emailNotmaches[currentIndex][1], emailNotmaches[currentIndex][2],
						emailNotmaches[currentIndex][3], emailNotmaches[currentIndex][4],
						emailNotmaches[currentIndex][5], emailNotmaches[currentIndex][6],
						emailNotmaches[currentIndex][7], emailNotmaches[currentIndex][8],
						emailNotmaches[currentIndex][9], emailNotmaches[currentIndex][10]

				));
			});

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddgioiTinhnotformat() {
		for (int i = 0; i < gioiTinhnotformat.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, ()->{
				nhanVienService.insert(nhanVienService.getNhanVien(gioiTinhnotformat[currentIndex][0],
						gioiTinhnotformat[currentIndex][1], gioiTinhnotformat[currentIndex][2],
						gioiTinhnotformat[currentIndex][3], gioiTinhnotformat[currentIndex][4],
						gioiTinhnotformat[currentIndex][5], gioiTinhnotformat[currentIndex][6],
						gioiTinhnotformat[currentIndex][7], gioiTinhnotformat[currentIndex][8],
						gioiTinhnotformat[currentIndex][9], gioiTinhnotformat[currentIndex][10]

				));
			});

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void Addvaitronotformat() {
		for (int i = 0; i < vaiTroTinhnotformat.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, ()->{
				nhanVienService.insert(nhanVienService.getNhanVien(vaiTroTinhnotformat[currentIndex][0],
						vaiTroTinhnotformat[currentIndex][1], vaiTroTinhnotformat[currentIndex][2],
						vaiTroTinhnotformat[currentIndex][3], vaiTroTinhnotformat[currentIndex][4],
						vaiTroTinhnotformat[currentIndex][5], vaiTroTinhnotformat[currentIndex][6],
						vaiTroTinhnotformat[currentIndex][7], vaiTroTinhnotformat[currentIndex][8],
						vaiTroTinhnotformat[currentIndex][9], vaiTroTinhnotformat[currentIndex][10]

				));
			});

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddngaySinhnotformat() {
		for (int i = 0; i < ngaysinhnotformat.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, ()->{
				nhanVienService.insert(nhanVienService.getNhanVien(ngaysinhnotformat[currentIndex][0],
						ngaysinhnotformat[currentIndex][1], ngaysinhnotformat[currentIndex][2],
						ngaysinhnotformat[currentIndex][3], ngaysinhnotformat[currentIndex][4],
						ngaysinhnotformat[currentIndex][5], ngaysinhnotformat[currentIndex][6],
						ngaysinhnotformat[currentIndex][7], ngaysinhnotformat[currentIndex][8],
						ngaysinhnotformat[currentIndex][9], ngaysinhnotformat[currentIndex][10]

				));
			});

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddtenDangNhapExit() {
		for (int i = 0; i < tenDangNhapExit.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, ()->{
				nhanVienService.insert(nhanVienService.getNhanVien(tenDangNhapExit[currentIndex][0],
						tenDangNhapExit[currentIndex][1], tenDangNhapExit[currentIndex][2],
						tenDangNhapExit[currentIndex][3], tenDangNhapExit[currentIndex][4],
						tenDangNhapExit[currentIndex][5], tenDangNhapExit[currentIndex][6],
						tenDangNhapExit[currentIndex][7], tenDangNhapExit[currentIndex][8],
						tenDangNhapExit[currentIndex][9], tenDangNhapExit[currentIndex][10]

				));
			});
			
		}
	}

	@Test
	public void AddSuccess() {
		assertEquals("Add thành công",
				nhanVienService.insert(nhanVienService.getNhanVien(addsucesss[0][0], addsucesss[0][1], addsucesss[0][2],
						addsucesss[0][3], addsucesss[0][4], addsucesss[0][5], addsucesss[0][6], addsucesss[0][7],
						addsucesss[0][8], addsucesss[0][9], addsucesss[0][10])));
	}

	// Update
	@Test(expected = NullPointerException.class)
	public void Updatenull() {
		for (int i = 0; i < nhanVienNullStrings.length; i++) {
			final int currentIndex = i;
			assertThrows(NullPointerException.class, ()->{
				nhanVienService.update(nhanVienService.getNhanVien(nhanVienNullStrings[currentIndex][0],
						nhanVienNullStrings[currentIndex][1], nhanVienNullStrings[currentIndex][2],
						nhanVienNullStrings[currentIndex][3], nhanVienNullStrings[currentIndex][4],
						nhanVienNullStrings[currentIndex][5], nhanVienNullStrings[currentIndex][6],
						nhanVienNullStrings[currentIndex][7], nhanVienNullStrings[currentIndex][8],
						nhanVienNullStrings[currentIndex][9], nhanVienNullStrings[currentIndex][10]

				));
			});
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdateMaNVExits() {
		for (int i = 0; i < nhanVienExit.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				nhanVienService.update(nhanVienService.getNhanVien(nhanVienExit[currentIndex][0],
						nhanVienExit[currentIndex][1], nhanVienExit[currentIndex][2], nhanVienExit[currentIndex][3],
						nhanVienExit[currentIndex][4], nhanVienExit[currentIndex][5], nhanVienExit[currentIndex][6],
						nhanVienExit[currentIndex][7], nhanVienExit[currentIndex][8], nhanVienExit[currentIndex][9],
						nhanVienExit[currentIndex][10]

				));
			});

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdatePhonenotmaches() {
		for (int i = 0; i < phoneNotmaches.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				nhanVienService.update(nhanVienService.getNhanVien(phoneNotmaches[currentIndex][0],
						phoneNotmaches[currentIndex][1], phoneNotmaches[currentIndex][2],
						phoneNotmaches[currentIndex][3], phoneNotmaches[currentIndex][4],
						phoneNotmaches[currentIndex][5], phoneNotmaches[currentIndex][6],
						phoneNotmaches[currentIndex][7], phoneNotmaches[currentIndex][8],
						phoneNotmaches[currentIndex][9], phoneNotmaches[currentIndex][10]));
			});


		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdateEmailnotmaches() {
		for (int i = 0; i < emailNotmaches.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, () -> {
				nhanVienService.update(nhanVienService.getNhanVien(emailNotmaches[currentIndex][0],
						emailNotmaches[currentIndex][1], emailNotmaches[currentIndex][2],
						emailNotmaches[currentIndex][3], emailNotmaches[currentIndex][4],
						emailNotmaches[currentIndex][5], emailNotmaches[currentIndex][6],
						emailNotmaches[currentIndex][7], emailNotmaches[currentIndex][8],
						emailNotmaches[currentIndex][9], emailNotmaches[currentIndex][10]

				));
			});


		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdategioiTinhnotformat() {
		for (int i = 0; i < gioiTinhnotformat.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, ()->{
				nhanVienService.update(nhanVienService.getNhanVien(gioiTinhnotformat[currentIndex][0],
						gioiTinhnotformat[currentIndex][1], gioiTinhnotformat[currentIndex][2],
						gioiTinhnotformat[currentIndex][3], gioiTinhnotformat[currentIndex][4],
						gioiTinhnotformat[currentIndex][5], gioiTinhnotformat[currentIndex][6],
						gioiTinhnotformat[currentIndex][7], gioiTinhnotformat[currentIndex][8],
						gioiTinhnotformat[currentIndex][9], gioiTinhnotformat[currentIndex][10]

				));
			});

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void Updatevaitronotformat() {
		for (int i = 0; i < vaiTroTinhnotformat.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, ()->{
				nhanVienService.update(nhanVienService.getNhanVien(vaiTroTinhnotformat[currentIndex][0],
						vaiTroTinhnotformat[currentIndex][1], vaiTroTinhnotformat[currentIndex][2],
						vaiTroTinhnotformat[currentIndex][3], vaiTroTinhnotformat[currentIndex][4],
						vaiTroTinhnotformat[currentIndex][5], vaiTroTinhnotformat[currentIndex][6],
						vaiTroTinhnotformat[currentIndex][7], vaiTroTinhnotformat[currentIndex][8],
						vaiTroTinhnotformat[currentIndex][9], vaiTroTinhnotformat[currentIndex][10]

				));
			});
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdatengaySinhnotformat() {
		for (int i = 0; i < ngaysinhnotformat.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, ()->{
				nhanVienService.update(nhanVienService.getNhanVien(ngaysinhnotformat[currentIndex][0],
						ngaysinhnotformat[currentIndex][1], ngaysinhnotformat[currentIndex][2],
						ngaysinhnotformat[currentIndex][3], ngaysinhnotformat[currentIndex][4],
						ngaysinhnotformat[currentIndex][5], ngaysinhnotformat[currentIndex][6],
						ngaysinhnotformat[currentIndex][7], ngaysinhnotformat[currentIndex][8],
						ngaysinhnotformat[currentIndex][9], ngaysinhnotformat[currentIndex][10]

				));
			});


		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdatetenDangNhapExit() {
		for (int i = 0; i < tenDangNhapExit.length; i++) {
			final int currentIndex = i;
			assertThrows(IllegalArgumentException.class, ()->{
				nhanVienService.update(nhanVienService.getNhanVien(tenDangNhapExit[currentIndex][0],
						tenDangNhapExit[currentIndex][1], tenDangNhapExit[currentIndex][2],
						tenDangNhapExit[currentIndex][3], tenDangNhapExit[currentIndex][4],
						tenDangNhapExit[currentIndex][5], tenDangNhapExit[currentIndex][6],
						tenDangNhapExit[currentIndex][7], tenDangNhapExit[currentIndex][8],
						tenDangNhapExit[currentIndex][9], tenDangNhapExit[currentIndex][10]

				));
			});

		}
	}

	@Test
	public void UpdateSuccess() {
		assertEquals("Update thành công",
				nhanVienService.update(
						nhanVienService.getNhanVien(updatesucesss[0][0], updatesucesss[0][1], updatesucesss[0][2],
								updatesucesss[0][3], updatesucesss[0][4], updatesucesss[0][5], updatesucesss[0][6],
								updatesucesss[0][7], updatesucesss[0][8], updatesucesss[0][9], updatesucesss[0][10])));
	}

	// delete

	@Test(expected = NullPointerException.class)
	public void Deletenull() {
		for (int i = 0; i < checknulldelete.length; i++) {
			final int currentIndex = i;
			assertThrows(NullPointerException.class, ()->{
				nhanVienService.delete(checknulldelete[currentIndex]);
			});
			
		}
	}

	@Test
	public void DeleteSuccess() {
		assertEquals("Xóa thành công", nhanVienService.delete(deletesuccess[0]));
	}

}
