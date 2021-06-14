package ru.geekbrains.lession6.notepad.ui.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import ru.geekbrains.lession6.notepad.R;
import ru.geekbrains.lession6.notepad.logic.NoteDates;
import ru.geekbrains.lession6.notepad.logic.Notepad;

public class ContentNoteFragment extends Fragment {

    static final String ARG_INDEX = "index";
    static final String ARG_NOTEPAD = "notepad_class";
    private int noteIndex;
    private Notepad notepad;

    public static ContentNoteFragment newInstance(int noteIndex, Notepad notepad)
    {
        ContentNoteFragment fragment = new ContentNoteFragment();
        // Передача параметра
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, noteIndex);
        args.putParcelable(ARG_NOTEPAD, (Parcelable) notepad);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null)
//        {
//            noteIndex = getArguments().getInt(ARG_INDEX);
//            notepad = getArguments().getParcelable(ARG_NOTEPAD);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editText = view.findViewById(R.id.note_dates_content_fragment);
        noteIndex = getArguments().getInt(ARG_INDEX);
        notepad = getArguments().getParcelable(ARG_NOTEPAD);

        editText.setText(notepad.getNoteByNumber(noteIndex));
    }
}