import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        List<Person> persons = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("users.xml"));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("person");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                //Create new Person Object
                Person person = new Person();

                person.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                person.setGender(eElement.getElementsByTagName("gender").item(0).getTextContent());

                String street = eElement.getElementsByTagName("street").item(0).getTextContent();
                int houseNumber = Integer.parseInt(eElement.getElementsByTagName("house_number").item(0).getTextContent());

                ////Create new Address Object
                Address addr = new Address();
                addr.setStreet(street);
                addr.setHouseNumber(houseNumber);

                person.setAddress(addr);

                //Add Person to list
                persons.add(person);
            }
        }
        System.out.println(persons);
    }
}
