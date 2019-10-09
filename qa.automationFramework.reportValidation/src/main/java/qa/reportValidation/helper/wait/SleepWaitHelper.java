package qa.reportValidation.helper.wait;

public class SleepWaitHelper {

	/**
	 * Thread.sleep method
	 * 
	 * @param milliSecond
	 */
	public static void sleep(long milliSecond) {
		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
