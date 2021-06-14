package ru.geekbrains.lession6.notepad.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ru.geekbrains.lession6.notepad.R;
import ru.geekbrains.lession6.notepad.logic.NoteDates;
import ru.geekbrains.lession6.notepad.logic.Notepad;
import ru.geekbrains.lession6.notepad.ui.ContentNoteActivity;

public class NoteDatesListFragment extends Fragment {

    private boolean isLandscape; // Параметр для различения портретной ориентации от ландшафтной

    // Создание класса с заметками
    private Notepad notepad = new Notepad();

    public static NoteDatesListFragment newInstance() {
        NoteDatesListFragment fragment = new NoteDatesListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
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
        if (context != null)
        {
            NoteDates curDates = notepad.getNext();

            // Определим ориентацию экрана
            isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

            Toast.makeText(context, String.format("%S", String.valueOf(isLandscape)), Toast.LENGTH_SHORT).show();
            int counter = -1;
            notepad.addNewNote("НОВАЯ ЗАПИСЬ");
            while (curDates != null)
            {
                counter++;
                TextView textView = new TextView(context);
                textView.setText(curDates.getName());
                textView.setTextSize(30);
                layoutView.addView(textView);
                curDates = notepad.getNext();

                // Вешаем слушатель на элементы списка
                final int noteIndex = counter;
                textView.setOnClickListener(v -> showContentOrientation(noteIndex, notepad));
            }
        }
    }

    private void showContentOrientation(int noteIndex, Notepad notepad)
    {
        if (isLandscape == true)
        {
            showLandCoatOfArms(noteIndex, notepad);
        }
        else
        {
            showPortCoatOfArms(noteIndex, notepad);
        }
    }

    private void showLandCoatOfArms(int noteIndex, Notepad notepad)
    {
        // Создаём новый фрагмент с текущей позицией для вывода содержания заметки
        ContentNoteFragment detail = ContentNoteFragment.newInstance(noteIndex, notepad);

        // Выполняем транзакцию по замене фрагмента
        FragmentActivity context = getActivity();
        if (context != null)
        {
            FragmentManager fragmentManager = context.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.note_dates_content_fragment, detail); // замена фрагмента
            fragmentTransaction.commit();
        }
    }

    private void showPortCoatOfArms(int noteIndex, Notepad notepad)
    {
        // Откроем вторую activity
        Context context = getContext();
        if (context != null)
        {
            Intent intent = new Intent(context, ContentNoteActivity.class);
            intent.putExtra(ContentNoteFragment.ARG_INDEX, noteIndex);
            intent.putExtra(ContentNoteFragment.ARG_NOTEPAD, notepad);
            startActivity(intent);
        }
    }
}
