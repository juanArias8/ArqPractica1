/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jnda
 */
@Entity
@Table(name = "Ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByIdVenta", query = "SELECT v FROM Ventas v WHERE v.idVenta = :idVenta")
    , @NamedQuery(name = "Ventas.findByPrecio", query = "SELECT v FROM Ventas v WHERE v.precio = :precio")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVenta")
    private Integer idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @JoinColumn(name = "idAdmin", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Administradores idAdmin;
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "matriculaCoche", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Vehiculos matriculaCoche;

    public Ventas() {
    }

    public Ventas(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Ventas(Integer idVenta, int precio) {
        this.idVenta = idVenta;
        this.precio = precio;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Administradores getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Administradores idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Vehiculos getMatriculaCoche() {
        return matriculaCoche;
    }

    public void setMatriculaCoche(Vehiculos matriculaCoche) {
        this.matriculaCoche = matriculaCoche;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.entity.Ventas[ idVenta=" + idVenta + " ]";
    }
    
}
