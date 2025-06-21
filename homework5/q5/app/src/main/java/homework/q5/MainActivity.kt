package homework.q5

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// complete
class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(v: View?)
    {
        try
        {
            // Retrieve the data from the input box
            val credits_box = findViewById<EditText>(R.id.credits)
            val credits_string = credits_box.text.toString()
            val credits = credits_string.toFloat()


            // Retrieve data from  state/degree radio group
            val degree_group = findViewById<RadioGroup>(R.id.degree)
            val state_group = findViewById<RadioGroup>(R.id.state_parent)
            val degree_id = degree_group.checkedRadioButtonId
            val state_id = state_group.checkedRadioButtonId


            // Check degree
            var class_level = ""

            class_level += if (degree_id == R.id.graduate)
            {
                "Graduate"
            }
            else if (degree_id == R.id.undergraduate)
            {
                "Undergraduate"
            }
            else
            {
                "Non-Degree"
            }


            // Check state
            var state_status = ""

            state_status += if (state_id == R.id.in_state)
            {
                "In State"
            }
            else
            {
                "Out of state"
            }


            // Retrieve data from the check boxes
            val dorm = findViewById<CheckBox>(R.id.dorm)
            val dining = findViewById<CheckBox>(R.id.dining)
            val parking = findViewById<CheckBox>(R.id.parking)


            // Check optional charges
            var hasDorm = false
            var hasDining = false
            var hasParking = false

            if (dorm.isChecked) hasDorm = true

            if (dining.isChecked) hasDining = true

            if (parking.isChecked) hasParking = true


            val calculator = Calculator(
                credits, class_level, state_status,
                hasDorm, hasDining, hasParking
            )

            val total_cost = calculator.total

            val output_box = findViewById<TextView>(R.id.total)

            output_box.text = "$$total_cost"
        }
        catch (e: Exception)
        {
            val credits_box = findViewById<EditText>(R.id.credits)
            credits_box.setText("" + 0)
        }
    }
}