package allClasses.util;

import sim.engine.SimState;
import sim.engine.Steppable;
import java.text.DecimalFormat;

/**
 * Diese Klasse misst die Zeit zwischen {@link #STEPDISTANCE} Schritten.
 * 
 * @author j0mc0021
 */
@SuppressWarnings("serial")
public class TimeAnalyser implements Steppable
{
    /**
     * Auf <code>false</code> setzen um Zeitangaben auszuschalten.
     */
    private final boolean ENABLE_TIMEANALYSIS = true;
    /**
     * Abstand der Zeitmessungen.
     */
    private final int     STEPDISTANCE	= 1000000;

    private long	  currentTime;

    @Override
    public void step(SimState state)
    {
	if (ENABLE_TIMEANALYSIS)
	{
	    if ((state.schedule.getSteps() % STEPDISTANCE) == 0)
	    {
		ConsoleLog.print("zeit für "
		+ new java.text.DecimalFormat("###,###").format(STEPDISTANCE) + " Schritte: "
		+ (System.currentTimeMillis() - getCurrentTime()) + " ms");
		actualiseCurrentTime();
	    }
	}
    }

    private long getCurrentTime()
    {
	return currentTime;
    }

    private void actualiseCurrentTime()
    {
	this.currentTime = System.currentTimeMillis();
    }
}