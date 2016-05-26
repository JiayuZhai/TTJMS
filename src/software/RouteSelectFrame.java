package software;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * The frame for the manager to select an available route to assign a journey.
 * @author zhai
 *
 */
public class RouteSelectFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The route list to choose.
	 */
	private JButton[] buttons;
	/**
	 * The parent frame.
	 */
	private MainFrame parent;
	/**
	 * Construct method.
	 * @param mainFrame The parent frame
	 * @param route The route list
	 */
	public RouteSelectFrame(MainFrame mainFrame, ArrayList<Route> route){
		this.parent = mainFrame;
		
		this.setTitle("Which route would you like to select?");
		this.setSize(mainFrame.getWidth() / 2, mainFrame.getHeight() / 2);
		this.setLocation(mainFrame.getX() + mainFrame.getWidth()/4 , mainFrame.getY() + mainFrame.getHeight()/4);
		buttons = new JButton[route.size()];
		

		this.setLayout(new GridLayout());
		for(int i=0;i<route.size();i++){
			if(route.get(i).state != true){
				buttons[i] = new JButton(route.get(i).getID() + "");
				
				buttons[i].addActionListener(al);
				
				this.getContentPane().add(buttons[i]);
			}
		}
		
		this.setUndecorated(true);
		this.setVisible(true);
	}
	/**
	 *  The Listener to listen for the selection and close the frame and back to parent frame again.
	 */
	ActionListener al = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String s = ((JButton)(e.getSource())).getText();
			int result = Integer.parseInt(s);
			parent.addJourney(result);
			RouteSelectFrame.this.setVisible(false);
		}
		
	};
	
	
}
