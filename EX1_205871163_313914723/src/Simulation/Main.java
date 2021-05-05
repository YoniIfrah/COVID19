package Simulation;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;
import Country.Map;
import UI.MainWindow;
import UI.StatisticsWindow;


/**
 * main class whihc will run the simulation
 * @author coral
 *
 */
public class Main {

	//static data members
	static Map map;
	static MainWindow main;
	static StatisticsWindow statistics;
	
	
	//load function
	public static void load() throws InterruptedException {
		map = null;
		main = new MainWindow();

		while(main.getUserMenu().getIsON()) {
			// when getIsON true the user press play and the simulation start 
			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					//update all
					Main.updateAll();
					
				}
				
			});
			//inc by ont the clock
			Clock.nextTick();
			Thread.sleep(Main.getMain().getJSlider().getValue());
		}

	}

	//Get map
	public static Map getMap() {
		return map;
	}
	//Set map
	public static void setMap(Map map) {
		Main.map = map;
	}
	
	//get the main main
	public static MainWindow getMain() {
		return main;
	}
	
	//set statistiics window
	public static void setStatistics(StatisticsWindow statistics) {
		Main.statistics = statistics;
	}
	//get statistics window
	public static StatisticsWindow getStatistics() {
		return statistics;
	}
	
	//update all
	public static void updateAll() {
		
		Main.getStatistics().getModel().fireTableDataChanged();
		Main.getMain().getMapPanel().repaint();
		
	}
	
	
	
	
	
	//main function for all the system
	public static void main(String[] args) throws InterruptedException {

		load();
		
	}

}
