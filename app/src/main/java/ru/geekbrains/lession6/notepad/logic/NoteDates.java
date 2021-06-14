package ru.geekbrains.lession6.notepad.logic;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

public class NoteDates implements Parcelable
{
    private String name;
    private String description;
    private int dateYear;
    private int dateMonth;
    private int dateDay;
    private String text;
    private boolean isEmptyNote;

    NoteDates()
    {
        name = "";
        description = "";
        Calendar cal = Calendar.getInstance();
        dateYear = cal.get(Calendar.YEAR);
        dateMonth = cal.get(Calendar.MONTH) + 1;
        dateDay = cal.get(Calendar.DAY_OF_MONTH);
        text = "";
        isEmptyNote = true;
    }

     public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String _description) {
        description = _description;
    }

    public String getText() {
        return text;
    }

    public void setText(String _text) {
        text = _text;
    }

    public void setDateYear(int _dateYear) {
        dateYear = _dateYear;
    }

    public void setDateMonth(int _dateMonth) {
        dateMonth = _dateMonth;
    }

    public void setDateDay(int _dateDay) {
        dateDay = _dateDay;
    }

    public String getDate() {
        String date = (dateDay < 10 ? ("0" + String.valueOf(dateDay)) : String.valueOf(dateDay));
        String month = (dateMonth < 10 ? ("0" + String.valueOf(dateMonth)) : String.valueOf(dateMonth));
        return String.format("%s.%s.%d", date, month, dateYear);
    }

    public void setIsEmptyNote(boolean emptyNote) {
        isEmptyNote = emptyNote;
    }

    public boolean getIsEmptyNote()
    {
        return isEmptyNote;
    }

    // Методы для передачи класса
    protected NoteDates(Parcel in) {
        name = in.readString();
        description = in.readString();
        dateYear = in.readInt();
        dateMonth = in.readInt();
        dateDay = in.readInt();
        text = in.readString();
        isEmptyNote = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(dateYear);
        dest.writeInt(dateMonth);
        dest.writeInt(dateDay);
        dest.writeString(text);
        dest.writeByte((byte) (isEmptyNote ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NoteDates> CREATOR = new Creator<NoteDates>() {
        @Override
        public NoteDates createFromParcel(Parcel in) {
            return new NoteDates(in);
        }

        @Override
        public NoteDates[] newArray(int size) {
            return new NoteDates[size];
        }
    };
}
