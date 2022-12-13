package chegamais.com.chagamais.controller.Form;

import java.sql.Date;

import chegamais.com.chagamais.controller.DTO.UsuarioDTO;

public class UsuarioFormUpdate {

    private String nome;
    private Date dataNascimento;
    private String posicaoFavorita;
    private String email;
    private String senha;

    public UsuarioDTO converterParaDTO(){

        UsuarioDTO usuarioDTO = new UsuarioDTO(this.nome, this.dataNascimento, this.posicaoFavorita, this.email, this.senha);
        return usuarioDTO;
        
    }
    
}
