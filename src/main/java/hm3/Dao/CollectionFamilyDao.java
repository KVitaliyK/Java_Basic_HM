package hm3.Dao;

import hm3.Family;
import hm3.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    private List<Family> families = new ArrayList<>();

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

    public void loadData(List<Family> families) {
        this.families = families;
    }


    public void saveToFile(String filePath) {
        try (PrintWriter pw = new PrintWriter(filePath)) {
            int index = 0;
            for (Family f : families) {
                pw.println(index + ": family:");
                pw.println("\tmother: " + f.getMother().prettyFormat());
                pw.println("\tfather: " + f.getFather().prettyFormat());

                pw.println("\tchildren:");
                for (Human child : f.getChildren()) {
                    pw.println("\t\thuman: " + child.prettyFormat());
                }

                pw.print("\tpets: ");
                if (f.getPet() != null) {
                    pw.println("[" + f.getPet().prettyFormat() + "]");
                } else {
                    pw.println("[]");
                }

                index++;
                pw.println(); // порожній рядок між сім’ями
            }
            System.out.println("Дані успішно збережені у файл!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loadFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<Family> loadedFamilies = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
            System.out.println("Дані успішно завантажені!");
        } catch (Exception e) {
            System.out.println("Не вдалося завантажити файл: " + e.getMessage());
        }
    }
}
