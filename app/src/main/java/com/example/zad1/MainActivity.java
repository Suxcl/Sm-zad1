package com.example.zad1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button showHint;
    private TextView questionTextView;


    private Question[] questions = new Question[]{
            new Question(R.string.q_activity, true),
            new Question(R.string.q_find_resources, false),
            new Question(R.string.q_listener, true),
            new Question(R.string.q_resources, true),
            new Question(R.string.q_version, false),
            new Question(R.string.q_prawda, true)
    };

    private int currentIndex = 0;
    private int good_answers = 0;

    private void checkAnswer(boolean userAnswer){
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId = 0;

        if(userAnswer == correctAnswer){
            resultMessageId = R.string.correct_answer;
            good_answers++;
        }else {
            resultMessageId = R.string.incorrect_answer;
        }

        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    private void setNextQuestion(){
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        trueButton = findViewById(R.id.button_true);
        falseButton = findViewById(R.id.button_false);
        nextButton = findViewById(R.id.button_next);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                checkAnswer(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                checkAnswer(false);
            }
        });
        nextButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;

                if(currentIndex==questions.length){
                    Intent intent = new Intent(MainActivity.this, Answer_activity.class );
                    intent.putExtra("points", String.valueOf(good_answers));
                    intent.putExtra("max_points", String.valueOf(currentIndex));
                    startActivity(intent);
                }else {
                    setNextQuestion();
                }
            }
        });




        setNextQuestion();

    }


}