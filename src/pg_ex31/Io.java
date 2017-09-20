package pg_ex31;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Io {
	public abstract String read(String filePath,ArrayList<Service> srv);
	public abstract void write(HashMap<String,String> get);
}
