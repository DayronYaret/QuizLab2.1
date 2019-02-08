package es.ulpgc.eite.cleancode.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


  private Button trueButton, falseButton;
  private TextView answerText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // poner layout en pantalla
    setContentView(R.layout.activity_main);

    // acceder a botones de pantalla
    trueButton = findViewById(R.id.trueButton);
    falseButton = findViewById(R.id.falseButton);

    // acceder a etiquetas de texto de pantalla
    answerText = findViewById(R.id.answerText);
  }

  public void onTrueButtonClicked(View view) {
    Log.e("MainActivity", "onTrueButtonClicked()");

    answerText.setText(R.string.trueButtonLabel);
  }

  public void onFalseButtonClicked(View view) {
    Log.e("MainActivity", "onFalseButtonClicked()");

    answerText.setText(R.string.falseButtonLabel);
  }

}
