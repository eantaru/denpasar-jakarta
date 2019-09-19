package datastoreload.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import datastoreload.Solution;

public class Test {
	
	private Solution s;

	@Before
	public void setUp() throws Exception {
		s = new Solution();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@org.junit.Test
	public void testKeyA() {
		s.store("key&1=&value1;key2=value2;key3=value3\nkeyA=valueA");
		String[] list = s.load("\nkeyA=valueA;");
		
		String[] exptectedResults = {
				"keyA=valueA"
		};
		
		assertArrayEquals(exptectedResults, list);
	}
	

	@org.junit.Test
	public void testKeyWithNewline() {
		s.store("key\n1=value1;key2=value2;key3=value3\nkeyA=valueA");
		String[] list = s.load("1=value1");
		s.print();
		
		String[] exptectedResults = {
				"1=value1"
		};
		
		assertArrayEquals(exptectedResults, list);
	}

}
