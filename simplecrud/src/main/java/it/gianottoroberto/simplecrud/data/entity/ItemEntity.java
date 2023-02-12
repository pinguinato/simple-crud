package it.gianottoroberto.simplecrud.data.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Data
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEntity {

    @Id
    @Column(name = "item_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    @Column(name = "item_name", nullable = false)
    private String itemName;
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "added_on", nullable = false)
    private LocalDateTime addedOn;

}
