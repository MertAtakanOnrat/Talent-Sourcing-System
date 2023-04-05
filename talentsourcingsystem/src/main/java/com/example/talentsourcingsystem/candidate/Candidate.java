package com.example.talentsourcingsystem.candidate;
import javax.persistence.*;
import java.util.List;

@Entity(name = "candidates")
@Table(name = "candidates")
public class Candidate {
    @Id
    @SequenceGenerator(
            name = "candidate_sequence",
            sequenceName = "candidate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "candidate_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(name = "contact_info",
            nullable = false,
            columnDefinition = "TEXT")
    private String contactInfo;

    @ElementCollection
    @Column(name = "interactions",
            nullable = false,
            columnDefinition = "TEXT")
    private List<String> interactions;

    @Column(name = "status",
            nullable = false,
            columnDefinition = "TEXT")
    private String status;

    public Candidate() {}
    public Candidate(String name, String contactInfo, List<String> interactions, String status) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.interactions = interactions;
        this.status = status;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<String> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<String> interactions) {
        this.interactions = interactions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", interactions=" + interactions +
                ", status='" + status + '\'' +
                '}';
    }
}
