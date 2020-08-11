package mej.springframework.petclinic;

import model.Owner;
import model.PetType;

import java.time.LocalDate;

public class Pet {
    private model.PetType petType;
    private model.Owner owner;
    private LocalDate birthday;

    public model.PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public model.Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
