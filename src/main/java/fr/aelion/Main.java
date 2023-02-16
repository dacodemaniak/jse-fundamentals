package fr.aelion;

import fr.aelion.models.Person;
import fr.aelion.models.Student;

public class Main {
    private static Main app;
    public static void main(String[] args) {
        app = new Main();
        if (app instanceof Main) {
            System.out.println("You are a Main object");
        } else {
            System.out.println("Your not a Main object");
        }
        System.out.println("I'm the main method");

        // Play with User Object
        app.userLife();
    }

    /**
     * Class constructor : trigger when an instance of this Class is created
     * Constructor is totally optional no need in a class
     */
    public Main() {
        Person jl = new Person();
        jl.setLastName("Aubert");
        jl.setFirstName("Jean-Luc");
        jl.setPhoneNumber("06 11 11 11 11");
        jl.setEmail("jean-luc.aubert@aelion.fr");

        System.out.println("Bonjour je m'appelle " + jl.greetings());

        Person jt = new Person();
        jt.setLastName("Talut");
        jt.setFirstName("Jean");
        jt.setPhoneNumber("06 44 44 44 44");
        jt.setEmail("jean.talut@4x4.com");

        System.out.println("Bonjour je m'appelle " + jt.greetings());

        Person mel = new Person("Zétofré", "Mélanie,", "51 51 51 51 51", "mel@51.com");
        System.out.println("Bonjour, je suis " + mel.greetings());

        Person bond = new Person("Bond", "james.bond@mi6.co.uk");
        System.out.println("Bonjour, je suis " + bond.greetings());
    }

    public Main(String name) {
        System.out.println("Hello " + name);
    }

    public void userLife() {
        // Make an instance of Student
        Student student = new Student("Aubert", "Jean-Luc", "jean-luc.aubert@aelion.fr");
        student.setUsername("jlaubert");
        student.setPassword("dacodemaniak");

        // Try to log with correct credentials
        if (!student.isLoggedIn()) {
            if (student.login("jlaubert", "dacodemaniak")) {
                System.out.println("Bonjour " + student.firstName + " " + student.lastName);
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