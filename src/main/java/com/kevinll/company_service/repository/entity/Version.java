package com.kevinll.company_service.repository.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "version")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Version {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_id")
    private Long id;

    // Relación MANY-TO-ONE - Application (FK app_id) */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "app_id", nullable = false)
    private Application application;

    ///
    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "version_description", length = 50, nullable = false)
    private String description;
}

