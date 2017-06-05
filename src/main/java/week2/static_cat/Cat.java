package week2.static_cat;

import java.util.ArrayList;

/**
 * Created by valentina on 26.05.17.
 */
public class Cat {
    private String name;
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat(String name) {
        this.name = name;
        cats.add(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void pritCats() {
        for (Cat cat : cats) {
            System.out.println(cat.getName());
        }
    }


}
