/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.colciencias.gruplac.utilitarios;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class ExtractorInformacion {
    public ArrayList<String> extraerArticuloInvestigacion(String informacion){
        ArrayList<String> info=new ArrayList(); 
        info.add(informacion.split(",")[0]);
        
        return info;
    }    
}
