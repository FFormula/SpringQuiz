package service;

import face.IDialog;
import face.IQuiz;
import service.QuizShuffler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Exam {
    private QuizShuffler selector;
    private IDialog dialog;

    private String correctMessage = "OK";
    private String invalidMessage = "Wrong";

    public Exam(QuizShuffler selector, IDialog dialog) {
        this.selector = selector;
        this.dialog = dialog;
    }

    public Exam setCorrectMessage(String correctMessage) { this.correctMessage = correctMessage; return this; }
    public Exam setInvalidMessage(String invalidMessage) { this.invalidMessage = invalidMessage; return this; }

    public int start(int count)  {
        int points = 0;
        for (IQuiz quiz : selector.getRandomQuizList(count)) {
            dialog.print(String.format("%20s: ", quiz.getQuestion()));
            String answer = dialog.input();
            if (answer.equals(quiz.getAnswer())) {
                dialog.print(String.format("%21s%n", correctMessage));
                points++;
            } else
                dialog.print(String.format("%20s: %s%n", invalidMessage, quiz.getAnswer()));
        }
        return (100 * points) / count;
    }
}
