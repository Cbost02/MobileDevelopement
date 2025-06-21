package homework.q4;
// complete
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    private int PICTURE_REQUEST = 1;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageManager manager = getPackageManager();

        if(manager.hasSystemFeature(PackageManager.FEATURE_CAMERA))
        {
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            startActivityForResult(pictureIntent, PICTURE_REQUEST);
        }
        else
        {
            Toast.makeText(this, "No camera", Toast.LENGTH_LONG).show();
        }
    }

    public void greyscale(View v)
    {
        // Create a new bitmap
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config configuration = bitmap.getConfig();
        Bitmap greyBitmap = Bitmap.createBitmap(width, height, configuration);

        // Change each pixel to a certain color
        for(int i = 0; i < bitmap.getWidth(); i++)
        {
            for(int j = 0; j < bitmap.getHeight(); j++)
            {
                // Get color of current pixel
                int color = bitmap.getPixel(i,j);

                // Find rbg values of pixel
                int red = Color.red(color);
                int green = Color.green(color);
                int blue = Color.blue(color);

                // create the greyscale color
                int grey = (int)((red + green + blue)/3.0);
                color = Color.rgb(grey,grey,grey);

                greyBitmap.setPixel(i,j,color);
            }
        }

        // Set the new bitmap to the widget
        ImageView grey_picture = findViewById(R.id.picture);
        grey_picture.setImageBitmap(greyBitmap);
    }

    public void original(View v)
    {

        // Gain access to the text view and display the original picture
        ImageView grey_picture = findViewById(R.id.picture);
        grey_picture.setImageBitmap(bitmap);
    }

    public void black_white(View v)
    {
        // Create a new bitmap
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config configuration = bitmap.getConfig();
        Bitmap greyBitmap = Bitmap.createBitmap(width, height, configuration);

        // Change each pixel to a certain color
        for(int i = 0; i < bitmap.getWidth(); i++)
        {
            for(int j = 0; j < bitmap.getHeight(); j++)
            {
                // Get color of current pixel
                int color = bitmap.getPixel(i,j);

                // Find RGB values of pixel
                int red = Color.red(color);
                int green = Color.green(color);
                int blue = Color.blue(color);

                // Make the pixel black-white
                int white = (int)((red + green + blue)/3.0);
                white = Math.min(255, white + 100);
                color = Color.rgb(white, white, white);

                greyBitmap.setPixel(i, j, color);
            }
        }

        // Set the new bitmap to the widget
        ImageView grey_picture = findViewById(R.id.picture);
        grey_picture.setImageBitmap(greyBitmap);
    }


    public void greenscale(View v)
    {
        // Create a new bitmap
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config configuration = bitmap.getConfig();
        Bitmap greyBitmap = Bitmap.createBitmap(width, height, configuration);

        // Change each pixel to a certain color
        for(int i = 0; i < bitmap.getWidth(); i++)
        {
            for(int j = 0; j < bitmap.getHeight(); j++)
            {
                // Get color of current pixel
                int color = bitmap.getPixel(i,j);

                // Find RGB values of pixel
                int red = Color.red(color);
                int green = Color.green(color);
                int blue = Color.blue(color);

                // Create the greenscale color using only the green channel
                color = Color.rgb(0, green, 0);

                greyBitmap.setPixel(i, j, color);
            }
        }

        // Set the new bitmap to the widget
        ImageView grey_picture = findViewById(R.id.picture);
        grey_picture.setImageBitmap(greyBitmap);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICTURE_REQUEST)
        {
            // Grab the result from the activity
            Bundle extras = data.getExtras();


            // Grab the bitmap from the activity
            bitmap = (Bitmap)extras.get("data");

            // Gain access to the imagine view widget
            ImageView imageView = findViewById(R.id.picture);


            // display the picture
            imageView.setImageBitmap(bitmap);

        }
    }

}