package com.cm.securityservice.models;

import com.cm.securityservice.models.enums.CmUserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cm_roles")
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    private String comment;


    @ManyToMany(mappedBy = "roles")
    private Set<CmUser> users = new HashSet<>();

}
