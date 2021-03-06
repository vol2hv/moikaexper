package io.khasang.moikaplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String provider;
    private String technology;
    @OneToOne(fetch = FetchType.LAZY)
    private Phone phone;

    public PhoneDetails(String provider, String technology) {
        this.provider = provider;
        this.technology = technology;
    }
}
