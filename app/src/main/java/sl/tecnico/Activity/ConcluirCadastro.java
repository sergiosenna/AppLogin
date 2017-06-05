package sl.tecnico.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import sl.tecnico.DAO.ConfiguracaoFirebase;
import sl.tecnico.Entidades.Usuarios;
import sl.tecnico.Helper.Base64Custom;
import sl.tecnico.Helper.Preferencias;
import sl.tecnico.R;

public class ConcluirCadastro extends AppCompatActivity {


    private EditText edtDtNascimento;
  //  private Spinner spinnerSexo;
  //  private Spinner spinnerEstadoCivil;
    private EditText edtCep,edtEndereco,edtComplemento,edtNumero,edtBairro;

  //  private Spinner spinnerUF;
   // private Spinner spinnerCidade;
    private Button bttConcluir;
    private Usuarios usuarios;
    private FirebaseAuth autenticacao;
    private CriarConta criarConta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concluir_cadastro);

        edtDtNascimento = (EditText) findViewById(R.id.edtDtNascimento);
       // spinnerSexo = (Spinner) findViewById(R.id.spinnerSexo);
       // spinnerEstadoCivil = (Spinner) findViewById(R.id.spinnerEstadoCivil);
        edtCep = (EditText) findViewById(R.id.edtCep);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtComplemento = (EditText) findViewById(R.id.edtComplemento);
        edtNumero = (EditText) findViewById(R.id.edtNumero);
        edtBairro = (EditText) findViewById(R.id.edtBairro);
     //   spinnerUF = (Spinner) findViewById(R.id.spinnerUF);
     //   spinnerCidade = (Spinner) findViewById(R.id.spinnerCidade);
        bttConcluir = (Button) findViewById(R.id.bttConcluir);


        bttConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

           /*     if (edtDtNascimento.getText().toString().equals("")) {
                    Toast.makeText(ConcluirCadastro.this, "Favor Preencher todos os campos", Toast.LENGTH_LONG).show();
                } else if (edtCep.getText().toString().equals("")) {
                    Toast.makeText(ConcluirCadastro.this, "Favor Preencher todos os campos", Toast.LENGTH_LONG).show();
                } else if (edtEndereco.getText().toString().equals("")) {
                    Toast.makeText(ConcluirCadastro.this, "Favor Preencher todos os campos", Toast.LENGTH_LONG).show();
                } else if (edtComplemento.getText().toString().equals("")) {
                    Toast.makeText(ConcluirCadastro.this, "Favor Preencher todos os campos", Toast.LENGTH_LONG).show();
                } else if (edtNumero.getText().toString().equals("")) {
                    Toast.makeText(ConcluirCadastro.this, "Favor Preencher todos os campos", Toast.LENGTH_LONG).show();
                } else if (edtBairro.getText().toString().equals("")) {
                    Toast.makeText(ConcluirCadastro.this, "Favor Preencher todos os campos", Toast.LENGTH_LONG).show();*/
                    usuarios = new Usuarios();
                    usuarios.setDtNascimento(edtDtNascimento.getText().toString());
                   // usuarios.setSexo(spinnerSexo.getTag().toString());
                   // usuarios.setEstadoCivil(spinnerEstadoCivil.getTag().toString());
                    usuarios.setCep(edtCep.getText().toString());
                    usuarios.setEndereco(edtEndereco.getText().toString());
                    usuarios.setComplemento(edtComplemento.getText().toString());
                    usuarios.setNumero(edtNumero.getText().toString());
                    usuarios.setBairro(edtBairro.getText().toString());
                  //  usuarios.setUf(spinnerUF.getTag().toString());
                   // usuarios.setCidade(spinnerCidade.getTag().toString());
                    usuarios.salvar();
                    abrirMain();


           /* } else {
                Toast.makeText(ConcluirCadastro.this, "Dados nao correspondem aos critérios", Toast.LENGTH_LONG).show();
            }*/

            }
        });
    }






    public void abrirMain(){
        Intent intent = new Intent(ConcluirCadastro.this, MainActivity.class);
        startActivity(intent);


    }

}
