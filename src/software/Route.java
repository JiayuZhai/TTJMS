package software;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Route class
 *
 * @author Yijie Hu
 * 
 */
public class Route {
	/**
	 * The ID of the route
	 */
	public long ID;
	/**
	 * The Station names of the stations on the route.
	 */
	public String stationName[];
	/**
	 * The intervals of the stations on the route.
	 */
	public int stationInterval[];
	/**
	 * The state of the Route.
	 * It must be the following state:
	 * 		
	 */
	public boolean state;
	/**
	 * Construct method
	 * @param id2 The ID of the route
	 * @param b The state of the route
	 * @param stationName2 The name of the stations
	 * @param stationInterval2 The time interval of the station intervals in minute.
	 */
	public Route(long id2, boolean b, String[] stationName2, int[] stationInterval2) {
		// TODO Auto-generated constructor stub
		this.ID = id2;
		this.stationName = stationName2;
		this.stationInterval = stationInterval2;
		this.state = b;
	}

	public void setID(long ID){
		this.ID=ID;
	}
	
	public long getID(){
		return ID;
	}
	
	public void setState(boolean state){
		this.state=state;
	}
	
	public boolean getState(){
		return state;
	}
	/**
	 * Import the route information from the file named route.csv.
	 * @return The list of the routes 
	 */
	public static ArrayList<Route> RouteImport(){
		ArrayList<Route> list = new ArrayList<Route>();
		File f = new File("structure/route.csv");
		StringTokenizer st;
		long id;
		int stationNum;
		String[] stationName;
		int[] stationInterval; 
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			br.readLine();//except the first line
			String temp = br.readLine();
			while(temp != null){
				st = new StringTokenizer(temp, ",");
				id = Long.parseLong(st.nextToken());
				
				//System.out.println(id);
				
				stationNum = Integer.parseInt(st.nextToken());
				stationName = new String[stationNum];
				stationInterval = new int[stationNum - 1];
				for(int i=0;i<stationNum;i++){
					stationName[i] = st.nextToken();
				}
				for(int i=0;i<stationNum-1;i++){
					stationInterval[i] = Integer.parseInt(st.nextToken());
				}
				
				list.add(new Route(id, false, stationName,stationInterval));
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

		return list;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		result += "ID:" + this.ID + "\n";
		
		result += "StationName:";
		for(int i=0;i<this.stationName.length;i++){
			result += stationName[i] + " ";
		}
		result += "\n";
		
		result += "StationInterval:";
		for(int i=0;i<this.stationInterval.length;i++){
			result += stationInterval[i] + " ";
		}
		result += "\n";
		
		return result;
	}
}
