package cupcake;

public class Cupcake {

    private Cake_toppings topping;
    private Cake_bottoms bottom;
    private int bottomPrice, toppingPrice, totalPrice;

    public Cupcake(Cake_toppings topping, Cake_bottoms bottom, int toppingPrice, int bottomPrice) {
        this.topping = topping;
        this.bottom = bottom;
        this.bottomPrice = bottomPrice;
        this.toppingPrice = toppingPrice;
    }

    public int getTotalPrice() 
    {
        return bottomPrice + toppingPrice;
    }
        
    public Cake_toppings getTopping() {
        return topping;
    }

    public Cake_bottoms getBottom() {
        return bottom;
    }

    
    public int getBottomPrice() {
        return bottomPrice;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }
    
    @Override
    public String toString() 
    {
        return "\n" + topping + bottom + "Price: " + (bottomPrice + toppingPrice);
    }
    
}
