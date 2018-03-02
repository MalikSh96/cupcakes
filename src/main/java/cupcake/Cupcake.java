package cupcake;

public class Cupcake {

    private Cake_toppings topping;
    private Cake_bottoms bottom;
    private int bottomPrice, toppingPrice;
    private int amount;

    public Cupcake(Cake_toppings topping, Cake_bottoms bottom, int toppingPrice, int bottomPrice) {
        this.topping = topping;
        this.bottom = bottom;
        this.bottomPrice = bottomPrice;
        this.toppingPrice = toppingPrice;
    }
    
    public Cupcake(int bottomPrice,int toppingPrice, int amount){
        this.bottomPrice = bottomPrice;
        this.toppingPrice = toppingPrice;
        this.amount = amount;
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
