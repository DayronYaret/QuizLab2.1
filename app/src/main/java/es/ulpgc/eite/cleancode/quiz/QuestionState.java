package es.ulpgc.eite.cleancode.quiz;

public class QuestionState {

  //private String question;
  //private boolean answer;
  private boolean buttonClicked;
  private boolean button;
  private int index;

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  /*
  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public boolean isAnswer() {
    return answer;
  }

  public void setAnswer(boolean answer) {
    this.answer = answer;
  }
  */

  public boolean isButtonClicked() {
    return buttonClicked;
  }

  public void setButtonClicked(boolean buttonClicked) {
    this.buttonClicked = buttonClicked;
  }

  public boolean getSelectedButton() {
    return button;
  }

  public void setButton(boolean button) {
    this.button = button;
  }
}
