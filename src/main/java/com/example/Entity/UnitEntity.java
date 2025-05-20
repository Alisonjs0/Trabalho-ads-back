package com.example.Entity;

import jakarta.persistence.*;

@Entity
public class UnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private UserEntity userId;

    private int extinguisherAmount;

    public UnitEntity() {
    }

    public UnitEntity(long id, String name, UserEntity userId, int extinguisherAmount) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.extinguisherAmount = extinguisherAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getExtinguisherAmount() {
        return extinguisherAmount;
    }

    public void setExtinguisherAmount(int extinguisherAmount) {
        this.extinguisherAmount = extinguisherAmount;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
