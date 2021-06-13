package ru.geekbrains.lession6.notepad.logic;

import java.util.Date;

class NoteDates
{
    private String name;
    private String description;
    private Date date;
    private String text;

    NoteDates()
    {
        name = "";
        description = "";
        date = new Date();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date _date) {
        date = _date;
    }

    public String getText() {
        return text;
    }

    public void setText(String _text) {
        text = _text;
    }
}
