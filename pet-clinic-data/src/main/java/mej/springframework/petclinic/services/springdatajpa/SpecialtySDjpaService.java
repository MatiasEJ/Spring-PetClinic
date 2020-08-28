package mej.springframework.petclinic.services.springdatajpa;

import mej.springframework.petclinic.model.Specialtiy;
import mej.springframework.petclinic.repositories.SpecialtyRepository;
import mej.springframework.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDjpaService implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDjpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialtiy> findAll() {
        Set<Specialtiy> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialtiy findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialtiy save(Specialtiy object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialtiy object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
