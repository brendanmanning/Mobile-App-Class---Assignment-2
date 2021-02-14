package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    EditText nameEditText, emailEditText, passwordEditText, repeatEditText = null;
    TextView nameRightText, emailRightText, passwordRightText, repeatRightText = null;
    Button submitButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElements();
        clearRightTextElements();

        submitButton.setOnClickListener((View v) -> {
            clearRightTextElements();
            if(this.allFieldsFilled()) {
                if(this.doPasswordsMath()) {
                    System.out.println("Should show Toast");
                    Toast.makeText(this, getToastContents(), Toast.LENGTH_SHORT).show();
                } else {
                    displayPasswordMismatchWarning();
                }
            } else {
                displayFieldEmptyWarnings();
            }
        });

    }

    private void initElements() {
        nameEditText = findViewById(R.id.nameEditText);
        nameRightText = findViewById(R.id.nameRightText);

        emailEditText = findViewById(R.id.emailEditText);
        emailRightText = findViewById(R.id.emailRightText);

        passwordEditText = findViewById(R.id.passwordEditText);
        passwordRightText = findViewById(R.id.passwordRightText);

        repeatEditText = findViewById(R.id.repeatEditText);
        repeatRightText = findViewById(R.id.repeatRightText);

        submitButton = findViewById(R.id.submitButton);
    }

    private void clearRightTextElements() {
        nameRightText.setText("");
        emailRightText.setText("");
        passwordRightText.setText("");
        repeatRightText.setText("");
    }

    private boolean allFieldsFilled() {
        return (
            nameEditText.getText().length() > 0 &&
            emailEditText.getText().length() > 0 &&
            passwordEditText.getText().length() > 0 &&
            repeatEditText.getText().length() > 0
        );
    }

    private void displayFieldEmptyWarnings() {
        if(nameEditText.getText().length() == 0) {
            nameRightText.setText("Fill in!");
        }
        if(emailEditText.getText().length() == 0) {
            emailRightText.setText("Fill in!");
        }
        if(passwordEditText.getText().length() == 0) {
            passwordRightText.setText("Fill in!");
        }
        if(repeatEditText.getText().length() == 0) {
            repeatRightText.setText("Fill in!");
        }
    }

    private boolean doPasswordsMath() {
        return passwordEditText.getText().toString().equals(repeatEditText.getText().toString());
    }

    private void displayPasswordMismatchWarning() {
        repeatRightText.setText("Does not match!");
    }

    private String getToastContents() {
        return "Welcome, " + nameEditText.getText().toString() + ", to the SignUpForm App";
    }
}