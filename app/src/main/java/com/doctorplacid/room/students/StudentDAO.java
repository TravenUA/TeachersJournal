package com.doctorplacid.room.students;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.doctorplacid.room.grades.Grade;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class StudentDAO {

    @Insert
    abstract long insert(Student student);

    @Insert
    abstract void insert(List<Grade> grades);

    public boolean insertNewStudentWithGrades(StudentWithGrades studentWithGrades) {
        int id = (int) insert(studentWithGrades.getStudent());

        List<Grade> grades = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            grades.add(new Grade(id));

        insert(grades);
        return true;
    }

    @Update
    abstract void update(Student student);

    @Delete
    abstract void delete(Student student);

    @Query("SELECT * FROM students_table WHERE group_id = :groupId ORDER BY name")
    abstract LiveData<List<StudentWithGrades>> getStudentsWithGrades(int groupId);

}
