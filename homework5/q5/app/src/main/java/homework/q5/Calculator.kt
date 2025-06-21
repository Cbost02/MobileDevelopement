package homework.q5

class Calculator
    (
    private val credits: Float,
    private val degree: String,
    private val state: String,
    private val dorm: Boolean,
    private val dining: Boolean,
    private val parking: Boolean
) {
    val total: Float
        get()
        {
            var totalTution = 0.0f
            val totalDegree = 0.0f
            var additionalCharges = 0.0f
            var totalCost = 0.0f

            totalTution = if (degree.equals("Graduate", ignoreCase = true))
            {
                credits * 800.0f
            }
            else if (degree.equals("Undergraduate", ignoreCase = true))
            {
                credits * 500.0f
            }
            else
            {
                credits * 300.0f
            }

            if (state.equals("Out of state", ignoreCase = true)) totalTution *= 2f

            if (dorm) additionalCharges += 5000f

            if (dining) additionalCharges += 2000f

            if (parking) additionalCharges += 1000f

            totalCost += totalDegree + additionalCharges + totalTution

            return totalCost
        }
}