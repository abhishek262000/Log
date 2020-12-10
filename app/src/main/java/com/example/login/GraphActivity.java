package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GraphActivity extends AppCompatActivity {

    ProgressBar stress,depression,anxiety;
    TextView stressText,depressionText,anxietyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        stress = findViewById(R.id.stressBar);
        depression = findViewById(R.id.depressionBar);
        anxiety = findViewById(R.id.anxietyBar);
        stressText = findViewById(R.id.stress);
        depressionText = findViewById(R.id.depression);
        anxietyText = findViewById(R.id.anxiety);
        int s,a,d;
        s = percent(Testp.stress);
        a = percent(Testp.anxiety);
        d = percent(Testp.depression);

        stress.setProgress(s,true);
        depression.setProgress(d,true);
        anxiety.setProgress(a,true);

        stressText.setText("Stress\n"+s+"%");
        anxietyText.setText("Anxiety\n"+a+"%");
        depressionText.setText("Depression\n"+d+"%");
    }

    int percent(int a){
        return a*100/21;
    }
}