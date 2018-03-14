package calculator;

import entity.Users;
import shoppingCart.ShoppingCart;

public class Calculator 
{
    ShoppingCart shop;
    
    /**
     * 
     * @param u
     * Objective: Check if the user's balance is greater than the amount
     * @return true if balance is greater otherwise and exception is thwrown
     * @throws Exception 
     */
    public boolean calculatePrice(Users u) throws Exception
    {
        if(u.getBalance() >= u.getCart().getTotalPrice()) return true;
        else throw new Exception("Insufficient funds");
    }
}
