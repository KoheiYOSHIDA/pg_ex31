package pg_ex31;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E1Service extends Service {

	final int DISCOUNT_E1_PER_MINUTE = 5;
	public boolean _isService = false;
	public int _servicePerMon = 200;
	public int _totalPerService;
	public String name;
	
	E1Service() {
		this.name = "e1srv";
	}
	
	@Override
	public int getTotalBasic() {
		if(this.getCustomService()) {
			return this._servicePerMon;
		} else {
			return 0;
		}
	}

	@Override
	public boolean getCustomService() {
		return this._isService;
	}

	@Override
	public boolean setCustomService(String item) {
		this._isService = true;
		return this._isService;
	}
	
	public int parseStrToInt(String item) {
		String regex = ":";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(item);
		String result = m.replaceFirst("");
		return Integer.parseInt(result);
	}

	@Override
	public boolean isCustomService(String item) {
		return this.isStartCall(this.parseStrToInt(item));
	}
	
	public boolean isStartCall(int startTime) {
		if(800 <= startTime && startTime <=1759) {
			return true;
		}
			return false;
	}

	@Override
	public int getCallPerMin(String item,int current) {
		if(this.isCustomService(item)) {
			return current - DISCOUNT_E1_PER_MINUTE;
		}
		return current;
	}


	public int getCallTotal(int time,String item,int current) {
		return time * this.getCallPerMin(item,current);
	}

	
	@Override
	public int addTotalPerService(int time, String item, int current) {
		return _totalPerService += this.getCallTotal(time,item,current);
	}

	@Override
	public int getTotalPerService() {
		return _totalPerService;
	}
	
	@Override
	public int clearTotal() {
		this._isService = false;
		this._totalPerService = 0;
		return this._totalPerService;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
