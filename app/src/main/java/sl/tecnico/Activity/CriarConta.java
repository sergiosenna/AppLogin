package sl.tecnico.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import javax.xml.validation.Validator;

import sl.tecnico.DAO.ConfiguracaoFirebase;
import sl.tecnico.Entidades.Usuarios;
import sl.tecnico.Helper.Base64Custom;
import sl.tecnico.Helper.Preferencias;
import sl.tecnico.R;

public class CriarConta extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtCelular;
    private EditText edtSenha;
    private EditText edtConfirmarSenha;
    private Button   bttGravar;
    private Usuarios usuarios;
    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        edtNome  =  (EditText) findViewById(R.id.edtNome);
        edtEmail  =  (EditText) findViewById(R.id.edtEmail);
        edtCelular  =  (EditText) findViewById(R.id.edtCelular);
        edtCelular.addTextChangedListener(Mask.insert("(##)#####-####",edtCelular));
        edtSenha  =  (EditText) findViewById(R.id.edtSenha);
        edtConfirmarSenha  =  (EditText) findViewById(R.id.edtCinfirmarSenha);
        bttGravar  = (Button) findViewById(R.id.bttGravar);


        bttGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtNome.getText().toString().equals("")){
                    Toast.makeText(CriarConta.this, "Favor Preencher todos os campos",Toast.LENGTH_LONG).show();
                } else if (edtEmail.getText().toString().equals("")) {
                    Toast.makeText(CriarConta.this, "Favor Preencher todos os campos",Toast.LENGTH_LONG).show();
                } else if ( edtCelular.getText().toString().equals("")){
                    Toast.makeText(CriarConta.this, "Favor Preencher todos os campos",Toast.LENGTH_LONG).show();
                } else if(edtSenha.getText().toString().equals(edtConfirmarSenha.getText().toString())){
                    usuarios = new Usuarios();
                    usuarios.setNome(edtNome.getText().toString());
                    usuarios.setEmail(edtEmail.getText().toString());
                    usuarios.setCelular(edtCelular.getText().toString());
                    usuarios.setSenha(edtSenha.getText().toString());

                    cadastrarUsuario();

                }else{
                    Toast.makeText(CriarConta.this, "As Senhas não são correspondentes",Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    private void cadastrarUsuario(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuarios.getEmail(),
                usuarios.getSenha()
        ).addOnCompleteListener(CriarConta.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CriarConta.this, "Usuario cadastrado com sucesso", Toast.LENGTH_LONG).show();

                    String identificadorUsuario = Base64Custom.codificarBase64(usuarios.getEmail());
                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuarios.setId(identificadorUsuario);
                    usuarios.salvar();

                    Preferencias preferencias = new Preferencias(CriarConta.this);
                    preferencias.salvarUsuarioPreferencias(identificadorUsuario, usuarios.getNome());

                    abrirLoginUsuario();

                }else{

                    String erroExcecao = "";

                    try {
                        throw  task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao= "Digite uma senha mais forte, contendo no minimo 8 caracteres de letras e numeros";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erroExcecao= "O email digitado e inválido, digite um novo email";
                    }catch (FirebaseAuthUserCollisionException e){
                        erroExcecao= "Esse email ja esta cadastrado no sistema";
                    }catch ( Exception e ){
                        erroExcecao= "Erro ao efetuar o cadastro";
                        e.printStackTrace();
                    }
                    Toast.makeText(CriarConta.this, "Erro: " + erroExcecao, Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    public void abrirLoginUsuario(){
        Intent intent = new Intent(CriarConta.this, LoginUsuario.class);
        startActivity(intent);
        finish();
    }

}
