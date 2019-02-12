package es.ulpgc.eite.cleancode.quiz;

import java.util.Arrays;
import java.util.List;

public class QuestionRepositoryMock implements QuestionRepository {

  private static final String QUESTION1_TRUE = "Question #1: True";
  private static final String QUESTION2_FALSE = "Question #2: False";
  private static final String QUESTION3_TRUE = "Question #3: True";
  private static final boolean TRUE_ANSWER = true;
  private static final boolean FALSE_ANSWER = false;

  private static final String EMPTY_ANSWER = "";
  private static final String CORRECT_ANSWER = "Correct!";
  private static final String INCORRECT_ANSWER = "Incorrect!";

  private int questionIndex = 0;
  private String questionAnswer = EMPTY_ANSWER;


  private List<Question> questionStore = Arrays.asList(
      new Question(QUESTION1_TRUE, TRUE_ANSWER),
      new Question(QUESTION2_FALSE, FALSE_ANSWER),
      new Question(QUESTION3_TRUE, TRUE_ANSWER)
  );

  @Override
  public String getCurrentQuestion() {
    if(questionIndex == questionStore.size()) {
      return null;
    }

    return questionStore.get(questionIndex).getQuestion();
  }

  @Override
  public void setupNextQuestion() {
    questionIndex++;
    questionAnswer = EMPTY_ANSWER;
  }

  @Override
  public String getCurrentAnswer() {
    if(questionIndex == questionStore.size()) {
      return null;
    }

    return questionAnswer;
  }

  @Override
  public void checkCurrentAnswer(boolean userAnswer) {
    if(userAnswer == questionStore.get(questionIndex).getAnswer()) {
      questionAnswer = CORRECT_ANSWER;
    } else {
      questionAnswer = INCORRECT_ANSWER;
    }
  }

  @Override
  public boolean existNextQuestion() {
    return questionIndex < questionStore.size() - 1;
  }

}
