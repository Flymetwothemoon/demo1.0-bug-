package com.example.roomwordssample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText mEditWordView;
    private Button mButton;
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mEditWordView = findViewById(R.id.editText);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {

                    setResult(RESULT_CANCELED, replyIntent);

                }
                else {
                    String word = mEditWordView.getText().toString();
                    new WordRepository(getApplication()).insert((world) mEditWordView.getText());
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}