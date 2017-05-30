package sl.tecnico.Entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

import sl.tecnico.DAO.ConfiguracaoFirebase;

/**
 * Created by Sergio on 27/05/2017.
 */

public class Usuarios {

     private String id;
     private String nome;
     private String email;
     private String celular;
     private String senha;


     public Usuarios() {
     }
     //Salva os dados do usuário na tabela
     public  void salvar(){
          DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
          referenciaFirebase.child("usuario").child(String.valueOf(getId())).setValue(this);

     }

     @Exclude
     public Map<String,Object> toMap(){
          HashMap<String, Object> hashMapUsuarios = new HashMap<>();

          hashMapUsuarios.put("id" , getId());
          hashMapUsuarios.put("nome" , getNome());
          hashMapUsuarios.put("email" , getEmail());
          hashMapUsuarios.put("celular" , getCelular());
          hashMapUsuarios.put("senha" , getSenha());

          return  hashMapUsuarios;

     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getCelular() {
          return celular;
     }

     public void setCelular(String celular) {
          this.celular = celular;
     }

     public String getSenha() {
          return senha;
     }

     public void setSenha(String senha) {
          this.senha = senha;
     }
}
