package sl.tecnico.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import sl.tecnico.R;

public class Login extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button  btEntrar   = (Button) findViewById(R.id.buttonEntrar);
        Button  btCriarConta   = (Button) findViewById(R.id.buttonCriarConta);



        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, LoginUsuario.class);
                startActivity(intent);
            }
        });


        btCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, CriarConta.class);
                startActivity(intent);
            }
        });

    }

}


