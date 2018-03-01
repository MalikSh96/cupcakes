package calculator;

import entity.Users;
import shoppingCart.ShoppingCart;

public class Calculator 
{
    ShoppingCart shop;
    
   
    public double calculatePrice(Users bal)
    {
        if(bal.getBalance() >= bal.getCart().getTotalPrice()) return bal.getBalance() - bal.getCart().getTotalPrice();
        else throw new IllegalStateException("Insufficient funds");
    }
}
