import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileOutputStream; 
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException; 

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text; 
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import org.xml.sax.InputSource;


public class XMLReader {

    public void readAntBody() {
        Scanner scanner = new Scanner(System.in);
        XMLModifier sim = new XMLModifier(); 
        ArrayList geneArray = new ArrayList();
        ArrayList expressionArray = new ArrayList();  
        
        try {
            
            System.out.print("Enter filename: ");
            String filename = scanner.nextLine(); 
            
            File file = new File("C:\\Users\\Santiago\\Documents\\NetBeansProjects"
                + "\\aidatabase\\src\\" + filename);
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document xmlDoc = docBuilder.parse(file);
            xmlDoc.getDocumentElement().normalize();
            
            //System.out.println("Root element " + doc.getDocumentElement().getNodeName());
            
            NodeList nodeLst = xmlDoc.getElementsByTagName("reading");
            
            System.out.println("Ant Data:");

            for (int s = 0; s < nodeLst.getLength(); s++) {

                Node fstNode = nodeLst.item(s);

                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element fstElmnt = (Element) fstNode;
                    
                    NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("gene");
                    Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    String geneValue = fstNm.item(0).getNodeValue(); 
                    geneArray.add(geneValue);
                    
                    //System.out.println("Gene : " + ((Node) fstNm.item(0)).getNodeValue());
                    
                    NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("expression");
                    Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
                    NodeList lstNm = lstNmElmnt.getChildNodes();
                    String expressionValue = lstNm.item(0).getNodeValue();
                    expressionArray.add(expressionValue);
                    
                    //System.out.println("Expression : " + ((Node) lstNm.item(0)).getNodeValue());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //System.out.println("Gene Array " + geneArray);
        //System.out.println("Expression Array " + expressionArray);
        
        sim.generateTrueVals(geneArray, expressionArray);
    
    }
}

