package com.example.sounboard;


import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button button;
    MediaPlayer player;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        button = findViewById( R.id.Click );

        button.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()== MotionEvent.ACTION_DOWN) {
                    player= MediaPlayer.create( MainActivity.this,R.raw.horn );

                    player.start();

                    v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                    v.invalidate();
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    player.stop();
                    player.release();

                    v.getBackground().clearColorFilter();
                    v.invalidate();
                }
                return true;

            }
        } );

    }


}
