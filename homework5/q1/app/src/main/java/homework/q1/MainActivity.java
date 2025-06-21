package homework.q1;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Testing changes for branch "homework2
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    // Getting the tools for the sound pool
    private SoundPool sound_pool;
    private static Random rand;
    private int sound_ID;

    private int stream_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating a random for random number generating
        rand = new Random();

        // Prepare the sound pool
        SoundPool.Builder sound_pool_builder = new SoundPool.Builder();
        sound_pool = sound_pool_builder.build();

        // loading the audio files into the sound pool
        sound_pool.load(this,R.raw.sound1,1);
        sound_pool.load(this,R.raw.sound2,1);
        sound_pool.load(this,R.raw.sound3,1);
        sound_pool.load(this,R.raw.sound4,1);
        sound_pool.load(this,R.raw.sound5,1);

    }


    public void play(View v)
    {
        // Picking a random song to play
        sound_ID = rand.nextInt(5) + 1;
        stream_ID = sound_pool.play(sound_ID,1,1,1,1,1);
    }


    public void pause(View v)
    {
        sound_pool.pause(stream_ID);
    }


    public void resume(View v)
    {
        sound_pool.resume(stream_ID);
    }


    public void stop(View v)
    {
        sound_pool.stop(stream_ID);
    }

}