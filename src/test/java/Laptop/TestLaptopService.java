package Laptop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.shoplaptop.dao.LaptopDAO;

public class TestLaptopService {
	
	LaptopDAO laptopDAO = new LaptopDAO();
	
	String[][] laptopsNull = new String[][] {
		{null, "Laptop01","1","1","2020"},
		{"LT01", null,"1","1","2020"},
		{"LT01", "Laptop02",null,"1","2020"},
		{"LT01", "Laptop02","1",null,"2020"},
		{"LT01", "Laptop02","1","1",null},
		{" ", "Laptop01","1","1","2020"},
		{"LT01", " ","1","1","2020"},
		{"LT01", "Laptop02"," ","1","2020"},
		{"LT01", "Laptop02","1"," ","2020"},
		{"LT01", "Laptop02","1","1"," "}
	};
	
	String[][] laptopsNumberFormat = new String[][] {
		{"LT01", "Laptop01","1abc","1","2020"},
		{"LT01", "laptop01","1","1abc","2020"},
		{"LT01", "Laptop02","1","1","2020abc"}
	};
	
	String[][] laptopsInValid = new String[][] {
		{"ML01", "Laptop01","1abc","1","2020"},
		{"LT01", "laptop01@123","1","1abc","2020"},
		{"LT01", "Laptop02","1","1","1944"},
		{"LT01", "Laptop02","1","1","2025"},
		{"LT01", "Laptop02","100","1","2020"},
		{"LT01", "Laptop02","1","100","2020"}
	};
	
	String[][] laptopsValid = new String[][] {
		{"LT102", "Laptop Lenovo Ideapad 5","1","1","2020"}
	};
	
	String[] maLaptopNull = new String[] {
			null, "", " "
	};
	
	/* -------------- Add LapTop ---------------- */
	
	@Test(expected = NullPointerException.class)
	public void testAddNull() {
		for (int i = 0; i < laptopsNull.length; i++) {
			laptopDAO.insert(laptopDAO.getLaptop(laptopsNull[i][0], laptopsNull[i][1], laptopsNull[i][2], laptopsNull[i][3], laptopsNull[i][4]));
		}
	}
	
	@Test(expected = NumberFormatException.class)
	public void testAddNumberFormat() {
		for (int i = 0; i < laptopsNumberFormat.length; i++) {
			laptopDAO.insert(laptopDAO.getLaptop(laptopsNumberFormat[i][0], laptopsNumberFormat[i][1], laptopsNumberFormat[i][2], laptopsNumberFormat[i][3], laptopsNumberFormat[i][4]));
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddInValid() {
		for (int i = 0; i < laptopsInValid.length; i++) {
			laptopDAO.insert(laptopDAO.getLaptop(laptopsInValid[i][0], laptopsInValid[i][1], laptopsInValid[i][2], laptopsInValid[i][3], laptopsInValid[i][4]));
		}
	}
	
	@Test
	public void testAddSuccess() {
		assertEquals("Add thành công", laptopDAO.insert(laptopDAO.getLaptop(laptopsValid[0][0], laptopsValid[0][1], laptopsValid[0][2], laptopsValid[0][3], laptopsValid[0][4])));
	}
	
	/* -------------- Update LapTop ---------------- */
	
	@Test(expected = NullPointerException.class)
	public void testUpdateNull() {
		for (int i = 0; i < laptopsNull.length; i++) {
			laptopDAO.update(laptopDAO.getLaptop(laptopsNull[i][0], laptopsNull[i][1], laptopsNull[i][2], laptopsNull[i][3], laptopsNull[i][4]));
		}
	}
	
	@Test(expected = NumberFormatException.class)
	public void testUpdateNumberFormat() {
		for (int i = 0; i < laptopsNumberFormat.length; i++) {
			laptopDAO.update(laptopDAO.getLaptop(laptopsNumberFormat[i][0], laptopsNumberFormat[i][1], laptopsNumberFormat[i][2], laptopsNumberFormat[i][3], laptopsNumberFormat[i][4]));
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUpdateInValid() {
		for (int i = 0; i < laptopsInValid.length; i++) {
			laptopDAO.update(laptopDAO.getLaptop(laptopsInValid[i][0], laptopsInValid[i][1], laptopsInValid[i][2], laptopsInValid[i][3], laptopsInValid[i][4]));
		}
	}
	
	@Test
	public void testUpdateSuccess() {
		assertEquals("Update thành công", laptopDAO.update(laptopDAO.getLaptop(laptopsValid[0][0], laptopsValid[0][1], laptopsValid[0][2], laptopsValid[0][3], laptopsValid[0][4])));
	}
	
	/* -------------- Delete LapTop ---------------- */
	
	@Test(expected = NullPointerException.class)
	public void testDeleteNull() {
		for (int i = 0; i < maLaptopNull.length; i++) {
			laptopDAO.delete(laptopDAO.maLaptop(maLaptopNull[i]));
		}
	}
	
	@Test
	public void testDeleteSuccess() {
		assertEquals("Xóa thành công", laptopDAO.delete("LT102"));
	}

}
