package utils;

import java.util.Random;

public class AppUtils {

	  
	public static int getRandomId() {
	        int id = 0;
	        Random random = new Random();
	      
//	        while(id <1084) {
//	        	return random.nextInt();
//	        }
	        id = (int) random.nextInt(1084);
	        return id;
	    }
}
