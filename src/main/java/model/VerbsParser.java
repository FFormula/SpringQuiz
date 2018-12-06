package model;

import face.IQuizParser;
import face.IQuiz;
import model.Verb;

public class VerbsParser implements IQuizParser {

    @Override
    public IQuiz parse(String line) {
        String[] cols = line.split(",", 4);
        if (cols.length != 4)
            throw new RuntimeException("Line must contains 4 fields: " + line);
        return (IQuiz)new Verb(
                cols[0] + " " + cols[1] + " " + cols[2],
                cols[3]);
    }
}
