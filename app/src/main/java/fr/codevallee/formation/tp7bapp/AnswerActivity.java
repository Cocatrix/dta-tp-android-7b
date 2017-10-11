package fr.codevallee.formation.tp7bapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by maximerevel on 11/10/2017.
 */

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        final Intent intentReceived = getIntent();
        boolean isCorrectAnswer = intentReceived.getBooleanExtra("isCorrectAnswer",false);
        if (isCorrectAnswer) {
            TextView answerCorrectness = (TextView) findViewById(R.id.correct);
            answerCorrectness.setVisibility(View.VISIBLE);
        } else {
            TextView answerCorrectness = (TextView) findViewById(R.id.incorrect);
            answerCorrectness.setVisibility(View.VISIBLE);
        }

        Button bouton3 = (Button) findViewById(R.id.button3);
        bouton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BOUTON","Bouton 3");
                Intent intentNewQuestion = new Intent(AnswerActivity.this,QuestionActivity.class);
                // intentNewQuestion.putExtra("index", intentReceived.getIntExtra("index",0));
                startActivity(intentNewQuestion);
            }
        });
    }
}
