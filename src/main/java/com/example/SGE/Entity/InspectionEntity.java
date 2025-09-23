package com.example.SGE.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inspecoes")
public class InspectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inspecoes")
    private Long id;

    @Column(name = "data_inspecao", nullable = false)
    private LocalDateTime inspectionDate;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    private UserEntity inspectionAuthor;

    @ManyToOne
    @JoinColumn(name = "extintor_id", referencedColumnName = "id_extintor")
    private ExtinguisherEntity extinguisher;

    @Column(name = "manometro", nullable = false)
    private boolean manometro;

    @Column(name = "lacre", nullable = false)
    private boolean seal;

    @Column(name = "rotulo", nullable = false)
    private boolean rotulo;

    @Column(name = "danos", nullable = false)
    private boolean damages;

    @Column(name = "obstrucoes", nullable = false)
    private boolean obstructions;

    @Column(name = "sinalizacao", nullable = false)
    private boolean sinalizacao;

    @Column(name = "suporte_fixacao", nullable = false)
    private boolean suporteFixacao;

    @Column(name = "observacoes")
    private String observations;

    @Column(name = "proxima_inspecao")
    private LocalDateTime nextInspectionDate;

    public InspectionEntity() {
    }

    // Construtor atualizado com os novos campos e sem setId(id)
    public InspectionEntity(LocalDateTime inspectionDate, UserEntity inspectionAuthor, ExtinguisherEntity extinguisher,
                            boolean manometro, boolean seal, boolean rotulo, boolean damages,
                            boolean obstructions, boolean sinalizacao, boolean suporteFixacao, String observations,
                            LocalDateTime nextInspectionDate) {
        this.inspectionDate = inspectionDate;
        this.inspectionAuthor = inspectionAuthor;
        this.extinguisher = extinguisher;
        this.manometro = manometro;
        this.seal = seal;
        this.rotulo = rotulo;
        this.damages = damages;
        this.obstructions = obstructions;
        this.sinalizacao = sinalizacao;
        this.suporteFixacao = suporteFixacao;
        this.observations = observations;
        this.nextInspectionDate = nextInspectionDate;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDateTime inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public UserEntity getInspectionAuthor() {
        return inspectionAuthor;
    }

    public void setInspectionAuthor(UserEntity inspectionAuthor) {
        this.inspectionAuthor = inspectionAuthor;
    }

    public ExtinguisherEntity getExtinguisher() {
        return extinguisher;
    }

    public void setExtinguisher(ExtinguisherEntity extinguisher) {
        this.extinguisher = extinguisher;
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

    public boolean isRotulo() {
        return rotulo;
    }

    public void setRotulo(boolean rotulo) {
        this.rotulo = rotulo;
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

    public boolean isSinalizacao() {
        return sinalizacao;
    }

    public void setSinalizacao(boolean sinalizacao) {
        this.sinalizacao = sinalizacao;
    }

    public boolean isSuporteFixacao() {
        return suporteFixacao;
    }

    public void setSuporteFixacao(boolean suporteFixacao) {
        this.suporteFixacao = suporteFixacao;
    }


    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public LocalDateTime getNextInspectionDate() {
        return nextInspectionDate;
    }

    public void setNextInspectionDate(LocalDateTime nextInspectionDate) {
        this.nextInspectionDate = nextInspectionDate;
    }
}