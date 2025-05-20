package com.example.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ExtinguisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date validate;
    private String agentType;
    private String fireClass;
    private String capacity;
    private String manufacturingDate;
    private String maturityDate;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private UnitEntity unitId;

    @ManyToOne
    @JoinColumn(name = "equipment")
    private EquipamentEntity equipmentId;


    public ExtinguisherEntity() {

    }

    public ExtinguisherEntity(long id, String name, Date validate, String agentType, String fireClass,
                              String capacity, String manufacturingDate, String maturityDate, EquipamentEntity equipmentId, UnitEntity unitId) {
        this.id = id;
        this.name = name;
        this.validate = validate;
        this.agentType = agentType;
        this.fireClass = fireClass;
        this.capacity = capacity;
        this.manufacturingDate = manufacturingDate;
        this.maturityDate = maturityDate;
        this.unitId = unitId;
        this.equipmentId = equipmentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getValidate() {
        return validate;
    }

    public void setValidate(Date validate) {
        this.validate = validate;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getFireClass() {
        return fireClass;
    }

    public void setFireClass(String fireClass) {
        this.fireClass = fireClass;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public UnitEntity getUnitId() {
        return unitId;
    }

    public void setUnitId(UnitEntity unitId) {
        this.unitId = unitId;
    }

    public EquipamentEntity getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(EquipamentEntity equipmentId) {
        this.equipmentId = equipmentId;
    }
}
