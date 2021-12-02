package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name="breakfast_menu")
public class BreakfastMenu {
    private ArrayList<Food> foodItems = new ArrayList<>();

    public BreakfastMenu() {}

    public BreakfastMenu(ArrayList<Food> foodItems) {
        this.foodItems = foodItems;
    }

    @XmlElement(name="food")
    public ArrayList<Food> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<Food> foodItems) {
        this.foodItems = foodItems;
    }
}
