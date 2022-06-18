package com.klid.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Ivan Kaptue
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pref_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
}
