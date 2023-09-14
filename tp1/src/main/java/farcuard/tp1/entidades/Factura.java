package farcuard.tp1.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "factura")
public class Factura extends BaseEntidad{
    private int numero;
    private Date fecha;
    private double descuento;
    private String fromaPago; //(efectivo|ebc)
    private double total;
public enum Status{
    EFECTIVO, EBC
}
}
