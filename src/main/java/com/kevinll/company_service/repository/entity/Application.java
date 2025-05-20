package com.kevinll.company_service.repository.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "application")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {


    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long id;


    @Column(name = "app_code")
    private String code;

    @Column(name = "app_name", length = 50)
    private String name;

    @Column(name = "app_description", length = 50)
    private String description;
}

