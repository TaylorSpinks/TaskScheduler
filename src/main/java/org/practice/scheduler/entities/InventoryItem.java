package org.practice.scheduler.entities;

import java.util.Objects;

public class InventoryItem {

    private String name;
    private String type;

    public InventoryItem(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public InventoryItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.name = type;
    }

    public String getItemTypeAndName() {
        return this.name + " " + this.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InventoryItem that = (InventoryItem) obj;
        return Objects.equals(name, that.name);
    }
}
