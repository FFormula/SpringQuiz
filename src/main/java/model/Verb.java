package model;

import face.IQuiz;

public class Verb implements IQuiz {
    public String english;
    public String russian;

    public Verb(String english, String russian) {
        this.english = english;
        this.russian = russian;
    }

    @Override
    public String getQuestion() {
        return russian;
    }

    @Override
    public String getAnswer() {
        return english;
    }
}
