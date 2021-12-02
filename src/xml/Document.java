package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="document")
public class Document {
    private BreakfastMenu bm;

    public Document() {}

    public Document(BreakfastMenu bm) {
        this.bm = bm;
    }

    @XmlElement(name="breakfast_menu")
    public BreakfastMenu getBm() {
        return bm;
    }

    public void setBm(BreakfastMenu bm) {
        this.bm = bm;
    }
}
