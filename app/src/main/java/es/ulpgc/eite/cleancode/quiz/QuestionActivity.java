package es.ulpgc.eite.cleancode.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

  public static String TAG = QuestionActivity.class.getSimpleName();

  private static final String TRUE_BUTTON_LABEL = "True";
  private static final String FALSE_BUTTON_LABEL = "False";
  private static final String CHEAT_BUTTON_LABEL = "Cheat";
  private static final String NEXT_BUTTON_LABEL = "Next";

  private QuestionRepository repository;
  private TextView questionText, answerText;
  private Button trueButton, falseButton, cheatButton, nextButton;

  private boolean buttonClicked = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);

    trueButton = findViewById(R.id.trueButton);
    falseButton = findViewById(R.id.falseButton);
    cheatButton = findViewById(R.id.cheatButton);
    nextButton = findViewById(R.id.nextButton);

    questionText = findViewById(R.id.questionText);
    answerText = findViewById(R.id.answerText);

    repository = new QuestionRepositoryMock();

    initUI();
    updateUI();
  }

  private void initUI(){
    Log.e(TAG, "initUI()");

    trueButton.setText(TRUE_BUTTON_LABEL);
    falseButton.setText(FALSE_BUTTON_LABEL);
    cheatButton.setText(CHEAT_BUTTON_LABEL);
    nextButton.setText(NEXT_BUTTON_LABEL);
  }

  private void updateUI(){
    Log.e(TAG, "updateUI()");

    questionText.setText(repository.getCurrentQuestion());
    answerText.setText(repository.getCurrentAnswer());
  }

  public void onTrueButtonClicked(View view) {
    Log.e(TAG, "onTrueButtonClicked()");

    checkCurrentAnswer(true);
  }

  public void onFalseButtonClicked(View view) {
    Log.e(TAG, "onFalseButtonClicked()");

    checkCurrentAnswer(false);
  }

  private void checkCurrentAnswer(boolean answer){
    buttonClicked = true;

    repository.checkCurrentAnswer(answer);
    updateUI();
  }

  public void onCheatButtonClicked(View view) {
    if(buttonClicked){
      return;
    }

    Log.e(TAG, "onCheatButtonClicked()");

    // not implemented
  }

  public void onNextButtonClicked(View view) {
    if(!buttonClicked){
      return;
    }

    if(!repository.existNextQuestion()) {
      return;
    }

    Log.e(TAG, "onNextButtonClicked()");

    buttonClicked = false;
    repository.setupNextQuestion();
    updateUI();
  }
}
