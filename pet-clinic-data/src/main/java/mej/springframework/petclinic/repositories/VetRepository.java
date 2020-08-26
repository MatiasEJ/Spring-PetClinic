package mej.springframework.petclinic.repositories;

import mej.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
