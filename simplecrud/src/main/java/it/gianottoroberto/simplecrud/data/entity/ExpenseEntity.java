package it.gianottoroberto.simplecrud.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "expense")
@Data
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    @NotBlank(message = "Title is mandatory")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "last_update_timestamp")
    private LocalDateTime lastUpdateTimestamp;

    @Column(name = "amount")
    @NotNull(message = "Amount is mandatory")
    private Double amount;

    @Column(name = "expense_date")
    private LocalDate expenseDate;

    @Column(name = "user_id")
    private Integer userId;
}
