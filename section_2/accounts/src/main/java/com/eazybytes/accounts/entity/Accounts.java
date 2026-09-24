package com.eazybytes.accounts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity implements Persistable<Long> {
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "account_number")
    @Id
    private Long accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name= "branch_adress")
    private String branchAdress;

    @Transient
    private boolean isNew = true;

    @Override
    public Long getId() {
        return accountNumber;
    }
}
