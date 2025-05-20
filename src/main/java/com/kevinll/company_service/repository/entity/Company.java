package com.kevinll.company_service.repository.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private Long id;

    @Column(name = "codigo_company", length = 50)
    private String codigo;

    @Column(name = "name_company", length = 50)
    private String nombre;

    @Column(name = "description_company", length = 50)
    private String descripcion;
}

