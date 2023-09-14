package farcuard.tp1.entidades;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "detallePedido")
public class DetallePedido extends BaseEntidad{
    private int cantidad;
    private double subtotal;

    @ManyToOne()
    @JoinColumn(name = "detallePedido_id")
    private Producto producto;

}
