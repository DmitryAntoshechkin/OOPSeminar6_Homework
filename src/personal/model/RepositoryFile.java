package personal.model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private NoteMapper mapper = new NoteMapper();
    private FileOperation fileOperation;

    private String separator;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileOperation.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public Integer CreateNote(Note note) {

        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item : notes) {
            int id = item.getId();
            if (max < id) {
                max = id;
            }
        }
        int id = max + 1;
        note.setId(id);
        notes.add(note);
        saveNote(notes);
        return id;
    }

    private void saveNote(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note item : notes) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }

    public void updateNote(Note note) {
        List<Note> notes = getAllNotes();
        for (Note item : notes) {
            if (item.getId().equals(note.getId())) {
                item.setTitle(note.getTitle());
                item.setNote(note.getNote());
                item.setDate(note.getDate());
            }
        }
        saveNote(notes);
    }

    public void deleteNote(Note note) {
        List<Note> notes = getAllNotes();
        int removeIndex = -1;
        for (Note item : notes) {
            if (item.getId() == note.getId()) {
                removeIndex = notes.indexOf(item);
            } else if (item.getId() > (note.getId())) {
                item.setId(item.getId() - 1);
            }
        }
        notes.remove(removeIndex);
        saveNote(notes);

    }

}
