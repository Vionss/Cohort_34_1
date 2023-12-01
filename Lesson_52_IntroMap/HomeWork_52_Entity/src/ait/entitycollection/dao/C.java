package ait.entitycollection.dao;

import ait.entitycollection.interfaces.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class C {
    ArrayList<Entity> collection = new ArrayList<>();
    Comparator<Entity> comp = (e1, e2) -> Integer.compare(e1.getValue(), e2.getValue());

    // O(n)
    public void add(Entity entity){
        int index= Collections.binarySearch(collection, entity,comp);
        if(index < 0){
            collection.add(-index - 1, entity);
        }
    }

    // O(1)
    public Entity removeMaxValue(){
        return collection.remove(collection.size() - 1);
    }
}
