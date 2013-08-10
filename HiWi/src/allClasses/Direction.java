package allClasses;

import java.util.LinkedList;
import java.util.List;
import allClasses.util.ConsoleLog;

public enum Direction
{
    UP, DOWN, LEFT, RIGHT;

    /**
     * Berechnet eine andere Richtung als die angegebene(n). <br>
     * Die Angabe keiner Richtung ist ebenfalls möglich, dann wird eine
     * beliebige Richtung ausgegeben.
     * 
     * @param blockedDirection Die gesperrte(n) Richtung(en).
     * @return eine neue Richtung
     */
    public static Direction calculateAnyDirectionBut(Direction[] blockedDirection)
    {
	if (blockedDirection.length == 4)
	{
	    throw new IllegalArgumentException("Too many blocked directions.");
	}

	List<Direction> directionList = new LinkedList<Direction>();

	directionList.add(UP);
	directionList.add(DOWN);
	directionList.add(LEFT);
	directionList.add(RIGHT);

	for (int i = 0; i < blockedDirection.length; i++)
	{
	    directionList.remove(blockedDirection[i]);
	}
	ConsoleLog.print("Größe der Richtungsliste " + directionList.size());

	double random = Math.random() * directionList.size();
	if (random < 1)
	{
	    return directionList.get(0);
	}
	else if (random < 2)
	{
	    return directionList.get(1);
	}
	else if (random < 3)
	{
	    return directionList.get(2);
	}
	else
	    return directionList.get(3);
    }

    /**
     * @see #calculateAnyDirectionBut(Direction[])
     * @return
     */
    public static Direction calculateAnyDirectionBut()
    {
	return calculateAnyDirectionBut(null);
    }

}
