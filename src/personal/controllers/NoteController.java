package personal.controllers;

import personal.model.Repository;
import personal.model.Note;

import java.util.List;

public class NoteController {

    private final Validat valid = new Validat();
    private final Repository repository;

    public NoteController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) {
        System.out.println(note.getTitle());
        System.out.println(note.getNote());
        valid.validate(note);
        repository.CreateNote(note);
    }

    public Note readNote(Integer noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId() == noteId) {
                return note;
            }
        }
        throw new Exception("Note not found");
    }

    public List<Note> allNotes() {
        return repository.getAllNotes();

    }
    public void updateNote(Note note){
        valid.validate(note);
        repository.updateNote(note);
    }

    public void deleteNote(Note note){
        repository.deleteNote(note);
    }

}
