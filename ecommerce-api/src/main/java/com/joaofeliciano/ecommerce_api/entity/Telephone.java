package com.joaofeliciano.ecommerce_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "telephone")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telephone")
    private Long idTelephone;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @NotBlank
    @Column(name = "number_phone", nullable = false)
    private String numberPhone;
}
