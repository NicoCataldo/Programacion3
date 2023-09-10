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
@Table(name="Rubro")
public class Rubro extends ClaseBase {
    private String denominacion;
    @OneToMany(orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Rubro_id")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void agregarProductos(Producto producto){productos.add(producto);}
}