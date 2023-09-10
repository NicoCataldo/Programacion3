package com.example.PracticoPersistencia.Entidades;

import com.example.PracticoPersistencia.Enums.FormasDePago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Factura")
public class Factura extends ClaseBase{
    private LocalDate fecha;
    private int numero;
    private double descuento;
    private double total;
    private FormasDePago formasDePago;
}
