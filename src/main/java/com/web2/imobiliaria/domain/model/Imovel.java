package com.web2.imobiliaria.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "imoveis")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_imovel", nullable = false, length = 50)
    private String tipoImovel;

    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;

    @Column(name = "cep", nullable = false, length = 10)
    private String cep;

    @Column(name = "dormitorios", nullable = false)
    private Integer dormitorios;

    @Column(name = "banheiros", nullable = false)
    private Integer banheiros;

    @Column(name = "suites", nullable = false)
    private Integer suites;

    @Column(name = "metragem", nullable = false)
    private Integer metragem;

    @Column(name = "valor_aluguel_sug", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorAluguelSug;

    @Column(name = "obs", columnDefinition = "text")
    private String obs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(Integer dormitorios) {
        this.dormitorios = dormitorios;
    }

    public Integer getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(Integer banheiros) {
        this.banheiros = banheiros;
    }

    public Integer getSuites() {
        return suites;
    }

    public void setSuites(Integer suites) {
        this.suites = suites;
    }

    public Integer getMetragem() {
        return metragem;
    }

    public void setMetragem(Integer metragem) {
        this.metragem = metragem;
    }

    public BigDecimal getValorAluguelSug() {
        return valorAluguelSug;
    }

    public void setValorAluguelSug(BigDecimal valorAluguelSug) {
        this.valorAluguelSug = valorAluguelSug;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imovel imovel = (Imovel) o;
        return Objects.equals(id, imovel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + id +
                ", tipoImovel='" + tipoImovel + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cep='" + cep + '\'' +
                ", dormitorios=" + dormitorios +
                ", banheiros=" + banheiros +
                ", suites=" + suites +
                ", metragem=" + metragem +
                ", valorAluguelSug=" + valorAluguelSug +
                '}';
    }
}
