package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.login.Question;

public class Testp extends AppCompatActivity {

    TextView question;
    Intent graph;
    static int count = 0;
    Button next;
    Question q;
    LottieAnimationView lti;
    RadioGroup options;
    int zero,one,two,three;
    RadioButton selected;
    static int stress,depression,anxiety;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testp);
        zero = R.id.zero;
        one = R.id.one;
        two = R.id.two;
        three = R.id.three;
       // next = findViewById(R.id.next);
        lti=(LottieAnimationView) findViewById(R.id.lotti);
        q = Question.getInstance();
        options = findViewById(R.id.radioGroup);
        question = findViewById(R.id.question);
        question.setText(q.at(count).getQuestion());
        stress = depression = anxiety = 0;
        graph = new Intent(Testp.this,GraphActivity.class);
    }

    public void getResult(View view){
        lti.playAnimation();
        if(count <= 20 && count >= 0){
            selected = findViewById(options.getCheckedRadioButtonId());
            if(selected == null){
                Toast.makeText(this,"Please select an option",Toast.LENGTH_SHORT).show();
            }
            else{
                if(selected.getId() == zero){
                    options.clearCheck();
                    selected.setChecked(false);
                    count++;
                }
                if(selected.getId()==  one){
                    options.clearCheck();
                    selected.setSelected(false);
                    addScore(q.at(count).getType(),1);
                    count++;
                }
                if(selected.getId() == two){
                    options.clearCheck();
                    selected.setSelected(false);
                    addScore(q.at(count).getType(),2);
                    count++;
                }
                if(selected.getId() == three){
                    options.clearCheck();
                    selected.setSelected(false);
                    addScore(q.at(count).getType(),3);
                    count++;
                }
                if(count < 21){
                    String temp = q.at(count).getQuestion();
                    question.setText(temp);
                }
                if(count == 21){
                    startActivity(graph);
                }
            }
        }
        else{
            Log.d("IndexOutOfBounds","On to the next activity");
        }
    }

    public void addScore(char type, int response){
        switch(type){
            case 's':
                stress += response;
                break;
            case 'a':
                anxiety += response;
                break;
            case 'd':
                depression += response;
                break;
        }
    }
}