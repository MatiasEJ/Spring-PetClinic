package mej.springframework.petclinic.services.map;

import mej.springframework.petclinic.model.Visit;
import mej.springframework.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit,Long> implements VisitService {
    private final VisitService visitService;

    public VisitServiceMap(VisitService visitService) {
        this.visitService = visitService;
    }
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return visitService.findById(id);
    }

    @Override
    public Visit findByLastName(String lastName) {
        return null;
    }
}
