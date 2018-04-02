package com.example.android.senseiscommon;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layout = findViewById(R.id.parent_relative_layout);
        layout.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent ev)
            {
                hideSoftKeyboard(view);
                return false;
            }
        });
    }

    /**
     * Hides virtual keyboard
     */
    protected void hideSoftKeyboard(View view)
    {
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


    int noOfCorrectAnswers = 0;
    int i = 1;

    public TextView getQues(){
        TextView questionView = findViewById(R.id.question);
        return questionView;
    }
    public RadioButton getop1(){
        RadioButton rb = findViewById(R.id.op1);
        return rb;
    }
    public RadioButton getop2(){
        RadioButton rb = findViewById(R.id.op2);
        return rb;
    }
    public RadioButton getop3(){
        RadioButton rb = findViewById(R.id.op3);
        return rb;
    }
    public RadioButton getop4(){
        RadioButton rb = findViewById(R.id.op4);
        return rb;
    }
    public RadioButton getop5(){
        RadioButton rb = findViewById(R.id.op5);
        return rb;
    }
    public ImageView getResImg(){
        ImageView im = findViewById(R.id.result_image);
        return im;
    }
    /*
    Asks 1st question and shows submit button
     */
    public void startQuiz(View view){
        hideSoftKeyboard(view);
        if(NameEntered().isEmpty()){
            Toast.makeText(this, getString(R.string.toast_for_name), Toast.LENGTH_SHORT).show();
        }else{
            Button startButton = findViewById(R.id.start_button);
            startButton.setVisibility(View.INVISIBLE);

            LinearLayout quesAnsLinearLayout = findViewById(R.id.question_answer);
            quesAnsLinearLayout.setVisibility(View.VISIBLE);
            Toast.makeText(this, "All the Best, " + NameEntered(), Toast.LENGTH_SHORT).show();


            getQues().setText(R.string.question1);
            getop1().setText(R.string.q1o1);
            getop2().setText(R.string.q1o2);
            getop3().setText(R.string.q1o3);
            getop4().setText(R.string.q1o4);
            getop5().setText(R.string.q1o5);

        }
    }

    /*
    Submit button changes the question and option on every click and also updates the noOfCorrectAnswers
     */
    public void submitAns(View view){
        if(i<10){
            switch(i){
                case 1: {
                    i++;
                    if(getop1().isChecked()){
                        ++noOfCorrectAnswers;
                        getop1().setTextColor(Color.BLUE);
                    }
                    getQues().setText(R.string.question2);
                    getop1().setText(R.string.q2o1);
                    getop2().setText(R.string.q2o2);
                    getop3().setText(R.string.q2o3);
                    getop4().setText(R.string.q2o4);
                    getop5().setVisibility(View.INVISIBLE);
                }
                break;
                case 2: {

                    i++;
                    if(getop2().isChecked()){
                        ++noOfCorrectAnswers;
                        getop2().setTextColor(Color.BLUE);
                    }
                    getQues().setText(R.string.question3);
                    getop1().setText(R.string.q3o1);
                    getop2().setText(R.string.q3o2);
                    getop3().setText(R.string.q3o3);
                    getop4().setText(R.string.q3o4);
                    getop5().setVisibility(View.VISIBLE);
                    getop5().setText(R.string.q3o5);
                }
                break;
                case 3: {
                    i++;
                    if(getop1().isChecked()){
                        ++noOfCorrectAnswers;
                        getop1().setTextColor(Color.BLUE);
                    }
                    getQues().setText(R.string.question4);
                    getop1().setText(R.string.q4o1);
                    getop2().setText(R.string.q4o2);
                    getop3().setText(R.string.q4o3);
                    getop4().setVisibility(View.INVISIBLE);
                    getop5().setVisibility(View.INVISIBLE);
                }
                break;
                case 4: {
                    i++;
                    if(getop3().isChecked()){
                        ++noOfCorrectAnswers;
                        getop3().setTextColor(Color.BLUE);
                    }
                    getQues().setText(R.string.question5);
                    getop1().setText(R.string.q5o1);
                    getop2().setText(R.string.q5o2);
                    getop3().setText(R.string.q5o3);
                    getop4().setVisibility(View.VISIBLE);
                    getop4().setText(R.string.q5o4);
                    getop5().setVisibility(View.VISIBLE);
                    getop5().setText(R.string.q5o5);
                }
                break;
                case 5: {
                    i++;
                    if(getop4().isChecked()){
                        ++noOfCorrectAnswers;
                        getop4().setTextColor(Color.BLUE);
                    }
                    getQues().setText(R.string.question6);
                    getop1().setText(R.string.q6o1);
                    getop2().setText(R.string.q6o2);
                    getop3().setText(R.string.q6o3);
                    getop4().setText(R.string.q6o4);
                    getop5().setText(R.string.q6o5);
                }
                break;
                case 6: {
                    i++;
                    if(getop4().isChecked()){
                        ++noOfCorrectAnswers;
                        getop4().setTextColor(Color.BLUE);
                    }
                    getQues().setText(R.string.question7);
                    getop1().setText(R.string.q7o1);
                    getop2().setText(R.string.q7o2);
                    getop3().setText(R.string.q7o3);
                    getop4().setText(R.string.q7o4);
                    getop5().setVisibility(View.INVISIBLE);
                }
                break;
                case 7: {
                    i++;
                    if(getop2().isChecked()){
                        ++noOfCorrectAnswers;
                        getop2().setTextColor(Color.BLUE);
                    }
                    getQues().setText(R.string.question8);
                    getop1().setText(R.string.q8o1);
                    getop2().setText(R.string.q8o2);
                    getop3().setText(R.string.q8o3);
                    getop4().setText(R.string.q8o4);
                    getop5().setVisibility(View.INVISIBLE);
                }
                break;
                case 8: {
                    i++;
                    if(getop4().isChecked()){
                        ++noOfCorrectAnswers;
                        getop4().setTextColor(Color.BLUE);
                    }
                    getQues().setText(R.string.question9);
                    getop1().setText(R.string.q9o1);
                    getop2().setText(R.string.q9o2);
                    getop3().setText(R.string.q9o3);
                    getop4().setText(R.string.q9o4);
                }
                break;
                case 9: {
                    i++;
                    if(getop3().isChecked()){
                        ++noOfCorrectAnswers;
                        getop3().setTextColor(Color.BLUE);
                    }
                    getQues().setText(R.string.question10);
                    getop1().setText(R.string.q10o1);
                    getop2().setText(R.string.q10o2);
                    getop3().setText(R.string.q10o3);
                    getop4().setText(R.string.q10o4);
                    getop5().setVisibility(View.VISIBLE);
                    getop5().setText(R.string.q10o5);
                }
                break;
            }
        }
        else{
            if(getop4().isChecked()){
                ++noOfCorrectAnswers;
            }
            LinearLayout quesAns = findViewById(R.id.question_answer);
            quesAns.setVisibility(View.INVISIBLE);
            LinearLayout result = findViewById(R.id.result);
            result.setVisibility(View.VISIBLE);
            TextView summary = findViewById(R.id.summary);
            if(noOfCorrectAnswers>7 && noOfCorrectAnswers<10){
                Toast.makeText(this, getString(R.string.if8090Toast) + "You answered " + noOfCorrectAnswers + " correct answers.", Toast.LENGTH_SHORT).show();
                getResImg().setImageResource(R.drawable.goodjob);
                summary.setText(R.string.if8090);
            }else if(noOfCorrectAnswers==10){
                Toast.makeText(this, getString(R.string.if100Toast) + "You answered " + noOfCorrectAnswers + " correct answers.", Toast.LENGTH_SHORT).show();
                getResImg().setImageResource(R.drawable.respect);
                summary.setText(R.string.if100);
            }else if(noOfCorrectAnswers<6){
                Toast.makeText(this, "You answered " + noOfCorrectAnswers + " correct answers.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, getString(R.string.if50Toast), Toast.LENGTH_SHORT).show();
                summary.setText(R.string.if50);
                summary.setTextColor(Color.RED);
            }else{
                Toast.makeText(this, getString(R.string.if6070Toast) + "You answered " + noOfCorrectAnswers + " correct answers.", Toast.LENGTH_SHORT).show();
                getResImg().setImageResource(R.drawable.goodjob);
                summary.setText(R.string.if6070);
            }
        }
    }

    public void checkRB(View view){
        RadioButton rb = (RadioButton) view;
        rb.setTextColor(getResources().getColor(R.color.green));
        if(!rb.equals(getop1())){
            getop1().setTextColor(Color.BLUE);
        }
        if(!rb.equals(getop2())){
            getop2().setTextColor(Color.BLUE);
        }
        if(!rb.equals(getop3())){
            getop3().setTextColor(Color.BLUE);
        }
        if(!rb.equals(getop4())){
            getop4().setTextColor(Color.BLUE);
        }
        if(!rb.equals(getop5())){
            getop5().setTextColor(Color.BLUE);
        }
    }

    public void reset(View view){
        i = 1;
        noOfCorrectAnswers = 0;
        Button startButton = findViewById(R.id.start_button);
        startButton.setVisibility(View.VISIBLE);
        LinearLayout result = findViewById(R.id.result);
        result.setVisibility(View.INVISIBLE);
    }

    private String NameEntered(){
        EditText nameView = findViewById(R.id.your_name);
        String s = nameView.getText().toString();
        return s;
    }
}
