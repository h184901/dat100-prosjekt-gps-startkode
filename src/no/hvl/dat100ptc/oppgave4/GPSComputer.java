package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {

		double distance = 0;
		
		for (int i = 0; i < gpspoints.length - 1; i++) {
		
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
		}
		return distance;
	
	}

	public double totalElevation() {

		double elevation = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			
			double elevationdiffrence = gpspoints[i+1].getElevation() - gpspoints[i].getElevation();
		
			if (elevationdiffrence > 0) {
				
				elevation += elevationdiffrence;
			
			}
			}
		return elevation;
		
	}

	public int totalTime() {

		int time = 0;
		
		for (int i = 0; i < gpspoints.length - 1; i++) {
		
			int timediffrence = gpspoints[i+1].getTime() - gpspoints[i].getTime();
			
			if(timediffrence > 0) {
				
				time += timediffrence;
			}
		}
		return time;
	}
		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		
		for (int i = 0; i < speeds.length; i++) {
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		}
		return speeds;
		}
		
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		maxspeed = GPSUtils.findMax(speeds());
		
		return maxspeed;
		

	}

	public double averageSpeed() {

		double average = 0;
		
		double totalDistance = totalDistance();
		double totalTime = totalTime();
		
		average = totalDistance/totalTime;
		
		return average;
}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;		
		double speedmph = speed * MS;
		
		if (speedmph < 10) {
			met = 4.0;
		}else if (speedmph < 12) {
			met = 6.0;
		}else if (speedmph < 14) {
			met = 8.0;
		}else if (speedmph < 16) {
			met = 10.0;
		}else if (speedmph < 18) {
			met = 12.0;
		}else {
			met = 16.0;
		}
		
		double t = secs/3600;
		
		kcal = met * weight * t; 

		return kcal;
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

}
