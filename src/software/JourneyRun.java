package software;

import java.util.Date;

/**
 * This can implement the Runnable interface to simulate a journey running process
 * @author zhai
 *
 */

public class JourneyRun implements Runnable {
	/**
	 * The journey it simulated
	 */
	private Journey j; 
	/**
	 * The Frame it located
	 */
	private MainFrame mf;
	/**
	 * When the control ask for stop, record the time of stop
	 */
	public Date stopTime = null;
	/**
	 * The time interval of the train stop and restart
	 */
	public long offset = 0;
	/**
	 * The state of the current journey
	 */
	public boolean state = true;
	/**
	 * Construct method
	 * @param j the journey
	 * @param mainFrame the frame
	 */
	public JourneyRun(Journey j, MainFrame mainFrame){
		this.j = j;
		this.mf = mainFrame;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int direction = 0;
		while(true){
			if(state){
				Date d = new Date((new Date()).getTime() - this.offset);
				StationDis sd = getLocation(d, this.j,direction);
				//forward direction
				if(direction == 0){
					this.mf.runningChange(sd, j);
					if(sd.station == j.getRouteID().stationInterval.length){
						direction = 1;
						for(int i=0;i<mf.runInfo.size();i++){
							if(mf.runInfo.get(i).trainID == j.getTrainID().getTrainID())
								mf.runInfo.get(i).direction = 1;
						}
					}
				}
				//backward direction
				else{
					this.mf.runningChange(sd, j);
					if(sd.station == -1){
						this.mf.finishJouney(j);
						
						break;
					}
					
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * Get the location of the train in this journey
	 * @param d	the time we need the location
	 * @param j	the journey we need for the location
	 * @param direction	the current direction of the journey
	 * @return the location in class of StationDis
	 */
	public StationDis getLocation(Date d,Journey j, int direction){
			StationDis sd = new StationDis(d,j,direction);
			System.out.println(sd);
		return sd;
	}
}
