package com.study.ramda;

class Student {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public Student(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", hak=" + hak +
                ", ban=" + ban +
                ", score=" + score +
                '}';
    }

    enum Level {
        HIGH, MID, LOW
    }
}

public class PartioningByTest {
    public static void main(String args[]) {
        Student[] students = {
                  new Student("홍길동", true, 1, 1, 300)
                , new Student("김길동", false, 1, 1, 100)
                , new Student("이길동", true, 2, 1, 150)
                , new Student("박길동", false, 2, 2, 500)
                , new Student("최길동", true, 3, 2, 200)
                , new Student("양길동", false, 3, 2, 200)
                , new Student("심길동", true, 4, 1, 100)
        };
    }

    https://www.youtube.com/watch?v=VUh_t_j9qjE&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp&index=171
}
