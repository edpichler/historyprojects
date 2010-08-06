package test.com.blackduck.engine;

import net.pqno.engine.UrlValidator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class UrlValidatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateUrl1() {
		UrlValidator validator = new UrlValidator();
		try {
			validator.validateUrl("http://www.google.com");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testValidateUrl2() {
		UrlValidator validator = new UrlValidator();
		try {
			validator.validateUrl("http://www.google.com");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testValidateUrl3() {
		UrlValidator validator = new UrlValidator();

		try {
			validator.validateUrl("ata.ata.atatatata");
			fail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Test
	public void testValidateUrl4()  {
		UrlValidator validator = new UrlValidator();

		try {
			validator.validateUrl("wwwgoogle.com.çaa");
			fail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testValidateUrl5() throws Exception {
		UrlValidator validator = new UrlValidator();

		validator.validateUrl("http://about.museum");

	}
	
	
	@Test
	public void testValidateUrl6(){
		String validYoutubeUrl = "http://www.youtube.com/watch?v=rKnDgT73v8s&feature=sub";
		UrlValidator validator =  new UrlValidator();
		try {
			validator.validateUrl(validYoutubeUrl);
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}
	}
}
