package software;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
/**
 * The panel class for display the route station by station
 * @author zhai
 * 
 */
public class RoutePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The route of the JTextArea.
	 */
	private Route r;
	/**
	 * The journey may on the route. When route has no train running, the journey is null
	 */
	private Journey j = null;
	/**
	 * The list of Progress Bar
	 */
	private ArrayList<JProgressBar> jpbl = new ArrayList<JProgressBar>();
	
	/**
	 * Construct method
	 * @param r The route
	 */
	public RoutePanel(Route r){
		super();
		this.setR(r);
		this.setLayout(new GridLayout(1, 2));
		for(int i=0;i<r.stationName.length;i++){
			JButton butt = new JButton(r.stationName[i]);
//			butt.setEnabled(false);
			butt.addActionListener(new ActionListener() {
				/*
				 * (non-Javadoc)
				 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
				 * We assumed that the information from the station is an remote communication 
				 * and it left as an interface
				 */
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JButton b_Op = (JButton)(e.getSource());
					String name = b_Op.getText();
					//the interface is here which can use a method called getStationInfo()
					String mess = "Get Information from Station " + name;
					JOptionPane.showMessageDialog(null, mess);
				}
			});
			this.add(butt);
			if(i<r.stationInterval.length){
				JProgressBar a = new JProgressBar(SwingConstants.HORIZONTAL);
				//a.setValue(20);
				jpbl.add(a);
				this.add(a);
			}
			
		}
	}
	public Route getR() {
		return r;
	}
	public void setR(Route r) {
		this.r = r;
	}
	public Journey getJ() {
		return j;
	}
	public void setJ(Journey j) {
		this.j = j;
	}
	/**
	 * According to the location message change the value of the progress bar.
	 * @param sd The location message
	 */
	public void setPBar(StationDis sd) {
		// TODO Auto-generated method stub
		if(sd.station == -1){
			jpbl.get(sd.station + 1).setValue(0);
			return;
		}
		if(sd.station == j.getRouteID().stationInterval.length){
			jpbl.get(sd.station - 1).setValue(100);
			return;
		}
		int value = (int)(((float)sd.displacement/j.getRouteID().stationInterval[sd.station]) * 100);
		if(sd.station != 0)
			jpbl.get(sd.station - 1).setValue(100);

		jpbl.get(sd.station).setValue(value);
	}
	
}
