package com.grzegorznowakowski.AionDB.quests.object;

import com.grzegorznowakowski.AionDB.db.object.Settings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * @author Grzegorz Nowakowski
 */
public class QuestObj {

    private String questText;

    public QuestObj(int id) {




        InputStream is = getFileFromResourceAsStream(id);

        this.questText = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
    }

    public QuestObj() {
    }

    public String getQuestText() {
        return questText;
    }

    public void setQuestText(String questText) {
        this.questText = questText;
    }


    public InputStream getFileFromResourceAsStream(int id) {

        String server = Settings.getServerId();
        String code = Settings.getLocaCode();

        String fileName = "static/server/" + server + "/quest/" + code + "/quest_q" + id + ".html";

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {

            //file was not found, load korean version (default)
            fileName = "static/server/" + server + "/quest/ko/quest_q" + id + ".html";
            inputStream = classLoader.getResourceAsStream(fileName);

            if (inputStream == null) {
                //korean file not found, load empty quest text file. this file needs to be available.
                fileName = "static/server/common/quest/quest_qempty.html";
                return classLoader.getResourceAsStream(fileName);
            } else {
                return inputStream;
            }
        } else {
            return inputStream;
        }

    }
}
