package com.doctorplacid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doctorplacid.R;
import com.doctorplacid.holder.SumHolder;
import com.doctorplacid.room.students.Student;
import com.doctorplacid.room.students.StudentWithGrades;

import java.util.ArrayList;
import java.util.List;

public class SumsAdapter extends RecyclerView.Adapter<SumHolder> {

    List<StudentWithGrades> students = new ArrayList<>();

    @NonNull
    @Override
    public SumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_sum, parent, false);
        return new SumHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SumHolder holder, int position) {
        Student student = students.get(position).getStudent();
        holder.SetText(student);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public void setItems(List<StudentWithGrades> studentsWithGrades) {
        this.students = studentsWithGrades;
        notifyDataSetChanged();
    }
}
