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
 * This activity is the first triggered activity.
 *
 * We use a QuestionManager instance that contains all questions.
 * It has a method getQuestion (to get the next one),
 * and a method hasNext() (to know whether we continue).
 *
 * We check whether there is a next question (with hasNext()).
 * If there is :
 *      We print the question, and then two buttons with an answer inside each.
 *      Pressing one button considers that the user gave that answer.
 *      Then we go to the second screen, to print whether the answer was correct.
 * Otherwise :
 *      We go to the final screen to print the score.
 */
public class QuestionActivity extends AppCompatActivity {
    private static QuestionManager questionManager = new QuestionManager(0);
    private static Question currentQuestion;
    private static int nbRightAnswers;
    private static boolean answeredRight;
    /**
     * This method launches the first activity : screen with question and two possible answers.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        /*
         * This intent is just in case this activity is called by resultActivity.
         * This happens if user wants to restart. We check the boolean.
         * It's of course "false" by default (then only true if called by resultActivity).
         * We  do this because the QuestionManager need to be reset.
         * Otherwise, after a quiz, hasNext() will still return false, because all the questions
         *  have been browsed before.
         */
        Intent intentRestart = getIntent();
        boolean restart = intentRestart.getBooleanExtra("restart",false);
        if(restart) {
            this.questionManager = new QuestionManager(0);
        }

        // If we still have questions to ask
        if(this.questionManager.hasNext()) {
            this.currentQuestion = this.questionManager.getQuestion(questionManager.getIndex());

            // (re-)filling the TextView with current question
            TextView question = (TextView) findViewById(R.id.question);
            question.setText(this.currentQuestion.getQuestion());

            // (re-)filling the TextView with current possible answer one
            Button bouton1 = (Button) findViewById(R.id.button1);
            bouton1.setText(this.currentQuestion.getAnswerOne());
            bouton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("BOUTON", "Bouton 1");
                    Intent intent1 = new Intent(QuestionActivity.this, AnswerActivity.class);
                    intent1.putExtra("answerGiven", QuestionActivity.currentQuestion.getAnswerOne());
                    QuestionActivity.answeredRight = QuestionActivity.currentQuestion.getTrueAnswer() == 1;
                    if(QuestionActivity.answeredRight){
                        QuestionActivity.nbRightAnswers++;
                    }
                    intent1.putExtra("isCorrectAnswer", answeredRight);
                    startActivity(intent1);
                }
            });

            // (re-)filling the TextView with current possible answer two
            Button bouton2 = (Button) findViewById(R.id.button2);
            bouton2.setText(this.currentQuestion.getAnswerTwo());
            bouton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("BOUTON", "Bouton 2");
                    Intent intent2 = new Intent(QuestionActivity.this, AnswerActivity.class);
                    intent2.putExtra("answerGiven", QuestionActivity.currentQuestion.getAnswerTwo());
                    intent2.putExtra("isCorrectAnswer", QuestionActivity.currentQuestion.getTrueAnswer() == 2);
                    startActivity(intent2);
                }
            });
        } else { // Otherwise, go to final screen
            Intent intent0 = new Intent(QuestionActivity.this, ResultActivity.class);
            intent0.putExtra("score", this.nbRightAnswers);
            intent0.putExtra("nbQuestions", this.questionManager.getSize());
            startActivity(intent0);
        }
    }
}
