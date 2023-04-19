package personal.views;

import personal.controllers.NoteController;
import personal.model.Note;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ViewNotebook {

    private NoteController noteController;

    public ViewNotebook(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());

                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        createNote();
                        break;
                    case READ:
                        readNote();
                        break;
                    case LIST:
                        listNotes();
                        break;
                    case UPDATE:
                        updateNote();
                        break;
                    case DELETE:
                        deleteNote();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void updateNote() throws Exception {
        Integer id = Integer.parseInt(prompt("Идентификатор записи: "));
        Note note = noteController.readNote(id);
        System.out.println(note);
        System.out.println();
        String title = prompt("Заголовок: ");
        String noteBody = prompt("Запись: ");
        noteController.updateNote(new Note(id, title, noteBody, LocalDate.now()));
    }

    private void createNote() {
        String title = prompt("Заголовок: ");
        String noteBody = prompt("Запись: ");
        noteController.saveNote(new Note(title, noteBody, LocalDate.now()));
    }

    private void readNote() throws Exception {
        Integer id = Integer.parseInt(prompt("Идентификатор записи: "));
        Note note = noteController.readNote(id);
        System.out.println(note);
    }

    private void listNotes() {
        List<Note> allNotes = noteController.allNotes();
        for (Note note : allNotes) {
            System.out.println(note);
            System.out.println();
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private void deleteNote() throws Exception {
        Integer id = Integer.parseInt(prompt("Идентификатор записи: "));
        Note note = noteController.readNote(id);
        System.out.println(note);
        System.out.println();
        String confirm = prompt("Вы уверены? (Y/N): ");
        if (confirm.toUpperCase().equals("Y")){
            noteController.deleteNote(note);
            System.out.println("Запись удалена");
        }
    }


}
