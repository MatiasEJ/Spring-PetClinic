package mej.springframework.petclinic.repositories;

import mej.springframework.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
