package com.kevinll.company_service.repository.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "TMP_LLENAR_CAMPOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TmpC {

    @Id
    @Column(name = "id_company")
    private Integer idCompany;


    @Column(name = "codigo_company", length = 50)
    private String codigoCompany;

    @Column(name = "name_company", length = 50)
    private String nameCompany;

    @Column(name = "description_company", length = 50)
    private String descriptionCompany;


    @Column(name = "version_id")
    private Integer versionId;

    @Column(name = "app_id")
    private Integer appId;

    @Column(name = "version", length = 50)
    private String version;

    @Column(name = "version_description", length = 50)
    private String versionDescription;

    @Column(name = "version_company_id")
    private Integer versionCompanyId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "version_company_description", length = 50)
    private String versionCompanyDescription;


    @Column(name = "app_code", length = 50)
    private String appCode;

    @Column(name = "app_name", length = 50)
    private String appName;

    @Column(name = "app_description", length = 50)
    private String appDescription;
}

