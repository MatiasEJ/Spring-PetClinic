package mej.springframework.petclinic.services;

import mej.springframework.petclinic.model.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
