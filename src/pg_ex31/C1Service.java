package pg_ex31;

public class C1Service extends Service {
	
	public boolean _isService = false;
	public int _servicePerMon = 100;
	public int _totalPerService;
	public String[] _number = new String[2];
	public String name;

	C1Service() {
		this._servicePerMon = 100;
		this.clearTotal();
		this.name = "c1srv";
	}
	
	public int getCallPerMin(String item,int current) {
		if(this.isCustomService(item)) {
			return current/2;
		}
		return current;
	}


	public int getCallTotal(int time,String item,int current) {
		return time * this.getCallPerMin(item,current);
	}

	@Override
	public int addTotalPerService(int time,String item,int current) {
		return _totalPerService += this.getCallTotal(time,item,current);
	}
	
	@Override
	public int getTotalPerService() {
		return _totalPerService;
	}


	@Override
	public int clearTotal() {
		this._totalPerService=0;
		for(int i=0;i<this._number.length;i++) {
			this._number[i] = "";
		}
		this._isService = false;
		return _totalPerService;
	}

	@Override
	public boolean getCustomService() {
		return this._isService;
	}

	@Override
	public boolean setCustomService(String item) {
			this._isService = true;
			this.setRegistNumber(item);
		return _isService;
	}
	
	public void setRegistNumber(String number) {
		if(isCustomService(number)) return;
		for(int i=0;i<this._number.length;i++) {
			if("".equals(_number[i])) {
				this._number[i] = number;
				break;
			}
		}
	}
	

	@Override
	public boolean isCustomService(String item) {
		for(int i=0;i<this._number.length;i++) {
			if(item.equals(this._number[i])) {
				return true;
			}
		}
		return false;
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
	public String getName() {
		return this.name;
	}
}
