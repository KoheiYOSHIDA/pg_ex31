package pg_ex31;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicServiceTest {

	@Test
	public void testGetCallPerMin() {
		Service srv = new BasicService();
		assertEquals(20,((BasicService) srv).getCallPerMin("",0));
	}

	@Test
	public void testIsCustomService() {
		Service srv = new BasicService();
		assertFalse(srv.isCustomService("item"));
	}
	
	@Test
	public void testGetCallTotal() {
		Service srv = new BasicService();
		assertEquals(200,((BasicService) srv).getCallTotal(10));
	}
	
	@Test
	public void testAddTotalPerService() {
		Service srv = new BasicService();
		assertEquals(200,srv.addTotalPerService(10,"",20));
		assertEquals(400,srv.addTotalPerService(10,"",20));
		assertEquals(560,srv.addTotalPerService(8,"",20));
	}
	
	@Test
	public void testGetTotalPerService() {
		Service srv = new BasicService();
		assertEquals(200,srv.addTotalPerService(10,"",20));
		assertEquals(400,srv.addTotalPerService(10,"",20));
		assertEquals(560,srv.addTotalPerService(8,"",20));
		assertEquals(560,srv.getTotalPerService());
	}
	
	@Test
	public void testClearTotal() {
		Service srv = new BasicService();
		assertEquals(200,srv.addTotalPerService(10,"",20));
		assertEquals(400,srv.addTotalPerService(10,"",20));
		assertEquals(560,srv.addTotalPerService(8,"",20));
		assertEquals(560,srv.getTotalPerService());
		assertEquals(0,srv.clearTotal());
	}
	
	@Test
	public void testGetTotalBasic() {
		Service srv = new BasicService();
		assertEquals(1000,srv.getTotalBasic());
	}
}
