package chegamais.com.chagamais.controller.Form;

import chegamais.com.chagamais.controller.DTO.GrupoDTO;

public class GrupoFormUpdate {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GrupoDTO converterParaDTO(){

        GrupoDTO GrupoDTO = new GrupoDTO(this.nome);
        return GrupoDTO;
        
    }

    
    
}
