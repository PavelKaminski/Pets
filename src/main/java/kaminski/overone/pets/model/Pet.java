package kaminski.overone.pets.model;

import java.io.Serializable;

public class Pet implements Serializable {
    private int id;
    private String species;
    private String name;
    private int age;
    private String color;
    private String owner;

    public Pet() {
    }

    public Pet(String species, String name, int age, String color, String owner) {
        this.species = species;
        this.name = name;
        this.age = age;
        this.color = color;
        this.owner = owner;
    }

    public Pet(int id, String species, String name, int age, String color, String owner) {
        this.id = id;
        this.species = species;
        this.name = name;
        this.age = age;
        this.color = color;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
