package com.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "unidade")
public class UnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidade")
    private long id;

    @Column(name = "nome")
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "responsible_id")
//    private UserEntity userId;

//    private int extinguisherAmount;

    public UnitEntity() {
    }

    public UnitEntity(long id, String name) {
        this.id = id;
        this.name = name;
//        this.extinguisherAmount = extinguisherAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public int getExtinguisherAmount() {
//        return extinguisherAmount;
//    }
//
//    public void setExtinguisherAmount(int extinguisherAmount) {
//        this.extinguisherAmount = extinguisherAmount;
//    }

//    public UserEntity getUserId() {
//        return userId;
//    }
//
//    public void setUserId(UserEntity userId) {
//        this.userId = userId;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
