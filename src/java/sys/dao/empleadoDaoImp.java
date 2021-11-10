/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.model.Tbdepartamento;
import sys.model.Tbempleado;
import sys.model.Tbmunicipio;
import sys.model.Tbpais;
import sys.util.HibernateUtil;

/**
 *
 * @author Neo
 */
public class empleadoDaoImp implements empleadoDao{

    @Override
    public List<Tbempleado> mostrarEmpleados() {
        List<Tbempleado> listarEmpleados = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql="FROM Tbempleado as e inner join fetch e.tbpais left join fetch e.tbdepartamento left join fetch e.tbmunicipio";
        
        try {
            listarEmpleados = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        
        return listarEmpleados;                        
    }

    @Override
    public void nuevoEmpleado(Tbempleado tbempleado) {
        Session session = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tbempleado);
            session.getTransaction().commit();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();            
        }finally{
            if (session!=null) {
                session.close();
            }
        }
    }    
    
    
    @Override
    public void modificarEmpleado(Tbempleado tbempleado) {
        Session session = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(tbempleado);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();            
        }finally{
            if (session!=null) {
                session.close();
            }
        }
    }

    @Override
    public void eliminarEmpleado(Tbempleado tbempleado) {
        Session session = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(tbempleado);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();            
        }finally{
            if (session!=null) {
                session.close();
            }
        }
    }

    @Override
    public List<Tbpais> listarPaises() {
        List<Tbpais> listaPaises = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql="FROM Tbpais";
        
        try {
            listaPaises = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        
        return listaPaises;
    }

    @Override
    public List<Tbdepartamento> listarDepartamentos(Tbempleado empleado) {
        List<Tbdepartamento> listaDeptos = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql="FROM Tbdepartamento WHERE idPais = '"+empleado.getTbpais().getIdPais()+"'";
        
        try {
            listaDeptos = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        
        return listaDeptos;
    }

    @Override
    public List<Tbmunicipio> listarMunicipios(Tbempleado empleado) {
        List<Tbmunicipio> listaMunicipios = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql="FROM Tbmunicipio WHERE idDepartamento = '"+empleado.getTbdepartamento().getIdDepartamento()+"'";
        
        try {
            listaMunicipios = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        
        return listaMunicipios;
    }

    

   
    
    
    
    
}
