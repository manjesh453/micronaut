package com.estore.users;

import com.estore.shared.Roles;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    private String email;

    private String contact;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;
}
