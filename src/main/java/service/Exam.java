package service;

import face.IQuiz;
import service.QuizShuffler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Exam {
    private QuizShuffler selector;
    private BufferedReader reader;
    private BufferedWriter writer;

    private String correctMessage = "OK";
    private String invalidMessage = "Wrong";

    public Exam(QuizShuffler selector, BufferedReader reader, BufferedWriter writer) {
        this.selector = selector;
        this.reader = reader;
        this.writer = writer;
    }

    public Exam setCorrectMessage(String correctMessage) { this.correctMessage = correctMessage; return this; }
    public Exam setInvalidMessage(String invalidMessage) { this.invalidMessage = invalidMessage; return this; }

    public int start(int count) throws IOException {
        int points = 0;
        for (IQuiz quiz : selector.getRandomQuizList(count)) {
            writer.write(String.format("%20s: ", quiz.getQuestion())); writer.flush();
            String answer = reader.readLine();
            if (answer.equals(quiz.getAnswer())) {
                writer.write(String.format("%21s%n", correctMessage)); writer.flush();
                points++;
            } else {
                writer.write(String.format("%20s: %s%n", invalidMessage, quiz.getAnswer()));
                writer.flush();
            }
        }
        return (100 * points) / count;
    }
}
