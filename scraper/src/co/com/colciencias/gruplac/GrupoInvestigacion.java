/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.colciencias.gruplac;

import co.com.colciencias.gruplac.productosInvestigacion.ArticuloInvestigacion;
import co.com.colciencias.gruplac.productosInvestigacion.LibroPublicado;
import co.com.colciencias.gruplac.productosInvestigacion.ProductoInvestigacion;
import java.util.ArrayList;

/**
 *
 * @author L
 */
public class GrupoInvestigacion {
    private String nombre;
    private String anoMesFormacion;
    private String departamento;
    private String ciudad;
    private String lider;
    private String infoCertificacion;
    private String pagWeb;
    private String email;
    private String clasificacion;
    private String areaConocimiento;
    private String programaCienciaTecnologia;
    private String programaCienciaTecnologiaSecundario;
    private ArrayList<Institucion> instituciones;
    private ArrayList<LineaInvestigacion> lineasInvestigacion;
    private ArrayList<Integrante> integrantes;
    private ArrayList<ProductoInvestigacion> productosInvestigacion;
    private ArrayList<ArticuloInvestigacion> articulosInvestigacion;
    private ArrayList<LibroPublicado> librosResultadoInvestigacion;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnoMesFormacion() {
        return anoMesFormacion;
    }

    public void setAnoMesFormacion(String anoMesFormacion) {
        this.anoMesFormacion = anoMesFormacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public String getInfoCertificacion() {
        return infoCertificacion;
    }

    public void setInfoCertificacion(String infoCertificacion) {
        this.infoCertificacion = infoCertificacion;
    }

    public String getPagWeb() {
        return pagWeb;
    }

    public void setPagWeb(String pagWeb) {
        this.pagWeb = pagWeb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getAreaConocimiento() {
        return areaConocimiento;
    }

    public void setAreaConocimiento(String areaConocimiento) {
        this.areaConocimiento = areaConocimiento;
    }

    public String getProgramaCienciaTecnologia() {
        return programaCienciaTecnologia;
    }

    public void setProgramaCienciaTecnologia(String programaCienciaTecnologia) {
        this.programaCienciaTecnologia = programaCienciaTecnologia;
    }

    public String getProgramaCienciaTecnologiaSecundario() {
        return programaCienciaTecnologiaSecundario;
    }

    public void setProgramaCienciaTecnologiaSecundario(String programaCienciaTecnologiaSecundario) {
        this.programaCienciaTecnologiaSecundario = programaCienciaTecnologiaSecundario;
    }

    public ArrayList<Institucion> getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(ArrayList<Institucion> instituciones) {
        this.instituciones = instituciones;
    }

    public ArrayList<LineaInvestigacion> getLineasInvestigacion() {
        return lineasInvestigacion;
    }

    public void setLineasInvestigacion(ArrayList<LineaInvestigacion> lineasInvestigacion) {
        this.lineasInvestigacion = lineasInvestigacion;
    }

    public ArrayList<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public ArrayList<ProductoInvestigacion> getProductosInvestigacion() {
        return productosInvestigacion;
    }

    public void setProductosInvestigacion(ArrayList<ProductoInvestigacion> productosInvestigacion) {
        this.productosInvestigacion = productosInvestigacion;
    }

    public ArrayList<ArticuloInvestigacion> getArticulosInvestigacion() {
        return articulosInvestigacion;
    }

    public void setArticulosInvestigacion(ArrayList<ArticuloInvestigacion> articulosInvestigacion) {
        this.articulosInvestigacion = articulosInvestigacion;
    }

    public ArrayList<LibroPublicado> getLibrosResultadoInvestigacion() {
        return librosResultadoInvestigacion;
    }

    public void setLibrosResultadoInvestigacion(ArrayList<LibroPublicado> librosResultadoInvestigacion) {
        this.librosResultadoInvestigacion = librosResultadoInvestigacion;
    }
}
