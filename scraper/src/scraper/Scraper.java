/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scraper;

import co.com.colciencias.gruplac.GrupoInvestigacion;
import co.com.colciencias.gruplac.Institucion;
import co.com.colciencias.gruplac.Integrante;
import co.com.colciencias.gruplac.LineaInvestigacion;
import co.com.colciencias.gruplac.productosInvestigacion.ArticuloInvestigacion;
import co.com.colciencias.gruplac.productosInvestigacion.LibroPublicado;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.xsoup.Xsoup;
/**
 *
 * @author L
 */
public class Scraper {
      
      public void testSelect() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://scienti.colciencias.gov.co:8080/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000001394").get();
        } catch (IOException ex) {
            Logger.getLogger(Scraper.class.getName()).log(Level.SEVERE, null, ex);
        }

        Elements elements=Xsoup.compile("/html/body/table[1]/tbody/tr").evaluate(doc).getElements();
          System.out.println("elementos"+elements.size());
        for(int i=1;i<elements.size();i++){
            
            System.out.println(Xsoup.compile("/td[2]/text()").evaluate(elements.get(i)).get());
        }
        
//        Xsoup.compile("//").evaluate(elements.get(0));
        
        List<String> list = Xsoup.compile("/html/body/table[1]/tbody/tr[2]/td[2]/text()").evaluate(doc).list();
        System.out.println(list.get(0));
        System.out.println(Xsoup.compile("/html/body/table[1]/tbody/tr[2]/td[2]/text()").evaluate(doc).get());
    }
      
      public void extraerGrupoInvestigacion(String urlGruplac){
          Document doc = null;
        try {
            doc = Jsoup.connect(urlGruplac).get();
            Elements elements=Xsoup.compile("/html/body/table[1]/tbody/tr").evaluate(doc).getElements();
            GrupoInvestigacion grupoInvestigacion = new GrupoInvestigacion();
            grupoInvestigacion.setAnoMesFormacion(Xsoup.compile("/td[2]/text()").evaluate(elements.get(1)).get());
            grupoInvestigacion.setDepartamento(Xsoup.compile("/td[2]/text()").evaluate(elements.get(2)).get().split("-")[0]);
            grupoInvestigacion.setCiudad(Xsoup.compile("/td[2]/text()").evaluate(elements.get(2)).get().split("-")[1]);
            grupoInvestigacion.setLider(Xsoup.compile("/td[2]/text()").evaluate(elements.get(3)).get());
            grupoInvestigacion.setInfoCertificacion(Xsoup.compile("/td[2]/text()").evaluate(elements.get(4)).get());
            grupoInvestigacion.setPagWeb(Xsoup.compile("/td[2]/text()").evaluate(elements.get(5)).get());
            grupoInvestigacion.setEmail(Xsoup.compile("/td[2]/text()").evaluate(elements.get(6)).get());
            grupoInvestigacion.setClasificacion(Xsoup.compile("/td[2]/text()").evaluate(elements.get(7)).get());
            grupoInvestigacion.setProgramaCienciaTecnologia(Xsoup.compile("/td[2]/text()").evaluate(elements.get(8)).get());
            grupoInvestigacion.setProgramaCienciaTecnologiaSecundario(Xsoup.compile("/td[2]/text()").evaluate(elements.get(9)).get());
            
            elements=Xsoup.compile("/html/body/table[2]/tbody/tr").evaluate(doc).getElements();
            grupoInvestigacion.setInstituciones(extraerInstituciones(elements));
            
            elements=Xsoup.compile("/html/body/table[4]/tbody/tr").evaluate(doc).getElements();
            grupoInvestigacion.setLineasInvestigacion(extraerLineasInvestigacion(elements));
            
//            elements=Xsoup.compile("/html/body/table[6]/tbody/tr").evaluate(doc).getElements();
//            grupoInvestigacion.setIntegrantes(extraerIntegrantes(elements));
            
//            elements=Xsoup.compile("/html/body/table[8]/tbody/tr").evaluate(doc).getElements();
//            grupoInvestigacion.setArticulosInvestigacion(extraerArticulosPublicados(elements));
            
            elements=Xsoup.compile("/html/body/table[9]/tbody/tr").evaluate(doc).getElements();
            grupoInvestigacion.setLibrosResultadoInvestigacion(extraerLibrosPublicados(elements));
            
            Gson gson = new Gson();
            
            System.out.println(gson.toJson(grupoInvestigacion));
        } catch (IOException ex) {
            Logger.getLogger(Scraper.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        new Scraper().extraerGrupoInvestigacion("http://scienti.colciencias.gov.co:8080/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000001394");
    }

    private ArrayList<Institucion> extraerInstituciones(Elements elements) {
        ArrayList<Institucion> instituciones = new ArrayList();
        for(int i=1;i<elements.size();i++){
            Institucion institucion = new Institucion();
            institucion.setNombre(Xsoup.compile("/td/text()").evaluate(elements.get(i)).get().split("-")[1]);
            institucion.setAvalado(Xsoup.compile("/td/text()").evaluate(elements.get(i)).get().split("-")[2].contains("(Avalado)"));
            instituciones.add(institucion);
        }
        return instituciones;
    }

    private ArrayList<LineaInvestigacion> extraerLineasInvestigacion(Elements elements) {
        ArrayList<LineaInvestigacion> lineasInvestigacion = new ArrayList();
        for(int i=1;i<elements.size();i++){
            LineaInvestigacion lineaInvestigacion = new LineaInvestigacion();
            String nombre=Xsoup.compile("/td/text()").evaluate(elements.get(i)).get();
            lineaInvestigacion.setNombre(nombre.substring(4));
            lineasInvestigacion.add(lineaInvestigacion);
        }
        return lineasInvestigacion;
    }

    private ArrayList<Integrante> extraerIntegrantes(Elements elements) {
        ArrayList<Integrante> integrantes = new ArrayList();
       for(int i=2;i<elements.size();i++){
            Integrante integrante = new Integrante();
            integrante.setNombreCompleto(Xsoup.compile("/td[1]/a/text()").evaluate(elements.get(i)).get());
            integrante.setVinculacion(Xsoup.compile("/td[2]/text()").evaluate(elements.get(i)).get());
            integrante.setHorasDedicacion(Xsoup.compile("/td[3]/text()").evaluate(elements.get(i)).get());
            integrante.setInicioVinculacion(Xsoup.compile("/td[4]/text()").evaluate(elements.get(i)).get().split("-")[0]);
            integrante.setFinVinculacion(Xsoup.compile("/td[4]/text()").evaluate(elements.get(i)).get().split("-")[1]);
            
            String url= (Xsoup.compile("/td[1]/a/@href").evaluate(elements.get(i)).get());
            Document doc = null;
            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException ex) {
                Logger.getLogger(Scraper.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String categoriaIntegrante=Xsoup.compile("/html/body/table/tbody/tr[2]/td/blockquote/table/tbody/tr[1]/td[1]/text()").evaluate(doc).get();
            
            if(categoriaIntegrante==null){

                String campo = Xsoup.compile("/html/body/div/div[3]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/text()").evaluate(doc).get();
                
                if(campo!=null && StringUtils.stripAccents(campo).equalsIgnoreCase("Categoria ")){
                categoriaIntegrante=Xsoup.compile("/html/body/div/div[3]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/text()").evaluate(doc).get();
                integrante.setCategoria(categoriaIntegrante);
                }
            }else{
                categoriaIntegrante=categoriaIntegrante.replace("Categoría", "");
                integrante.setCategoria(categoriaIntegrante);
            }
            integrantes.add(integrante);
        }
        return integrantes;
    }
    
    private ArrayList<ArticuloInvestigacion> extraerArticulosPublicados(Elements elements) {
        ArrayList<ArticuloInvestigacion> articulosPublicados = new ArrayList();
        for(int i=2;i<elements.size();i++){

            ArticuloInvestigacion articuloInvestigacion = new ArticuloInvestigacion();
            articuloInvestigacion.setTipo(Xsoup.compile("/td[2]/strong[1]/text()").evaluate(elements.get(i)).get());
            articuloInvestigacion.setNombre(Xsoup.compile("/td[2]/text(2)").evaluate(elements.get(i)).get().substring(1));

            String detalleRevista=Xsoup.compile("/td[2]/text(3)").evaluate(elements.get(i)).get();
            String nombreRevista=detalleRevista.split(",")[1].split("ISSN:")[0];
            String[] arrayISSN=detalleRevista.split(",")[1].split("ISSN:");
            String ano=detalleRevista.split(",")[2].substring(1,5);
            if(arrayISSN.length<2){
                for(int j=2;arrayISSN.length<2;j++){
                    arrayISSN=detalleRevista.split(",")[j].split("ISSN:");
                    if(arrayISSN.length<2){
                    nombreRevista+=detalleRevista.split(",")[j];
                    
                    }else{
                    nombreRevista+=detalleRevista.split(",")[j].split("ISSN:")[0];
                    ano=detalleRevista.split(",")[j+1].substring(1,5);
                    }
                }
            }
            articuloInvestigacion.setRevista(nombreRevista.substring(1, nombreRevista.length()-1));
            articuloInvestigacion.setIssn(arrayISSN[1].substring(1));
            articuloInvestigacion.setAno(Integer.parseInt(ano));
            ArrayList<Integrante> autores=new ArrayList<Integrante>();
            String[] datosAutores=Xsoup.compile("/td[2]/text(5)").evaluate(elements.get(i)).get().substring(9).split(",");
            for(int k=0;k<datosAutores.length-1;k++){
                Integrante autor=new Integrante();
                autor.setNombreCompleto(datosAutores[k].substring(1));
                autores.add(autor);
            }
            articuloInvestigacion.setAutores(autores);
            articulosPublicados.add(articuloInvestigacion);
        }
        return articulosPublicados;
    }
    
    private ArrayList<LibroPublicado> extraerLibrosPublicados(Elements elements) {
        ArrayList<LibroPublicado> librosPublicados = new ArrayList();
        for(int i=1;i<elements.size();i++){
            LibroPublicado libroPublicado = new LibroPublicado();
            libroPublicado.setTipo(Xsoup.compile("/td[2]/strong[1]/text()").evaluate(elements.get(i)).get());
            libroPublicado.setNombre(Xsoup.compile("/td[2]/text(2)").evaluate(elements.get(i)).get().substring(3));
            String detalleLibro=Xsoup.compile("/td[2]/text(3)").evaluate(elements.get(i)).get();
            libroPublicado.setPais(detalleLibro.split(",")[0].substring(1));
            libroPublicado.setAno(Integer.parseInt(detalleLibro.split(",")[1]));
            String isbn=detalleLibro.split(",")[2].split("vol:")[0].split("ISBN:")[1];
            libroPublicado.setIsbn(isbn.substring(1,isbn.length()-1));
            System.out.println("detalle"+detalleLibro);
            String[] datosAutores=Xsoup.compile("/td[2]/text(4)").evaluate(elements.get(i)).get().substring(9).split(",");
            ArrayList<Integrante> autores=new ArrayList<Integrante>();
            for(int k=0;k<datosAutores.length-1;k++){
                Integrante autor=new Integrante();
                autor.setNombreCompleto(datosAutores[k].substring(1));
                autores.add(autor);
            }
            libroPublicado.setAutores(autores);
//            libroPublicado.setIsbn(Xsoup.compile("/td[2]/text()[2]").evaluate(elements.get(i)).get());
            //articuloInvestigacion.setAno(Xsoup.compile("/td[2]/text()[3]").evaluate(elements.get(i)).get());
            //articuloInvestigacion.setAutores(Xsoup.compile("/td[2]/text()[5]").evaluate(elements.get(i)).get());
           
            librosPublicados.add(libroPublicado);
        }
        return librosPublicados;
    }
    
}
