/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.sql.Date;

/**
 *
 * @author 617702
 */
public class Note {
    private int noteId;
    private Date date;
    private String contents;
    
    public Note(){
        
    }
          
    public Note(int noteId, Date date, String contents) {
        this.noteId = noteId;
        this.date = date;
        this.contents = contents;
    }

    
    public int getNoteId() {
        return noteId;
    }

    public Date getDate() {
        return date;
    }

    public String getContents() {
        return contents;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    
    
}
