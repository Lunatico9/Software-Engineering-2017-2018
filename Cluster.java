package model;

public class Cluster {
	private int name;
	private int downRobot;
	private long lastChange;
	private long upTimeLocal; //Resetted every X minutes
	private int areaID;
	private long upTimeTotal = 3600000;
	
	public Cluster(int name, int downRobot, long lastChange, int areaID){
		this.name = name;
		this.setDownRobot(downRobot);
		this.lastChange = lastChange;
		this.setAreaID(areaID);
		this.setUpTimeLocal(0);
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public long getLastChange() {
		return lastChange;
	}
	public void setLastChange(long lastChange) {
		this.lastChange = lastChange;
	}
	public int getDownRobot() {
		return downRobot;
	}
	public void setDownRobot(int downRobot) {
		this.downRobot = downRobot;
	}
	public long getUpTimeTotal() {
		return upTimeTotal;
	}
	public void setUpTimeTotal(long lastEfficiency) {
		this.upTimeTotal = lastEfficiency;
	}
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public long getUpTimeLocal() {
		return upTimeLocal;
	}
	public void setUpTimeLocal(long upTimeLocal) {
		this.upTimeLocal = upTimeLocal;
	}
}
