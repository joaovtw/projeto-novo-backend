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
    public boolean addConfirmado(Usuario usuario) {
        return confirmados.add(usuario);
    }
}
