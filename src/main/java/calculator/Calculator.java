package calculator;

import entity.Users;
import shoppingCart.ShoppingCart;

public class Calculator 
{
    ShoppingCart shop;
    
   
    public boolean calculatePrice(Users u) throws Exception
    {
        if(u.getBalance() >= u.getCart().getTotalPrice()) return true;
        else throw new Exception("Insufficient funds");
    }
}
