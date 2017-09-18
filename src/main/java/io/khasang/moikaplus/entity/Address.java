package io.khasang.moikaplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String street;
    private String number;
    private String postalCode;
    @ManyToMany(mappedBy = "addresses")
    private List<Person> persons = new ArrayList<>();

    public Address(String street, String number, String postalCode) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }
    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals( street, address.street ) &&
                Objects.equals( number, address.number ) &&
                Objects.equals( postalCode, address.postalCode );
    }

    @Override
    public int hashCode() {
        return Objects.hash( street, number, postalCode );
    }

}
