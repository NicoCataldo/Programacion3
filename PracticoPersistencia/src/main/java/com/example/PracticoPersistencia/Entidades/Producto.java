package com.example.PracticoPersistencia.Entidades;

import com.example.PracticoPersistencia.Enums.Tipo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Producto")
public class Producto extends ClaseBase{
    private Tipo tipo;
    private int tiempoEstimado;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stoclMinimo;
    private String unidadMedida;
    private String foto;
    private String reseta;


}
