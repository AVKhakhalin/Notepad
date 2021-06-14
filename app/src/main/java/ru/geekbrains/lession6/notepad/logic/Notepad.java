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
        noteDates.get(curNumberNote).setName("Empty");
    }

    public int getNumberNotes()
    {
        return noteDates.size();
    }

    public void addNewNote() {
        noteDates.add(new NoteDates());
        noteDates.getLast().setName("Empty");
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
