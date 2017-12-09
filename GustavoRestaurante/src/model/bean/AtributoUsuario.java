
package model.bean;

import java.sql.Array;


public class AtributoUsuario {
    
    private int id;
    private String nome="";
    private String usuario="";
    private String senha="";
    private String email="";
    private String privilegio="";
    private String situacao="";
    private byte[] fotoEmByte;
    private final String ativar="ativado";
    private final String desativar="desativado";
    private final String bloquear="bloqueado";
    
    
    
    
    
    

    public String Desativado() {
        return desativar;
    }

    public String Bloqueado() {
        return bloquear;
    }

  

    
    
    
    
     public AtributoUsuario() {
    }

    public AtributoUsuario(String nome, String usuario, String senha, String email, String privilegio) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.privilegio = privilegio; 
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String Ativado() {
        return ativar;
    }

 
    
      public byte[] getFotoEmByte() {
        return fotoEmByte;
    }

    public void setFotoEmByte(byte[] fotoEmByte) {
        this.fotoEmByte = fotoEmByte;
    }

   
    
    
    
    
    
    
    
    
    
    
}
