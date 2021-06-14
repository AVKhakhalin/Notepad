package ru.geekbrains.lession6.notepad.logic;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.LinkedList;
import java.util.ListIterator;

public class Notepad implements Parcelable
{
    LinkedList<NoteDates> noteDates;
    int curNumberNote = 0;

    public Notepad()
    {
        noteDates = new LinkedList<>();
        noteDates.add(new NoteDates());
        noteDates.getFirst().setName("Создать запись");
        noteDates.getFirst().setIsEmptyNote(true);
        noteDates.getFirst().setText("ПОБЕДА!!!"); // Это заглушка для проверки
    }

    public int getSizeNotes()
    {
        return noteDates.size();
    }

    public void addNewNote(String name) {
        noteDates.getFirst().setName(name + " (" + noteDates.getFirst().getDate() + ")");
        noteDates.getFirst().setIsEmptyNote(false);
        noteDates.getFirst().setText("ПОЛНАЯ ПОБЕДА!!!"); // Это заглушка для проверки

        // Создание нового пустого элемента вместо только что заполненного
        noteDates.addFirst(new NoteDates());
        noteDates.getFirst().setName("Создать запись");
        noteDates.getFirst().setIsEmptyNote(true);
        noteDates.getFirst().setText("ПОБЕДА!!!"); // Это заглушка для проверки
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

    public String getNoteByNumber(int indexNote)
    {
        String noteText = "";
        noteText = noteDates.get(indexNote).getText();
        return noteText;
    }


    // Методы для передачи класса
    protected Notepad(Parcel in) {
        curNumberNote = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(curNumberNote);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Notepad> CREATOR = new Creator<Notepad>() {
        @Override
        public Notepad createFromParcel(Parcel in) {
            return new Notepad(in);
        }

        @Override
        public Notepad[] newArray(int size) {
            return new Notepad[size];
        }
    };

}
