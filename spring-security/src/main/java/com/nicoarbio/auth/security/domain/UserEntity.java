package com.nicoarbio.auth.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name = "app_user")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(nullable = false, unique = true, length = 36)
    private String id;

    @Email
    private String email;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class)//, fetch = FetchType.EAGER)
    private List<Role> roles;

    private String extraInfo;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean accountLocked = Boolean.FALSE;

}
