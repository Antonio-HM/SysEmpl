/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import sys.dao.empleadoDao;
import sys.dao.empleadoDaoImp;
import sys.model.Tbdepartamento;
import sys.model.Tbempleado;
import sys.model.Tbmunicipio;
import sys.model.Tbpais;

/**
 *
 * @author Neo
 */
@ManagedBean
@ViewScoped
public class empleadoBean {

    private List<Tbempleado> listar;
    private Tbempleado empleado;

    private List<SelectItem> listPaises;
    private List<SelectItem> listDeptos;
    private List<SelectItem> listMunicipios;
    
    
    public empleadoBean() {
        empleado = new Tbempleado();
    }
    
    public Tbempleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Tbempleado empleado) {
        this.empleado = empleado;
    }

    public List<Tbempleado> getListar() {
        empleadoDao eDao = new empleadoDaoImp();
        listar = eDao.mostrarEmpleados();        
        return listar;
    }
    
    public void preparNuevoEmpleado(ActionEvent actionEvent){
        empleado= new Tbempleado();
    }
    
    public void nuevoEmpleado(){
        empleadoDao eDao = new empleadoDaoImp();
        eDao.nuevoEmpleado(empleado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","El registro se guardó satisfactoriamente"));
    }
     
    public void modificarEmpleado(){
        empleadoDao eDao = new empleadoDaoImp();
        eDao.modificarEmpleado(empleado);
        empleado= new Tbempleado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","El registro se actualizó satisfactoriamente"));
    }
    
    public void eliminarEmpleado(){
        empleadoDao eDao = new empleadoDaoImp();
        eDao.eliminarEmpleado(empleado);
        empleado= new Tbempleado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","El registro se eliminó satisfactoriamente"));
    }

    public List<SelectItem> getListPaises() {               
        this.listPaises = new ArrayList<SelectItem>();
        empleadoDao eDao = new empleadoDaoImp();
        List<Tbpais> p = eDao.listarPaises();
        listPaises.clear();
        
        for (Tbpais pais : p) {
            SelectItem paisItem = new SelectItem(pais.getIdPais(), pais.getNombrePais());
            this.listPaises.add(paisItem);
        }
                
        return listPaises;
    }

    public List<SelectItem> getListDeptos() {
        this.listDeptos = new ArrayList<SelectItem>();
        empleadoDao eDao = new empleadoDaoImp();
        List<Tbdepartamento> d = eDao.listarDepartamentos(this.empleado);
        listDeptos.clear();
        
        for (Tbdepartamento depto : d) {
            SelectItem departamentosItem = new SelectItem(depto.getIdDepartamento(), depto.getNombreDepartamento());
            this.listDeptos.add(departamentosItem);
        }
        return listDeptos;
    }

    public List<SelectItem> getListMunicipios() {
        this.listMunicipios = new ArrayList<SelectItem>();
        empleadoDao eDao = new empleadoDaoImp();
        List<Tbmunicipio> m = eDao.listarMunicipios(this.empleado);
        listMunicipios.clear();
        
        for (Tbmunicipio mun : m) {
            SelectItem municipiosItem = new SelectItem(mun.getIdMunicipio(), mun.getNombreMunicipio());
            this.listMunicipios.add(municipiosItem);
        }
        return listMunicipios;
    }
    
    public void cancelar()
    {
        empleado= new Tbempleado();        
    }    
}
