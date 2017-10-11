package fr.codevallee.formation.tp7bapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by maximerevel on 11/10/2017.
 */

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Integer result = intent.getIntExtra("score", 0);
        Integer nbQuestions = intent.getIntExtra("nbQuestions", 0);

        TextView resultText = (TextView) findViewById(R.id.result);
        resultText.setText(resultText.getText().toString() + result + "/" + nbQuestions);

        Button boutonRestart = (Button) findViewById(R.id.buttonRestart);
        boutonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BOUTON","Bouton Restart");
                Intent intentNewQuestion = new Intent(ResultActivity.this,QuestionActivity.class);
                intentNewQuestion.putExtra("restart", true);
                startActivity(intentNewQuestion);
            }
        });
    }
}