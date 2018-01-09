package simulatore.src.Controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import simulatore.src.Model.Robot;
import model.Signal;


public class SimulatoreTwo {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException{

		start(args[0], args[1], args[2]);

	}
	
	private static void start(String numRob,String numSegn,String numsegnaliMinMedio ) throws UnknownHostException, IOException, InterruptedException {
		
		/*
		 * 		inizializzo variabili e costanti
		 * 
		 */
		
		Random rand = new Random();
		
		
		final int numRobot = Integer.parseInt(numRob);
		final int tipiSegnali =Integer.parseInt(numSegn);
		final int numSegnaliMinuto = Integer.parseInt(numsegnaliMinMedio);
		
		int percentageSignal=numSegnaliMinuto/100;		
		int numSegnaliMinutoMin= numSegnaliMinuto+(percentageSignal*5);
		int	numSegnaliMinutoMax= numSegnaliMinuto-(percentageSignal*5);
		int signalsNow=numSegnaliMinuto;
		
		ArrayList<Robot> robot = new ArrayList<Robot>();
		ArrayList<Signal> signals = new ArrayList<Signal>();
		
		boolean[] segnali = new boolean[tipiSegnali];
		boolean run=true;
		
		long timeStart = System.currentTimeMillis();
		long timeGen=System.currentTimeMillis();
		long overHead=0;
		double timeSignal=0;
		
		/*
		 * 
		 * 
		 */
		
		
		// Popolo l'array "segnali" con tutti 1 (i robot sono inizialmente tutti up)
		for (int j = 0; j < tipiSegnali; j++) {
			segnali[j] = true;
		}
		
		
		// Popolo l'array "robot" di robot
		for (int i = 0; i < numRobot; i++) {
			robot.add(new Robot(i, i / 500, i / 5000, segnali));
		}
		
		/*
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		while(run) {
			timeStart=System.currentTimeMillis();
			signalsNow=rand.nextInt((numSegnaliMinutoMax-numSegnaliMinutoMin)+1)+numSegnaliMinutoMin;
			
			/*
			 * Genero i segnali, randomizzando l'ammontare del 5% dal dato ricevuto
			 */
			
			for (int k = 0; k < signalsNow ; k++) {
				Robot r = robot.get((new Random()).nextInt(robot.size()));
				int indiceSegnale = new Random().nextInt(segnali.length);
				r.setSegnale(indiceSegnale);
				Signal s;
				if (r.getSegnali(indiceSegnale)) {
					s = new Signal(r.getIdRobot(), r.getIdCluster(), r.getIdArea(), "up",
							(long) (System.currentTimeMillis() + (0.2 * k)));
				} else {
					s = new Signal(r.getIdRobot(), r.getIdCluster(), r.getIdArea(), "down",
							(long) (System.currentTimeMillis() + (0.2 * k)));
				}
				signals.add(s);
			}
			
			/*
			 * 
			 */
			timeGen=System.currentTimeMillis();
			overHead= timeGen-timeStart;
			timeSignal= (60000-overHead)/signalsNow;
			
			
			/*
			 * 
			 * 
			 */
			
			Socket socket = new Socket("127.0.0.1", 9090);
			System.out.println("Connection	established");
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
			try {
				for (int i = 0; i < numSegnaliMinuto; i++) {
					busywait((long) (timeSignal*1000000));
					outputStream.writeObject(signals.get(i));
					outputStream.flush();
				}
			} catch (NoSuchElementException e) {
				System.out.println("Connection	closed");
			} finally {
				socket.close();
			}
			
			
		}
		
	}
	
	
	public static void busywait(long nanosecs) {
		final long INTERVAL = nanosecs;
	    long start = System.nanoTime();
	    long end=0;
	    do{
	        end = System.nanoTime();
	    }while(start + INTERVAL >= end);
	    System.out.println(end - start);
	}
	
	

}
