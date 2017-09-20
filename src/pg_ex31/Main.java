package pg_ex31;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		Service bsrv = new BasicService();
		Service c1srv = new C1Service();
		Service e1srv = new E1Service();
		
		ArrayList<Service> service = new ArrayList<Service>();
		service.add(bsrv);
		service.add(c1srv);
		service.add(e1srv);
		
		Io io = new File();
		String filePath = "/Users/koheiyoshida/eclipse-workspace/pg_ex31/src/pg_ex31/record.log";
		io.read(filePath,service);
		
		return;
	}
	
	public static HashMap<String,String> controller(ArrayList<String> list,ArrayList<Service> srv) {
	
		HashMap<String,String> map = new HashMap<>();
		for(String temp:list) {
			String tmp[] = temp.split(" ");
			if(tmp[0].equals("1")) {				
				clearAllInstance(srv);
				map.put("number",tmp[1]);
			}
			if(tmp[0].equals("2")) {
				setInstance(srv,tmp);
			}
			if(tmp[0].equals("5")) {
				calucAdd(srv,tmp);
			}
		}
		
		map.put("base",calucBasicTotal(srv));
		map.put("call",calucCallTotal(srv));
		
		return map;
	}
	
	public static Service getInstace(ArrayList<Service> srv,String target) {
		Service gsrv = null;
		for(int i=0;i<srv.size();i++) {
			if(srv.get(i).getName().equals(target)) {
				gsrv = srv.get(i);
				break;
			}
		}
		return gsrv;
	}
	
	public static void clearAllInstance(ArrayList<Service> srv) {
		for(int i=0;i<srv.size();i++) {
			srv.get(i).clearTotal();
		}
	}
	
	public static void setInstance(ArrayList<Service> srv,String tmp[]) {
		if(tmp[1].equals("C1")) {
			getInstace(srv,"c1srv").setCustomService(tmp[2]);
		} else if(tmp[1].equals("E1")) {
			getInstace(srv,"e1srv").setCustomService("");
		}
	}
	
	public static void calucAdd(ArrayList<Service> srv,String tmp[]) {
		if((getInstace(srv,"e1srv").getCustomService()) && (Main.getInstace(srv,"c1srv").getCustomService())) {
			Main.getInstace(srv,"c1srv").addTotalPerService(Integer.parseInt(tmp[3]),tmp[4],Main.getInstace(srv,"e1srv").getCallPerMin(tmp[2],Main.getInstace(srv,"bsrv").getCallPerMin("",0)));		
		} else if(Main.getInstace(srv,"e1srv").getCustomService()) {
			Main.getInstace(srv,"e1srv").addTotalPerService(Integer.parseInt(tmp[3]),tmp[2],Main.getInstace(srv,"bsrv").getCallPerMin("",0));
		} else if(Main.getInstace(srv,"c1srv").getCustomService()) {
			Main.getInstace(srv,"c1srv").addTotalPerService(Integer.parseInt(tmp[3]),tmp[4],Main.getInstace(srv,"bsrv").getCallPerMin("",0));
		} else {
			Main.getInstace(srv,"bsrv").addTotalPerService(Integer.parseInt(tmp[3]),tmp[4],Main.getInstace(srv,"bsrv").getCallPerMin("",0));
		}
	}
	
	public static String calucBasicTotal(ArrayList<Service> srv) {
		int caluc=0;
		for(int i=0;i<srv.size();i++) {
			caluc += srv.get(i).getTotalBasic();
		}
		return Integer.toString(caluc);
	}

	public static String calucCallTotal(ArrayList<Service> srv) {
		int caluc=0;
		for(int i=0;i<srv.size();i++) {
			caluc += srv.get(i).getTotalPerService();
		}
		return Integer.toString(caluc);
	}
}
