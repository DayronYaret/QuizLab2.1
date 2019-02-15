package es.ulpgc.eite.cleancode.quiz;

import android.app.Application;

public class AppMediator extends Application {

  private QuestionState questionState;

  public QuestionState getQuestionState(){
    return questionState;
  }

  public void setQuestionState(QuestionState state) {
    questionState = state;
  }
}
