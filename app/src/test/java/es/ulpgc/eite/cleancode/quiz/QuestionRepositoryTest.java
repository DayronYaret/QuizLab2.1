package es.ulpgc.eite.cleancode.quiz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionRepositoryTest {

  private static final String QUESTION1_TRUE = "Question #1: True";
  private static final String QUESTION2_FALSE = "Question #2: False";
  private static final String QUESTION3_TRUE = "Question #3: True";
  private static final String EMPTY_RESULT = "";
  private static final String CORRECT_RESULT = "Correct!";
  private static final String INCORRECT_RESULT = "Incorrect!";
  
  @Test
  public void testNoClickAnyButton() {

    // Given
    QuestionRepository repository = new QuestionRepositoryMock();

    // When
    String question = repository.getCurrentQuestion();
    String answer = repository.getCurrentResult();

    // Then
    assertEquals("Get current question failed", question, QUESTION1_TRUE);
    assertEquals("Get current result failed", answer, EMPTY_RESULT);
  }

  @Test
  public void testFirstClickTrueButton() {

    // Given
    QuestionRepository repository = new QuestionRepositoryMock();

    // When
    repository.checkCurrentAnswer(true);
    String question = repository.getCurrentQuestion();
    String answer = repository.getCurrentResult();
    boolean lastQuestion = repository.existNextQuestion();

    // Then
    assertEquals("Get current question failed", question, QUESTION1_TRUE);
    assertEquals("Get current result failed", answer, CORRECT_RESULT);
    assertEquals("Check last question failed", lastQuestion, true);
  }


  @Test
  public void testFirstClickFalseButton() {

    // Given
    QuestionRepository repository = new QuestionRepositoryMock();

    // When
    repository.checkCurrentAnswer(false);
    String question = repository.getCurrentQuestion();
    String answer = repository.getCurrentResult();
    boolean lastQuestion = repository.existNextQuestion();

    // Then
    assertEquals("Get current question failed", question, QUESTION1_TRUE);
    assertEquals("Get current result failed", answer, INCORRECT_RESULT);
    assertEquals("Check last question failed", lastQuestion, true);
  }

  @Test
  public void testFirstClickNextButton() {

    // Given
    QuestionRepository repository = new QuestionRepositoryMock();

    // When
    repository.setupNextQuestion();
    String question = repository.getCurrentQuestion();
    String answer = repository.getCurrentResult();

    // Then
    assertEquals("Get current question failed", question, QUESTION2_FALSE);
    assertEquals("Get current result failed", answer, EMPTY_RESULT);

  }

  @Test
  public void testSecondClickTrueButton() {

    // Given
    QuestionRepository repository = new QuestionRepositoryMock();

    // When
    repository.setupNextQuestion();
    repository.checkCurrentAnswer(true);
    String question = repository.getCurrentQuestion();
    String answer = repository.getCurrentResult();
    boolean lastQuestion = repository.existNextQuestion();

    // Then
    assertEquals("Get current question failed", question, QUESTION2_FALSE);
    assertEquals("Get current result failed", answer, INCORRECT_RESULT);
    assertEquals("Check last question failed", lastQuestion, true);
  }


  @Test
  public void testSecondClickFalseButton() {

    // Given
    QuestionRepository repository = new QuestionRepositoryMock();

    // When
    repository.setupNextQuestion();
    repository.checkCurrentAnswer(false);
    String question = repository.getCurrentQuestion();
    String answer = repository.getCurrentResult();
    boolean lastQuestion = repository.existNextQuestion();

    // Then
    assertEquals("Get current question failed", question, QUESTION2_FALSE);
    assertEquals("Get current result failed", answer, CORRECT_RESULT);
    assertEquals("Check last question failed", lastQuestion, true);
  }

  @Test
  public void testSecondClickNextButton() {

    // Given
    QuestionRepository repository = new QuestionRepositoryMock();

    // When
    repository.setupNextQuestion();
    repository.setupNextQuestion();
    String question = repository.getCurrentQuestion();
    String answer = repository.getCurrentResult();

    // Then
    assertEquals("Get current question failed", question, QUESTION3_TRUE);
    assertEquals("Get current result failed", answer, EMPTY_RESULT);
  }

  @Test
  public void testThirdClickTrueButton() {

    // Given
    QuestionRepository repository = new QuestionRepositoryMock();

    // When
    repository.setupNextQuestion();
    repository.setupNextQuestion();
    repository.checkCurrentAnswer(true);
    String question = repository.getCurrentQuestion();
    String answer = repository.getCurrentResult();
    boolean lastQuestion = repository.existNextQuestion();

    // Then
    assertEquals("Get current question failed", question, QUESTION3_TRUE);
    assertEquals("Get current result failed", answer, CORRECT_RESULT);
    assertEquals("Check last question failed", lastQuestion, false);
  }


  @Test
  public void testThirdClickFalseButton() {

    // Given
    QuestionRepository repository = new QuestionRepositoryMock();

    // When
    repository.setupNextQuestion();
    repository.setupNextQuestion();
    repository.checkCurrentAnswer(false);
    String question = repository.getCurrentQuestion();
    String answer = repository.getCurrentResult();
    boolean lastQuestion = repository.existNextQuestion();

    // Then
    assertEquals("Get current question failed", question, QUESTION3_TRUE);
    assertEquals("Get current result failed", answer, INCORRECT_RESULT);
    assertEquals("Check last question failed", lastQuestion, false);
  }

  @Test
  public void testThirdClickNextButton() {

    // Given
    QuestionRepository repository = new QuestionRepositoryMock();

    // When
    repository.setupNextQuestion();
    repository.setupNextQuestion();
    repository.setupNextQuestion();
    String question = repository.getCurrentQuestion();
    String answer = repository.getCurrentResult();

    // Then
    assertEquals("Get current question failed", question, null);
    assertEquals("Get current result failed", answer, null);
  }
}
