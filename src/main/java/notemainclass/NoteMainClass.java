package notemainclass;

import notedao.NoteDAO;
import notedto.NoteDTO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class NoteMainClass {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean status = true;
        do {
            System.out.println("Enter No of Operation to be performed!!");
            System.out.println("1. Add Note!!");
            System.out.println("2. Update Note!!");
            System.out.println("3. Delete Note!!");
            System.out.println("4. Display All Notes!!");
            System.out.println("5. Exit!!");
            int ch = sc.nextInt();
            switch (ch)
            {
                case 1: addNote();
                    break;
                case 2: updateNote();
                    break;
                case 3: deleteNote();
                    break;
                case 4: displayAllNotes();
                    break;
                case 5:
                    status = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (status);
    }

    private static void updateNote() {
        System.out.println("Enter title");
        String title=sc.nextLine();
        title=sc.nextLine();
        System.out.println("Enter updated title");
        String utitle=sc.nextLine();
        utitle=sc.nextLine();
        NoteDTO dto = new NoteDTO();
        dto.setTitle(title);

        NoteDAO dao = new NoteDAO();
        int count=dao.updateNote(dto,utitle);
        System.out.println(count+" row updated successfully!!");
    }

    private static void deleteNote() {
        System.out.println("Enter Title");
        String title=sc.nextLine();
        title=sc.nextLine();
        NoteDTO dto = new NoteDTO();
        dto.setTitle(title);

        NoteDAO dao = new NoteDAO();
        int count=dao.deleteNote(dto);
        System.out.println(count+" row deleted successfully!!");
    }

    private static void displayAllNotes() {
        NoteDAO dao = new NoteDAO();
        ArrayList<NoteDTO> list= dao.displayAllNotes();
        System.out.println("ID   TITLE    CONTENT      DATE");
        for (NoteDTO b:list) {
            System.out.println(b);
        }
    }


    private static void addNote() {
        System.out.println("Enter Note Title");
        String title = sc.nextLine();
        title = sc.nextLine();
        System.out.println("Enter Note Content");

        String content = sc.nextLine();
        content = sc.nextLine();

        NoteDTO dto = new NoteDTO();
        dto.setTitle(title);
        dto.setNote(content);

        NoteDAO dao = new NoteDAO();
        int count=dao.addNote(dto);
        System.out.println(count+" row inserted successfully");
    }
}
