package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
                    joinColumns = @JoinColumn(name = "CATEGORY_ID"), //내가 조인하는 컬럼
                    inverseJoinColumns = @JoinColumn(name = "ITEM_ID")) //반대 쪽이 조인하는 컬럼
    private List<Item> items = new ArrayList<>();

}
