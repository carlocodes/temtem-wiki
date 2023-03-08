package com.carlocodes.temtem.wiki.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "temtem")
public class Temtem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(name = "temtem_type",
            joinColumns = @JoinColumn(name = "temtem_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<Type> types = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "temtem_technique",
            joinColumns = @JoinColumn(name = "temtem_id"),
            inverseJoinColumns = @JoinColumn(name = "technique_id"))
    private Set<Technique> techniques = new HashSet<>();
    @OneToMany(mappedBy = "temtem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Statistic> statistics = new ArrayList<>();
}
