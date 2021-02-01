package com.grzegorznowakowski.AionDB.assemble.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Grzegorz Nowakowski
 */
@Entity
@Table(name = "client_assemble_parts")
public class AssemblePartsEntity implements Serializable {


    @JsonIgnore
    @Id
    @Column
    private Integer id;

    @JsonIgnore
    @Column
    private String name;

    @Column(name = "part_item")
    private String partItem;

    @Column(name = "part_item_num")
    private int partItemNum;

    public AssemblePartsEntity() {
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

    public String getPartItem() {
        return partItem;
    }

    public void setPartItem(String partItem) {
        this.partItem = partItem;
    }

    public int getPartItemNum() {
        return partItemNum;
    }

    public void setPartItemNum(int partItemNum) {
        this.partItemNum = partItemNum;
    }
}
