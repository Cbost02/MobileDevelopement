package homework.q5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    public void submit(View v)
    {
        // Retrieves user input from widget & decrements number of chances
        EditText user_input_box = findViewById(R.id.user_input);
        String user_input_string = user_input_box.getText().toString();
        int user_input = Integer.parseInt(user_input_string);
        game.decrementChances();

        // Retrieves number from the game object
        int number = game.getNumber();

        // Creating data that will be sent back to the application
        String guess_message = "";
        TextView guess_box = findViewById(R.id.guess_box);
        TextView chance_box = findViewById(R.id.chance_box);

        // Initializes Dialog Box
        AlertDialog.Builder dialog_box = new AlertDialog.Builder(this);
        dialog_box.setMessage("Would you like to play again?");
        DialogBoxListener temp = new DialogBoxListener(); // You need a handler for the box



        // If the user gets the number correct, do the following
        if(user_input == number)
        {
            chance_box.setText("Chances remaining: " + game.getChances()); // Display number of chances
            guess_message = "You got it right!"; // Initialize message
            guess_box.setText(guess_message); // Sends the message to the text box

            // disables input box & submit button
            Button button = findViewById(R.id.submit_button);
            user_input_box.setEnabled(false);
            button.setEnabled(false);
            showDialogBox();
        }
        else if(game.getChances() == 0) // if the user has no more chances, do the following
        {
            chance_box.setText("Chances remaining: " + game.getChances()); // Display number of chances
            guess_message = "You have no more chances."; // Initialize message
            guess_box.setText(guess_message); // Sends the message to the text box
            // disables input box & submit button
            Button button = findViewById(R.id.submit_button);
            user_input_box.setEnabled(false);
            button.setEnabled(false);
            showDialogBox();
        }
        else if(number > user_input)
        {
            chance_box.setText("Chances remaining: " + game.getChances()); // Display number of chances
            guess_message = "The number is higher than that"; // Initialize message
            guess_box.setText(guess_message); // Sends the message to the text box
        }
        else
        {
            chance_box.setText("Chances remaining: " + game.getChances()); // Display number of chances
            guess_message = "The number is lower than that"; // Initialize message
            guess_box.setText(guess_message); // Sends the message to the text box
        }



    }


    // Method creates a dialog box
    private void showDialogBox()
    {
        //create dialog box
        AlertDialog.Builder dialogBox = new AlertDialog.Builder(this);

        //set message on dialog box
        dialogBox.setMessage("Would you like to play again?");

        //create an event handler for dialog box
        DialogBoxListener temp = new DialogBoxListener();

        //add event handler to dialog box buttons
        dialogBox.setPositiveButton("Yes", temp);
        dialogBox.setNegativeButton("No", temp);
        dialogBox.setNeutralButton("Cancel", temp);

        //show dialog box
        dialogBox.show();
    }

    private class DialogBoxListener implements DialogInterface.OnClickListener
    {

        @Override
        public void onClick(DialogInterface dialog, int id)
        {
            if(id == -1) // if this condition is met, create a new game then reset the app
            {
                game = new Game();
                setContentView(R.layout.activity_main);
            }
            else if(id == -2) // if this condition is met, close the app
            {
                System.exit(0);
            }
        }
    }
}