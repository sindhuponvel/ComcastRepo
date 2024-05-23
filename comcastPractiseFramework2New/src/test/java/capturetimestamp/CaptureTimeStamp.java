package capturetimestamp;

import java.util.Date;

public class CaptureTimeStamp {
	public static void main(String[] args) {
//		Date dateObj = new Date();
//		System.out.println(dateObj.toString());
//		
//		String time = new Date().toString();
//		System.out.println(time);
		
		String time = new Date().toString().replace(":","_").replace(" ","_");
		System.out.println(time);
		
	}

}
