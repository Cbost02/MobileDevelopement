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
        double rateDecimal = rate / 100.0;
        double growthFactor = Math.pow(1 + rateDecimal, years);

        double amount = initial * growthFactor + addition * ((growthFactor - 1) / rateDecimal);

        return (int)Math.round(amount);
    }


}
