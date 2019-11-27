package co.edu.udea.entity;

import co.edu.udea.entity.Administradores;
import co.edu.udea.entity.Clientes;
import co.edu.udea.entity.Vehiculos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-28T01:56:45")
@StaticMetamodel(Ventas.class)
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, Administradores> idAdmin;
    public static volatile SingularAttribute<Ventas, Integer> precio;
    public static volatile SingularAttribute<Ventas, Vehiculos> matriculaCoche;
    public static volatile SingularAttribute<Ventas, Clientes> idCliente;
    public static volatile SingularAttribute<Ventas, Integer> idVenta;

}