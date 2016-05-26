package software;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * The main frame of the software
 * @author zhai
 * 
 */
public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The train information showing on the frame.
	 */
	public JTextArea ta_train_info = new JTextArea("Train infomation");
	/**
	 * The driver information showing on the frame.
	 */
	public JTextArea ta_driver_info = new JTextArea("Driver information");
	/**
	 * The button to control the train start.
	 */
	public JButton b_train_start = new JButton("Start"); 
	/**
	 * The button to control the train stop.
	 */
	public JButton b_train_stop = new JButton("Stop");
	/**
	 * The button to show the timetable of the operating journey.
	 */
	public JButton b_train_timetable = new JButton("Timetable");
	/**
	 * The number of the available trains currently showing on the frame.
	 */
	public JTextArea ta_train_num = new JTextArea("Train number available:");
	/**
	 * The number of the available drivers currently showing on the frame.
	 */
	public JTextArea ta_driver_num = new JTextArea("Driver number available:");
	/**
	 * The button to assign a new journey.
	 */
	public JButton b_journey_assgin = new JButton("Journey Assginment");
	public JTextArea ta_running_info = new JTextArea("Running Infomation");
	/**
	 * The number of the available trains currently.
	 */
	private int trainAvailable;
	/**
	 * The number of the available drivers currently.
	 */
	private int driverAvailable;
	/**
	 * The route list hold for the system.
	 */
	private ArrayList<Route> route;
	/**
	 * The train list hold for the system.
	 */
	private LinkedList<Train> train;
	/**
	 * The driver list hold for the system.
	 */
	private LinkedList<Driver> driver;
	/**
	 * The information list of the running journey 
	 */
	public LinkedList<RunInfo> runInfo = new LinkedList<RunInfo>();
	/**
	 * The textArea for route list
	 */
	private ArrayList<RoutePanel> taList = new ArrayList<RoutePanel>();
	/**
	 * The Listener for b_train_timetable button to create dialog to show the timetable
	 */
	private ActionListener timetableListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JPanel mess = j_Op.getTimeTable(true);
			JOptionPane.showMessageDialog(MainFrame.this, 
					mess,
					"Timetable", 
					JOptionPane.INFORMATION_MESSAGE, 
					new Icon() {
				
						@Override
						public void paintIcon(Component c, Graphics g, int x, int y) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public int getIconWidth() {
							// TODO Auto-generated method stub
							return 0;
						}
						
						@Override
						public int getIconHeight() {
							// TODO Auto-generated method stub
							return 0;
						}
					});
		}
	};
	/**
	 * The journey which the user clicked
	 */
	private Journey j_Op = null;
	
	/**
	 * Construct method
	 * 
	 * @param route Initial the route list
	 * @param train2 Initial the train list
	 * @param driver2 Initial the driver list
	 */
	public MainFrame(ArrayList<Route> route, LinkedList<Train> train2, LinkedList<Driver> driver2){
		this.route = route;
		this.train = train2;
		this.driver = driver2;
		
		for(int i=0;i<route.size();i++){
			taList.add(new RoutePanel(route.get(i)));
		}
		trainAvailable = this.train.size();
		driverAvailable = this.driver.size();
		
		this.setTitle("TTJMS");
		this.setLocation(300, 200);
		this.setSize(800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		FlowLayout mainLayout = new FlowLayout(FlowLayout.LEFT,0,0);
		//GridLayout mainLayout = new GridLayout(1,3,0,0);
		this.setLayout(mainLayout);
		this.setLeftPart();
		
		this.b_train_start.setEnabled(false);
		this.b_train_stop.setEnabled(false);
		this.b_train_timetable.setEnabled(false);
		this.ta_train_info.setEditable(false);
		this.ta_driver_info.setEditable(false);
		this.ta_train_num.setEditable(false);
		this.ta_driver_num.setEditable(false);
		this.ta_running_info.setEditable(false);
//		this.ta_running_info.setLineWrap(true);
		
		this.setRightPart();
		this.setRunningInfo();
		
		this.setUndecorated(true);//transparent frame 
		
		this.setVisible(true);
	}
	/**
	 * Set the Running info part
	 */
	private void setRunningInfo() {
		// TODO Auto-generated method stub
		JPanel runningInfo = new JPanel();
		runningInfo.setPreferredSize(new Dimension((int) (this.getWidth() * 0.2), this.getHeight()));
		runningInfo.setBorder(BorderFactory.createTitledBorder("Running information"));
		ta_running_info.setSize(runningInfo.getWidth(), 0);
		runningInfo.add(this.ta_running_info);
		this.getContentPane().add(runningInfo);
	}
	/**
	 * Setting the LeftPart.
	 */
	public void setLeftPart(){
		JPanel monitor = new JPanel();
		monitor.setPreferredSize(new Dimension((int) (this.getWidth() * 0.4), this.getHeight()));
		monitor.setBorder(BorderFactory.createTitledBorder("Monitor"));
		monitor.setLayout(new GridLayout(route.size(), 1,5,5));
		for(int i=0;i<taList.size();i++){
			//taList.get(i).setText(taList.get(i).routeInfo());
			
			taList.get(i).addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					MainFrame.this.j_Op = ((RoutePanel)e.getComponent()).getJ();
					if(j_Op != null){
						if(j_Op.getTrainID().getStatement()!=Train.TRAIN_WAY)
							b_train_start.setEnabled(true);
						else
							b_train_stop.setEnabled(true);
						b_train_timetable.setEnabled(true);
					}
					else{
						b_train_start.setEnabled(false);
						b_train_stop.setEnabled(false);
						b_train_timetable.setEnabled(false);
					}
					MainFrame.this.changeInformation(j_Op);
				}
			});
			monitor.add(taList.get(i));
		}
		this.getContentPane().add(monitor);
	}
	/**
	 * When Click the context of a route, it will show the information of the train and driver on this route.
	 * @param j  the journey need to change information
	 */
	public void changeInformation(Journey j) {
		// TODO Auto-generated method stub
		if(j!=null){
			this.ta_train_info.setText("" + j.getTrainID().toString());
			this.ta_driver_info.setText("" + j.getDriverID().toString());
		}
		else{
			this.ta_train_info.setText("No Train on this route");
			this.ta_driver_info.setText("No Driver on this route");
		}
	}
	/**
	 * Setting the RightPart.
	 */
	public void setRightPart(){
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension((int) (this.getWidth() * 0.4), this.getHeight()));
		right.setLayout(new GridLayout(2, 1,5,5));
		this.setUpRight(right);
		this.setDownRight(right);
		
		this.getContentPane().add(right);
	}
	/**
	 * Setting the UpRightPart.
	 * @param right the panel it belongs to
	 */
	public void setUpRight(JPanel right){
		JPanel upRight = new JPanel();
		upRight.setBorder(BorderFactory.createTitledBorder("Journey Info"));
		upRight.setLayout(new GridLayout(3, 1,5,5));
		upRight.add(this.ta_train_info);
		upRight.add(this.ta_driver_info);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 3,5,5));
		this.b_train_start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				j_Op.getRunningInterf().offset += (new Date()).getTime() - j_Op.getRunningInterf().stopTime.getTime();
				j_Op.getRunningInterf().stopTime = null;
				j_Op.getRunningInterf().state = true;
				j_Op.getTrainID().setStatement(Train.TRAIN_WAY);
				b_train_start.setEnabled(false);
				b_train_stop.setEnabled(true);
			}
		});
		buttons.add(this.b_train_start);
		this.b_train_stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				j_Op.getRunningInterf().stopTime = new Date();
				j_Op.getRunningInterf().state = false;
				j_Op.getTrainID().setStatement(Train.TRAIN_STOP);
				b_train_start.setEnabled(true);
				b_train_stop.setEnabled(false);
			}
		});
		buttons.add(this.b_train_stop);
		
		this.b_train_timetable.addActionListener(timetableListener);
		buttons.add(this.b_train_timetable);
		
		upRight.add(buttons);
		
		right.add(upRight);
	}
	/**
	 * Setting the DownRightPart.
	 * @param right the panel it belongs to 
	 */
	public void setDownRight(JPanel right){
		JPanel downRight = new JPanel();
		downRight.setBorder(BorderFactory.createTitledBorder("Assignment Info"));
		downRight.setLayout(new GridLayout(1, 2,5,5));
		
		JPanel textAreas = new JPanel();
		textAreas.setLayout(new GridLayout(2, 1,5,5));
		this.ta_train_num.setText("Train Available:" + trainAvailable);
		textAreas.add(this.ta_train_num);
		this.ta_driver_num.setText("Driver Available:" + driverAvailable);
		textAreas.add(this.ta_driver_num);
		
		downRight.add(textAreas);
		this.b_journey_assgin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Component c = ((JButton)(e.getSource())).getParent().getParent().getParent();
				if(trainAvailable == 0 || driverAvailable == 0)
					JOptionPane.showInternalConfirmDialog(c,"No enough Train or Driver, Please wait a time!");
				else{
					//assign a journey by create a new frame and choose routes.
					RouteSelectFrame rsf = new RouteSelectFrame(MainFrame.this, MainFrame.this.route);
				}
			}
		});
		downRight.add(this.b_journey_assgin );
		right.add(downRight);
	}
	/**
	 * When click the assign journey button, it will select a train and a driver to create the journey.
	 * 
	 * @param result The route the manager choose for the journey
	 */
	public void addJourney(int result) {
		// TODO Auto-generated method stub
		//System.out.println(result);
		Train t_j = train.poll();
		t_j.setStatement(Train.TRAIN_WAY);
		Driver d_j = driver.poll();
		d_j.setStatement(Driver.DRIVER_WAY);
		Date d = new Date();
		Journey j = new Journey(t_j,d_j,route.get(result-1),d,50);
		this.updateRoute(result,j,true);
		this.updateAvailable();
		JourneyRun target = new JourneyRun(j, MainFrame.this);
		j.setRunningInterf(target);
		
		RunInfo running = new RunInfo(j);
		this.runInfo.add(running);
		
		Thread run = new Thread(target);
		run.start();
		
		Journey.log(j);
		
	}
	/**
	 * Update the available number of train and driver.
	 */
	private void updateAvailable() {
		// TODO Auto-generated method stub
		this.ta_train_num.setText("Train Available:" + train.size());
		this.ta_driver_num.setText("Driver Available:" + driver.size());
	}
	/**
	 * Add the journey to the route.
	 * @param result The route which has been chose
	 * @param j The journey
	 */
	private void updateRoute(int result, Journey j, boolean stat) {
		// TODO Auto-generated method stub
		if(stat){
			this.route.get(result - 1).setState(true);
			this.taList.get(result - 1).setJ(j);
		}
		else{
			this.route.get(result - 1).setState(false);
			this.taList.get(result -1).setJ(null);
		}
	}
	/**
	 * Changing the running info part by StationDis message
	 * @param sd The message of location
	 * @param j The operation journey
	 */
	public void runningChange(StationDis sd, Journey j) {
		// TODO Auto-generated method stub
		this.ta_running_info.setText("");
		for(int i=0;i<this.runInfo.size();i++){
			if(this.runInfo.get(i).trainID == j.getTrainID().getTrainID()){
				if(this.runInfo.get(i).direction == 0){//forward
					if(sd.station != j.getRouteID().stationName.length - 1)	
						this.runInfo.get(i).nextStation = j.getRouteID().stationName[sd.station + 1];
				}
				else{
					if(sd.station != -1)
						this.runInfo.get(i).nextStation = j.getRouteID().stationName[sd.station];
				}
			}
			this.ta_running_info.append(this.runInfo.get(i).toString() + "\n");
		}
		int id = (int)(j.getRouteID().getID());
		this.taList.get(id - 1).setPBar(sd);
	}
	/**
	 * Finish the journey
	 * @param j The journey
	 */
	public void finishJouney(Journey j) {
		// TODO Auto-generated method stub
		this.updateRoute((int)(j.getRouteID().getID()), null,false);
		j.getTrainID().setStatement(Train.TRAIN_AVAILABLE);
		train.offer(j.getTrainID());
		j.getDriverID().setStatement(Driver.DRIVER_AVAILABLE);
		driver.offer(j.getDriverID());
		this.updateAvailable();
		for(int i=0;i<this.runInfo.size();i++){
			if(this.runInfo.get(i).trainID == j.getTrainID().getTrainID()){
				this.runInfo.remove(i);
			}
		}
		this.ta_running_info.setText("");
		for(int i=0;i<this.runInfo.size();i++){
			this.ta_running_info.append(this.runInfo.get(i).toString() + "\n");
		}
		
		if(j.equals(this.j_Op)){
			this.changeInformation(null);
			this.b_train_start.setEnabled(false);
			this.b_train_stop.setEnabled(false);
			this.b_train_timetable.setEnabled(false);
		}
		
	}
}