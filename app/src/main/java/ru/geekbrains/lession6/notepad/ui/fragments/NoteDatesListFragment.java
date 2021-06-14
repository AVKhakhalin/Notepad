package ru.geekbrains.lession6.notepad.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ru.geekbrains.lession6.notepad.R;
import ru.geekbrains.lession6.notepad.logic.NoteDates;
import ru.geekbrains.lession6.notepad.logic.Notepad;

public class NoteDatesListFragment extends Fragment {

    private boolean isLandscape; // Параметр для различения портретной ориентации от ландшафтной

    // Создание класса с заметками
    private Notepad notepad = new Notepad();

//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

//    private String mParam1;
//    private String mParam2;

//    public static NoteDatesListFragment newInstance(String param1, String param2) {
    public static NoteDatesListFragment newInstance() {
        NoteDatesListFragment fragment = new NoteDatesListFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_dates_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view)
    {
        LinearLayout layoutView = (LinearLayout) view;
        Context context = getContext();
        notepad.addNewNote();
        notepad.addNewNote();
        notepad.addNewNote();
        notepad.addNewNote();
        notepad.addNewNote();
        NoteDates curDates = notepad.getNext();
        Toast.makeText(context, String.format("%d", notepad.getNumberNotes()), Toast.LENGTH_SHORT).show();
        while (curDates != null)
        {
            if (context != null)
            {
                TextView textView = new TextView(context);
                textView.setText(curDates.getName() + ", " + curDates.getDate());
                textView.setTextSize(25);
                layoutView.addView(textView);
            }
            curDates = notepad.getNext();
        }
    }
}
