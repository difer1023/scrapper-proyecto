/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.colciencias.gruplac.productosInvestigacion;

import co.com.colciencias.gruplac.Institucion;
import co.com.colciencias.gruplac.Integrante;
import java.util.ArrayList;

/**
 *
 * @author L
 */
public class EstrategiaComunicacionConocimiento extends ProductoInvestigacion{
    
    private int anoInicio;
    private String descripcion;
    private String tipo;

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        this.anoInicio = anoInicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
