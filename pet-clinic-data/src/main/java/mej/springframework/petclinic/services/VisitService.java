package mej.springframework.petclinic.services;

import mej.springframework.petclinic.model.Visit;

public interface VisitService extends CrudService<Visit, Long> {
    Visit findByLastName(String lastName);
}
