package allClasses.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Dient der Ausgabe auf die Console. Erspart später suchen und löschen von
 * syso-Befehlen.
 *
 * @author j0mc0021
 *
 */
public class ConsoleLog {

	/**
	 * Diese Variable steuert die Ausgabe der ConsoleLog-Klasse.
	 */
	private final static boolean ENABLE_LOGGING = true;

	public static void print(String string) {

		if (ConsoleLog.ENABLE_LOGGING) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Date currentDate = new Date(System.currentTimeMillis());
	    System.out.println(dateFormat.format(currentDate) + "  " + string);
		}
	}



}
