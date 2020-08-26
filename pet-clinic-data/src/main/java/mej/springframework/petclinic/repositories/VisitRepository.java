package mej.springframework.petclinic.repositories;

import mej.springframework.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
