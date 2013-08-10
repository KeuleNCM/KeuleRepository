package allClasses;

import sim.engine.SimState;
import allClasses.util.TimeAnalyser;

@SuppressWarnings("serial")
public class Simulation extends SimState
{

    private City   city;
    private Person person;

    public Simulation(long seed)
    {
	super(seed);
    }

    @Override
    public void start()
    {
	super.start();

	this.city = new City(4, 4);

	this.schedule.scheduleRepeating(new Person(this.city, 2.0, 2.2));

	this.addTimeAnalyser();
    }

    private void addTimeAnalyser()
    {
	this.schedule.scheduleRepeating(new TimeAnalyser());
    }

    public static void main(String[] args)
    {
	doLoop(Simulation.class, args);
	System.exit(0);
    }
}
