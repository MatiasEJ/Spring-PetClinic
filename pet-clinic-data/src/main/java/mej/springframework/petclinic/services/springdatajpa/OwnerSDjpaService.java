package mej.springframework.petclinic.services.springdatajpa;

import mej.springframework.petclinic.model.Owner;
import mej.springframework.petclinic.repositories.OwnerRepositoriy;
import mej.springframework.petclinic.repositories.PetRepository;
import mej.springframework.petclinic.repositories.PetTypeRepository;
import mej.springframework.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDjpaService implements OwnerService {
    private final OwnerRepositoriy ownerRepositoriy;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDjpaService(OwnerRepositoriy ownerRepositoriy, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepositoriy = ownerRepositoriy;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepositoriy.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepositoriy.findAllByLastNameLike(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepositoriy.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepositoriy.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepositoriy.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepositoriy.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepositoriy.deleteById(aLong);
    }
}
