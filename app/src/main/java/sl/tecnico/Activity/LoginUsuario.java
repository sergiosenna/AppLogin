package sl.tecnico.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import sl.tecnico.DAO.ConfiguracaoFirebase;
import sl.tecnico.Entidades.Usuarios;
import sl.tecnico.R;

public class LoginUsuario extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private Button bttLogar;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        bttLogar = (Button) findViewById(R.id.bttLogar);

        bttLogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                if(!edtEmail.getText().toString().equals("") && !edtSenha.getText().toString().equals("")){

                    usuarios = new Usuarios();
                    usuarios.setEmail(edtEmail.getText().toString());
                    usuarios.setSenha(edtSenha.getText().toString());

                    validarLogin();

                }else{
                    Toast.makeText(LoginUsuario.this, "Favor Preencher Email e Senha!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private void validarLogin(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuarios.getEmail(),usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    abrirMenu();
                    Toast.makeText(LoginUsuario.this, "Login Efetuado com Sucesso!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginUsuario.this, "Usuário ou Senha Inválidos!", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    public void abrirMenu(){
        Intent intentAbrirMenu = new Intent(LoginUsuario.this, MainActivity.class);
        startActivity(intentAbrirMenu);
    }

    public void callReset(View view){
        Intent intentCallReset = new Intent(LoginUsuario.this, ResetActivity.class);
        startActivity(intentCallReset);
    }

}
