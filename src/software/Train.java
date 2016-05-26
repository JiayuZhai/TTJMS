package software;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * Train Class
 * @author Di Li
 *
 */
public class Train {
	/**
	 * Train ID
	 */
	private long trainID;
	/**
	 * Train Name
	 */
	private String trainName;
	/**
	 * The statement of the train.
	 * It must be the following state:
	 * 		TRAIN_AVAILABLE
	 * 		TRAIN_WAY
	 * 		TRAIN_STOP
	 */
	private int statement;
	public static final int TRAIN_AVAILABLE = 1;
	public static final int TRAIN_WAY = 2;
	public static final int TRAIN_STOP = 3;
	
	
	public long getTrainID() {
		return trainID;
	}
	public void setTrainID(long trainID) {
		this.trainID = trainID;
	}
	public int getStatement() {
		return statement;
	}
	public void setStatement(int statement) {
		this.statement = statement;
	}

	/**
	 * Construct method
	 * @param id The train ID
	 * @param name The Train name
	 */
	public Train(long id, String name) {
		// TODO Auto-generated constructor stub
		this.trainID = id;
		this.trainName = name;
		this.statement = Train.TRAIN_AVAILABLE;
		
	}

	@Override
	public String toString() {
		return "Train ID:" + trainID + "\nTrain Name:" + trainName + "\nTrain State:" +statement + " ";
	}

	/**
	 * Import the Train list for the file train.csv.
	 * 
	 * @return The list of trains
	 */
	public static LinkedList<Train> TrainImport() {
		// TODO Auto-generated method stub
		LinkedList<Train> list = new LinkedList<Train>();
		File f = new File("structure/train.csv");
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
				
				list.offer(new Train(id, Name));
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

