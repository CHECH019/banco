package com.patrones.banco.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true, unique = true)
    private long dni;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = true)
    private String cel;

    @Column(nullable = true, unique = true)
    private String correo;

    @OneToMany(mappedBy = "cliente")
    List<CuentaAhorros> cuentas;

    @OneToMany(mappedBy = "cliente")
    List<Prestamo> prestamos;

    @OneToMany(mappedBy = "cliente")
    List<TarjetaDebito> tarjetas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<CuentaAhorros> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaAhorros> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public List<TarjetaDebito> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<TarjetaDebito> tarjetas) {
        this.tarjetas = tarjetas;
    }

    
}