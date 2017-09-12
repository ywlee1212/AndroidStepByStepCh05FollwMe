package com.example.followme;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    float posX, posY;
    Vibrator vibrator;
    ObjectAnimator objectAnimatorX, objectAnimatorY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int touchX = (int) event.getX();
                int touchY = (int) event.getY();

                objectAnimatorX = ObjectAnimator.ofFloat(iv, "translationX", posX, touchX);
                objectAnimatorY = ObjectAnimator.ofFloat(iv, "translationY", posY, touchY);
                objectAnimatorX.start();
                objectAnimatorY.start();

                vibrator.vibrate(50);

                posX = touchX;
                posY = touchY;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }
}
