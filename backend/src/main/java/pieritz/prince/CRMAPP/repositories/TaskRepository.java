package pieritz.prince.CRMAPP.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pieritz.prince.CRMAPP.domain.Task;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long> {
  Page<Task> findByKontaktId(Long kontaktId, Pageable pageable);
  long countByArt(String art);
  Page<Task> findByBezeichnung(String bezeichnung, Pageable pageable);

}