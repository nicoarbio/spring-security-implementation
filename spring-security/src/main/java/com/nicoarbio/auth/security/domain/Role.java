package com.nicoarbio.auth.security.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "role")
@RequiredArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Column(nullable = false, unique = true, length = 24)
    private String role;

    @Override
    public String toString() {
        return this.role;
    }
}