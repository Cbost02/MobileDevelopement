package homework1.q2;

public class University
{
    private int credits;
    private String status;
    private boolean dorm;
    private boolean dining;


    public University()
    {
        credits = 0;
        status = "";
        dorm = false;
        dining = false;
    }

    public int getCredits()
    {
        return credits;
    }

    public void setCredits(int credits)
    {
        this.credits = credits;
    }

    public boolean isDorm()
    {
        return dorm;
    }

    public void setDorm(boolean dorm)
    {
        this.dorm = dorm;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public boolean isDining()
    {
        return dining;
    }

    public void setDining(boolean dining)
    {
        this.dining = dining;
    }


    public float getTotal()
    {
        float total = 0.0f;

        if(status.equalsIgnoreCase("Undergrad"))
        {
            total += (300 * credits);
        }
        else
        {
            total += (400 * credits);
        }

        if(dorm)
        {
            total += 1000;
        }

        if(dining)
        {
            total += 500;
        }

        return total;
    }
}
