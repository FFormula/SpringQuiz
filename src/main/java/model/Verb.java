package model;

import face.IQuiz;

public class Verb implements IQuiz {
    private final String english;
    private final String russian;

    Verb(String english, String russian) {
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
