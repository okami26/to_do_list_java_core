package org.todolist.core.model;

public class Note {
    private int id;
    private String name;
    private String note;

    public Note() {}

    public Note (String name, String note, int id) {
        this.id = id;
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
