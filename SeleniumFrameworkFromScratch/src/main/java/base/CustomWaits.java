package base;

public class CustomWaits {
	
	public static void staticWait(int sleepTimeInSeconds) {
		try {
			Thread.sleep(sleepTimeInSeconds * 1000L);//1000 milliseconds or 1 second
		}
		catch(InterruptedException e){
			throw new RuntimeException(e);
			
		}
	}

}
