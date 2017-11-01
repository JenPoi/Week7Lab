/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Note;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 617702
 */
public class NoteDB {
    /*
•	public int delete(Note note) throws NotesDBException*/
    
     public int insert(Note note) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        try {
            String preparedQuery = "INSERT INTO Note (noteId, dateCreated, contents) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setInt(1, note.getNoteId());
            ps.setDate(2, (Date) note.getDate());
            ps.setString(3, note.getContents());
            int rows = ps.executeUpdate();
            return rows;
        }  
        catch (SQLException ex) {
                Logger.getLogger(NoteDB.class.getName()).log(Level.SEVERE, "Cannot insert " + note.toString(), ex);
                throw new NotesDBException("Error inserting note");
            }
        finally {
            pool.freeConnection(connection);
        }
    }
    
     public int update(Note note) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        try {
            String preparedSQL = "UPDATE Note SET "
                    + "date = ?, "
                    + "contents = ?, "
                    + "WHERE noteId = ?";

            PreparedStatement ps = connection.prepareStatement(preparedSQL);

            ps.setDate(1, (Date) note.getDate());
            ps.setString(2, note.getContents());
            ps.setInt(3, note.getNoteId());
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
                Logger.getLogger(NoteDB.class.getName()).log(Level.SEVERE, "Cannot update " + note.toString(), ex);
                throw new NotesDBException("Error updating note");
            }
        finally {
            pool.freeConnection(connection);
        }
    }
    
    public List<Note> getAll() throws NotesDBException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Note> noteList =  new ArrayList<>();
        
        try
        {
            ps = connection.prepareStatement("Select * from note;");
            rs = ps.executeQuery();
            while(rs.next())
            {
                noteList.add(new Note(rs.getInt("noteId"), rs.getDate("date"), rs.getString("contents")));
            }
            pool.freeConnection(connection);
            return noteList;
        }  catch (SQLException ex) 
        {
            Logger.getLogger(NoteDB.class.getName()).log(Level.SEVERE, "Cannot get all notes", ex);
            throw new NotesDBException("Error listing notes");
        }
        finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
    }
 
    public Note getNote(int noteId) throws NotesDBException
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
        ps = connection.prepareStatement("Select * from note where noteId = ?;");
        rs = ps.executeQuery();

        Note note = null;
        while (rs.next()) {
            note = new Note(rs.getInt("noteId"), rs.getDate("date"), rs.getString("contents"));
        }
        pool.freeConnection(connection);
        return note;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(NoteDB.class.getName()).log(Level.SEVERE, "Cannot get note " + noteId, ex);
            throw new NotesDBException("Error gettting note");
        }
        finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
    }
    
    public int delete(Note note) throws NotesDBException
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        try
        {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM User WHERE noteId = ?");
        ps.setInt(1, note.getNoteId());
        int rows = ps.executeUpdate();
        return rows;
        }catch (SQLException ex) 
        {
            Logger.getLogger(NoteDB.class.getName()).log(Level.SEVERE, "Cannot delete note" + note.toString(), ex);
            throw new NotesDBException("Error deleting note");
        }
        
    }
}
