package chegamais.com.chagamais.repository;

import chegamais.com.chagamais.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByNome(String nomeRole);

}

