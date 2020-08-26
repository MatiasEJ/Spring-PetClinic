package mej.springframework.petclinic.services.springdatajpa;

import mej.springframework.petclinic.model.Visit;
import mej.springframework.petclinic.repositories.VisitRepository;
import mej.springframework.petclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

public class VisitSDjpaService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitSDjpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
