package pg_ex31;

public class BasicService extends Service {
	
	public int _callPerMin = 20;
	public int _servicePerMon = 1000;
	public int _totalPerService = 0;
	public String name;


//	public int getCallPerMin() {
//		return _callPerMin;
//	}
	
	BasicService() {
		this.name = "bsrv";
	}

	@Override
	public boolean getCustomService() {
		return true;
	}

	public int getCallTotal(int time) {
		return time * this.getCallPerMin("",0);
	}

	@Override
	public int addTotalPerService(int time,String item,int current) {
		
		return _totalPerService += this.getCallTotal(time);
	}
	
	@Override
	public int getTotalPerService() {
		return _totalPerService;
	}

	@Override
	public int clearTotal() {
		_totalPerService = 0;
		return _totalPerService;
	}

	@Override
	public boolean setCustomService(String item) {
		return false;
	}

	@Override
	public boolean isCustomService(String item) {
		return false;
	}

	@Override
	public int getTotalBasic() {
		return this._servicePerMon;
	}

	@Override
	public int getCallPerMin(String item, int current) {
		return this._callPerMin;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}
