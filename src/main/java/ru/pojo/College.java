package ru.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setSnp("Surname Name Patronymic");
        student.setGroup("1");
        student.setDate("12.04.2023");
        System.out.println("SNP: " + student.getSnp() + "\nGroup: " + student.getGroup() + "\nDate: " + student.getDate());
    }
}
