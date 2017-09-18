package io.khasang.moikaplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NaturalId
    private String registrationNumber;
    private String name;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonAddress> addresses = new ArrayList<>();

    public Person(String registrationNumber, String name) {
        this.registrationNumber = registrationNumber;
        this.name = name;
    }

    public void addAddress(Address address) {
        PersonAddress personAddress = new PersonAddress( this, address );
        addresses.add( personAddress );
        address.getOwners().add( personAddress );
    }

    public void removeAddress(Address address) {
        PersonAddress personAddress = new PersonAddress( this, address );
        address.getOwners().remove( personAddress );
        addresses.remove( personAddress );
        personAddress.setPerson( null );
        personAddress.setAddress( null );
    }
    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals( registrationNumber, person.registrationNumber );
    }

    @Override
    public int hashCode() {
        return Objects.hash( registrationNumber );
    }

}
