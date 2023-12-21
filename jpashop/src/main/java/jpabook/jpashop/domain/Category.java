package jpabook.jpashop.domain;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Category {
    @Id@GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @ManyToMany
    @JoinTable(name = "category_item",
        joinColumns = @JoinColumn(name="category_id"),
            inverseJoinColumns = @JoinColumn(name="item_id") //item쪽으로 들어가는 매핑
    ) //중간테이블 매핑
    private List<Item> items = new ArrayList<>();


}
