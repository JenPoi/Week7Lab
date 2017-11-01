/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.util.Date;

/**
 *
 * @author 617702
 */
public class Note {
    private int noteId;
    private String contents;
    private java.util.Date date;

    public Note(int noteId, String contents) {
        this.noteId = noteId;
        this.contents = contents;
        this.date = new Date();
    }

    public Note(int noteId) {
        this.noteId = noteId;
        this.date = new Date();
    }

    public Note(int noteId, java.sql.Date date, String contents) {
        this.noteId = noteId;
        this.date = date;
        this.contents = contents;
    }

    public Note(String contents) {
        this.date = new Date();
        this.contents = contents;
    }

    public int getNoteId() {
        return noteId;
    }

    public String getContents() {
        return contents;
    }

    public Date getDate() {
        return date;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
