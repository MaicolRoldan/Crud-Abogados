package com.crud.abogados.entity;

import jakarta.persistence.*;

@Entity
public class AsuntoProcurador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Asunto asunto;

    @ManyToOne
    private Procurador procurador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Asunto getAsunto() {
        return asunto;
    }

    public void setAsunto(Asunto asunto) {
        this.asunto = asunto;
    }

    public Procurador getProcurador() {
        return procurador;
    }

    public void setProcurador(Procurador procurador) {
        this.procurador = procurador;
    }
}
