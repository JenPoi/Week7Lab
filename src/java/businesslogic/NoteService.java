/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import dataaccess.NoteDB;
import dataaccess.NotesDBException;
import domainmodel.Note;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 617702
 */
public class NoteService {
  
    private NoteDB noteDB;
    
    public NoteService()
    {
        
    }
    
    public Note getNote(int noteId) throws NotesDBException
    {
        return noteDB.getNote(noteId);
    }
    
    public List<Note> getAll() throws NotesDBException
    {
        return noteDB.getAll();
    }
    
    public int update(int noteId, String contents) throws NotesDBException
    {
        Note note = new Note(noteId, contents);
        return noteDB.update(note);
    }
    
    public int delete(int noteId) throws NotesDBException
    {
        Note note = new Note(noteId);
        return noteDB.delete(note);
    }
    
    public int insert(String contents) throws NotesDBException
    {
        Note note = new Note(contents);
        return noteDB.insert(note);
    }
}
