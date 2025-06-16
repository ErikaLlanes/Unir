package com.unir.biblioteca.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name="prestamos")
@NoArgsConstructor
@Getter
@Setter
public class PrestamoEntity {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prestamo_id", nullable = false)
    private Integer prestamoId;    
    @Column(name="prestamo_cedula_usuario", nullable = false, length = 12)
    private Integer prestamoCedulaUsuario;        
    @Column(name="prestamo_fecha_entrega", nullable = false)    
    private Date prestamofechaEntrega;
    @Column(name="prestamo_fecha_devolucion" , nullable = false)
    private Date prestamoFechaDevolucion;
    @Column(name="prestamo_entregado", nullable = false)
    private boolean prestamoEntregado;    
    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private UsuarioEntity usuario;
     @OneToMany(mappedBy = "prestamo")
    private Set<PrestamoLibroEntity> prestamoLibros;
 }