package service;

import face.IQuizParser;
import face.IQuiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuizStorage {
    private IQuizParser parser;
    private String filename;

    public QuizStorage(String filename, IQuizParser parser) {
        this.filename = filename;
        this.parser = parser;
    }

    private BufferedReader getReader() {
        InputStream stream = getClass().getResourceAsStream(filename);
        return new BufferedReader(new InputStreamReader(stream));
    }

    public List<IQuiz> getQuizList() {
        try (BufferedReader reader = getReader()) {
            List<IQuiz> list = new ArrayList<>();
            while (reader.ready())
                list.add(parser.parse(reader.readLine()));
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
