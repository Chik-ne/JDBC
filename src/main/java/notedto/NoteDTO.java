package notedto;

import java.sql.Date;

public class NoteDTO {
    private int id;
    private String title;
    private String note;
    private Date date;

    public NoteDTO() {
    }

    public NoteDTO(int id, String title, String note, Date date) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id+"\t\t"+title+"\t\t"+note+"\t\t"+date;
    }
}
