package personal.model;
import java.time.LocalDate;

public class NoteMapper {
    public String map(Note note) {
        return String.format("%d, %s, %s, %s", note.getId(), note.getTitle(), note.getNote(), note.getDate().toString());
    }

    public Note map(String line) {
        String[] lines = line.split(", ");
        return new Note(Integer.parseInt(lines[0]), lines[1], lines[2], LocalDate.parse(lines[3]));
    }
}

