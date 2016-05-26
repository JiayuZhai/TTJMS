package software;

import java.util.Date;
/**
 * The class is build for define the location message
 * @author zhai
 * 
 */
public class StationDis {
	/**
	 * The previous station 
	 */
	public int station;
	/**
	 * The displacement for current location to the previous
	 */
	public int displacement;
	/**
	 * Construct method
	 * @param d the date
	 * @param j the journey
	 * @param direction the current direction
	 */
	public StationDis(Date d, Journey j, int direction){
		//the second has been pass
		int s = (int) ((d.getTime() - j.getStartTime().getTime())/1000);
		int i;
		for(i=0;i<j.getRouteID().stationInterval.length;i++){
			if(s>=j.getRouteID().stationInterval[i]){
				s = s - j.getRouteID().stationInterval[i];
			}
			else {
				this.station = i;
				this.displacement = s;
				return;
			}
			
		}
		if(direction == 0){
			this.station = i;
			this.displacement = 0;
		}
		else{
			for(i=j.getRouteID().stationInterval.length-1;i>=0;i--){
				if(s>j.getRouteID().stationInterval[i]){
					s = s - j.getRouteID().stationInterval[i];
				}
				else{
					this.station = i;
					this.displacement = j.getRouteID().stationInterval[i] - s;
					return;
				}
			}
			this.station = i;
			this.displacement = 0;
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.station + " " + this.displacement;
	}
	
	
}
