package com.grzegorznowakowski.AionDB;

import com.grzegorznowakowski.AionDB.quests.object.Customer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/**
 * @author Grzegorz Nowakowski
 */
public class MainTest {


    public static void main(String[] args) throws JAXBException, IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        MainTest app = new MainTest();

        String fileName = "quest_qempty.html";

        //JAXBContext jc = JAXBContext.newInstance(Customer.class);
        //Unmarshaller unmarshaller = jc.createUnmarshaller();

        //HtmlPages quest = (HtmlPages) unmarshaller.unmarshal(fileName);



        FileInputStream xmlInputStream = new FileInputStream("P:\\quest_qempty.html");

        String conents = new String(Files.readAllBytes(Paths.get("P:\\quest_qempty.html")));

        //Unmarshaller unmarshaller = jc.createUnmarshaller();
        //Customer quest = (Customer) unmarshaller.unmarshal(xmlInputStream);

        conents = conents.replaceAll("<Contents cdata=\"true\">", "<Content><![CDATA[");
        conents = conents.replaceAll("</Contents>", "]]></Content>");

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(conents));

        Document xmlDocument = builder.parse(is);
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "/HtmlPages/HtmlPage[@name=" + "'quest_summary'" + "]";

        Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);

        //System.out.println(node.getTextContent());

        System.out.println(getNodeString(xmlDocument, expression));
        System.out.println(getNodeString(xmlDocument, "/HtmlPages/HtmlPage[@name='select2_1']"));


    }

    public static String getNodeString (Document xmlDocument, String expression) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
        return node.getTextContent();
    }

    private static String nodeToString(Node node) {
        StringWriter sw = new StringWriter();
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(node), new StreamResult(sw));
        } catch (TransformerException te) {
            System.out.println("nodeToString Transformer Exception");
        }
        return sw.toString();
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



    // print input stream
    private static void printInputStream(InputStream is) {

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
