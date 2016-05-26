package software;
/**
 * The class is build for a display of the running information
 * @author zhai
 *
 */
public class RunInfo {
	/**
	 * Construct method
	 * @param j the journey which is running
	 */
	public RunInfo(Journey j) {
		// TODO Auto-generated constructor stub
		this.trainID = j.getTrainID().getTrainID();
		this.trainName = "Train" + j.getTrainID().getTrainID();
		this.fromStation = j.getRouteID().stationName[0];
		this.toStation = j.getRouteID().stationName[j.getRouteID().stationName.length-1];
		this.direction = 0;
		this.nextStation = j.getRouteID().stationName[0];
	}
	/**
	 * The train ID
	 */
	public long trainID;
	/**
	 * The train name
	 */
	public String trainName;
	/**
	 * The station where the journey is strat with
	 */
	public String fromStation;
	/**
	 * The destination station
	 */
	public String toStation;
	/**
	 * The direction of the journey
	 */
	public int direction;
	/**
	 * The name of next station
	 */
	public String nextStation;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s;
		if(this.direction == 0)
			s = "Forward";
		else
			s = "Backward";
		return "FROM:<" + this.fromStation + ">\n" + 
				"TO:<" + this.toStation + ">\n" + 
				"DIRECTION:<" + s + ">\n" + 
				"Next Station:<" + this.nextStation + ">\n";
	}
	
	
}
