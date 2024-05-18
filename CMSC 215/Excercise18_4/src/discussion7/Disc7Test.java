package discussion7;

import static org.junit.Assert.*;

import org.junit.Test;

public class Disc7Test {

	@Test
	public void test() {
		disc7 dc = new disc7();
		String s = "This is a test case string";
		char[] c = s.toCharArray();
		int check = dc.count(c, 'e');
		
		assertEquals(check, 2);
	}

}
