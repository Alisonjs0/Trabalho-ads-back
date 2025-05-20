package com.example.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class InspectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;
    private double weigth;

    @Transient
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id_usuario")
    private UserEntity inspectionAuthor;

    public InspectionEntity() {
    }

    public InspectionEntity(Date date, double weigth, UserEntity inspectionAuthor,
                            boolean manometro, boolean seal, boolean stamp, boolean damages,
                            boolean obstructions, boolean parts) {
        setId(id);
        this.date = date;
        this.weigth = weigth;
        this.inspectionAuthor = inspectionAuthor;
        this.manometro = manometro;
        this.seal = seal;
        this.stamp = stamp;
        this.damages = damages;
        this.obstructions = obstructions;
        this.parts = parts;
    }

    private boolean manometro;
    private boolean seal;
    private boolean stamp;
    private boolean damages;
    private boolean obstructions;
    private boolean parts;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public UserEntity getInspectionAuthor() {
        return inspectionAuthor;
    }

    public void setInspectionAuthor(UserEntity inspectionAuthor) {
        this.inspectionAuthor = inspectionAuthor;
    }

    public boolean isManometro() {
        return manometro;
    }

    public void setManometro(boolean manometro) {
        this.manometro = manometro;
    }

    public boolean isSeal() {
        return seal;
    }

    public void setSeal(boolean seal) {
        this.seal = seal;
    }

    public boolean isStamp() {
        return stamp;
    }

    public void setStamp(boolean stamp) {
        this.stamp = stamp;
    }

    public boolean isDamages() {
        return damages;
    }

    public void setDamages(boolean damages) {
        this.damages = damages;
    }

    public boolean isObstructions() {
        return obstructions;
    }

    public void setObstructions(boolean obstructions) {
        this.obstructions = obstructions;
    }

    public boolean isParts() {
        return parts;
    }

    public void setParts(boolean parts) {
        this.parts = parts;
    }


}
