package co.edu.udea.entity;

import co.edu.udea.entity.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-28T01:56:45")
@StaticMetamodel(Vehiculos.class)
public class Vehiculos_ { 

    public static volatile SingularAttribute<Vehiculos, String> marca;
    public static volatile SingularAttribute<Vehiculos, Integer> precio;
    public static volatile SingularAttribute<Vehiculos, String> matricula;
    public static volatile SingularAttribute<Vehiculos, byte[]> imagen;
    public static volatile ListAttribute<Vehiculos, Ventas> ventasList;
    public static volatile SingularAttribute<Vehiculos, String> modelo;

}