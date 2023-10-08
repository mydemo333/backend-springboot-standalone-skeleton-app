package com.skeleton.app.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "username")
    private String username;

	@Column(name = "password")
    private String password;

	@Column(name = "firstName")
    private String firstName;

	@Column(name = "lastName")
    private String lastName;

}
