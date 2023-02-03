
package chegamais.com.chagamais.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private final Usuario owner; // quem criou o evento
    //Usuário que deveria ter uma lista de eventos.

    @ManyToMany
    @JoinTable(name = "event_comfirmado", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "comfirmado_id"))
    private List<Usuario> confirmados; // quem confirmou presença

    @NotNull @NotEmpty
    private LocalDateTime dataHora;
    @NotNull @NotEmpty
    private Duration duracao; // Quanto tempo o racha vai durar
    @NotNull @NotEmpty
    private Boolean isPublic; // Se o evento é público ou privado

    public Event(@NotNull @NotEmpty String nome, @NotNull @NotEmpty Usuario owner, @NotNull @NotEmpty LocalDateTime dataHora,
                 @NotNull @NotEmpty Duration duracao, @NotNull @NotEmpty Boolean isPublic){
        this.nome = nome;
        this.owner = owner;
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.isPublic = isPublic;
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

    public Usuario getOwner(){
        return this.owner;
    }

    public List<Usuario> getConfirmados() {
        return confirmados;
    }

    public Usuario addConfirmado(Usuario user) {
        if (!containsConfirmado(user)) {
            this.confirmados.add(user);
            return user;
        }
        return null;
    }

    public boolean containsConfirmado(Usuario user){
        return this.confirmados.contains(user);
    }

    public Usuario removeComfirmado(Usuario user){
        if (containsConfirmado(user)) {
            this.confirmados.remove(user);
            return user;
        }
        return null;
    }

    public LocalDateTime getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(LocalDateTime dataHora){
        this.dataHora = dataHora;
    }

    public Duration getDuracao() {
        return this.duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public Boolean getPublic() {
        return this.isPublic;
    }

    public void setPublic(Boolean aPublic) {
        this.isPublic = aPublic;
    }

}
