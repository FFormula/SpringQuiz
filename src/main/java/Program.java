import face.IDialog;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Dialog;
import service.Exam;
import service.QuizShuffler;

import java.io.*;

public class Program {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        QuizShuffler shuffler = context.getBean(QuizShuffler.class);
        IDialog dialog = context.getBean(IDialog.class);

        Exam exam = new Exam(shuffler, dialog)
                .setCorrectMessage("Правильно!")
                .setInvalidMessage("Ошибка. Верный ответ");

        dialog.print("Напишите перевод и все основные формы глаголов:\n");
        int result = exam.start(5);
        dialog.print("Ваш результат: " + result + "%\n");
    }
}
