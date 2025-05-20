package com.kevinll.company_service.repository.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "version_company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VersionCompany {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_company_id")
    private Long id;

    /** FK a 'company' (id_company) */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    /** FK a 'version' (version_id) */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "version_id", nullable = false)
    private Version version;

    @Column(name = "version_company_description", length = 50, nullable = false)
    private String description;
}
