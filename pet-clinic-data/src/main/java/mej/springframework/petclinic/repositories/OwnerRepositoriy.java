package mej.springframework.petclinic.repositories;

import mej.springframework.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepositoriy extends CrudRepository<Owner, Long>     {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
