package cupcake;

public class Cupcake {

    private Cake_toppings topping;
    private Cake_bottoms bottom;
    private int bottomPrice, toppingPrice;

    public Cupcake(Cake_toppings topping, Cake_bottoms bottom, int toppingPrice, int bottomPrice) {
        this.topping = topping;
        this.bottom = bottom;
        this.bottomPrice = bottomPrice;
        this.toppingPrice = toppingPrice;
    }

    public int getBottomPrice() {
        return bottomPrice;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }
    
    @Override
    public String toString() {
        return "Cupcake{" + "topping=" + topping + ", bottom=" + bottom + ", bottomPrice=" + bottomPrice + ", toppingPrice=" + toppingPrice + '}';
    }
    
}
