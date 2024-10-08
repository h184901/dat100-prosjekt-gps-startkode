package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		//"2017-08-13T08:52:26.000Z"
		
		int secs;
		int hr, min, sec;
		
		String timer = timestr.substring(11,13);
		hr = Integer.parseInt(timer);
		
		String minutter = timestr.substring(14,16); 
		min = Integer.parseInt(minutter);
		
		String sekunder = timestr.substring(17,19);
		sec = Integer.parseInt(sekunder);
		
		secs = (hr *3600) + (min*60) + sec;
	
		return secs;
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;
		
		int tid = toSeconds(timeStr);
		double breddegrad = Double.parseDouble(latitudeStr);
		double lengdegrad = Double.parseDouble(longitudeStr);
		double hoyde = Double.parseDouble(elevationStr);
		
		gpspoint = new GPSPoint(tid, breddegrad, lengdegrad, hoyde);
		
		return gpspoint;
	
	}
	
}
