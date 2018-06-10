package com.devglan.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.logging.Logger;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.*;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "statuspessoa")
@SuppressWarnings("unused")
public class Statuspessoa implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Statuspessoa.class.getName());

    // Raw attributes
    private Integer id;
    private String nmsCompleto;
    private Instant dhdAtualizacao;
    private Integer idiPrincipal;
    private String cdsPadrao;

    @Override
    public String entityClassName() {
        return Statuspessoa.class.getSimpleName();
    }

    // -- [id] ------------------------
    @GeneratedValue(generator = "statuspessoa-generator")
    @GenericGenerator(name = "statuspessoa-generator",
            strategy = "com.devglan.model.generator.AppCustomGenerator")
    @Override
    @Digits(integer = 10, fraction = 0)
    @NotNull
    @Column(name = "IdiStatusPessoa", precision = 10)
    @Id
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Statuspessoa id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [nmsCompleto] ------------------------

    @Size(max = 40)
    @Column(name = "NmsCompleto", length = 40)
    public String getNmsCompleto() {
        return nmsCompleto;
    }

    public void setNmsCompleto(String nmsCompleto) {
        this.nmsCompleto = nmsCompleto;
    }

    public Statuspessoa nmsCompleto(String nmsCompleto) {
        setNmsCompleto(nmsCompleto);
        return this;
    }
    // -- [dhdAtualizacao] ------------------------

    @Column(name = "DhdAtualizacao", length = 19)
    public Instant getDhdAtualizacao() {
        return dhdAtualizacao;
    }

    public void setDhdAtualizacao(Instant dhdAtualizacao) {
        this.dhdAtualizacao = dhdAtualizacao;
    }

    public Statuspessoa dhdAtualizacao(Instant dhdAtualizacao) {
        setDhdAtualizacao(dhdAtualizacao);
        return this;
    }
    // -- [idiPrincipal] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "IdiPrincipal", precision = 10)
    public Integer getIdiPrincipal() {
        return idiPrincipal;
    }

    public void setIdiPrincipal(Integer idiPrincipal) {
        this.idiPrincipal = idiPrincipal;
    }

    public Statuspessoa idiPrincipal(Integer idiPrincipal) {
        setIdiPrincipal(idiPrincipal);
        return this;
    }
    // -- [cdsPadrao] ------------------------

    @Size(max = 20)
    @Column(name = "CdsPadrao", length = 20)
    public String getCdsPadrao() {
        return cdsPadrao;
    }

    public void setCdsPadrao(String cdsPadrao) {
        this.cdsPadrao = cdsPadrao;
    }

    public Statuspessoa cdsPadrao(String cdsPadrao) {
        setCdsPadrao(cdsPadrao);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Statuspessoa withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Statuspessoa && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Statuspessoa instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("nmsCompleto", getNmsCompleto()) //
                .add("dhdAtualizacao", getDhdAtualizacao()) //
                .add("idiPrincipal", getIdiPrincipal()) //
                .add("cdsPadrao", getCdsPadrao()) //
                .toString();
    }
}
