package io.khasang.moikaplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonAddress implements Serializable {
    @Id
    @ManyToOne
    private Person person;

    @Id
    @ManyToOne
    private Address address;


    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        PersonAddress that = (PersonAddress) o;
        return Objects.equals( person, that.person ) &&
                Objects.equals( address, that.address );
    }

    @Override
    public int hashCode() {
        return Objects.hash( person, address );
    }
}