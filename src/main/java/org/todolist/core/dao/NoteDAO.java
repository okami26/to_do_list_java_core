package org.todolist.core.dao;

import org.todolist.core.model.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    private static final Connection connection;


    static {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

    public List<Note> index(){
        List<Note> notes = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM notes";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Note note = new Note();
                note.setId(resultSet.getInt("id"));
                note.setName(resultSet.getString("name"));
                note.setNote(resultSet.getString("note"));
                notes.add(note);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return notes;
    }
    public Note show(int id){
        Note note = null;

        try {

            note = new Note();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM notes WHERE id=?");

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            note.setId(resultSet.getInt("id"));
            note.setName(resultSet.getString("name"));
            note.setNote(resultSet.getString("note"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return note;
    }

    public void save(Note note) {




        try {


            PreparedStatement statement = connection.prepareStatement("INSERT Into notes (name, note) " +
                    "values (?, ?)");

            statement.setString(1, note.getName());
            statement.setString(2, note.getNote());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(int id, Note updateNote) {



        try {

            PreparedStatement statement = connection.prepareStatement("UPDATE notes SET name=?, note=? WHERE id=?");
            statement.setString(1, updateNote.getName());
            statement.setString(2, updateNote.getNote());

            statement.setInt(3, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void delete(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM notes WHERE id=?");
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
