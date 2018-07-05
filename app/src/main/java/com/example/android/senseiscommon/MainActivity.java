package com.example.android.senseiscommon;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    LinearLayout quesAnsLinearLayout, editTextQuesAns, checkBoxQuesAns;

    TextView questionView;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
    RadioGroup rg;
    ImageView im;
    EditText q3ans;
    CheckBox cb1, cb2, cb3, cb4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layout = findViewById(R.id.parent_relative_layout);

        quesAnsLinearLayout = findViewById(R.id.question_answer);
        editTextQuesAns = findViewById(R.id.ET_question_answer);
        checkBoxQuesAns = findViewById(R.id.CB_question_answer);

        questionView = findViewById(R.id.question);
        rg = findViewById(R.id.answer);
        rb1 = rg.findViewById(R.id.op1);
        rb2 = rg.findViewById(R.id.op2);
        rb3 = rg.findViewById(R.id.op3);
        rb4 = rg.findViewById(R.id.op4);
        rb5 = rg.findViewById(R.id.op5);
        rb6 = rg.findViewById(R.id.decoy);
        im = findViewById(R.id.result_image);

        q3ans = findViewById(R.id.q3ansEditText);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);

        //Hides virtual keyboard on a touch anywhere outside EditText View
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

    //Code to hide virtual keyboard
    protected void hideSoftKeyboard(View view)
    {
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (in != null) {
            in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    int noOfCorrectAnswers = 0;
    int i = 1;

    /*
    Asks 1st question and shows submit button
     */
    public void startQuiz(View view){
        hideSoftKeyboard(view);
        if(NameEntered().isEmpty()){
            Toast.makeText(this, getString(R.string.toast_for_name), Toast.LENGTH_SHORT).show();
        }else{
            LinearLayout mainLayout = findViewById(R.id.main_LinearLayout);
            mainLayout.setVisibility(View.INVISIBLE);

            quesAnsLinearLayout.setVisibility(View.VISIBLE);
            Toast.makeText(this, "All the Best, " + NameEntered(), Toast.LENGTH_SHORT).show();

            questionView.setText(R.string.question1);
            rb1.setText(R.string.q1o1);
            rb2.setText(R.string.q1o2);
            rb3.setText(R.string.q1o3);
            rb4.setText(R.string.q1o4);
            rb5.setText(R.string.q1o5);

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
                    if(rb1.isChecked()){
                        ++noOfCorrectAnswers;
                    }
                    rb6.setChecked(true);
                    setColorGreen(rb6);


                    questionView.setText(R.string.question2);
                    rb1.setText(R.string.q2o1);
                    rb2.setText(R.string.q2o2);
                    rb3.setText(R.string.q2o3);
                    rb4.setText(R.string.q2o4);
                    rb5.setVisibility(View.INVISIBLE);
                }
                break;
                case 2: {

                    i++;
                    if(rb2.isChecked()){
                        ++noOfCorrectAnswers;
                    }
                    rb6.setChecked(true);
                    setColorGreen(rb6);

                    quesAnsLinearLayout.setVisibility(View.INVISIBLE);
                    editTextQuesAns.setVisibility(View.VISIBLE);
                }
                break;
                case 3: {
                    i++;
                    if(Integer.parseInt(q3ans.getText().toString()) == 5){
                        ++noOfCorrectAnswers;
                    }
                    q3ans.setText("");
                    hideSoftKeyboard(view);
                    editTextQuesAns.setVisibility(View.INVISIBLE);
                    checkBoxQuesAns.setVisibility(View.VISIBLE);
                }
                break;
                case 4: {
                    i++;
                    if(cb1.isChecked() && !(cb2.isChecked()) && !(cb3.isChecked()) && cb4.isChecked()){
                        ++noOfCorrectAnswers;
                    }
                    setCheckBoxToDefault(cb1);
                    checkBoxQuesAns.setVisibility(View.INVISIBLE);
                    quesAnsLinearLayout.setVisibility(View.VISIBLE);

                    questionView.setText(R.string.question5);
                    rb1.setText(R.string.q5o1);
                    rb2.setText(R.string.q5o2);
                    rb3.setText(R.string.q5o3);
                    rb4.setVisibility(View.VISIBLE);
                    rb4.setText(R.string.q5o4);
                    rb5.setVisibility(View.VISIBLE);
                    rb5.setText(R.string.q5o5);
                }
                break;
                case 5: {
                    i++;
                    if(rb4.isChecked()){
                        ++noOfCorrectAnswers;
                    }
                    rb6.setChecked(true);
                    setColorGreen(rb6);

                    questionView.setText(R.string.question6);
                    rb1.setText(R.string.q6o1);
                    rb2.setText(R.string.q6o2);
                    rb3.setText(R.string.q6o3);
                    rb4.setText(R.string.q6o4);
                    rb5.setText(R.string.q6o5);
                }
                break;
                case 6: {
                    i++;
                    if(rb4.isChecked()){
                        ++noOfCorrectAnswers;
                    }
                    rb6.setChecked(true);
                    setColorGreen(rb6);

                    questionView.setText(R.string.question7);
                    rb1.setText(R.string.q7o1);
                    rb2.setText(R.string.q7o2);
                    rb3.setText(R.string.q7o3);
                    rb4.setText(R.string.q7o4);
                    rb5.setVisibility(View.INVISIBLE);
                }
                break;
                case 7: {
                    i++;
                    if(rb2.isChecked()){
                        ++noOfCorrectAnswers;
                    }
                    rb6.setChecked(true);
                    setColorGreen(rb6);

                    questionView.setText(R.string.question8);
                    rb1.setText(R.string.q8o1);
                    rb2.setText(R.string.q8o2);
                    rb3.setText(R.string.q8o3);
                    rb4.setText(R.string.q8o4);
                    rb5.setVisibility(View.INVISIBLE);
                }
                break;
                case 8: {
                    i++;
                    if(rb4.isChecked()){
                        ++noOfCorrectAnswers;
                    }
                    rb6.setChecked(true);
                    setColorGreen(rb6);

                    questionView.setText(R.string.question9);
                    rb1.setText(R.string.q9o1);
                    rb2.setText(R.string.q9o2);
                    rb3.setText(R.string.q9o3);
                    rb4.setText(R.string.q9o4);
                }
                break;
                case 9: {
                    i++;
                    if(rb3.isChecked()){
                        ++noOfCorrectAnswers;
                        rb6.setChecked(true);
                    }
                    rb6.setChecked(true);
                    setColorGreen(rb6);

                    questionView.setText(R.string.question10);
                    rb1.setText(R.string.q10o1);
                    rb2.setText(R.string.q10o2);
                    rb3.setText(R.string.q10o3);
                    rb4.setText(R.string.q10o4);
                    rb5.setVisibility(View.VISIBLE);
                    rb5.setText(R.string.q10o5);
                }
                break;
            }
        }
        else{
            if(rb4.isChecked()){
                ++noOfCorrectAnswers;
            }
            rb6.setChecked(true);
            setColorGreen(rb6);

            LinearLayout quesAns = findViewById(R.id.question_answer);
            quesAns.setVisibility(View.INVISIBLE);
            LinearLayout result = findViewById(R.id.result);
            result.setVisibility(View.VISIBLE);
            TextView summary = findViewById(R.id.summary);
            if(noOfCorrectAnswers>7 && noOfCorrectAnswers<10){
                Toast.makeText(this, getString(R.string.if8090Toast) + "You answered " + noOfCorrectAnswers + " correct answers.", Toast.LENGTH_SHORT).show();
                im.setImageResource(R.drawable.goodjob);
                summary.setText(R.string.if8090);
            }else if(noOfCorrectAnswers==10){
                Toast.makeText(this, getString(R.string.if100Toast) + "You answered " + noOfCorrectAnswers + " correct answers.", Toast.LENGTH_SHORT).show();
                im.setImageResource(R.drawable.respect);
                summary.setText(R.string.if100);
            }else if(noOfCorrectAnswers<6){
                Toast.makeText(this, "You answered " + noOfCorrectAnswers + " correct answers.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, getString(R.string.if50Toast), Toast.LENGTH_SHORT).show();
                im.setImageResource(R.drawable.dontgiveup);
                summary.setText(R.string.if50);
                summary.setTextColor(Color.RED);
            }else{
                Toast.makeText(this, getString(R.string.if6070Toast) + "You answered " + noOfCorrectAnswers + " correct answers.", Toast.LENGTH_SHORT).show();
                im.setImageResource(R.drawable.goodjob);
                summary.setText(R.string.if6070);
            }
        }
    }

    public void setColorGreen(View view){
        RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
        rb.setTextColor(Color.GREEN);
        rb.setBackgroundColor(Color.WHITE);
        if(!rb1.equals(rb)){
            rb1.setTextColor(Color.BLUE);
            rb1.setBackgroundColor(0);
        }
        if(!rb2.equals(rb)){
            rb2.setTextColor(Color.BLUE);
            rb2.setBackgroundColor(0);
        }
        if(!rb3.equals(rb)){
            rb3.setTextColor(Color.BLUE);
            rb3.setBackgroundColor(0);
        }
        if(!rb4.equals(rb)){
            rb4.setTextColor(Color.BLUE);
            rb4.setBackgroundColor(0);
        }
        if(!rb5.equals(rb)){
            rb5.setTextColor(Color.BLUE);
            rb5.setBackgroundColor(0);
        }
        if(!rb6.equals(rb)){
            rb6.setTextColor(Color.BLUE);
            rb6.setBackgroundColor(0);
        }
    }

    public void reset(View view){
        i = 1;
        noOfCorrectAnswers = 0;
        LinearLayout result = findViewById(R.id.result);
        result.setVisibility(View.INVISIBLE);
        LinearLayout mainLayout = findViewById(R.id.main_LinearLayout);
        mainLayout.setVisibility(View.VISIBLE);
    }

    private String NameEntered(){
        EditText nameView = findViewById(R.id.your_name);
        String s = nameView.getText().toString();
        return s;
    }

    public void setCheckBoxColor(View view){
        if(cb1.isChecked()){
            cb1.setTextColor(Color.GREEN);
            cb1.setBackgroundColor(Color.WHITE);
        }
        if(cb2.isChecked()){
            cb2.setTextColor(Color.GREEN);
            cb2.setBackgroundColor(Color.WHITE);
        }
        if(cb3.isChecked()){
            cb3.setTextColor(Color.GREEN);
            cb3.setBackgroundColor(Color.WHITE);
        }
        if(cb4.isChecked()){
            cb4.setTextColor(Color.GREEN);
            cb4.setBackgroundColor(Color.WHITE);
        }
    }

    public void setCheckBoxToDefault(View view){
        cb1.setBackgroundColor(0);
        cb2.setBackgroundColor(0);
        cb3.setBackgroundColor(0);
        cb4.setBackgroundColor(0);
        cb1.setTextColor(getResources().getColor(R.color.radioButtonColor));
        cb2.setTextColor(getResources().getColor(R.color.radioButtonColor));
        cb3.setTextColor(getResources().getColor(R.color.radioButtonColor));
        cb4.setTextColor(getResources().getColor(R.color.radioButtonColor));
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
    }
}
