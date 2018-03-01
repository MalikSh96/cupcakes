package calculator;

import entity.Users;
import shoppingCart.ShoppingCart;

public class Calculator 
{
    ShoppingCart shop;
    
   
    public double calculatePrice(Users u)
    {
        if(u.getBalance() >= u.getCart().getTotalPrice()) return u.getBalance() - u.getCart().getTotalPrice();
        else throw new IllegalStateException("Insufficient funds");
    }
}
