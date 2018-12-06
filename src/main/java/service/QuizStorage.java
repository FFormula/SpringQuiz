package service;

import face.IQuizParser;
import face.IQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuizStorage {
    private BufferedReader reader;
    private IQuizParser parser;
    private List<IQuiz> list;

    public QuizStorage(String filename, IQuizParser parser) {
        setReader(filename);
        this.parser = parser;
        fillQuizList();
    }

    private void setReader(String filename) {
        InputStream stream = getClass().getResourceAsStream(filename);
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public List<IQuiz> getList() {
        return list;
    }

    private void fillQuizList() {
        try {
            list = new ArrayList<>();
            while (reader.ready())
                list.add(parser.parse(reader.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // как лучше поступить с обработкой исключения?
        // пробросить дальше - throws
        // сгенерировать runtime
        // проигнорировать и вернуть то, что успело считаться
        // вывести e.printStackTrace()
        // создать свою систему исключений
        // что-то ещё?
    }
}
