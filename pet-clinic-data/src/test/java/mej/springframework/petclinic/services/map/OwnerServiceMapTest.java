package mej.springframework.petclinic.services.map;

import mej.springframework.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;



class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    final String lastName = "juan";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }


    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
       Owner owner = ownerServiceMap.findById(ownerId);
       assertEquals(ownerId,owner.getId());
    }

    @Test
    void save() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(id, savedOwner.getId());
    }
    @Test
    void saveNoId(){
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }
    @Test
    void findByLastName() {
        Owner juan = ownerServiceMap.findByLastName(lastName);
        assertNotNull(juan);
        assertEquals(lastName, ownerServiceMap.findById(ownerId).getLastName());
        assertEquals(ownerId, juan.getId());
    }
    @Test
    void findByLastNameNotFound() {
        Owner juan = ownerServiceMap.findByLastName("Diega");
        assertNull(juan);
    }
}
