package fr.aelion.run;

import fr.aelion.models.Student;

public class StudentRun {
    public void run() {
        // Make an instance of Student
        Student student = new Student("Aubert", "Jean-Luc", "jean-luc.aubert@aelion.fr");
        student.setUsername("jlaubert");
        student.setPassword("dacodemaniak");

        // Try to log with correct credentials
        if (!student.isLoggedIn()) {
            if (student.login("jlaubert", "dacodemaniak")) {
                System.out.println("Bonjour " + student.getFirstName() + " " + student.getLastName());
            } else {
                System.out.println("Désolé, mais aucun utilisateur ne correspond à vos identifiants");
            }
        }

        // Try to connect with bad credentials
        if (student.isLoggedIn()) {
            student.logout();
        }
        if (!student.login("toto", "tata")) {
            System.out.println("Désolé mais aucun utilisateur ne correspond à ces identifiants");
        }
    }
}
