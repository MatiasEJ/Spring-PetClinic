package mej.springframework.petclinic.services.springdatajpa;

import mej.springframework.petclinic.model.Owner;
import mej.springframework.petclinic.repositories.OwnerRepositoriy;
import mej.springframework.petclinic.repositories.PetRepository;
import mej.springframework.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDjpaServiceTest {
    final String OWNER_LASTNAME = "juan";
    final Long ID = 1L;

    @Mock
    OwnerRepositoriy ownerRepositoriy;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDjpaService service;
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(OWNER_LASTNAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepositoriy.findByLastName(any())).thenReturn(returnOwner);

        Owner juan = service.findByLastName(OWNER_LASTNAME);

        assertEquals(OWNER_LASTNAME, juan.getLastName());
        verify(ownerRepositoriy).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(ID).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepositoriy.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

       assertNotNull(owners);
       assertEquals(2, owners.size());

    }

    @Test
    void findById() {
        when(ownerRepositoriy.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(1L);
        assertNotNull(owner);
    }
    @Test
    void findByNotFoundId() {
        when(ownerRepositoriy.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(3L);
        assertNull(owner);
    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepositoriy.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);
       assertNotNull(savedOwner);
       verify(ownerRepositoriy).save(any());

    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepositoriy).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(ID);
        verify(ownerRepositoriy).deleteById(anyLong());
    }
}