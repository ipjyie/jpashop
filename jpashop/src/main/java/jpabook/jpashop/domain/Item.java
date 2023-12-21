package jpabook.jpashop.domain;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //한테이블에 정보요소 다 집어넣기
@DiscriminatorColumn(name="dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();







}
