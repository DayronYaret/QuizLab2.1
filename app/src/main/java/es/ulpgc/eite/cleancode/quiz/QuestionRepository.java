package es.ulpgc.eite.cleancode.quiz;

public interface QuestionRepository {

  Boolean getCurrentAnswer();
  String getCurrentQuestion();
  void setupNextQuestion();
  String getCurrentResult();

  Integer getCurrentIndex();

  void setCurrentIndex(Integer index);

  void checkCurrentAnswer(boolean userAnswer);
  boolean existNextQuestion();
}
