package mej.springframework.petclinic.bootstrap;

import mej.springframework.petclinic.model.*;
import mej.springframework.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }



    }

    private void loadData() {
        //SPECIALTY
        Specialty ciruja = new Specialty();
        ciruja.setDescription("Cirujano");
        Specialty dentista = new Specialty();
        dentista.setDescription("Dentista");
        Specialty radiologo = new Specialty();
        radiologo.setDescription("Radiologo");
        Specialty savedSpecialtyCiruja = specialtyService.save(ciruja);
        Specialty savedSpecialtyDentista = specialtyService.save(dentista);
        Specialty savedSpecialtyRadiologo= specialtyService.save(radiologo);

        //SPECIALTY


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
        owner1.setAddress("calle falsa 123");
        owner1.setCity("Coburza");
        owner1.setTelephone("41234");
        Pet juanPet = new Pet();
        juanPet.setOwner(owner1);
        juanPet.setBirthday(LocalDate.now());
        juanPet.setName("Mono");
        juanPet.setPetType(mono);
        owner1.getPets().add(juanPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Juan1");
        owner2.setLastName("Juncos1");
        owner2.setAddress("calle falsa 123");
        owner2.setCity("Coburza");
        owner2.setTelephone("41234");

        Pet juan1Pet = new Pet();
        juan1Pet.setOwner(owner2);
        juan1Pet.setBirthday(LocalDate.now());
        juan1Pet.setPetType(mono);
        juan1Pet.setName("Mono");
        owner2.getPets().add(juan1Pet);

        ownerService.save(owner2);

        System.out.println("Loaded owners");
        //OWNERS
        //VISIT
        Visit monovisit = new Visit();
        monovisit.setPet(juanPet);
        monovisit.setDate(LocalDate.now());
        monovisit.setDescription("la visita del mono");
        visitService.save(monovisit);
        //
        //VETS
        Vet vet1 = new Vet();
        vet1.setFirstName("vet1");
        vet1.setLastName("vet1ape");
        vet1.getSpecialties().add(savedSpecialtyDentista);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vet2");
        vet2.setLastName("vet2ape");
        vet1.getSpecialties().add(savedSpecialtyRadiologo);
        vetService.save(vet2);

        System.out.println("Loaded vets");
        //VETS
    }
}
