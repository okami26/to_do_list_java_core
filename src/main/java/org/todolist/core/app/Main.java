package org.todolist.core.app;

import org.todolist.core.dao.NoteDAO;
import org.todolist.core.model.Note;

import java.util.List;

public class Main {

    private static NoteDAO noteDAO = new NoteDAO();
    public static void main(String[] args) {
        List<Note> res = noteDAO.index();
        for (Note note : res) {
            System.out.println(note.getId() + "|" + note.getName() + "|" + note.getNote());;
        }
        System.out.println();




    }
}
