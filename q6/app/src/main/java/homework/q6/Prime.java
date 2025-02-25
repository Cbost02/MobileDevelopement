package homework.q6;

public class Prime
{
    private boolean isPrime;

    public Prime()
    {
        isPrime = false;
    }


    // This method checks to see if a number is prime or set
    public boolean checkPrime(int num)
    {
        if (num <= 1)
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    // mutator method here is private for model structure reasons
    private void setPrime(boolean value)
    {
        isPrime = value;
    }





}
