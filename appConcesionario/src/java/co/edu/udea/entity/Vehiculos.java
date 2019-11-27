/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.entity;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URLConnection;
import java.util.Base64;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jnda
 */
@Entity
@Table(name = "Vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")
    , @NamedQuery(name = "Vehiculos.findByMatricula", query = "SELECT v FROM Vehiculos v WHERE v.matricula = :matricula")
    , @NamedQuery(name = "Vehiculos.findByMarca", query = "SELECT v FROM Vehiculos v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculos.findByModelo", query = "SELECT v FROM Vehiculos v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculos.findByPrecio", query = "SELECT v FROM Vehiculos v WHERE v.precio = :precio")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculaCoche")
    private List<Ventas> ventasList;

    public Vehiculos() {
    }

    public Vehiculos(String matricula) {
        this.matricula = matricula;
    }

    public Vehiculos(String matricula, String marca, String modelo, int precio, byte[] imagen) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    public String getFotoBase64() throws IOException {
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(imagen));
        String mimeType = URLConnection.guessContentTypeFromStream(is);

        is.close();

        String base64 = Base64.getEncoder().encodeToString(imagen);

        return "data:" + mimeType + ";base64," + base64;
    }
    
    @Override
    public String toString() {
        return "co.edu.udea.entity.Vehiculos[ matricula=" + matricula + " ]";
    }

}
