package com.doctorplacid;



import android.widget.EditText;

import com.doctorplacid.holder.CellHolder;
import com.doctorplacid.room.grades.Grade;
import com.doctorplacid.room.lessons.Lesson;

public interface ITableActivityListener {

    void openAddDialog();
    void openDeleteDialog(int position);

    void addStudent(String name);
    void deleteStudent();

    void addDate(Lesson lesson);
    void deleteDate(int position);

    void onGradeAmountEdited(CellHolder holder, EditText editText);
    void onGradePresenceEdited(Grade grade, int position);

    void expandButton();
    void collapseButton();
}

