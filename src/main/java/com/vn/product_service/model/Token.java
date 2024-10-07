package com.vn.product_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "token")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "token", length = 255, nullable = false)
    private String token;

    @Column(name = "token_type", length = 50)
    private String tokenType;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "revoked", nullable = false)
    private Boolean revoked;

    @Column(name = "expired", nullable = false)
    private Boolean expired;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
