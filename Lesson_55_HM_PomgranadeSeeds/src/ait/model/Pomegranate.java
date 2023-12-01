package ait.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Pomegranate implements Iterable<Seed> {
    private List<Seed> seeds;

    public Pomegranate(){
        seeds = new ArrayList<>();
    }
    public Pomegranate(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public void setSeeds(List<Seed> seeds) {
        this.seeds = seeds;
    }
    public boolean addSeed(Seed seed){
        return seeds.add(seed);
    }
    public int quantity(){
        return seeds.size();
    }
    public double weight(){
        return seeds.stream()
                .mapToDouble(s -> s.getWeight())
                .sum();
    }

    @Override
    public Iterator<Seed> iterator() {
        return seeds.iterator();
    }
}