package mej.springframework.petclinic.bootstrap;

import mej.springframework.petclinic.model.Owner;
import mej.springframework.petclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import mej.springframework.petclinic.services.OwnerService;
import mej.springframework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    //POPULATES entry

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Juan");
        owner1.setLastName("Juncos");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Juan1");
        owner2.setLastName("Juncos1");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("vet1");
        vet1.setLastName("vet1ape");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("vet2");
        vet2.setLastName("vet2ape");
        vetService.save(vet2);

        System.out.println("Loaded vets..and owners");

    }
}
