package pg_ex31;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class MainTest {

	@Test
	public void testSetInstance1() {
		Service bsrv = new BasicService();
		Service c1srv = new C1Service();
		Service e1srv = new E1Service();
		
		ArrayList<Service> service = new ArrayList<Service>();
		service.add(bsrv);
		service.add(c1srv);
		service.add(e1srv);
		
		String[] tmp = {"2","C1","090-1234-1234"};
		
		assertFalse(c1srv.getCustomService());
		Main.setInstance(service,tmp);
		assertTrue(c1srv.getCustomService());	
	}

	
	@Test
	public void testSetInstance2() {
		Service bsrv = new BasicService();
		Service c1srv = new C1Service();
		Service e1srv = new E1Service();
		
		ArrayList<Service> service = new ArrayList<Service>();
		service.add(bsrv);
		service.add(c1srv);
		service.add(e1srv);
		
		String[] tmp = {"2","E1"};
		
		assertFalse(e1srv.getCustomService());
		Main.setInstance(service,tmp);
		assertTrue(e1srv.getCustomService());	
	}
	
	@Test
	public void testCalucBasicTotal1() {
		Service bsrv = new BasicService();
		Service c1srv = new C1Service();
		Service e1srv = new E1Service();
		
		ArrayList<Service> service = new ArrayList<Service>();
		service.add(bsrv);
		service.add(c1srv);
		service.add(e1srv);
		
		assertFalse(c1srv.getCustomService());
		assertFalse(e1srv.getCustomService());
		
		assertEquals("1000",Main.calucBasicTotal(service));
		
	}
	
	@Test
	public void testCalucBasicTotal2() {
		Service bsrv = new BasicService();
		Service c1srv = new C1Service();
		Service e1srv = new E1Service();
		
		ArrayList<Service> service = new ArrayList<Service>();
		service.add(bsrv);
		service.add(c1srv);
		service.add(e1srv);
		
		assertFalse(c1srv.getCustomService());
		assertFalse(e1srv.getCustomService());
		
		String[] tmp = {"2","C1","090-1234-1234"};
		
		assertFalse(c1srv.getCustomService());
		Main.setInstance(service,tmp);
		assertTrue(c1srv.getCustomService());
		
		assertEquals("1100",Main.calucBasicTotal(service));
		
	}

	@Test
	public void testCalucBasicTotal3() {
		Service bsrv = new BasicService();
		Service c1srv = new C1Service();
		Service e1srv = new E1Service();
		
		ArrayList<Service> service = new ArrayList<Service>();
		service.add(bsrv);
		service.add(c1srv);
		service.add(e1srv);
		
		assertFalse(c1srv.getCustomService());
		assertFalse(e1srv.getCustomService());
		
		String[] tmp = {"2","C1","090-1234-1234"};
		
		assertFalse(c1srv.getCustomService());
		Main.setInstance(service,tmp);
		assertTrue(c1srv.getCustomService());
		
		String[] tmp1 = {"2","E1"};
		
		assertFalse(e1srv.getCustomService());
		Main.setInstance(service,tmp1);
		assertTrue(e1srv.getCustomService());
		
		assertEquals("1300",Main.calucBasicTotal(service));
	}
	
	@Test
	public void testCalucCallTotal() {
		Service bsrv = new BasicService();
		Service c1srv = new C1Service();
		Service e1srv = new E1Service();
		
		ArrayList<Service> service = new ArrayList<Service>();
		service.add(bsrv);
		service.add(c1srv);
		service.add(e1srv);
		
		String[] tmp11 = {"2","C1","090-1234-0001"};
		String[] tmp12 = {"2","C1","090-1234-0003"};
		String[] tmp13 = {"2","E1"};
		Main.setInstance(service,tmp11);
		Main.setInstance(service,tmp12);
		Main.setInstance(service,tmp13);
		
		String[] tmp1 = {"5","2004/06/05","17:50","010","090-1234-9999"};
		String[] tmp2 = {"5","2004/06/06","12:34","007","090-1234-0003"};
		Main.calucAdd(service, tmp1);
		Main.calucAdd(service, tmp2);
		
		assertEquals("199",Main.calucCallTotal(service));
	}
	
	@Test
	public void testController() {
		Service bsrv = new BasicService();
		Service c1srv = new C1Service();
		Service e1srv = new E1Service();
		
		ArrayList<Service> service = new ArrayList<Service>();
		service.add(bsrv);
		service.add(c1srv);
		service.add(e1srv);
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("1 090-1234-0002");
		list.add("2 C1 090-1234-0001");
		list.add("2 C1 090-1234-0003");
		list.add("2 E1");
		list.add("5 2004/06/05 17:50 010 090-1234-9999");
		list.add("5 2004/06/06 12:34 007 090-1234-0003");
		list.add("0 *************************");
		
		HashMap<String,String> ans = new HashMap<>();
		ans = Main.controller(list, service);
		
		assertEquals("090-1234-0002", ans.get("number"));
		assertEquals("1300", ans.get("base"));
		assertEquals("199", ans.get("call"));
	}		
}
