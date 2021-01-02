package com.grzegorznowakowski.AionDB.items.entity;

import com.grzegorznowakowski.AionDB.db.entity.TranslationEntity;

import javax.persistence.*;

/**
 * @author Grzegorz Nowakowski
 */
@Entity
@Table(name = "client_items")
public class ItemEntity {

    @Id
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "desc_long")
    private String descLong;

    @Column(name = "icon_name")
    private String iconName;

    @Column(name = "equipment_slots")
    private String equipmentSlots;

    @Column(name = "weapon_type")
    private String weaponType;

    @Column(name = "armor_type")
    private String armorType;

    private String quality;

    private Integer price;


















    public ItemEntity() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public String getEquipmentSlots() {
        return equipmentSlots;
    }

    public void setEquipmentSlots(String equipmentSlots) {
        this.equipmentSlots = equipmentSlots;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
