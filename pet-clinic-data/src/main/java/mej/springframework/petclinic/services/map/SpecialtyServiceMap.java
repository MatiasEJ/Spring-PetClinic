package mej.springframework.petclinic.services.map;

import mej.springframework.petclinic.model.Specialtiy;
import mej.springframework.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialtyServiceMap extends AbstractMapService<Specialtiy,Long> implements SpecialtyService {

    @Override
    public Set<Specialtiy> findAll() {
        return super.findAll();
    }

    @Override
    public Specialtiy findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialtiy save(Specialtiy object) {
        return super.save(object);
    }

    @Override
    public void delete(Specialtiy object) {
        super.delete(object);
        System.out.println("deleteando la spec");
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
        System.out.println("deleteando la spec por ID: "+id);

    }
}
