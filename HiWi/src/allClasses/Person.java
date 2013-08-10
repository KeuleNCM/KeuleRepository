package allClasses;

import java.util.List;
import java.util.LinkedList;

import sim.engine.SimState;
import sim.engine.Steppable;

@SuppressWarnings("serial")
public class Person implements Steppable
{
    /**
     * X-Koordinate beginnend bei 0
     */
    private double       abcissae;
    /**
     * Y-Koordinate beginnend bei 0
     */
    private double       ordinate;
    /**
     * Stadt in der Person aufhält/bewegt
     */
    private City	 city;
    /**
     * Geschwindigkeit in m/s
     */
    private final double SPEED = 5 / 3.6;
    /**
     * Richtung in die sich die Person bewegt
     */
    private Direction    direction;

    public Person(City city, double abcissae, double ordinate)
    {

	if ((abcissae % 1 != 0) && (ordinate % 1 != 0))
	{
	    throw new IllegalArgumentException(
	    "One of the coordinates must be exactly on the lines of the grid.");
	}
	this.abcissae = abcissae;
	this.ordinate = ordinate;
	this.city = city;
	this.direction = calculateValidDirection();
    }

    /**
     * Diese Methode berechnet alle aktuell ungültige Richtungen. Am Stadtrand
     * unzulässig werden beachtet.
     * 
     * @return ein Array aller ungültigen Richtungen
     */
    private Direction[] calculateBlockedDirections()
    {
	List<Direction> blockedDirections = new LinkedList<Direction>();

	if (abcissae == 0)
	{
	    blockedDirections.add(Direction.LEFT);
	}
	if (abcissae == city.getWidth())
	{
	    blockedDirections.add(Direction.RIGHT);
	}
	if (ordinate == 0)
	{
	    blockedDirections.add(Direction.DOWN);
	}
	if (ordinate == city.getHeight())
	{
	    blockedDirections.add(Direction.UP);
	}
	return ((Direction[]) blockedDirections.toArray(new Direction[blockedDirections.size()]));
    }

    /**
     * Berechnet mit gegebenen gesperrten Richtungen eine gültige neue Richtung.
     * 
     * @return zulässige Richtung
     */
    private Direction calculateValidDirection()
    {
	return Direction.calculateAnyDirectionBut(calculateBlockedDirections());
    }

    @Override
    public void step(SimState state)
    {
	// TODO Person bewegt sich in Stadt
	// Status: P befindet sich auf koordinaten und möchte in ihre Richtung
	// laufen

	// TODO grafische Darstellung erstellen
	// TODO Person kann andere anstecken
    }
}
