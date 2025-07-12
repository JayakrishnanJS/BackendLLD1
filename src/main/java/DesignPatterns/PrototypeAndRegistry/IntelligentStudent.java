package DesignPatterns.PrototypeAndRegistry;

public class IntelligentStudent extends Student {
    private int iq;

    public IntelligentStudent() {

    }

    public IntelligentStudent(int gradYear, int id, String name, double psp, int iq) {
        super(gradYear, id, name, psp);
        this.iq = iq;
    }

    // 1. copy constructor to create a clone of intelligent student from an existing intelligent student obj or template
    public IntelligentStudent(IntelligentStudent student) {
        super(student);
        this.iq = student.iq;
    }

    // 1. copy constructor to create a clone of intelligent student from an existing normal student obj or template
    // iq can be set after creating clone
    public IntelligentStudent(Student student) {
        super(student);
        iq = 120;// set an average iq for intelligent student or it will be 0 by default
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public IntelligentStudent copy(){
        return new IntelligentStudent(this);
    }
}
