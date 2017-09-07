package io.khasang.moikaplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// Вариант ManyToOne
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String number;
    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "PERSON_ID_FK")
    )
    private Person person;
}
