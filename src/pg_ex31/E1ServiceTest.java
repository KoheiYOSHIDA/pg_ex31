package pg_ex31;

import static org.junit.Assert.*;

import org.junit.Test;

public class E1ServiceTest {

	@Test
	public void testGetTotalBasic() {
		Service srv = new E1Service();
		assertEquals(200,srv.getTotalBasic());
	}
	
	@Test
	public void testGetCustomService1() {
		Service srv = new E1Service();
		assertFalse(srv.getCustomService());
	}
	
	@Test
	public void testGetCustomService2() {
		Service srv = new E1Service();
		assertFalse(srv.getCustomService());
		assertTrue(srv.setCustomService(""));
		assertTrue(srv.getCustomService());		
	}
	
	@Test
	public void testIsCustomService() {
		Service srv = new E1Service();
		assertTrue(srv.isCustomService("08:00"));
		assertFalse(srv.isCustomService("07:59"));
		assertTrue(srv.isCustomService("17:59"));
		assertFalse(srv.isCustomService("18:00"));
	}
	
	@Test
	public void testAddTotalPerService() {
		Service srv = new E1Service();
		assertEquals(150,srv.addTotalPerService(10,"08:00",20));
		assertEquals(350,srv.addTotalPerService(10,"07:00",20));
		assertEquals(500,srv.addTotalPerService(10,"17:59",20));
		assertEquals(700,srv.addTotalPerService(10,"18:00",20));
	}
	
	@Test
	public void testGetTotalPerService() {
		Service srv = new E1Service();
		assertEquals(150,srv.addTotalPerService(10,"08:00",20));
		assertEquals(350,srv.addTotalPerService(10,"07:00",20));
		assertEquals(500,srv.addTotalPerService(10,"17:59",20));
		assertEquals(700,srv.addTotalPerService(10,"18:00",20));
		assertEquals(700,srv.getTotalPerService());
	}
	
	@Test
	public void testClearTotal() {
		Service srv = new E1Service();
		assertEquals(150,srv.addTotalPerService(10,"08:00",20));
		assertEquals(350,srv.addTotalPerService(10,"07:00",20));
		assertEquals(500,srv.addTotalPerService(10,"17:59",20));
		assertEquals(700,srv.addTotalPerService(10,"18:00",20));
		assertEquals(700,srv.getTotalPerService());
		assertEquals(0,srv.clearTotal());
	}
}
