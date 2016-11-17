package com.example.guest.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.textView) TextView mTextView;
    @Bind(R.id.submitButton) Button mSubmitButton;
    @Bind(R.id.editText) EditText mWordEditText;
    List<String> guessedWords = new ArrayList();
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Random random = new Random();

        String [] consonants = new String[] {"B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Qu", "R", "S", "T", "V", "W", "X", "Y", "Z"};
        String [] vowels = new String[] {"A", "E", "I", "O", "U"};

        List<String> selectedLetters = new ArrayList();
        for (int i = 0; i < 6; i++) {
            int j = random.nextInt(20);
            selectedLetters.add(consonants[j]);
        }
        for (int i = 0; i < 2; i++) {
            int v = random.nextInt(4);
            selectedLetters.add(vowels[v]);
        }
        String joinedLetters = TextUtils.join(" ", selectedLetters);
        Log.i(TAG, joinedLetters);
        mTextView.setText(joinedLetters);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = mWordEditText.getText().toString();
                guessedWords.add(word);
            }
        });
    }



}
