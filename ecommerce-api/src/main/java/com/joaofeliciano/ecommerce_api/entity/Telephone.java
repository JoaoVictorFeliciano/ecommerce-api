package com.joaofeliciano.ecommerce_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "telephone")
@Data
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
