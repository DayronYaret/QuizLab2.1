package es.ulpgc.eite.cleancode.quiz;

import android.app.Application;

public class AppMediator extends Application {

  private QuestionState questionState;
  private QuestionToCheatState questionToCheatState;
  private CheatState cheatState;

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

  public void setCheatState(CheatState state) {
    cheatState = state;
  }

  public CheatState getCheatState() {
    return cheatState;
  }
}
