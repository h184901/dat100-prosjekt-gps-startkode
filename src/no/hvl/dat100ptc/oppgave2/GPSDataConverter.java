package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		String timer = timestr.substring(0,1);
		hr = Integer.parseInt(timer);
		
		String minutter = timestr.substring(9,11); 
		min = Integer.parseInt(minutter);
		
		String sekunder = timestr.substring(22,24);
		sec = Integer.parseInt(sekunder);
		
		secs = (hr *3600) + (min*60) + sec;
	
		return secs;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
}
