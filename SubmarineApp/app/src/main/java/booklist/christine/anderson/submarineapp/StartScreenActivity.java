package booklist.christine.anderson.submarineapp;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class StartScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        //Forces tablet not to fall asleep
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    public void onTouchScreen(View view) {
        Intent myIntent = new Intent(StartScreenActivity.this, ErrorScreen.class);
        StartScreenActivity.this.startActivity(myIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
