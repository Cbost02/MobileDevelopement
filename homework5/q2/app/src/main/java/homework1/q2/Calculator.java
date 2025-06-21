package homework1.q2;

public class Calculator
{
    private int first_number;
    private char operator;
    private int second_number;

    private String answer;


    public Calculator(int first_number, String operation,int second_number)
    {
        this.first_number = first_number;
        this.second_number = second_number;

        if(operation.equals("Addition"))
        {
            operator = '+';
        }
        else if(operation.equals("Subtraction"))
        {
            operator = '-';
        }
        else if(operation.equals("Multiplication"))
        {
            operator = '*';
        }
        else if(operation.equals("Division"))
        {
            operator = '/';
        }

        answer = calculate();
    }


    private String calculate()
    {
        switch(operator)
        {
            case '+':
                return Integer.toString(first_number + second_number);
            case '-':
                return Integer.toString(first_number - second_number);
            case '*':
                return Integer.toString(first_number * second_number);
            case '/':
                double temp = (double) first_number / second_number;

                if(temp % 0.01 >= 0.05)
                {
                    return String.format("%.1f", temp + (temp % 0.01));
                }
                else
                {
                    return String.format("%.1f", temp);
                }

            default:
                return "0";
        }
    }

    public int getFirst_number()
    {
        return first_number;
    }

    public char getOperator()
    {
        return operator;
    }

    public int getSecond_number()
    {
        return second_number;
    }

    public String getAnswer()
    {
        return answer;
    }
}
