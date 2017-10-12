package fr.codevallee.formation.tp7bapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author maximerevel
 * @date 11/10/2017
 * This activity rules the second screen. It displays the answer given and whether it's correct.
 * Then a button allows to pass to the next question (if no more, QuestionActivity will go to ResultActivity).
 */

public class AnswerActivity extends AppCompatActivity {
    /**
     * This method launches the second activity : screen with answer and correctness.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        final Intent intentReceived = getIntent();
        boolean isCorrectAnswer = intentReceived.getBooleanExtra("isCorrectAnswer",false); // Getting value to know if user was right or wrong
        String answerGiven = intentReceived.getStringExtra("answerGiven"); // Getting user's answer to display it again
        TextView userAnswer = (TextView) findViewById(R.id.userAnswer);
        userAnswer.setText(answerGiven);
        /*
         * For the next condition :
         * Having two TextView is a solution to avoid writing "Good Answer" and "Bad answer" here, and put them in strings.xml instead
         */
        if (isCorrectAnswer) { // We have two TextViews, we will make visible the "correct" one in that case
            TextView answerCorrectness = (TextView) findViewById(R.id.correct);
            answerCorrectness.setVisibility(View.VISIBLE);
        } else { // Here we make the "incorrect" TextView visible
            TextView answerCorrectness = (TextView) findViewById(R.id.incorrect);
            answerCorrectness.setVisibility(View.VISIBLE);
        }

        Button bouton3 = (Button) findViewById(R.id.button3);
        bouton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BOUTON","Bouton 3");
                Intent intentNewQuestion = new Intent(AnswerActivity.this,QuestionActivity.class);
                startActivity(intentNewQuestion);
            }
        });
    }
}
