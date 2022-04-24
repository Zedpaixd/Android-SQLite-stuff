package com.example.lab9questionmark;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "lab10";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mycourses";
    private static final String EXAM_ID = "id";
    private static String COURSE_NAME = "COURSE_NAME";
    private static String EXAM_DATE = "EXAM_DATE";
    private static String SELF_REV = "SELF_REV";
    private static String CM_REV = "CM_REV";
    private static String TEACHER_REV = "TEACHER_REV";
    private static String NB_LECTURES = "NB_LECTURES";
    private static String TIME_PER_LECTURE = "TIME_PER_LECTURE";
    private static String TIME_PER_EXTRA_MATS = "TIME_PER_EXTRA_MATS";
    private static String OBSERVATIONS = "OBSERVATIONS";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + EXAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COURSE_NAME + " TEXT,"
                + EXAM_DATE + " TEXT,"
                + SELF_REV + " TEXT,"
                + CM_REV + " TEXT,"
                + TEACHER_REV + " TEXT,"
                + NB_LECTURES + " TEXT,"
                + TIME_PER_LECTURE + " TEXT,"
                + TIME_PER_EXTRA_MATS + " TEXT,"
                + OBSERVATIONS + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addExam(String _COURSE_NAME, String _EXAM_DATE, String _SELF_REV, String _CM_REV, String _TEACHER_REV, String _NB_LECTURES, String _TIME_PER_LECTURE, String _TIME_PER_EXTRA_MATS, String _OBSERVATIONS){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COURSE_NAME, _COURSE_NAME);
        values.put(EXAM_DATE, _EXAM_DATE);
        values.put(SELF_REV, _SELF_REV);
        values.put(CM_REV, _CM_REV);
        values.put(TEACHER_REV, _TEACHER_REV);
        values.put(NB_LECTURES, _NB_LECTURES);
        values.put(TIME_PER_LECTURE, _TIME_PER_LECTURE);
        values.put(TIME_PER_EXTRA_MATS, _TIME_PER_EXTRA_MATS);
        values.put(OBSERVATIONS, _OBSERVATIONS);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<ExamModel> readExams(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorExams = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<ExamModel> allExams = new ArrayList<>();

        if (cursorExams.moveToFirst()){
            do {
                allExams.add(new ExamModel(cursorExams.getString(0), cursorExams.getString(1),cursorExams.getString(2),cursorExams.getString(3),cursorExams.getString(4),
                        cursorExams.getString(5),cursorExams.getString(6),cursorExams.getString(7),
                        cursorExams.getString(8),cursorExams.getString(9)));
            } while (cursorExams.moveToNext());
        }
        cursorExams.close();
        return allExams;

    }

    public void deleteEntry (String name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME+ " WHERE "+COURSE_NAME+"='"+name+"'");
        db.close();
    }

}
