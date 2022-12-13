package chegamais.com.chagamais.controller.Response;

import java.sql.Date;

public class UsuarioResponse {

    private long id;
    private String nome;
    private Date dataNascimento;
    private String posicaoFavorita;
    private String email;
    

    public UsuarioResponse(long id, String nome, Date dataNascimento, String posicaoFavorita, String email) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.posicaoFavorita = posicaoFavorita;
        this.email = email;
    }


    public long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public Date getDataNascimento() {
        return dataNascimento;
    }


    public String getPosicaoFavorita() {
        return posicaoFavorita;
    }


    public String getEmail() {
        return email;
    }

    



    

    
}
