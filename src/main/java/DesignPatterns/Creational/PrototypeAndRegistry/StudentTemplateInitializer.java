package DesignPatterns.Creational.PrototypeAndRegistry;

public class StudentTemplateInitializer {

    // initialize the registry with predefined student templates that can be copied and reused later for new objects
    public void initializeTemplates() {
        StudentRegistry registry = StudentRegistry.INSTANCE;

        Student dataScienceStudent = new Student(2020, 1 , "Rahul", 90.0); // mandatory basic student info
        dataScienceStudent.setCourse("Data Science"); // additional info about course
        dataScienceStudent.setAmountPaid(500);
        dataScienceStudent.setLengthCourse(12);

        Student devopsStudent = new Student(2020, 1 , "Gokul", 90.0);
        devopsStudent.setCourse("Devops");
        devopsStudent.setAmountPaid(200);
        devopsStudent.setLengthCourse(9);

        Student softwareStudent = new Student(2020, 1 , "Abhi", 90.0);
        softwareStudent.setCourse("Software");
        softwareStudent.setAmountPaid(600);
        softwareStudent.setLengthCourse(18);
/*
    The code below overrides the "Software Student" template with a new "Intelligent Software Student" template.
    Since the registry allows only one instance of each StudentType, this will replace the original "Software Student."
    Overwriting existing templates is not recommended, as it could lead to data loss.
    Instead, use the "Software Student" template to create the "Intelligent Software Student" clone
    using a copy constructor in the IntelligentStudent class.
*/
//        Student intelligentSoftwareStudent = new IntelligentStudent(2010,3,"JK",100.0,130);
//        intelligentSoftwareStudent.setCourse("Software");
//        intelligentSoftwareStudent.setAmountPaid(600);
//        intelligentSoftwareStudent.setLengthCourse(18);

        // with studentType, the chance of mistakes to make wrong key value pair is less
        registry.add(StudentType.DATASCIENCE , dataScienceStudent);
        registry.add(StudentType.DEVOPS , devopsStudent);
        registry.add(StudentType.SOFTWARE , softwareStudent);
        //registry.add(StudentType.SOFTWARE , intelligentSoftwareStudent);
    }
}
