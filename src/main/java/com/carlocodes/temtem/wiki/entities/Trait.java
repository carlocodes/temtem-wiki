package com.carlocodes.temtem.wiki.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "trait")
public class Trait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "impact")
    private String impact;

    // TODO: Multiple traits can have one trigger. Create a relationship between trait and trigger
    @Column(name = "trigger")
    private String trigger;
    // TODO: Multiple traits can have one effect. Create a relationship between trait and effect
    @Column(name = "effect")
    private String effect;
}
