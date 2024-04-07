package NhanVienTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.shoplaptop.dao.NhanVienService;
import com.shoplaptop.dao.TaiKhoanDAO;

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

	String[][] nhanVienExit = new String[][] { { "NV001", "hoten01", "0336389543", "2004-08-28", "true",
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
	String[][] addsucesss = new String[][] { { "NV021", "hoten01", "0336389543", "2004-08-28", "true",
			"khaildph34641@fpt.edu.vn", "abc.png", "Nam ĐỊnh", "true", "khai", "khai123" }, };
	String[][] updatesucesss = new String[][] { { "NV021", "hoten02", "0949432583", "2009-08-28", "true",
			"khaildph34641@fpt.edu.vn", "abc.png", "HN", "true", "khai", "123456789" },

	};
	String[] checknulldelete = new String[] { " ", null, "", "2009-08-28", "true", "khaildph34641@fpt.edu.vn", "abc.png",
			"HN", "true", "khai", "123456789" };
	String[] deletesuccess = new String[] { "NV020", "Lương Duy Khải", "0336389543", "2009-08-28", "true", "khaildph34641@fpt.edu.vn", "abc.png",
			"HN", "true", "khai", "123456789" };
	// Add

	@Test(expected = NullPointerException.class)
	public void Addnull() {
		for (int i = 0; i < nhanVienNullStrings.length; i++) {
			nhanVienService.insert(nhanVienService.getNhanVien(nhanVienNullStrings[i][0], nhanVienNullStrings[i][1],
					nhanVienNullStrings[i][2], nhanVienNullStrings[i][3], nhanVienNullStrings[i][4],
					nhanVienNullStrings[i][5], nhanVienNullStrings[i][6], nhanVienNullStrings[i][7],
					nhanVienNullStrings[i][8], nhanVienNullStrings[i][9], nhanVienNullStrings[i][10]));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddMaNVExits() {
		for (int i = 0; i < nhanVienExit.length; i++) {
			nhanVienService.insert(nhanVienService.getNhanVien(nhanVienExit[i][0], nhanVienExit[i][1],
					nhanVienExit[i][2], nhanVienExit[i][3], nhanVienExit[i][4], nhanVienExit[i][5], nhanVienExit[i][6],
					nhanVienExit[i][7], nhanVienExit[i][8], nhanVienExit[i][9], nhanVienExit[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddPhonenotmaches() {
		for (int i = 0; i < phoneNotmaches.length; i++) {
			nhanVienService.insert(
					nhanVienService.getNhanVien(phoneNotmaches[i][0], phoneNotmaches[i][1], phoneNotmaches[i][2],
							phoneNotmaches[i][3], phoneNotmaches[i][4], phoneNotmaches[i][5], phoneNotmaches[i][6],
							phoneNotmaches[i][7], phoneNotmaches[i][8], phoneNotmaches[i][9], phoneNotmaches[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddEmailnotmaches() {
		for (int i = 0; i < emailNotmaches.length; i++) {
			nhanVienService.insert(
					nhanVienService.getNhanVien(emailNotmaches[i][0], emailNotmaches[i][1], emailNotmaches[i][2],
							emailNotmaches[i][3], emailNotmaches[i][4], emailNotmaches[i][5], emailNotmaches[i][6],
							emailNotmaches[i][7], emailNotmaches[i][8], emailNotmaches[i][9], emailNotmaches[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddgioiTinhnotformat() {
		for (int i = 0; i < gioiTinhnotformat.length; i++) {
			nhanVienService.insert(nhanVienService.getNhanVien(gioiTinhnotformat[i][0], gioiTinhnotformat[i][1],
					gioiTinhnotformat[i][2], gioiTinhnotformat[i][3], gioiTinhnotformat[i][4], gioiTinhnotformat[i][5],
					gioiTinhnotformat[i][6], gioiTinhnotformat[i][7], gioiTinhnotformat[i][8], gioiTinhnotformat[i][9],
					gioiTinhnotformat[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void Addvaitronotformat() {
		for (int i = 0; i < vaiTroTinhnotformat.length; i++) {
			nhanVienService.insert(nhanVienService.getNhanVien(vaiTroTinhnotformat[i][0], vaiTroTinhnotformat[i][1],
					vaiTroTinhnotformat[i][2], vaiTroTinhnotformat[i][3], vaiTroTinhnotformat[i][4],
					vaiTroTinhnotformat[i][5], vaiTroTinhnotformat[i][6], vaiTroTinhnotformat[i][7],
					vaiTroTinhnotformat[i][8], vaiTroTinhnotformat[i][9], vaiTroTinhnotformat[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddngaySinhnotformat() {
		for (int i = 0; i < ngaysinhnotformat.length; i++) {
			nhanVienService.insert(nhanVienService.getNhanVien(ngaysinhnotformat[i][0], ngaysinhnotformat[i][1],
					ngaysinhnotformat[i][2], ngaysinhnotformat[i][3], ngaysinhnotformat[i][4], ngaysinhnotformat[i][5],
					ngaysinhnotformat[i][6], ngaysinhnotformat[i][7], ngaysinhnotformat[i][8], ngaysinhnotformat[i][9],
					ngaysinhnotformat[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddtenDangNhapExit() {
		for (int i = 0; i < tenDangNhapExit.length; i++) {
			nhanVienService.insert(nhanVienService.getNhanVien(tenDangNhapExit[i][0], tenDangNhapExit[i][1],
					tenDangNhapExit[i][2], tenDangNhapExit[i][3], tenDangNhapExit[i][4], tenDangNhapExit[i][5],
					tenDangNhapExit[i][6], tenDangNhapExit[i][7], tenDangNhapExit[i][8], tenDangNhapExit[i][9],
					tenDangNhapExit[i][10]));

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
			nhanVienService.update(nhanVienService.getNhanVien(nhanVienNullStrings[i][0], nhanVienNullStrings[i][1],
					nhanVienNullStrings[i][2], nhanVienNullStrings[i][3], nhanVienNullStrings[i][4],
					nhanVienNullStrings[i][5], nhanVienNullStrings[i][6], nhanVienNullStrings[i][7],
					nhanVienNullStrings[i][8], nhanVienNullStrings[i][9], nhanVienNullStrings[i][10]));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdateMaNVExits() {
		for (int i = 0; i < nhanVienExit.length; i++) {
			nhanVienService.update(nhanVienService.getNhanVien(nhanVienExit[i][0], nhanVienExit[i][1],
					nhanVienExit[i][2], nhanVienExit[i][3], nhanVienExit[i][4], nhanVienExit[i][5], nhanVienExit[i][6],
					nhanVienExit[i][7], nhanVienExit[i][8], nhanVienExit[i][9], nhanVienExit[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdatePhonenotmaches() {
		for (int i = 0; i < phoneNotmaches.length; i++) {
			nhanVienService.update(
					nhanVienService.getNhanVien(phoneNotmaches[i][0], phoneNotmaches[i][1], phoneNotmaches[i][2],
							phoneNotmaches[i][3], phoneNotmaches[i][4], phoneNotmaches[i][5], phoneNotmaches[i][6],
							phoneNotmaches[i][7], phoneNotmaches[i][8], phoneNotmaches[i][9], phoneNotmaches[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdateEmailnotmaches() {
		for (int i = 0; i < emailNotmaches.length; i++) {
			nhanVienService.update(
					nhanVienService.getNhanVien(emailNotmaches[i][0], emailNotmaches[i][1], emailNotmaches[i][2],
							emailNotmaches[i][3], emailNotmaches[i][4], emailNotmaches[i][5], emailNotmaches[i][6],
							emailNotmaches[i][7], emailNotmaches[i][8], emailNotmaches[i][9], emailNotmaches[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdategioiTinhnotformat() {
		for (int i = 0; i < gioiTinhnotformat.length; i++) {
			nhanVienService.update(nhanVienService.getNhanVien(gioiTinhnotformat[i][0], gioiTinhnotformat[i][1],
					gioiTinhnotformat[i][2], gioiTinhnotformat[i][3], gioiTinhnotformat[i][4], gioiTinhnotformat[i][5],
					gioiTinhnotformat[i][6], gioiTinhnotformat[i][7], gioiTinhnotformat[i][8], gioiTinhnotformat[i][9],
					gioiTinhnotformat[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void Updatevaitronotformat() {
		for (int i = 0; i < vaiTroTinhnotformat.length; i++) {
			nhanVienService.update(nhanVienService.getNhanVien(vaiTroTinhnotformat[i][0], vaiTroTinhnotformat[i][1],
					vaiTroTinhnotformat[i][2], vaiTroTinhnotformat[i][3], vaiTroTinhnotformat[i][4],
					vaiTroTinhnotformat[i][5], vaiTroTinhnotformat[i][6], vaiTroTinhnotformat[i][7],
					vaiTroTinhnotformat[i][8], vaiTroTinhnotformat[i][9], vaiTroTinhnotformat[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdatengaySinhnotformat() {
		for (int i = 0; i < ngaysinhnotformat.length; i++) {
			nhanVienService.update(nhanVienService.getNhanVien(ngaysinhnotformat[i][0], ngaysinhnotformat[i][1],
					ngaysinhnotformat[i][2], ngaysinhnotformat[i][3], ngaysinhnotformat[i][4], ngaysinhnotformat[i][5],
					ngaysinhnotformat[i][6], ngaysinhnotformat[i][7], ngaysinhnotformat[i][8], ngaysinhnotformat[i][9],
					ngaysinhnotformat[i][10]));

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void UpdatetenDangNhapExit() {
		for (int i = 0; i < tenDangNhapExit.length; i++) {
			nhanVienService.update(nhanVienService.getNhanVien(tenDangNhapExit[i][0], tenDangNhapExit[i][1],
					tenDangNhapExit[i][2], tenDangNhapExit[i][3], tenDangNhapExit[i][4], tenDangNhapExit[i][5],
					tenDangNhapExit[i][6], tenDangNhapExit[i][7], tenDangNhapExit[i][8], tenDangNhapExit[i][9],
					tenDangNhapExit[i][10]));

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
			nhanVienService.delete(checknulldelete[i]);
		}
	}

	@Test
	public void DeleteSuccess() {
		assertEquals("Xóa thành công",
				nhanVienService.delete(deletesuccess[0]));
	}

}
