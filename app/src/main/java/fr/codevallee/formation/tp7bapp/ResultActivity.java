package fr.codevallee.formation.tp7bapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author maximerevel
 * @date 11/10/2017
 * This activity rules the final screen. It displays the score : number of correct answers / number of asked questions.
 * Then a button allows to restart the quiz.
 */
public class ResultActivity extends Activity {
    /**
     * This method launches the third and last activity : screen with score result.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Log.d("ACTION","Getting score and displaying result");
        Intent intent = getIntent();
        Integer result = intent.getIntExtra("score", 0);
        Integer nbQuestions = intent.getIntExtra("nbQuestions", 0);

        TextView resultText = (TextView) findViewById(R.id.result);
        resultText.setText(resultText.getText().toString() + result + "/" + nbQuestions);

        Button boutonRestart = (Button) findViewById(R.id.buttonRestart);
        boutonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BUTTON","Restart Button");
                Intent intentNewQuestion = new Intent(ResultActivity.this,QuestionActivity.class);
                intentNewQuestion.putExtra("restart", true);
                startActivity(intentNewQuestion);
            }
        });
    }
}
