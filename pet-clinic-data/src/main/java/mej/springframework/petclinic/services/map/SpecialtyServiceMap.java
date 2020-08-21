package mej.springframework.petclinic.services.map;

import mej.springframework.petclinic.model.Specialty;
import mej.springframework.petclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty,Long> implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
        System.out.println("deleteando la spec");
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
        System.out.println("deleteando la spec por ID: "+id);

    }
}
