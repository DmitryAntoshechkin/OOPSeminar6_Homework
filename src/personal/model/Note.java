package personal.model;

import java.time.LocalDate;

public class Note {
    private Integer id;
    private String title;
    private String note;
    private LocalDate date;

    public Note(String title, String note, LocalDate date) {
        this.title = title;
        this.note = note;
        this.date = date;
    }

    public Note(Integer id, String title, String note, LocalDate date) {
        this(title, note, date);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("Запись номер: %d\nЗаголовок: %s,\nТекст: %s,\nДата: %s", id, title, note, date.toString());
    }
}
