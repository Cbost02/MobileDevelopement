package homework.q4;

public class Calculator
{
    private float credits;
    private String degree;
    private String state;
    private Boolean dorm;
    private Boolean dining;
    private Boolean parking;


    public Calculator(float credits, String degree, String state, Boolean dorm
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
        float totalTution = 0.0f;
        float totalDegree = 0.0f;
        float additionalCharges = 0.0f;
        float totalCost = 0.0f;

        if(degree.equalsIgnoreCase("Graduate"))
        {
            totalTution = credits * 800.0f;
        }
        else if(degree.equalsIgnoreCase("Undergraduate"))
        {
            totalTution = credits * 500.0f;
        }
        else
        {
            totalTution = credits * 300.0f;
        }

        if(state.equalsIgnoreCase("Out of state"))
            totalTution *= 2;

        if(dorm)
            additionalCharges += 5000;

        if(dining)
            additionalCharges += 2000;

        if(parking)
            additionalCharges += 1000;

        totalCost += totalDegree + additionalCharges + totalTution;

        return totalCost;

    }

}
