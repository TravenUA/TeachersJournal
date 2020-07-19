package com.doctorplacid.room.grades;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.doctorplacid.room.TeachersDatabase;

import java.util.List;

public class GradeRepository {

    private GradeDAO gradeDAO;

    public GradeRepository(Application application) {
        TeachersDatabase database = TeachersDatabase.getInstance(application);
        gradeDAO = database.gradeDAO();
    }

    public void insert(int studentId) {
        new GradeRepository.GradeInsertAsyncTask(gradeDAO).execute(studentId);
    }

    public void update(Grade grade) {
        new GradeRepository.GradeUpdateAsyncTask(gradeDAO).execute(grade);
    }

    public void delete(Grade grade) {
        new GradeRepository.GradeDeleteAsyncTask(gradeDAO).execute(grade);
    }

    public LiveData<List<Grade>> retrieveByStudentId(int studentId) {
        return gradeDAO.retrieveByStudentId();
    }

    private static class GradeInsertAsyncTask extends AsyncTask<Integer, Void, Void> {
        private GradeDAO gradeDAO;

        public GradeInsertAsyncTask(GradeDAO gradeDAO) {
            this.gradeDAO = gradeDAO;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            final int id = integers[0];
            Grade grade = new Grade(id);
            grade.setAmount(11);
            gradeDAO.insert(grade);
            //gradeDAO.insert(new Grade(id));
            return null;
        }
    }

    private static class GradeUpdateAsyncTask extends AsyncTask<Grade, Void, Void> {
        private GradeDAO gradeDAO;

        public GradeUpdateAsyncTask(GradeDAO gradeDAO) {
            this.gradeDAO = gradeDAO;
        }

        @Override
        protected Void doInBackground(Grade... grades) {
            gradeDAO.update(grades[0]);
            return null;
        }
    }

    private static class GradeDeleteAsyncTask extends AsyncTask<Grade, Void, Void> {
        private GradeDAO gradeDAO;

        public GradeDeleteAsyncTask(GradeDAO gradeDAO) {
            this.gradeDAO = gradeDAO;
        }

        @Override
        protected Void doInBackground(Grade... grades) {
            gradeDAO.delete(grades[0]);
            return null;
        }
    }
}