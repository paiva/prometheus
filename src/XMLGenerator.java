import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream; 
import java.io.FileNotFoundException;
import java.io.IOException; 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException; 

import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text; 


public class XMLGenerator
{
    public void XMLGenerator()
    {
                
        try{
            
            this.writeAntXML();
        }
        
        catch(ParserConfigurationException parse){
        }
        
        catch(FileNotFoundException filenotfound){
        }
        
        catch(IOException ioexception){
        }
    }
    
    public void writeAntXML() throws ParserConfigurationException , 
            FileNotFoundException, IOException
    {
                
        //Promt user for information
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Ant ID: ");
        String antID = scanner.nextLine();      
        
        //DocumentBuilderFactory
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance(); 
        //DocumentBuilder
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        //Document
        Document xmlDoc = docBuilder.newDocument();
        
        //Build XML Elements and Text Nodes
        //<ant id="1"> is the root element
        //   <body> is the bodyElement
        //      <reading> is the readingElement
        //          <gene></gene> is child of reading
        //          <expression></expression> is child of reading
        //      </reading> 
        //   </body>
        //   <AI> is the AIElement
        //      <meta></meta> This is for the Meta-Modeller
        //      <ES></ES> This is for the Expert Systems
        //      <KN></KN> This is for the Knowledge Node
        //      <NN></NN> This is for the KBCC Neural Network
        //   </AI>
        //</ant>
        
        Element rootElement = xmlDoc.createElement("ant");
        rootElement.setAttribute("ID",antID);
        
        Element bodyElement = xmlDoc.createElement("body");
        //Element readingElement = xmlDoc.createElement("reading");
        Element AIElement = xmlDoc.createElement("AI");
        
        
        for (int i = 0; i<5; i++) //Default set to 3
        {    
            Element readingElement = xmlDoc.createElement("reading");
            readingElement.setAttribute("type",Integer.toString(i));
            
            System.out.print("Enter Ant Gene: ");
            String gene = scanner.nextLine();
        
            System.out.print("Enter Ant Expression: ");
            String expression = scanner.nextLine();
            
            readingElement.appendChild(this.setAttributes("gene","code",gene,xmlDoc));      
            readingElement.appendChild(this.setAttributes("expression","code",expression,xmlDoc)); 
            //bodyElement.appendChild(this.setAttributes("truevalues","code","NULL",xmlDoc));
            
            
            bodyElement.appendChild(readingElement);
            i++;
        }
        AIElement.appendChild(this.setAttributes("META","serial","Null",xmlDoc)); 
        AIElement.appendChild(this.setAttributes("ES","serial","rule #THEN something",xmlDoc)); 
        AIElement.appendChild(this.setAttributes("KN","serial","Null",xmlDoc)); 
        AIElement.appendChild(this.setAttributes("NN","serial","Null",xmlDoc)); 
        
        
        rootElement.appendChild(bodyElement); 
        rootElement.appendChild(AIElement);
        xmlDoc.appendChild(rootElement);
       
        //Set OutputFormat
        OutputFormat outFormat = new OutputFormat(xmlDoc);
        outFormat.setIndenting(true);
        
        //Declare the File
        File xmlFile = new File("C:\\Users\\Santiago\\Documents\\NetBeansProjects"
                + "\\aidatabase\\src\\" + "ant_" + antID + ".xml");
        
        //Declare the FileOutputStream
        FileOutputStream outStream = new FileOutputStream(xmlFile);
        
        //XMLSerialized to serialize the XML data with the specified OutputFormat
        XMLSerializer serializer = new XMLSerializer(outStream,outFormat);
        //Serialize the data
        serializer.serialize(xmlDoc);
        
    
    }
    
    private Element setAttributes(String name, String att, String value, Document xmlDoc)
    {
    
        Element attributeName = xmlDoc.createElement(name);
        attributeName.setAttribute(att,value);
        
        // Comment the following two lines if we don't want any text between tags
        Text attributeText = xmlDoc.createTextNode(value);
        attributeName.appendChild(attributeText);
        
        return attributeName;
    
    }
    
}
