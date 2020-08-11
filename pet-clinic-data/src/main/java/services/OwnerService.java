package services;

import model.Owner;
import model.Vet;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);

}
