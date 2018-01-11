package models;


public class Word {
    private String entry;
    private String type;
    private String definition;
    private String synonym;

    public Word(String entry, String type, String definition, String synonym) {
        this.entry = entry;
        this.type = type;
        this.definition = definition;
        this.synonym = synonym;
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
}
