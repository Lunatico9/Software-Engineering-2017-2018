package model;

public class Robot {
	private int name;
	private int downSignals;
	private long lastChange = System.currentTimeMillis();
	private long upTimeLocal; //Resetted every X minutes
	private int clusterID;
	private int areaID;
	private long upTimeTotal;  
	
	public Robot(int name, int downSignals, long lastChange, int clusterID){
		this.name = name;
		this.downSignals = downSignals;
		this.lastChange = lastChange;
		this.clusterID = clusterID;
		this.setUpTimeLocal(0);	
		this.setUpTimeTotal(3600000);
	}
	public long getLastChange() {
		return lastChange;
	}
	public void setLastChange(long lastChange) {
		this.lastChange = lastChange;
	}
	public int getDownSignals() {
		return downSignals;
	}
	public void setDownSignals(int downSignals) {
		this.downSignals = downSignals;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getClusterID() {
		return clusterID;
	}
	public void setClusterID(int clusterID) {
		this.clusterID = clusterID;
	}
	public long getUpTimeTotal() {
		return upTimeTotal;
	}
	public void setUpTimeTotal(long lastEfficiency) {
		this.upTimeTotal = lastEfficiency;
	}
	public long getUpTimeLocal() {
		return upTimeLocal;
	}
	public void setUpTimeLocal(long upTimeLocal) {
		this.upTimeLocal = upTimeLocal;
	}
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
}
