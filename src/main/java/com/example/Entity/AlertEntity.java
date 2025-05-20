package com.example.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerta")
public class AlertEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta") // Nome da PK no banco
    private Long id;

    @Column(name = "tipo_alerta", nullable = false)
    @NotBlank
    private String alertType;

    @Column(name = "descricao", nullable = false)
    private String description;

    @Column(name = "data_envio", nullable = false)
    private LocalDateTime sendDate;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id_usuario")
    private UserEntity alertAuthor;

    public AlertEntity() {

    }

    public AlertEntity(String alertType, String description, UserEntity alertAuthor) {
        this.alertType = alertType;
        this.description = description;
        this.alertAuthor = alertAuthor;
    }

    public AlertEntity(String alertType, String description) {
        this.alertType = alertType;
        this.description = description;
        this.sendDate = LocalDateTime.now();
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getAlertAuthor() {
        return alertAuthor;
    }

    public void setAlertAuthor(UserEntity alertAuthor) {
        this.alertAuthor = alertAuthor;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
