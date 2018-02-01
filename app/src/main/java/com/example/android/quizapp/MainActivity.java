package com.example.android.quizapp;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    int total = 0;
    String message = "";
    String name = "";
    String result = "";

    RadioButton q1correct;
    RadioButton q2correct;
    RadioButton q3correct;
    RadioButton q4correct;
    RadioButton q5correct;
    RadioButton q7correct;
    RadioButton q8correct;
    RadioButton q9correct;

    CheckBox q6a;
    CheckBox q6b;
    CheckBox q6c;
    CheckBox q6d;

    RadioGroup q1group;
    RadioGroup q2group;
    RadioGroup q3group;
    RadioGroup q4group;
    RadioGroup q5group;
    RadioGroup q7group;
    RadioGroup q8group;
    RadioGroup q9group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the device screen height:
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int screenHeight = size.y;

        //Find the LinearLayout:
        RelativeLayout layout = findViewById(R.id.layout1);
//        LinearLayout layout2 = findViewById(R.id.layout2);

        //Set the height of the layout based on the screen height you got earlier:
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = screenHeight - getStatusBarHeight();

//        ViewGroup.LayoutParams params2 = layout2.getLayoutParams();
//        params2.height = screenHeight - getStatusBarHeight();
    }


    //Get the height of status bar
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    //check results
    public void buttonClick(View view){
        TextView tv = findViewById(R.id.result);
        EditText nameField = findViewById(R.id.nameInput);
        name = nameField.getText().toString();
        result = name + ", you have scored: " + summarize() + " out of 9 \n\n" + message;
        tv.setText(result);
        reset();
    }

    // counts the correct answers
    public int summarize(){

        q1correct = findViewById(R.id.q1c);
        q2correct = findViewById(R.id.q2b);
        q3correct = findViewById(R.id.q3c);
        q4correct = findViewById(R.id.q4b);
        q5correct = findViewById(R.id.q5b);
        q7correct = findViewById(R.id.q7b);
        q8correct = findViewById(R.id.q8b);
        q9correct = findViewById(R.id.q9b);

        q6a = findViewById(R.id.q6a);
        q6c = findViewById(R.id.q6c);
        q6d = findViewById(R.id.q6d);


        if (q1correct.isChecked())
        {
            total += 1;
        }

        if (q2correct.isChecked())
        {
            total += 1;
        }

        if (q3correct.isChecked())
        {
            total += 1;
        }

        if (q4correct.isChecked())
        {
            total += 1;
        }

        if (q5correct.isChecked())
        {
            total += 1;
        }

        boolean q6aCheck = q6a.isChecked();
        boolean q6cCheck = q6c.isChecked();
        boolean q6dCheck = q6d.isChecked();

        if(q6aCheck &&  q6cCheck &&  q6dCheck)
        {
            total += 1;
        }

        if (q7correct.isChecked())
        {
            total += 1;
        }

        if (q8correct.isChecked())
        {
            total += 1;
        }

        if (q9correct.isChecked())
        {
            total += 1;
        }


        //result related message
        if (total >=8){
            message = "Congratulations!\nYou have the potential of a real hero!";
        }
        else if (total >5){
            message = "Good job!\nThank you for challenging yourself and taking this quiz! There's a little room for further improvement.";
        }
        else{
            message = "You could have done it better!\nThank you for challenging yourself! Please read the lesson and retake your quiz";
        }

        return total;

    }

    //resetting quiz
    public void reset() {

        q1group = findViewById(R.id.q1group);
        q2group = findViewById(R.id.q2group);
        q3group = findViewById(R.id.q3group);
        q4group = findViewById(R.id.q4group);
        q5group = findViewById(R.id.q5group);
        q7group = findViewById(R.id.q7group);
        q8group = findViewById(R.id.q8group);
        q9group = findViewById(R.id.q9group);


        q6a = findViewById(R.id.q6a);
        q6b = findViewById(R.id.q6b);
        q6c = findViewById(R.id.q6c);
        q6d = findViewById(R.id.q6d);

        q1group.clearCheck();
        q2group.clearCheck();
        q3group.clearCheck();
        q4group.clearCheck();
        q5group.clearCheck();
        q7group.clearCheck();
        q8group.clearCheck();
        q9group.clearCheck();

        q6a.setChecked(false);
        q6b.setChecked(false);
        q6c.setChecked(false);
        q6d.setChecked(false);

        total = 0;

    }

}


