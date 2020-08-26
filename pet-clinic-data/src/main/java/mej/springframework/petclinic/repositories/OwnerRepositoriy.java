package mej.springframework.petclinic.repositories;

import mej.springframework.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepositoriy extends CrudRepository<Owner, Long>     {
    Owner findByLastName(String lastName);
}
