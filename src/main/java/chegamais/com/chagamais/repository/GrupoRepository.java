package chegamais.com.chagamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chegamais.com.chagamais.model.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    
}
