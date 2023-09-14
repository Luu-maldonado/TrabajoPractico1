package farcuard.tp1.entidades;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cliente")//se llama igual que la clase pero podria no llamarse asi, si se va a llamar igual no hace falta ponerselo
public class Cliente extends BaseEntidad {
    @Column(name = "nombre")
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    //fetch = FetchType.EAGER
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Domicilio> domicilioList = new ArrayList<Domicilio>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Pedido> pedidoList = new ArrayList<Pedido>();

    public void agregarDomicilio(Domicilio domi){
        domicilioList.add(domi);
    }
    public void agregarPedido(Pedido pedi){
        pedidoList.add(pedi);
    }


}
