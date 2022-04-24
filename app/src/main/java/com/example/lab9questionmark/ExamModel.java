package com.example.lab9questionmark;

public class ExamModel {

    private String ID;
    private String COURSE_NAME;
    private String EXAM_DATE;
    private String SELF_REV;
    private String CM_REV;
    private String TEACHER_REV;
    private String NB_LECTURES;
    private String TIME_PER_LECTURE;
    private String TIME_PER_EXTRA_MATS;
    private String OBSERVATIONS;

    public ExamModel(String _ID, String _COURSE_NAME, String _EXAM_DATE, String _SELF_REV, String _CM_REV, String _TEACHER_REV, String _NB_LECTURES, String _TIME_PER_LECTURE, String _TIME_PER_EXTRA_MATS, String _OBSERVATIONS){
        this.ID = _ID;
        this.COURSE_NAME = _COURSE_NAME;
        this.EXAM_DATE = _EXAM_DATE;
        this.SELF_REV = _SELF_REV;
        this.TEACHER_REV = _TEACHER_REV;
        this.CM_REV = _CM_REV;
        this.NB_LECTURES = _NB_LECTURES;
        this.TIME_PER_LECTURE = _TIME_PER_LECTURE;
        this.TIME_PER_EXTRA_MATS = _TIME_PER_EXTRA_MATS;
        this.OBSERVATIONS = _OBSERVATIONS;
    }

    @Override
    public String toString() {
        return  "Exam ID: " + this.ID + "\n" +
                "Exam Mame: " + this.COURSE_NAME + "\n" +
                "Exam Date: " + this.EXAM_DATE + "\n" +
                "Diff 1: " + this.SELF_REV + "\n" +
                "Diff 2: " + this.TEACHER_REV + "\n" +
                "Diff 3: " + this.CM_REV + "\n" +
                "Nb of lectures: " + this.NB_LECTURES + "\n" +
                "Time per lec: " + this.TIME_PER_LECTURE + "\n" +
                "Time per extra: " + this.TIME_PER_EXTRA_MATS + "\n" +
                "Observations: " + this.OBSERVATIONS;
    }

    public String getCourseName(){
        return this.COURSE_NAME;
    }
}
