package service;

import face.IDialog;
import face.IQuiz;

public class Exam {
    private final QuizShuffler shuffler;
    private final IDialog dialog;
    private int questionsCount;

    private String correctMessage = "OK";
    private String invalidMessage = "Wrong";
    private String welcomeMessage = "Welcome";
    private String percentMessage = "Result %d";

    public Exam(QuizShuffler shuffler, IDialog dialog) {
        this.shuffler = shuffler;
        this.dialog = dialog;
    }

    public Exam setCorrectMessage(String correctMessage) { this.correctMessage = correctMessage; return this; }
    public Exam setInvalidMessage(String invalidMessage) { this.invalidMessage = invalidMessage; return this; }
    public Exam setWelcomeMessage(String welcomeMessage) { this.welcomeMessage = welcomeMessage; return this; }
    public Exam setPercentMessage(String percentMessage) { this.percentMessage = percentMessage; return this; }
    public Exam setQuestionsCount(int questionsCount) { this.questionsCount = questionsCount; return this; }

    public void start()  {
        if (questionsCount <= 0)
            return;
        dialog.print(welcomeMessage + "\n");
        int points = 0;
        for (IQuiz quiz : shuffler.getRandomQuizList(questionsCount)) {
            dialog.print(String.format("%20s: ", quiz.getQuestion()));
            String answer = dialog.input();
            if (answer.equals(quiz.getAnswer())) {
                dialog.print(String.format("%21s%n", correctMessage));
                points++;
            } else
                dialog.print(String.format("%20s: %s%n", invalidMessage, quiz.getAnswer()));
        }
        int percent = (100 * points) / questionsCount;
        dialog.print(String.format(percentMessage + "%n", percent));
    }
}
