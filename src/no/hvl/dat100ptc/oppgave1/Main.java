package no.hvl.dat100ptc.oppgave1;

public class Main {

	public static void main(String[] args) {
		
		GPSPoint nyGPS = new GPSPoint(1, 2.0, 3.0, 5.0);
		nyGPS.getTime();
		nyGPS.setTime(2);
		System.out.println(nyGPS.toString());
	}

}
