package services;

import model.Vet;

import java.util.Set;

public interface OwnerService {
    Vet findById(Long id);
    Vet findByLastName(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();

}
