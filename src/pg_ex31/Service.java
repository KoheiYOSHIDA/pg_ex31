package pg_ex31;
public abstract class Service {
	
	public int total;
	public abstract int getTotalPerService();
	public abstract int getTotalBasic();
	public abstract boolean getCustomService();
	public abstract boolean setCustomService(String item);
	public abstract boolean isCustomService(String item);
	public abstract int addTotalPerService(int total,String item,int current);
	public abstract int clearTotal();
	public abstract int getCallPerMin(String item,int current);
	public abstract String getName();
	
}
