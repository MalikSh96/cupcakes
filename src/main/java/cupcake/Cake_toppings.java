package cupcake;

public class Cake_toppings 
{
    private String topping;
    private int topping_price;
    private int id;

    public Cake_toppings() 
    {
        
    }
   
    public Cake_toppings(String topping, int topping_price, int id) 
    {
        this.topping = topping;
        this.topping_price = topping_price;
        this.id = id;
    }

    public Cake_toppings(String topping, int topping_price) {
        this.topping = topping;
        this.topping_price = topping_price;
    }
    
    

    public String getTopping() 
    {
        return topping;
    }

    public void setTopping(String topping) 
    {
        this.topping = topping;
    }

    public int getTopping_price() 
    {
        return topping_price;
    }

    public void setTopping_price(int topping_price) 
    {
        this.topping_price = topping_price;
    }

    @Override
    public String toString() 
    {
        return "Topping: " + topping + " Topping price: " + topping_price + " Id: " + id + "\n";
    }
}
