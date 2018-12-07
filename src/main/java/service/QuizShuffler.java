package service;

import face.IQuiz;
import java.util.Collections;
import java.util.List;

public class QuizShuffler {
    private QuizStorage storage;

    public QuizShuffler(QuizStorage storage) {
        this.storage = storage;
    }

    public List<IQuiz> getRandomQuizList(int count) {
        List<IQuiz> list = storage.getQuizList();
        if (count > list.size())
            count = list.size();
        Collections.shuffle(list);
        return list.subList(0, count);
    }

}
