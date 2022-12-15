package chegamais.com.chagamais.controller.Response;


public class UsuarioResponse {

    private Long id;
    private String nome;
    private String dataNascimento;
    private String posicaoFavorita;
    private String email;
    

    public UsuarioResponse(Long id, String nome, String dataNascimento, String posicaoFavorita, String email) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.posicaoFavorita = posicaoFavorita;
        this.email = email;
    }


    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public String getDataNascimento() {
        return dataNascimento;
    }


    public String getPosicaoFavorita() {
        return posicaoFavorita;
    }


    public String getEmail() {
        return email;
    }

    



    

    
}
