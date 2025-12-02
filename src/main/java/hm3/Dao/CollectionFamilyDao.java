package hm3.Dao;

import hm3.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    private final List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index < 0 || index >= families.size()) return null;
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index >= families.size()) return false;
        families.remove(index);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public Family saveFamily(Family family) {
        int index = families.indexOf(family);

        if (index != -1) {
            families.set(index, family);
        } else {
            families.add(family);
        }

        return family;
    }
}
