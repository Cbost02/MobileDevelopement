package homework1.q2;

public class Calculator
{
    private float price;
    private boolean warranty;
    private boolean insurance;
    private String shipping;

    // Constructor
    public Calculator(float price, boolean warranty, boolean insurance, String shipping)
    {
        this.price = price;
        this.warranty = warranty;
        this.insurance = insurance;
        this.shipping = shipping;
    }


    public float getTotal()
    {
        float total = price;

        // Check if the user purchased warranty
        if(warranty)
        {
            total += (0.10 * price);
        }

        // Check if the user purchased insurance
        if(insurance)
        {
            total += (price * 0.05);
        }

        // Check for Next, Second, or Normal Day shipping
        if(shipping.equalsIgnoreCase("Next Day"))
        {
            total += 20;
        }
        else if(shipping.equalsIgnoreCase("Second Day"))
        {
            total += 10;
        }
        else if(shipping.equalsIgnoreCase("Normal Day"))
        {
            total += 5;
        }
        return total;
    }

}
