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
@Table(name="Domicilio")
public class Domicilio extends ClaseBase{
    private String calle;
    private String numero;
    private String localidad;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Domicilio_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedidos(Pedido pedido){pedidos.add(pedido);}

    public String toString(){
        return ("calle: "+calle+" Numero: "+numero+" Localidad "+localidad);
    }

}
