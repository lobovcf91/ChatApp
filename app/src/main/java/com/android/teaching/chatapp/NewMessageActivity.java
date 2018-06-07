package com.android.teaching.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewMessageActivity extends AppCompatActivity {

        private EditText usernameEditex;
        private EditText messageEditex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        usernameEditex = findViewById(R.id.username);
        messageEditex = findViewById(R.id.message);

        Toolbar myToolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

public void enviar (View view) {

        //obtengo valores
    String username = usernameEditex.getText().toString();
    String message = messageEditex.getText().toString();

    if (TextUtils.isEmpty(username)){
        //el campo de username esta vacio
        usernameEditex.setError("no puede estar vacio");
    }else if (TextUtils.isEmpty(message))
        messageEditex.setError("el mensaje no esta");

}

}
