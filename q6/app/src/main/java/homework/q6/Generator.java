package homework.q6;

import java.util.*;

public class Generator
{
    private int number1;
    private int number2;
    private String operator;
    private int answer;
    private int correct;
    private int total;
    private Random rand;


    public Generator()
    {
        rand = new Random();
        number1 = 0;
        number2 = 0;
        operator = "";
        answer = 0;
        correct = 0;
        total = 0;
    }


    public void generate()
    {
        int number = rand.nextInt(2);

        if(0 <= number && number <= 0.25)
        {
            operator = "+";
            number1 = rand.nextInt(1,999);
            number2 = rand.nextInt(1,999);
            answer = number1 + number2;
        }
        else if(0.25 < number && number <= 0.50)
        {
            operator = "-";
            number1 = rand.nextInt(1,999);
            number2 = rand.nextInt(1,999);
            answer = number1 - number2;
        }
        else if(0.5 < number && 0.5 <= 0.75)
        {
            operator = "*";
            number1 = rand.nextInt(1,99);
            number2 = rand.nextInt(1,99);
            answer = number1 * number2;
        }
        else if(0.75 < number && number <= 1.0)
        {
            operator = "/";
            number1 = rand.nextInt(1,999);
            number2 = rand.nextInt(1,99);
            answer = number1 / number2;
        }

    }

    public int getTotal()
    {
        return total;
    }

    public String getOperator()
    {
        return operator;
    }

    public int getCorrect()
    {
        return correct;
    }

    public int getAnswer()
    {
        return answer;
    }

    public int getNumber2()
    {
        return number2;
    }

    public int getNumber1()
    {
        return number1;
    }

    public void increaseTotal()
    {
        total++;
    }

    public void increaseCorrect()
    {
        correct++;
    }


}
