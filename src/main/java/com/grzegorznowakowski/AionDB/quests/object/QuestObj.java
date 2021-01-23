package com.grzegorznowakowski.AionDB.quests.object;

import com.grzegorznowakowski.AionDB.db.object.Settings;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author Grzegorz Nowakowski
 */
public class QuestObj {

    private String questText;

    public QuestObj(int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document xmlDocument = builder.parse(getXmlInputSource(1));

        this.questText =
                getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select1')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select2')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select3')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select4')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select5')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select6')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select7')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select8')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select9')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select10')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select11')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select12')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select13')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select_success')]") +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'select_quest_reward')]") + "Completion: " +
                        getNodeList(xmlDocument, "//HtmlPage[starts-with(@name, 'quest_complete')]")
                ;


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

    private InputSource getXmlInputSource (int id) throws IOException {
        String server = "0";
        String code = "ko";

        String conents = new String(Files.readAllBytes(Paths.get("P:\\Coding\\AionDB\\src\\main\\resources\\static\\server\\" + server + "\\quest\\" + code + "\\quest_q2946.html")));

        conents = conents.replaceAll("<Contents cdata=\"true\">", "<Content><![CDATA[");
        conents = conents.replaceAll("</Contents>", "]]></Content>");

        InputSource is = new InputSource(new StringReader(conents));

        return is;

    }

    public static String getNodeString (Document xmlDocument, String expression) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);

        if (node == null) {
            return "";
        } else {
            return node.getTextContent();
        }
    }

    public static String getNodeList (Document xmlDocument, String expression) throws XPathExpressionException {

        StringBuilder questHtml = new StringBuilder();

        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nl = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

        for(int i=0; i < nl.getLength() ; i++) {
            Node node = nl.item(i);
            //System.out.println(node.getTextContent());
            questHtml.append(node.getTextContent());
        }
        return questHtml.toString();
    }
}
