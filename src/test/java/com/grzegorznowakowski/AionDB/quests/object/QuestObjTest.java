package com.grzegorznowakowski.AionDB.quests.object;

import com.grzegorznowakowski.AionDB.db.object.Settings;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grzegorz Nowakowski
 */
class QuestObjTest {

    @Test
    void testQuestHtmlOutput () {

        QuestObj quest = new QuestObj();

        int id = 2946;
        String server = "0";
        String code = "ko";


        String fileName = "static/server/" + server + "/quest/" + code + "/quest_q" + id + ".html";

        InputStream is = getFileFromResourceAsStream(fileName);

        String text = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));


        System.out.println(text);
    }

    @Test
    void checkIfFileExists () {
        String filePath = "static/server/common/quest/quest_qempty.html";
        File f = new File(filePath);
        System.out.println(f.exists());
    }


    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

}