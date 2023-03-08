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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "technique")
public class Technique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToOne
    private Type type;
    @Column(name = "description")
    private String description;
    @Column(name = "damage")
    private Integer damage;
    @Column(name = "stamina_cost")
    private Integer staminaCost;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class techniqueClass;
    @ManyToOne
    private Hold hold;
    @ManyToOne
    private Priority priority;
    @ManyToOne
    private Target target;
}
