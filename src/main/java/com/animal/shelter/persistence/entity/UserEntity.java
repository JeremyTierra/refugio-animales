package com.animal.shelter.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
        @Id
        @Column(name = "username", length = 20, nullable = false, unique = true)
        private String username;

        @Column(name = "password", length = 200, nullable = false)
        private String password;

        @Column(name = "email", length = 50)
        private String email;

        @Column(name = "locked", nullable = false, columnDefinition = "TINYINT")
        private Boolean locked;

        @Column(name = "disabled", nullable = false, columnDefinition = "TINYINT")
        private Boolean disabled;

        @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
        List<UserRoleEntity> roles;

}
