package ru.geekbrains.lession6.notepad.logic;

import java.util.LinkedList;
import java.util.ListIterator;

public class Notepad
{
    LinkedList<NoteDates> noteDates;
    int curNumberNote = 0;

    public Notepad()
    {
        noteDates = new LinkedList<>();
        noteDates.add(new NoteDates());
        noteDates.get(curNumberNote).setName("Создать запись");
        noteDates.getFirst().setIsEmptyNote(true);
    }

    public int getNumberNotes()
    {
        return noteDates.size();
    }

    public void addNewNote(String name) {
        noteDates.getFirst().setName(name + " (" + noteDates.getFirst().getDate() + ")");
        noteDates.getFirst().setIsEmptyNote(false);

        // Создание нового пустого элемента
        noteDates.add(0, new NoteDates());
        noteDates.get(curNumberNote).setName("Создать запись");
        noteDates.getFirst().setIsEmptyNote(true);
    }

    public NoteDates getNext()
    {
        if (noteDates.size() - 1 >= curNumberNote)
        {
            return noteDates.get(curNumberNote++);
        }
        else
        {
            curNumberNote = 0;
            return null;
        }
    }
}
