package fr.aelion.run;

import fr.aelion.helpers.StudentBuilder;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.helpers.interfaces.Builder;
import fr.aelion.models.Student;

public class StudentRun {
    public void run() {
        try {
            Student student = ((StudentBuilder) StudentBuilder.getInstance())
                    .lastName("Aubert")
                    .firstName("Jean-Luc")
                    .phoneNumber("06 55 22 33 66")
                    .email("jean-luc.aubert@aelion.fr")
                    .username("jlaubert")
                    .password("dacodemaniak")
                    .build();

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
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }

    }
}
