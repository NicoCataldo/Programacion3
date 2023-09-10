package com.example.PracticoPersistencia.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Cliente")
public class Cliente extends ClaseBase {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    public void agregarDomicilio(Domicilio domicilio){domicilios.add(domicilio);}

    public String toString(){
        return ("Nombre: "+nombre+", Apellido: "+apellido+", Telefono: "+telefono+", Domicilio: "+domicilios.toString());
    }

}
