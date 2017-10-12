package fr.codevallee.formation.tp7bapp;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by maximerevel on 11/10/2017.
 */

public class QuestionIterator implements Iterator {
    /**
     * @author maximerevel
     * @date 11/10/2017
     * This class allows to manage a pool of questions.
     * Questions are written in this class's constructor for convenience, we could read them somewhere with other methods.
     */

    private ArrayList<Question> pool;
    private int index = 0; // current position in the array

    /**
     * @param toSetIndex
     * Initialises the questions' array at index "toSetIndex".
     * Just put zero to initialise it correctly.
     * Ten questions inside.
     */
    public QuestionIterator(int toSetIndex) {
        // This constructor is a way to create ten questions
        this.pool = new ArrayList<Question>();
        this.index = toSetIndex;
        this.addQuestion("Combien d'épisodes de Star Wars sont sortis ?","6 épisodes", "7 épisodes", 2);
        this.addQuestion("Dans Z/5Z, combien fait 3 fois 3 ?","4", "9", 1);
        this.addQuestion("La réponse de l'univers est...","42", "dans la question", 1);
        this.addQuestion("Quelle est la formule du cyanodécapentayne ?","HC11N3", "HC11N2", 1);
        this.addQuestion("En quelle année mère Térésa est-elle née ?","1910", "1919", 1);
        this.addQuestion("En anglais, quel mot désigne un cri ?","a yell", "a shoot", 1);
        this.addQuestion("Allez-vous répondre \"non\" ?","Oui", "Non", 2);
        this.addQuestion("Quel nom porte le personnage principal de \"Le joueur d'échecs\" de S.ZWEIG ?","Dimitri", "Il n'est pas précisé", 2);
        this.addQuestion("Combien de demi-tons comporte une quarte en musique ?","5", "6", 1);
        this.addQuestion("Quel est l'âge d'Emmanuel MACRON ?","39 ans", "41 ans", 1);
    }

    public void addQuestion(String question, String answerOne, String answerTwo, int trueAnswer) {
        Question newQuestion = new Question(question, answerOne, answerTwo, trueAnswer);
        this.pool.add(newQuestion);
    }

    public boolean hasNext() {
        return this.index < this.pool.size();
    }

    public Question next() {
        return this.pool.get(index++);
    }

    public int getSize(){
        return this.pool.size();
    }

    public int getIndex() {
        return this.index;
    }



}
