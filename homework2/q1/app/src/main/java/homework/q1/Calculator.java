package homework.q1;

public class Calculator
{
    private char letter_grade;
    private double final_score;


    // Constructor
    public Calculator(float program, float midterm, float final_e)
    {
        letter_grade = 'F';
        final_score = 0;

        calculateFinalScore(program, midterm, final_e);
        calculateFinalGrade();

    }


    // calculates final score based on formula given
    private void calculateFinalScore(float program, float midterm, float final_e)
    {
        final_score = 60*(program / 200.0f) + (20 * (midterm/100.0f) + (20* (final_e / 100.0f)));

    }

    // calculates final grade based on score
    private void calculateFinalGrade()
    {
        if(final_score >= 100 || final_score >= 90)
        {
            letter_grade = 'A';
        }
        else if(final_score < 90 && final_score >= 80)
        {
            letter_grade = 'B';
        }
        else if(final_score < 80 && final_score >= 70)
        {
            letter_grade = 'C';
        }
        else if(final_score < 70 && final_score >= 60)
        {
            letter_grade = 'D';
        }
        else
        {
            letter_grade = 'F';
        }
    }

    // Additional getter methods
    public double getScore()
    {
        return final_score;
    }

    public char getGrade()
    {
        return letter_grade;
    }


}
