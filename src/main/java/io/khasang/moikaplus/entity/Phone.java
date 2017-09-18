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
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String number;
    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PhoneDetails details;

    public Phone(String number) {
        this.number = number;
    }

    public Phone(String number, PhoneDetails details) {
        this.number = number;
        this.details = details;
    }
    public void addDetails(PhoneDetails details) {
        details.setPhone( this );
        this.details = details;
    }

    public void removeDetails() {
        if ( details != null ) {
            details.setPhone( null );
            this.details = null;
        }
    }
    @Override
    public String toString(){
        String result = String.format("Phone[id=%d, number=%s ",id, number);
        if (details != null) {
            result += String.format("Provider=%s,Technology=%s ",details.getProvider(), details.getTechnology());
        }
        return result +"]\n";
    }
}
