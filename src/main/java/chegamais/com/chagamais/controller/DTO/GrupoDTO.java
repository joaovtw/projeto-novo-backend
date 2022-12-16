package chegamais.com.chagamais.controller.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import chegamais.com.chagamais.controller.Response.GrupoResponse;
import chegamais.com.chagamais.model.Grupo;

public class GrupoDTO implements DTO_Interface<Grupo, GrupoResponse> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    public GrupoDTO() {
    }

    public GrupoDTO( String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Grupo converterParaModel() {
        Grupo grupo = new Grupo(this.nome);
        return grupo;
    }

    @Override
    public GrupoResponse converterParaResponse() {
        GrupoResponse response = new GrupoResponse(this.id, this.nome);
        return response;
    }


    

    
}
