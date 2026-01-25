package com.example.expensetracker.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends AbstractEntity {

    private String name;

    private String familyName;

    @Column(unique = true)
    private String username;

    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<RoleEntity> roles;

    private String password;
}
