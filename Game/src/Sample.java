import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Sample {

	static String getCurrentTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static void main(String[] args) {
		System.out.println(getCurrentTime());
	}

}
