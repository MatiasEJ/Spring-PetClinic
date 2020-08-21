package mej.springframework.petclinic.bootstrap;

import mej.springframework.petclinic.model.Owner;
import mej.springframework.petclinic.model.Pet;
import mej.springframework.petclinic.model.PetType;
import mej.springframework.petclinic.model.Vet;
import mej.springframework.petclinic.services.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import mej.springframework.petclinic.services.OwnerService;
import mej.springframework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        //PET TYPES
        PetType mono = new PetType();
        mono.setName("Mono");
        PetType savedMonoType = petTypeService.save(mono);

        PetType dogo = new PetType();
        dogo.setName("Dogo");
        PetType savedDogoType = petTypeService.save(dogo);
        //PET TYPES

        //OWNERS
        Owner owner1 = new Owner();
        owner1.setFirstName("Juan");
        owner1.setLastName("Juncos");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Juan1");
        owner2.setLastName("Juncos1");
        ownerService.save(owner2);

        System.out.println("Loaded owners");
        //OWNERS

        //VETS
        Vet vet1 = new Vet();
        vet1.setFirstName("vet1");
        vet1.setLastName("vet1ape");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vet2");
        vet2.setLastName("vet2ape");
        vetService.save(vet2);

        System.out.println("Loaded vets");
        //VETS


    }
}
