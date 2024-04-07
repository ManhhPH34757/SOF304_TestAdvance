package Laptop;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.junit.Test;

import com.shoplaptop.dao.LaptopDAO;

@org.testng.annotations.Test
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
	
	String[] maLaptopNull = new String[] {
			null, "", " "
	};
	
	/* -------------- Add LapTop ---------------- */
	
	@Test
	public void testAddNull() {
	    for (int i = 0; i < laptopsNull.length; i++) {
	        final int currentIndex = i; // Declare a final variable to capture the current index
	        assertThrows(NullPointerException.class, () -> {
	            laptopDAO.insert(laptopDAO.getLaptop(
	                laptopsNull[currentIndex][0],
	                laptopsNull[currentIndex][1],
	                laptopsNull[currentIndex][2],
	                laptopsNull[currentIndex][3],
	                laptopsNull[currentIndex][4]
	            ));
	        });
	    }
	}
	
	@Test
	public void testAddNumberFormat() {
		for (int i = 0; i < laptopsNumberFormat.length; i++) {
			final int currentIndex = i; // Declare a final variable to capture the current index
	        assertThrows(NumberFormatException.class, () -> {
	            laptopDAO.insert(laptopDAO.getLaptop(
            		laptopsNumberFormat[currentIndex][0],
            		laptopsNumberFormat[currentIndex][1],
            		laptopsNumberFormat[currentIndex][2],
            		laptopsNumberFormat[currentIndex][3],
            		laptopsNumberFormat[currentIndex][4]
	            ));
	        });
		}
	}
	
	@Test
	public void testAddInValid() {
		for (int i = 0; i < laptopsInValid.length; i++) {
			final int currentIndex = i; // Declare a final variable to capture the current index
	        assertThrows(IllegalArgumentException.class, () -> {
	            laptopDAO.insert(laptopDAO.getLaptop(
            		laptopsInValid[currentIndex][0],
            		laptopsInValid[currentIndex][1],
            		laptopsInValid[currentIndex][2],
            		laptopsInValid[currentIndex][3],
            		laptopsInValid[currentIndex][4]
	            ));
	        });
		}
		
	}
	
	String[][] laptopsValid = new String[][] {
		{"LT105", "Laptop Lenovo Ideapad 5","1","1","2020"}
	};
	@Test
	public void testAddSuccess() {
		assertEquals("Add thành công", laptopDAO.insert(laptopDAO.getLaptop(
				laptopsValid[0][0], 
				laptopsValid[0][1], 
				laptopsValid[0][2], 
				laptopsValid[0][3], 
				laptopsValid[0][4]
		)));
	}
	
	/* -------------- Update LapTop ---------------- */
	
	@Test
	public void testUpdateNull() {
		for (int i = 0; i < laptopsNull.length; i++) {
			final int currentIndex = i; // Declare a final variable to capture the current index
	        assertThrows(NullPointerException.class, () -> {
	            laptopDAO.update(laptopDAO.getLaptop(
            		laptopsNull[currentIndex][0],
            		laptopsNull[currentIndex][1],
            		laptopsNull[currentIndex][2],
            		laptopsNull[currentIndex][3],
            		laptopsNull[currentIndex][4]
	            ));
	        });
		}
	}
	
	@Test
	public void testUpdateNumberFormat() {
		for (int i = 0; i < laptopsNumberFormat.length; i++) {
			final int currentIndex = i; // Declare a final variable to capture the current index
	        assertThrows(NumberFormatException.class, () -> {
	            laptopDAO.update(laptopDAO.getLaptop(
            		laptopsNumberFormat[currentIndex][0],
            		laptopsNumberFormat[currentIndex][1],
            		laptopsNumberFormat[currentIndex][2],
            		laptopsNumberFormat[currentIndex][3],
            		laptopsNumberFormat[currentIndex][4]
	            ));
	        });
		}
	}
	
	@Test
	public void testUpdateInValid() {
		for (int i = 0; i < laptopsInValid.length; i++) {
			final int currentIndex = i; // Declare a final variable to capture the current index
	        assertThrows(IllegalArgumentException.class, () -> {
	            laptopDAO.update(laptopDAO.getLaptop(
            		laptopsInValid[currentIndex][0],
            		laptopsInValid[currentIndex][1],
            		laptopsInValid[currentIndex][2],
            		laptopsInValid[currentIndex][3],
            		laptopsInValid[currentIndex][4]
	            ));
	        });		
	    }
	}
	
	@Test
	public void testUpdateSuccess() {
		assertEquals("Update thành công", laptopDAO.update(laptopDAO.getLaptopUpdate(laptopsValid[0][0], laptopsValid[0][1], laptopsValid[0][2], laptopsValid[0][3], laptopsValid[0][4])));
	}
	
	/* -------------- Delete LapTop ---------------- */
	
	@Test
	public void testDeleteNull() {
		for (int i = 0; i < maLaptopNull.length; i++) {
			final int currentIndex = i; // Declare a final variable to capture the current index
	        assertThrows(NullPointerException.class, () -> {
	        	laptopDAO.delete(laptopDAO.maLaptop(maLaptopNull[currentIndex]));
	        });		
			
		}
	}
	
	@Test
	public void testDeleteSuccess() {
		assertEquals("Xóa thành công", laptopDAO.delete("LT102"));
	}

}
