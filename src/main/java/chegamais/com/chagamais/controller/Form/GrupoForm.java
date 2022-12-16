package chegamais.com.chagamais.controller.Form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import chegamais.com.chagamais.controller.DTO.GrupoDTO;

public class GrupoForm {

    @NotNull @NotEmpty 
    private String nome;

    public String getNome() {
        return nome;
    }

    public GrupoDTO converterParaDTO(){

        GrupoDTO GrupoDTO = new GrupoDTO(this.nome);
        return GrupoDTO;
        
    }

    
}
