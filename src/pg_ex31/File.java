package pg_ex31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class File extends Io {
	
	public final String END = "0 *************************";
	
	@Override
	public String read(String filePath,ArrayList<Service> srv) {
		
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String,String>  get = new HashMap<>();
		
		FileReader fr = null;
	    BufferedReader br = null;
	    
	    try {
	        fr = new FileReader(filePath);
	        br = new BufferedReader(fr);
	        String line;
	        
	        while ((line = br.readLine()) != null) {
	        		list.add(line);
	        		line = br.readLine();
	        			for(;!(line.equals(END));) {
	        				list.add(line);
	        				line = br.readLine();
	        			}
	       		get = Main.controller(list,srv);
	       		this.write(get);
	        		list.clear();
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            br.close();
	            fr.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		return ""; 
	}

	@Override
	public void write(HashMap<String,String> item) {
		String[] str = {"number","base","call","end"};
		try {
			String filePath = "/Users/koheiyoshida/eclipse-workspace/pg_ex31/src/pg_ex31/result.log";
			FileWriter file = new FileWriter(filePath,true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(file));

			item = parseToOut(item);
			
			for(int i=0;i<str.length;i++) {
				pw.println(item.get(str[i]));
			}
			pw.close();
		}catch (IOException e) {
            e.printStackTrace();
        }
	}
		
	public HashMap<String,String> parseToOut(HashMap<String,String> item) {
		item.put("number", "1 "+item.get("number"));
		item.put("base", "5 "+item.get("base"));
		item.put("call", "7 "+item.get("call"));
		item.put("end", "9 ====================");
		
		return item;
	}
	
}
