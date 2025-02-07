package homework.q4;

public class Calculator
{
    private double credits;
    private String degree;
    private String state;
    private Boolean dorm;
    private Boolean dining;
    private Boolean parking;


    public Calculator(double credits, String degree, String state, Boolean dorm
    , Boolean dining, Boolean parking)
    {
        this.credits = credits;
        this.degree = degree;
        this.state = state;
        this.dorm = dorm;
        this.dining = dining;
        this.parking = parking;
    }



    public float getTotal()
    {
        return 1.565f;
    }

}
