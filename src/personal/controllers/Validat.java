package personal.controllers;

import personal.model.Note;



public class Validat {
    public void validate(Note note) {
        if (note.getTitle().equals("")) {
            throw new RuntimeException("Заголовок записи не может быть пустым");

        }
        if (note.getNote().equals("")) {
            throw new RuntimeException("Запись не может быть пустой");
        }
    }

}