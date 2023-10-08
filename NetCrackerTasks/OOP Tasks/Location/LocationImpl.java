package ru.skillbench.tasks.basics.entity;

public class LocationImpl implements Location{

    private String name;
    private String fullAddress;
    private Type type;
    private Location parent;
    private boolean flag = false;

    public LocationImpl() {}
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void setParent(Location parent) {
        this.parent = parent;
    }

    @Override
    public String getParentName() {

        if(parent == null)
            return "--";
        return parent.getName();
    }

    @Override
    public Location getTopLocation() {

        if(parent == null)
            return this;


        return parent.getTopLocation();
    }

    @Override
    public boolean isCorrect() {

        if(parent == null)
            return true;

        if(type.ordinal() <= parent.getType().ordinal())
            return false;

        return parent.isCorrect();
    }

    @Override
    public String getAddress() {

        if(parent == null)
            return fullAddress + type.getNameForAddress() + name;
        if(name.indexOf('.') == name.length() - 1)
                return (name + ", " + parent.getAddress()).replace("null", "");
        else if(name.indexOf('.') < name.length() - 1) {

            if(name.indexOf(type.getNameForAddress()) == 0)
                return (name + ", " + parent.getAddress()).replace("null", "");
            return (type.getNameForAddress() + name + ", " + parent.getAddress()).replace("null", "");
        }


        return (type.getNameForAddress() + name + ", " + parent.getAddress()).replace("null", "");
    }

    @Override
    public String toString() {

        return name + " (" + type + ")";
    }
}
