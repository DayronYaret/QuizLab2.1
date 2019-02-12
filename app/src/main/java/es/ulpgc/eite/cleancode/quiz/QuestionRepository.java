package es.ulpgc.eite.cleancode.quiz;

public interface QuestionRepository {

  String getCurrentQuestion();
  void setupNextQuestion();
  String getCurrentAnswer();
  void checkCurrentAnswer(boolean userAnswer);
  boolean existNextQuestion();
}
