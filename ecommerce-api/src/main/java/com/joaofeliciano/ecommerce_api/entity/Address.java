package com.joaofeliciano.ecommerce_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "adress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long idAddress;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @NotBlank
    @Column(name = "cep", nullable = false)
    private String cep;

    @NotBlank
    @Column(name = "road", nullable = false)
    private String road;

    @NotBlank
    @Column(name = "house_number", nullable = false)
    private String houseNumber;

    @NotBlank
    @Column(name = "city", nullable = false)
    private String city;

    @NotBlank
    @Column(name = "state", nullable = false)
    private String state;
}
