package com.vn.product_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "size")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_id")
    private int id;

    @Column(name = "size_name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "sizes")
    private List<Product> products;

}
