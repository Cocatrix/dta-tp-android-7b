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

public class QuestionActivity extends AppCompatActivity {
    private static QuestionManager questionManager = new QuestionManager(0);
    private static Question currentQuestion;
    private static int nbRightAnswers;
    private boolean answeredRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // this.questionManager = new QuestionManager(lastIndex);
        /* I put that first in case the property was reset (because of memory lack ?...)
         * Hopefully, it is working without this line, we do not have to reset a Question Manager.
         */

        Intent intentRestart = getIntent();
        boolean restart = intentRestart.getBooleanExtra("restart",false);
        if(restart) {
            this.questionManager = new QuestionManager(0);
        }


        if(this.questionManager.hasNext()) {
            this.currentQuestion = this.questionManager.getQuestion(questionManager.getIndex());

            TextView question = (TextView) findViewById(R.id.question);
            question.setText(this.currentQuestion.getQuestion());

            Button bouton1 = (Button) findViewById(R.id.button1);
            bouton1.setText(this.currentQuestion.getAnswerOne());
            bouton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("BOUTON", "Bouton 1");
                    Intent intent1 = new Intent(QuestionActivity.this, AnswerActivity.class);
                    intent1.putExtra("answerGiven", "Answer1");
                    answeredRight = QuestionActivity.currentQuestion.getTrueAnswer() == 1;
                    if(answeredRight){
                        QuestionActivity.nbRightAnswers++;
                    }
                    intent1.putExtra("isCorrectAnswer", answeredRight);
                    intent1.putExtra("index", QuestionActivity.questionManager.getIndex());
                    startActivity(intent1);
                }
            });

            Button bouton2 = (Button) findViewById(R.id.button2);
            bouton2.setText(this.currentQuestion.getAnswerTwo());
            bouton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("BOUTON", "Bouton 2");
                    Intent intent2 = new Intent(QuestionActivity.this, AnswerActivity.class);
                    intent2.putExtra("answerGiven", "Answer2");
                    intent2.putExtra("isCorrectAnswer", QuestionActivity.currentQuestion.getTrueAnswer() == 2);
                    intent2.putExtra("index", QuestionActivity.questionManager.getIndex());
                    startActivity(intent2);
                }
            });
        } else {
            Intent intent0 = new Intent(QuestionActivity.this, ResultActivity.class);
            intent0.putExtra("score", this.nbRightAnswers);
            intent0.putExtra("nbQuestions", this.questionManager.getSize());
            startActivity(intent0);
        }
    }
}
