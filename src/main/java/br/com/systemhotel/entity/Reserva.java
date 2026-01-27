package br.com.systemhotel.entity;


import br.com.systemhotel.dto.CreateReservaDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long quartoId;

    @Column(nullable = false)
    private Long clienteId;

    @Column(name = "check_in")
    private LocalDate checkIn;

    @Column(name = "check_out")
    private LocalDate checkOut;

    @Column(name = "quantia_hospedes")
    private Integer numeroHospedes;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    private String observacoes;

    public Reserva() {}

    public Reserva(CreateReservaDTO dados) {
        this.clienteId = dados.clienteId();
        this.quartoId = dados.quartoId();
        this.checkIn = dados.checkIn();
        this.checkOut = dados.checkOut();
        this.numeroHospedes = dados.numeroHospedes();
        this.valorTotal = dados.valorTotal();
        this.observacoes = dados.observacoes();
    }

    // Getters e Setters


    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(Long quartoId) {
        this.quartoId = quartoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getNumeroHospedes() {
        return numeroHospedes;
    }

    public void setNumeroHospedes(Integer numeroHospedes) {
        this.numeroHospedes = numeroHospedes;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
