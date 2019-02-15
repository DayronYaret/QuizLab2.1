package es.ulpgc.eite.cleancode.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

  public static String TAG = CheatActivity.class.getSimpleName();


  private AppMediator mediator;

  private Button yes, no;
  private TextView answerText;

  private boolean buttonClicked = false;
  private boolean answer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    answerText = findViewById(R.id.resultText);

    yes = findViewById(R.id.trueButton);
    no = findViewById(R.id.falseButton);

    mediator = (AppMediator) getApplication();

    QuestionToCheatState state = mediator.getQuestionToCheatState();

    if(state != null){
      answer = state.getAnswer();
    }
  }


  public void onYesButtonClicked(View view) {
    Log.e(TAG, "onYesButtonClicked()");

    buttonClicked = true;
    answerText.setText(answer ? "True" : "False");
  }

  public void onNoButtonClicked(View view) {
    Log.e(TAG, "onNoButtonClicked()");

    finish();
  }

  @Override
  protected void onResume() {
    super.onResume();

    answerText.setText("");

    // recuperar estado
    CheatState state = mediator.getCheatState();

    if(state != null) {
      // fijar estado
      buttonClicked = state.isButtonClicked();

      // actualizar IU
      answerText.setText(answer ? "True" : "False");
    }
  }

  @Override
  protected void onPause() {
    super.onPause();

    // gardar estado

    CheatState state = new CheatState();
    state.setButtonClicked(buttonClicked);
    mediator.setCheatState(state);

  }
}
