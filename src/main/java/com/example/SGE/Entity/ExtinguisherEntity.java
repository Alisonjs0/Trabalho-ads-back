package com.example.SGE.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "extintor")
public class ExtinguisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_extintor")
    private long id;

//    @Column(name = "nome", nullable = false, length = 100)
//    private String name;

    @Column(name = "validade", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date validate;

    @Column(name = "tipo_agente", length = 50, nullable = false)
    private String agentType;

    @Column(name = "classe_incendio", length = 3, nullable = false)
    private String fireClass;

    @Column(name = "capacidade")
    private double capacity;

    @Column(name = "data_fabricacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date manufacturingDate;

//    @Column(name = "vencimento", nullable = false)
//    @Temporal(TemporalType.DATE)
//    private Date maturityDate;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private UnitEntity unitId;

    @ManyToOne
    @JoinColumn(name = "tipoequipamento_id")
    private EquipamentEntity equipmentId;


    public ExtinguisherEntity() {

    }

    // Construtor corrigido para aceitar Date para manufacturingDate
    public ExtinguisherEntity(long id, Date validate, String agentType, String fireClass,
                              double capacity, Date manufacturingDate, EquipamentEntity equipmentId, UnitEntity unitId) {
        this.id = id;
        this.validate = validate;
        this.agentType = agentType;
        this.fireClass = fireClass;
        this.capacity = capacity;
        this.manufacturingDate = manufacturingDate;
        this.unitId = unitId;
        this.equipmentId = equipmentId;
    }

    // Getters e Setters (manufacturingDate agora retorna e aceita Date)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

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

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Date getManufacturingDate() { // Retorna Date
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) { // Aceita Date
        this.manufacturingDate = manufacturingDate;
    }

//    public Date getMaturityDate() {
//        return maturityDate;
//    }
//
//    public void setMaturityDate(Date maturityDate) {
//        this.maturityDate = maturityDate;
//    }

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