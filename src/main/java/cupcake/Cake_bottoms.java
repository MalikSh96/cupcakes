package cupcake;

public class Cake_bottoms 
{
    private String bottom;
    private int bottom_price;

    public Cake_bottoms() 
    {
        
    }
    
    public Cake_bottoms(String bottom, int bottom_price) 
    {
        this.bottom = bottom;
        this.bottom_price = bottom_price;
    }

    public String getBottom() 
    {
        return bottom;
    }

    public void setBottom(String bottom) 
    {
        this.bottom = bottom;
    }

    public int getBottom_price() 
    {
        return bottom_price;
    }

    public void setBottom_price(int bottom_price) 
    {
        this.bottom_price = bottom_price;
    }
}
