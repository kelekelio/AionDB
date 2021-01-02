package com.grzegorznowakowski.AionDB.items.object;

import com.grzegorznowakowski.AionDB.db.service.TranslationService;
import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;

import java.text.DecimalFormat;

/**
 * @author Grzegorz Nowakowski
 */
public class ItemObj {


    private ItemEntity itemEntity;

    private String translation;
    private String descLong;
    private String price;

    public ItemObj() {
    }

    public ItemEntity getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(ItemEntity itemEntity) {
        this.itemEntity = itemEntity;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void buildItem(TranslationService translationService) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

       this.translation = translationService.findByName(itemEntity.getDescription()).getLocaString();
       this.descLong = translationService.findByName(itemEntity.getDescLong()).getLocaString();
       this.price = decimalFormat.format(itemEntity.getPrice());
    }

}
