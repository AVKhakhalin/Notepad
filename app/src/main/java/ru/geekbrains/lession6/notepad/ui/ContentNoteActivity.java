package ru.geekbrains.lession6.notepad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import ru.geekbrains.lession6.notepad.R;
import ru.geekbrains.lession6.notepad.logic.Notepad;
import ru.geekbrains.lession6.notepad.ui.fragments.ContentNoteFragment;

public class ContentNoteActivity extends AppCompatActivity {

    static final String ARG_INDEX = "index";
    static final String ARG_NOTEPAD = "notepad_class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_note);

        Intent intent = getIntent();

        int view1 = intent.getIntExtra(ARG_INDEX, -1);
        Notepad view2 = (Notepad) intent.getParcelableExtra(ARG_NOTEPAD);
        Toast.makeText(this, String.format("%d", view1), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, view2.getNoteByNumber(1), Toast.LENGTH_SHORT).show();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            return;
        }

        if (savedInstanceState == null)
        {
            ContentNoteFragment contentNoteFragment = new ContentNoteFragment();
            contentNoteFragment.setArguments(getIntent().getExtras());

//            int proba = getIntent().getIntExtra("index", -1);
//            Notepad notepad = getIntent().getParcelableExtra("notepad_class");
//            Toast.makeText(this, notepad.getNoteByNumber(0), Toast.LENGTH_SHORT).show();
            // Добавляем фрагмент на активити
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_note_fragment, contentNoteFragment).commit();
        }

    }
}