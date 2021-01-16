package com.grzegorznowakowski.AionDB.db.object;

/**
 * @author Grzegorz Nowakowski
 */
public class Settings {
    private String server;
    private String loca;

    public Settings() {
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLoca() {
        return loca;
    }

    public void setLoca(String loca) {
        this.loca = loca;
    }
}
