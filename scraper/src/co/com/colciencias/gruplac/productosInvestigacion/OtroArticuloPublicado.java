/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.colciencias.gruplac.productosInvestigacion;

import co.com.colciencias.gruplac.Integrante;
import java.util.ArrayList;

/**
 *
 * @author L
 */
public class OtroArticuloPublicado extends ProductoInvestigacion{
    private String pais;
    private String issn;
    private int ano;
    private String tipo;
    private ArrayList<Integrante> autores;
    private String revista;
    private String volumen;
    private String fasciculo;
    private String paginas;
    private String doi;

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public ArrayList<Integrante> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Integrante> autores) {
        this.autores = autores;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getFasciculo() {
        return fasciculo;
    }

    public void setFasciculo(String fasciculo) {
        this.fasciculo = fasciculo;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }
    
}

