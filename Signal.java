package model;

public class Signal implements java.io.Serializable {
	private int idRobot;
	private int idCluster;
	private int idArea;
	private String upDown;
	private long milliSeconds;
	
	public Signal(int idRobot, int idCluster, int idArea, String upDown, long milliSeconds) {
		this.setIdArea(idArea);
		this.setIdCluster(idCluster);
		this.setIdRobot(idRobot);
		this.setUpDown(upDown);
		this.setMilliSeconds(milliSeconds);
	}

	public long getMilliSeconds() {
		return milliSeconds;
	}

	public void setMilliSeconds(long milliSeconds) {
		this.milliSeconds = milliSeconds;
	}

	public String getUpDown() {
		return upDown;
	}

	public void setUpDown(String upDown) {
		this.upDown = upDown;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getIdCluster() {
		return idCluster;
	}

	public void setIdCluster(int idCluster) {
		this.idCluster = idCluster;
	}

	public int getIdRobot() {
		return idRobot;
	}

	public void setIdRobot(int idRobot) {
		this.idRobot = idRobot;
	}
	
}
