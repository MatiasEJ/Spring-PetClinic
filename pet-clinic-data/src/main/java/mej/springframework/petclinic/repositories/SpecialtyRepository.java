package mej.springframework.petclinic.repositories;

import mej.springframework.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
