package allClasses;

public class City
{
    /**
     * Breite der Stadt in 10m Schritten
     */
    private final int width;

    /**
     * Höhe der Stadt in 10m Schritten
     */
    private final int height;

    public City(int width, int height)
    {
	this.width = width;
	this.height = height;
}

    public int getWidth()
    {
	return this.width;
    }

    public int getHeight()
    {
	return this.height;
    }
}
