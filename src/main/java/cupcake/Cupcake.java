package cupcake;

public class Cupcake {

    private Cake_toppings topping;
    private Cake_bottoms bottom;
    private int totalPrice;

    private int amount;

    public int getAmount() {
        return amount;
    }
    
    

    public Cupcake(Cake_toppings topping, Cake_bottoms bottom, int amount) {
        this.topping = topping;
        this.bottom = bottom;
        this.amount = amount;
    }
    
    public Cupcake(int bottomPrice,int toppingPrice, int amount){
        this.amount = amount;
    }

    public int getTotalPrice() 
    {
        return bottom.getBottom_price() + topping.getTopping_price();
    }
        
    public Cake_toppings getTopping() 
    {
        return topping;
    }

    public Cake_bottoms getBottom() 
    {
        return bottom;
    }
    
    @Override
    public String toString() 
    {
        return "\n" + topping + bottom + "Price: " + getTotalPrice();
    }
    
}
