package software;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]){
		ArrayList<Route> route = Route.RouteImport();
//		for(int i=0;i<route.size();i++){
//			System.out.println(route.get(i));
//		}
		LinkedList<Train> train = Train.TrainImport();
//		for(int i=0;i<train.size();i++){
//			System.out.println(train.get(i));
//		}
		LinkedList<Driver> driver = Driver.DriverImport();
//		for(int i=0;i<driver.size();i++){
//			System.out.println(driver.get(i));
//		}
		
		MainFrame mf = new MainFrame(route, train, driver);
		
	}
}
