package mej.springframework.petclinic.services.map;

import mej.springframework.petclinic.model.PetType;
import mej.springframework.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
        System.out.println("deleteado: "+object.getName());
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
        System.out.println("Deleteado id: "+id);

    }
}