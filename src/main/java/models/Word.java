package models;


import java.util.ArrayList;

public class Word {
    private String entry;
    private String type;
    private String definition;
    private String synonym;
    private int id;
    private static ArrayList<Word> submissions = new ArrayList<>();

    public Word(String entry, String type, String definition, String synonym) {
        this.entry = entry;
        this.type = type;
        this.definition = definition;
        this.synonym = synonym;
        submissions.add(this);
        this.id = submissions.size();
    }

    public String getEntry(){
        return entry;
    }

    public String getType() {
        return type;
    }

    public String getDefinition() {
        return definition;
    }

    public String getSynonym() {
        return synonym;
    }

    public static ArrayList<Word> getAll() {
        return submissions;
    }

    public int getId() {
        return id;
    }

    public static Word findById(int id) {
        return submissions.get(id-1);
    }

    public static void clearAllWords() {
        submissions.clear();
    }
}
