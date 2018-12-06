package service;

import face.IQuiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizShuffler {
    private List<IQuiz> list;

    public QuizShuffler(QuizStorage storage) {
        this.list = storage.getList();
    }

    public IQuiz getRandomQuiz() {
        return list.get(getRandom());
    }

    public List<IQuiz> getRandomQuizList(int count) {
        List<IQuiz> randomList = new ArrayList<>();

        if (count >= list.size())
            return getRandomQuizList();

        for (int j = 0; j < count; j ++)
            while (true) {
                IQuiz quiz = getRandomQuiz();
                if (!randomList.contains(quiz)) {
                    randomList.add(quiz);
                    break;
                }
            }
        return randomList;
    }

    public List<IQuiz> getRandomQuizList() {
        List<IQuiz> randomList = new ArrayList<>();
        Collections.copy(randomList, list);
        Collections.shuffle(randomList);
        return randomList;
    }

    private int getRandom() {
        return (int) (Math.random() * list.size());
    }

}
