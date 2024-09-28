package com.vn.product_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "color")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private int id;

    @Column(name = "color_name", nullable = false)
    private String name;

    @Column(name = "color_code")
    private String code;

    @ManyToMany(mappedBy = "colors")
    private List<Product> products;
}
