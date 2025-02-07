package homework.q3;

public class Calculator
{
    private float initial;
    private float addition;
    private float rate;
    private float years;


    public Calculator(float initial, float addition, float rate, float years)
    {
        this.initial = initial;
        this.addition = addition;
        this.rate = rate;
        this.years = years;
    }



    public int getAmount()
    {
        float x = (initial + (100*(addition/rate)));
        float y = (float)(Math.pow(1+(rate/100),years));
        float z = 100*(addition/rate);


        return Math.round(x*y-z);
    }


}
