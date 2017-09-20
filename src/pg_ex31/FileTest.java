package pg_ex31;

import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;

public class FileTest {

	@Test
	public void testParseToOut() {
		HashMap<String,String> map = new HashMap<>();
		map.put("number", "090-1234-0002");
		map.put("base", "1300");
		map.put("call", "199");
		
		Io file = new File();
		
		map = ((File) file).parseToOut(map);
		assertEquals("1 090-1234-0002",map.get("number"));
		assertEquals("5 1300",map.get("base"));
		assertEquals("7 199",map.get("call"));
		assertEquals("9 ====================",map.get("end"));
	}
}
