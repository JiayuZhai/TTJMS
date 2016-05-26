package software;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * The driver class
 * @author Yuxuan Zhang
 *
 */
public class Driver {
	/**
	 * The Driver ID.
	 */
	private long driverID;
	/**
	 * The Driver name.
	 */
	private String driverName;
	/**
	 * The statement of the driver.
	 * It must be the following statement:
	 * 		DRIVER_AVAILABLE
	 * 		DRIVER_WAY
	 */
	private int statement;
	public static final int DRIVER_AVAILABLE = 1;
	public static final int DRIVER_WAY = 2;
	

	
	public long getDriverID() {
		return driverID;
	}
	public void setDriverID(long driverID) {
		this.driverID = driverID;
	}
	
	public int getStatement() {
		return statement;
	}
	public void setStatement(int statement) {
		this.statement = statement;
	}
	
	/**
	 * Construct method
	 * @param id The ID of the Driver
	 * @param name The name of the Driver
	 */
	public Driver(long id, String name) {
		// TODO Auto-generated constructor stub
		this.driverID = id;
		this.driverName = name;
		this.statement = Driver.DRIVER_AVAILABLE;
		
	}
//	public void trainID(int tid) {
//		driverID = tid;
//	}
	public String toString() {
		return "Driver ID:" + driverID + "\nDriver Name:" + driverName + "\nDriver State:" +statement + " ";
	}
	/**
	 * The Driver control the train which he is controlling to start.
	 * @param j The journey hold the train and driver information
	 */
	public void trainOn(Journey j){
//		this.driverState = "on";
//		this.statement = "on";
//		System.out.println("A train is now on its tour.");
	}
	/**
	 * The Driver control the train which he is controlling to stop.
	 * @param j The journey hold the train and driver infomation
	 */
	public void trainOff(Journey j){
//		this.driverState = "off";
//		this.statement = "off";
//		System.out.println("The train is off its tour.");
	}
	/**
	 * Import the Driver list for the file driver.csv.
	 * 
	 * @return The list of drivers
	 */
	public static LinkedList<Driver> DriverImport() {
		// TODO Auto-generated method stub
		LinkedList<Driver> list = new LinkedList<Driver>();
		File f = new File("structure/driver.csv");
		StringTokenizer st;
		long id;
		String Name;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			br.readLine();//except the first line
			String temp = br.readLine();
			while(temp != null){
				st = new StringTokenizer(temp, ",");
				id = Long.parseLong(st.nextToken());
				Name = st.nextToken();
				
				list.offer(new Driver(id, Name));
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
	
}

