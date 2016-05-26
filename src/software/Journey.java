package software;

import java.awt.GridLayout;
import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * The Journey Class
 * @author Xian Zhou
 *
 */

public class Journey {
	/**
	 * The journey ID.
	 */
	private long JourneyID;
	/**
	 * The train ID of the journey.
	 */
	private Train TrainID;
	/**
	 * The driver ID of the journey.
	 */
	private Driver DriverID;
	/**
	 * The route ID of the journey.
	 */
	private Route RouteID;
	/**
	 * The start time of the journey.
	 */
	private Date StartTime;
	/**
	 * The number of passengers in the journey.
	 */
	private int Passenger;
	/**
	 * The last ID number of the logged jouney on the file 
	 */
	public static long JourneyIDLast;
	/**
	 * The thread runnable interface 
	 */
	private JourneyRun runningInterf = null;
	/**
	 * Initial the JourneyIDLast.
	 */
	static{
		File f = new File("gen/log.txt");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JourneyIDLast = 0;
		}
		else{
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String temp = br.readLine();
				while (temp != null){
					JourneyIDLast = Integer.parseInt((new StringTokenizer(temp,",")).nextToken());
					temp = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(JourneyIDLast);
	}

	public long getJourneyID() {
		return JourneyID;
	}

	public void setJourneyID(long journeyIDLast2) {
		JourneyID = journeyIDLast2;
	}

	public Train getTrainID() {
		return TrainID;
	}

	public void setTrainID(Train trainID2) {
		TrainID = trainID2;
	}

	public Driver getDriverID() {
		return DriverID;
	}

	public void setDriverID(Driver driverID2) {
		DriverID = driverID2;
	}

	public Route getRouteID() {
		return RouteID;
	}

	public void setRouteID(Route routeID) {
		RouteID = routeID;
	}

	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date d) {
		StartTime = d;
	}

	public int getPassenger() {
		return Passenger;
	}

	public void setPassenger(int passenger) {
		Passenger = passenger;
	}

	@Override
	public String toString() {
		return JourneyID + "," + TrainID.getTrainID() + "," + DriverID.getDriverID() + "," + RouteID.getID() + ","
				+ StartTime + "," + Passenger + ",";
	}
	/**
	 * Construct method
	 * @param trainID2 the train 
	 * @param driverID2 the driver
	 * @param routeID the route
	 * @param d the date
	 * @param i the passager number
	 */
	public Journey(Train trainID2, Driver driverID2, Route routeID, Date d, int i) {
		// TODO Auto-generated constructor stub
		setJourneyID(JourneyIDLast + 1);
		JourneyIDLast ++;
		setTrainID(trainID2);
		setDriverID(driverID2);
		setRouteID(routeID);
		setStartTime(d);
		setPassenger(i);
	}

	/**
	 * Log the journey into the log file.
	 * @param j the journey need to be log
	 */
	public static void log(Journey j) {
		// TODO Auto-generated method stub
		File f = new File("gen/log.txt");
		try {
			FileWriter fw = new FileWriter(f,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(j.toString());
			bw.write("\n");
			
			
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Show the time table message of the journey
	 * @return the timetable as a String
	 */
	public String getTimeTable() {
		// TODO Auto-generated method stub
		String s = "";
		
		Date tempD = this.StartTime;
		for(int i=0;i<RouteID.stationName.length;i++){
			s += RouteID.stationName[i] + "";
			if (i==0)
				s += "" + tempD;
			else{
				tempD = new Date(tempD.getTime() + 1000 * RouteID.stationInterval[i-1]);
				s += "" + tempD;
			}
			s += "\n";
		}
		
		return s;
	}
	/**
	 * Show the time table message of the journey
	 * @param b A flag for the return type
	 * @return the timetable as a String
	 */
	public JPanel getTimeTable(boolean b) {
		// TODO Auto-generated method stub
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(RouteID.stationName.length * 2 + 1, 2));
		//String s = "";
		JTextArea title1 = new JTextArea("Station");
		JTextArea title2 = new JTextArea("Time");
		jp.add(title1);
		jp.add(title2);
		title1.setEditable(false);
		title2.setEditable(false);
		Date tempD = this.StartTime;
		String s;
		//forward
		for(int i=0;i<RouteID.stationName.length;i++){
			s = RouteID.stationName[i] + "";
			JButton bu = new JButton(s);
			jp.add(bu);
			bu.setEnabled(false);
			if (i!=0){
				tempD = new Date(tempD.getTime() + 1000 * RouteID.stationInterval[i-1]);
			}
			s = tempD.getHours() + ":" + tempD.getMinutes() + ":" + tempD.getSeconds();
			JTextArea tar = new JTextArea(s);
			jp.add(tar);
			tar.setEditable(false);
		}
		//backward
		for(int i=RouteID.stationName.length-2;i>=0;i--){
			s = RouteID.stationName[i] + "";
			JButton bu = new JButton(s);
			jp.add(bu);
			bu.setEnabled(false);
			tempD = new Date(tempD.getTime() + 1000 * RouteID.stationInterval[i]);
			s = tempD.getHours() + ":" + tempD.getMinutes() + ":" + tempD.getSeconds();
			JTextArea tar = new JTextArea(s);
			jp.add(tar);
			tar.setEditable(false);
		}
		
		return jp;
	}

	public JourneyRun getRunningInterf() {
		return runningInterf;
	}

	public void setRunningInterf(JourneyRun runningInterf) {
		this.runningInterf = runningInterf;
	}
}
