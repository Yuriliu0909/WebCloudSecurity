package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Parser {
    //creat xml file
    public String createXML() {
        StringWriter sw = new StringWriter();
        Food food1 = new Food("Belgian Waffles", "$5.95", "Two of our famous", 650);
        Food food2 = new Food("Strawberry Belgian Waffles", "$7.95", "Two of our famous", 900);
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(food1);
        foods.add(food2);
        BreakfastMenu bm = new BreakfastMenu(foods);
        Document document = new Document(bm);
        try {
            JAXBContext context = JAXBContext.newInstance(Document.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(document, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}
