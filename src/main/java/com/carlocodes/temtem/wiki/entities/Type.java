package com.carlocodes.temtem.wiki.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "types")
    private Set<Temtem> temtems = new HashSet<>();
    @OneToMany(mappedBy = "type")
    private Set<Technique> techniques = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "type_strength",
    joinColumns = @JoinColumn(name = "type_id"),
    inverseJoinColumns = @JoinColumn(name = "strength_id"))
    private Set<Type> strengths = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "type_weakness",
    joinColumns = @JoinColumn(name = "type_id"),
    inverseJoinColumns = @JoinColumn(name = "weakness_id"))
    private Set<Type> weaknesses = new HashSet<>();
}
