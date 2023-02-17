package fr.aelion.run;

import fr.aelion.models.Person;

/**
 * @name PersonRun
 *  Make some Person instances and make each say Hello
 */
public class PersonRun {
    public void run() {
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
}
