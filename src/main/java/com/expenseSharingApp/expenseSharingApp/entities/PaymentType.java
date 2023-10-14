package com.expenseSharingApp.expenseSharingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "payment_type")
@Table(name = "payment_type")
@Setter
@Getter
@NoArgsConstructor
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_payment_type")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
