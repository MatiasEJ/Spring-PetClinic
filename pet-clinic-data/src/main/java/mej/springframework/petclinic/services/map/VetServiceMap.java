package mej.springframework.petclinic.services.map;

import mej.springframework.petclinic.model.Vet;
import org.springframework.stereotype.Service;
import mej.springframework.petclinic.services.VetService;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet save(Long id,Vet object) {
        return super.save(id,object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}