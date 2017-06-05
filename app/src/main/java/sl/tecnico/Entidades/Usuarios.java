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
     private String sexo;
     private String dtNascimento;
     private String estadoCivil;
     private String cep;
     private String endereco;
     private String complemento;
     private String numero;
     private String bairro;
     private String cidade;
     private String uf;


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
          hashMapUsuarios.put("sexo" , getSenha());
          hashMapUsuarios.put("dtNascimento" , getDtNascimento());
          hashMapUsuarios.put("estadoCivil" , getEstadoCivil());
          hashMapUsuarios.put("cep" , getCep());
          hashMapUsuarios.put("endereco" , getEndereco());
          hashMapUsuarios.put("complemento" , getComplemento());
          hashMapUsuarios.put("numero" , getNumero());
          hashMapUsuarios.put("bairro" , getBairro());
          hashMapUsuarios.put("cidade" , getCidade());
          hashMapUsuarios.put("uf" , getUf());



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

     public String getSexo() {
          return sexo;
     }

     public void setSexo(String sexo) {
          this.sexo = sexo;
     }

     public String getDtNascimento() {
          return dtNascimento;
     }

     public void setDtNascimento(String dtNascimento) {
          this.dtNascimento = dtNascimento;
     }

     public String getEstadoCivil() {
          return estadoCivil;
     }

     public void setEstadoCivil(String estadoCivil) {
          this.estadoCivil = estadoCivil;
     }

     public String getCep() {
          return cep;
     }

     public void setCep(String cep) {
          this.cep = cep;
     }

     public String getEndereco() {
          return endereco;
     }

     public void setEndereco(String endereco) {
          this.endereco = endereco;
     }

     public String getComplemento() {
          return complemento;
     }

     public void setComplemento(String complemento) {
          this.complemento = complemento;
     }

     public String getNumero() {
          return numero;
     }

     public void setNumero(String numero) {
          this.numero = numero;
     }

     public String getBairro() {
          return bairro;
     }

     public void setBairro(String bairro) {
          this.bairro = bairro;
     }

     public String getCidade() {
          return cidade;
     }

     public void setCidade(String cidade) {
          this.cidade = cidade;
     }

     public String getUf() {
          return uf;
     }

     public void setUf(String uf) {
          this.uf = uf;
     }
}
