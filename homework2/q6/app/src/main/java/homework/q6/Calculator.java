package homework.q6;

public class Calculator
{
   private int number;

    public Calculator(int number)
    {
        this.number = number;
    }


    // This method checks to see if a number is prime or not
    public boolean isPrime()
    {
        if (number <= 1)
        {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0)
            {
                return true;
            }
        }
        return false;
    }

}
