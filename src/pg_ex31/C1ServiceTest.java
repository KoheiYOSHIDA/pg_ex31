package pg_ex31;

import static org.junit.Assert.*;

import org.junit.Test;

public class C1ServiceTest {

	@Test
	public void testGetCallPerMin1() {
		Service srv = new C1Service();
		assertEquals(20,((C1Service) srv).getCallPerMin("090-9999-8765",20));
	}
	
	@Test
	public void testGetCallTotal() {
		Service srv = new C1Service();
		assertEquals(200,((C1Service) srv).getCallTotal(10,"080-1234-5678",20));
	}
	
	@Test
	public void testAddTotalPerService() {
		Service srv = new C1Service();
		assertEquals(200,srv.addTotalPerService(10,"080-1234-5678",20));
		assertEquals(400,srv.addTotalPerService(10,"080-1234-5678",20));
		
	}

	@Test
	public void testGetTotalPerService() {
		Service srv = new C1Service();
		assertEquals(200,srv.addTotalPerService(10,"080-1234-5678",20));
		assertEquals(400,srv.addTotalPerService(10,"080-1234-5678",20));
		assertEquals(400,srv.getTotalPerService());
	}
	
	@Test
	public void testGetCustomService() {
		Service srv = new C1Service();
		assertFalse(srv.getCustomService());
	}
	
	@Test
	public void testGetCustomService1() {
		Service srv = new C1Service();
		assertFalse(srv.getCustomService());
		assertTrue(srv.setCustomService("090-1234-5678"));
		assertEquals(0,srv.clearTotal());
		assertFalse(srv.getCustomService());
	}
	
	@Test
	public void testSetCustomService() {
		Service srv = new C1Service();
		assertFalse(srv.getCustomService());
		assertTrue(srv.setCustomService("090-1234-5678"));
		assertTrue(srv.isCustomService("090-1234-5678"));
		assertTrue(srv.setCustomService("090-1234-5670"));
		assertTrue(srv.isCustomService("090-1234-5670"));
		assertTrue(srv.setCustomService("090-1234-5673"));
		assertFalse(srv.isCustomService("090-1234-5673"));
	}
	
	@Test
	public void testGetTotalBasic()  {
		Service srv = new C1Service();
		assertEquals(100,srv.getTotalBasic());
	}
	
	@Test
	public void testGetCallPerMin2() {
		Service srv = new C1Service();
		assertTrue(srv.setCustomService("090-1234-5678"));
		assertTrue(srv.isCustomService("090-1234-5678"));
		assertEquals(10,((C1Service) srv).getCallPerMin("090-1234-5678",20));
	}
	
	@Test
	public void testAddTotalPerService2() {
		Service srv = new C1Service();
		assertTrue(srv.setCustomService("090-1234-5678"));
		assertTrue(srv.isCustomService("090-1234-5678"));
		assertEquals(100,srv.addTotalPerService(10, "090-1234-5678", 20));
		assertEquals(300,srv.addTotalPerService(10, "090-1234-5675", 20));

	}
}
