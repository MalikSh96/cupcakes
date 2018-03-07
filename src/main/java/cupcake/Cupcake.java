package cupcake;

public class Cupcake {

    private Cake_toppings topping;
    private Cake_bottoms bottom;
    private int bottomPrice, toppingPrice, price;
    private int amount;

        public Cupcake(Cake_toppings topping, Cake_bottoms bottom, int toppingPrice, int bottomPrice, int amount) {
        this.topping = topping;
        this.bottom = bottom;
        this.bottomPrice = bottomPrice;
        this.toppingPrice = toppingPrice;
        this.amount = amount;
    }
    
    public Cupcake(Cake_toppings topping, Cake_bottoms bottom, int amount) {
        this.topping = topping;
        this.bottom = bottom;
        this.amount = amount;
    }

       public Cupcake(Cake_toppings topping, Cake_bottoms bottom, int price, int amount) {
        this.topping = topping;
        this.bottom = bottom;
        this.price = price;
        this.amount = amount;
    }
        
    public Cake_toppings getTopping() 
    {
        return topping;
    }

    public Cake_bottoms getBottom() 
    {
        return bottom;
    }

    public int getAmount() {
        return amount;
    } 
    
        public int getBottomPrice() {
        return bottomPrice;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }


     public int getTotalPrice() 
    {
        return bottom.getBottom_price() + topping.getTopping_price();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTopping(Cake_toppings topping) {
        this.topping = topping;
    }

    public void setBottom(Cake_bottoms bottom) {
        this.bottom = bottom;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString() 
    {
        return "\n" + "Bottom: " + bottom.toString() + " <br>Top: " + topping.toString() + "<br>Amount: " + amount;
    }
    
        public String toString2(String top, String bottom, int amount, int pris, int fullPrice) {  
        return "Topping: " + top + "<br>Bottom: " + bottom +  "<br>Amount: " + amount + "<br>Price: " + pris + "<br>Total Price: " + fullPrice;
    }
    
}
