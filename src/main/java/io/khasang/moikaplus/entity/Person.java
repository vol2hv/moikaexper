package io.khasang.moikaplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NaturalId
    private String registrationNumber;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Address> addresses = new ArrayList<>();

    public Person(String registrationNumber, String name) {
        this.registrationNumber = registrationNumber;
        this.name = name;
    }

    public void addAddress(Address address) {
        addresses.add( address );
        address.getPersons().add( this );
    }

    public void removeAddress(Address address) {
        addresses.remove( address );
        address.getPersons().remove( this );
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
