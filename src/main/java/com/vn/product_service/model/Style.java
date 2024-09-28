package com.vn.product_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "style")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "style_id")
    private int id;

    @Column(name = "style_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "style")
    private List<Product> products;
}
