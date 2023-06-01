package notedao;

import notedto.NoteDTO;

import java.sql.*;
import java.util.ArrayList;

public class NoteDAO {
    private Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1gga1", "root", "sql123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addNote(NoteDTO dto) {
        int count=0;
        String query = "insert into NoteTaker_info(title,note,date) values(?,?,NOW() )";
        try {
            pstmt = con.prepareCall(query);
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getNote());
            count=pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

return count;
    }

    public int deleteNote(NoteDTO dto) {
        int count=0;
        String query=" delete from notetaker_info where title=?";
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setString(1, dto.getTitle());
            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int updateNote(NoteDTO dto,String utitle) {
        int count=0;
        String query=" update  notetaker_info set title=? ,date=now() where title=?";
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setString(2, dto.getTitle());
            pstmt.setString(1, utitle);
            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public ArrayList<NoteDTO> displayAllNotes(){
        Statement stmt =null;
        ResultSet rs=null;
        ArrayList<NoteDTO> titleList = new ArrayList<>();
        String query = "select * from notetaker_info ";
        try {
            stmt = con.createStatement();
            rs =stmt.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String note = rs.getString(3);
                Date date=rs.getDate(4);
                //store data into DTO class object
                NoteDTO d1 = new NoteDTO();
                d1.setId(id);
                d1.setTitle(title);
                d1.setNote(note);
                d1.setDate(date);

                //add object into List
                titleList.add(d1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return titleList;
    }
}
