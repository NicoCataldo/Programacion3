package com.example.PracticoPersistencia.Entidades;

import com.example.PracticoPersistencia.Enums.Estado;
import com.example.PracticoPersistencia.Enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Pedido")
public class Pedido extends ClaseBase{
    private LocalDate fecha;
    private Estado estado;
    private LocalTime horaEstimadaEntrega;
    private TipoEnvio tipoEnvio;
    private double total;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Pedido_id")
    @Builder.Default
    private List<DetallePedido> Detalles = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Pedido_id")
    @Builder.Default
    private List<Factura> facturas = new ArrayList<>();


    public void agregarDetalle(DetallePedido detalle){
        Detalles.add(detalle);
    }
    public void agregarFactura(Factura factura){facturas.add(factura);}
}
