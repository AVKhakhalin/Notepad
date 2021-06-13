package ru.geekbrains.lession6.notepad.logic;

import java.util.Calendar;

class NoteDates
{
    private String name;
    private String description;
    private int dateYear;
    private int dateMonth;
    private int dateDay;
    private String text;

    NoteDates()
    {
        name = "";
        description = "";
        Calendar cal = Calendar.getInstance();
        dateYear = cal.get(Calendar.YEAR);
        dateMonth = cal.get(Calendar.MONTH) + 1;
        dateDay = cal.get(Calendar.DAY_OF_MONTH);
        text = "";
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
        String month = (dateDay < 10 ? ("0" + String.valueOf(dateMonth)) : String.valueOf(dateMonth));
        return String.format("%s.%s.%d", date, month, dateYear);
    }

}
