/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Tbdepartamento;
import sys.model.Tbempleado;
import sys.model.Tbmunicipio;
import sys.model.Tbpais;

/**
 *
 * @author Neo
 */
public interface empleadoDao {
    //Metodo para mostra lista de empleados
    public List<Tbempleado> mostrarEmpleados();    
    public void nuevoEmpleado (Tbempleado tbempleado);
    public void modificarEmpleado (Tbempleado tbempleado);
    public void eliminarEmpleado (Tbempleado tbempleado);
    
           
    //metodos para llenar dinamicamente los selectonemenus
    public List<Tbpais> listarPaises();
    public List<Tbdepartamento> listarDepartamentos(Tbempleado empleado);
    public List<Tbmunicipio> listarMunicipios (Tbempleado empleado);
    
    
}
