
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author 
 * 
 */

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, 
            FileNotFoundException, SAXException, IOException
    {
        
        XMLGenerator writeAntXML = new XMLGenerator();
        XMLReader readAntXML = new XMLReader();
        XMLModifier sim = new XMLModifier();
        
        readAntXML.readAntBody();
        //writeAntXML.XMLGenerator();
        
    }   
}
