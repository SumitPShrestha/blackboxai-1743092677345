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
@Entity(name = "cm_users")
@Table
public class CmUser {
    @Id
    private Long id;

    private String username;

    private String password;

//    @Enumerated(EnumType.STRING)
//    private CmUserType userType;

    @ManyToMany
    @JoinTable(name = "user_roles", // Join table name
            joinColumns = @JoinColumn(name = "user_id"), // Foreign key column for CmUser
            inverseJoinColumns = @JoinColumn(name = "role_id") // Foreign key column for Role
    )
    private Set<Role> roles = new HashSet<>();

}
