package io.khasang.moikaplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String number;
    @OneToOne
    private PhoneDetails details;

    public Phone(String number, PhoneDetails details) {
        this.number = number;
        this.details = details;
    }
}
