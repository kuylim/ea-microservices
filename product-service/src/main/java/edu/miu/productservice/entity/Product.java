package edu.miu.productservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Author: Kuylim TITH
 * Date: 11/11/2022
 */
@Setter
@Getter
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String color;
}
