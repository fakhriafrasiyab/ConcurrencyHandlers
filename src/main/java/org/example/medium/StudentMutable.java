package org.example.medium;

public class StudentMutable extends Student{

    private String hackName;
    public StudentMutable(String name) {
        super(name);
        this.hackName=name;
    }

    @Override
    public String getName(){
        return hackName+"Hack";
    }

    public static void main(String[] args) {
        Student s = new StudentMutable("Faxri");
        System.out.println(s.getName());
    }
}
