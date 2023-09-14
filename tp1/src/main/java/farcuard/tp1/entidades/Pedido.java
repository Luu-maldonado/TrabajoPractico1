package farcuard.tp1.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pedido")
public class Pedido extends BaseEntidad{
    private String estado; //(iniciado|preparacion|entregado)
    private Date fecha;
    private String tipoEnvio; //(delivery|retira)
    private double total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallePedidoList = new ArrayList<DetallePedido>();

    public void agregarDetallePedido (DetallePedido deta){
        detallePedidoList.add(deta);
    }

}
