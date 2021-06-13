package ru.geekbrains.lession6.notepad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import ru.geekbrains.lession6.notepad.R;
import ru.geekbrains.lession6.notepad.logic.Notepad;

public class MainActivity extends AppCompatActivity {

    Notepad notepad = new Notepad();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}