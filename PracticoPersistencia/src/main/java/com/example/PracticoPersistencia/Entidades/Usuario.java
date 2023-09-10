package com.example.PracticoPersistencia.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Usuario")
public class Usuario extends ClaseBase {
    private String nombre;
    private String password;
    private String rol;
    @OneToMany()
    @JoinColumn(name = "Usuario_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedido){pedidos.add(pedido);}

    public String toString(){
        return ("Nombre: "+nombre+", Rol: "+rol);
    }

}
