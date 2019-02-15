package es.ulpgc.eite.cleancode.quiz;

import android.app.Application;

public class AppMediator extends Application {

  private QuestionState questionState;
  private QuestionToCheatState questionToCheatState;

  public QuestionToCheatState getQuestionToCheatState() {
    return questionToCheatState;
  }

  public void setQuestionToCheatState(QuestionToCheatState state) {
    this.questionToCheatState = state;
  }

  public QuestionState getQuestionState(){
    return questionState;
  }

  public void setQuestionState(QuestionState state) {
    questionState = state;
  }
}
