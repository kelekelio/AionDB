package com.grzegorznowakowski.AionDB.dungeon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Grzegorz Nowakowski
 */
@Entity
@Table(name = "client_instance_cooltimes")
public class DungeonEntity {

    @Id
    @Column
    private Integer id;

    @Column
    private String name;

    public DungeonEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public DungeonEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
