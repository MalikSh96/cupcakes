package calculator;

import entity.Users;
import shoppingCart.ShoppingCart;

public class Calculator 
{
    ShoppingCart shop;
    
   
    public boolean calculatePrice(Users u)
    {
        return u.getBalance() >= u.getCart().getTotalPrice();
    }
}
