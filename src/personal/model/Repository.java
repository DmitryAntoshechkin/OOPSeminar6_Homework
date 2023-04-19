package personal.model;

import java.util.List;

public interface Repository {
    List<Note> getAllNotes();
    Integer CreateNote(Note note);

    void updateNote(Note note);

    void deleteNote(Note note);


}
