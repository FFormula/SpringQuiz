import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Exam;
import face.IQuizParser;
import model.VerbsParser;
import service.QuizStorage;
import service.QuizShuffler;

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException {
        start2();
    }

    public static void start2() throws IOException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        //IQuizParser parser = context.getBean(IQuizParser.class);
        //QuizStorage storage = context.getBean(QuizStorage.class);
        QuizShuffler shuffler = context.getBean(QuizShuffler.class);

        //QuizStorage storage = new QuizStorage("/verbs.csv", parser);
        //QuizShuffler shuffler = new QuizShuffler(storage);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Exam exam = new Exam(shuffler, consoleReader, consoleWriter)
                .setCorrectMessage("Правильно!")
                .setInvalidMessage("Ошибка. Верный ответ");

        consoleWriter.write("Напишите перевод и все основные формы глаголов:\n");
        consoleWriter.flush();
        int result = exam.start(5);
        consoleWriter.write("Ваш результат: " + result + "%\n");
        consoleWriter.flush();
        consoleWriter.close();
    }
}
