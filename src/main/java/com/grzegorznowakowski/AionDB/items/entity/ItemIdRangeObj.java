package com.grzegorznowakowski.AionDB.items.entity;

/**
 * @author Grzegorz Nowakowski
 */
public class ItemIdRangeObj {

    private int min;
    private int max;

    public ItemIdRangeObj() {
    }

    public ItemIdRangeObj(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


    public void setIdRangeBasedOnType (String type) {

        switch (type) {
            case "1h_sword":
                this.min = 100000001;
                this.max = 100100000;
                break;
            case "1h_dagger":
                this.min = 100200001;
                this.max = 100299999;
                break;
            case "1h_mace":
                this.min = 100100001;
                this.max = 100199999;
                break;
            case "2h_orb":
                this.min = 100500001;
                this.max = 100599999;
                break;
            case "2h_book":
                this.min = 100600001;
                this.max = 100699999;
                break;
            case "2h_sword":
                this.min = 100900001;
                this.max = 100999999;
                break;
            case "supply_scroll":
                this.min = 164000001;
                this.max = 164039999;
                break;
            default:
                this.min = 1;
                this.max = 2;
        }

    }
}
