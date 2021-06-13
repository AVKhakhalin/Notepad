package ru.geekbrains.lession6.notepad.logic;

import java.util.LinkedList;

public class Notepad
{
    LinkedList<NoteDates> noteDates;

    public Notepad()
    {
        noteDates = new LinkedList<>();
        noteDates.add(new NoteDates());
        noteDates.get(0).setName("Empty");
    }

    public void setNewNote() {
        noteDates.add(new NoteDates());
    }

}
