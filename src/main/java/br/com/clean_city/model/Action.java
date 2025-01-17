package br.com.clean_city.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Table(name = "action")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Lob
    private byte[] image;
    private LocalDateTime date;
    private Boolean active;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @OneToOne(mappedBy = "action", cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL)
    private Set<Donation> donation;

}
