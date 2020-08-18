package mej.springframework.petclinic.services;

import mej.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);

}
