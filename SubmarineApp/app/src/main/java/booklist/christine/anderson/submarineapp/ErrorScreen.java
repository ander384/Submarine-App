package booklist.christine.anderson.submarineapp;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class ErrorScreen extends AppCompatActivity {

    private TextView inputDateTextView;
    private Button enterButton;
    private Button clearButton;

    //If number functionality is ever needed
    /*private Button zeroButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_screen);
        this.inputDateTextView = findViewById(R.id.tv_input_date);
        this.enterButton = findViewById(R.id.btn_enter);
        this.clearButton = findViewById(R.id.btn_clear);

        //Forces the tablet to not auto-lock
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //If there is a need to add number buttons later
        /*this.zeroButton = findViewById(R.id.btn_0);
        this.oneButton = findViewById(R.id.btn_1);
        this.twoButton = findViewById(R.id.btn_2);
        this.threeButton = findViewById(R.id.btn_3);
        this.fourButton = findViewById(R.id.btn_4);
        this.fiveButton = findViewById(R.id.btn_5);
        this.sixButton = findViewById(R.id.btn_6);
        this.sevenButton = findViewById(R.id.btn_7);
        this.eightButton = findViewById(R.id.btn_8);
        this.nineButton = findViewById(R.id.btn_9);*/


        this.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String number = inputDateTextView.getText().toString();
                if (Objects.equals(number, "MINERVA")) {
                    Intent myIntent = new Intent(ErrorScreen.this, ClueScreen.class);
                    ErrorScreen.this.startActivity(myIntent);
                }
                else {
                    inputDateTextView.setTextColor(Color.parseColor("#ff0000"));
                    Animation anim = new AlphaAnimation(0.0f, 1.0f);
                    anim.setDuration(50); //You can manage the time of the blink with this parameter
                    anim.setStartOffset(20);
                    anim.setRepeatCount(5);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            inputDateTextView.setText("");
                            inputDateTextView.setTextColor(Color.parseColor("#ffffff"));
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    inputDateTextView.startAnimation(anim);

                }
            }
        });

        this.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDateTextView.setText("");
            }
        });



    }

    public void onNumberButtonClick(View view){
        String currentText = inputDateTextView.getText().toString();
        //Will only concatenate the next number if less than 4 numbers have been entered
        if (currentText.length()<10)
        {
            Button button = (Button) view;
            String number = button.getText().toString();
            currentText = currentText + number;
            inputDateTextView.setText(currentText);
        }
        else
        {
            Animation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(50); //You can manage the time of the blink with this parameter
            anim.setStartOffset(20);
            anim.setRepeatCount(2);
            inputDateTextView.startAnimation(anim);
        }
    }


    public void onBackButtonPress(View view) {
        this.finish();
    }
}
