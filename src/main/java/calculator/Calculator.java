package calculator;

import cupcake.Cake_bottoms;
import cupcake.Cake_toppings;
import entity.Users;

public class Calculator 
{
    private Users u;
    private Cake_bottoms cb;
    private Cake_toppings ct;
   
    public double calculatePrice(int total)
    {
        total = u.getBalance() - cb.getBottom_price() - ct.getTopping_price();
        return total;
    }
    
    public double calculatePrice(int user_balance, int bottom_price, int topping_price)
    {
        return user_balance - bottom_price - topping_price;
    }
}
