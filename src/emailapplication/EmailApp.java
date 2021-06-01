/*Project 1: Email Application

Scenario: you are charged with the task of creating email accounts for new hires.

Your Application should do the following:
- Generate an email with the following syntax: firstname.lastname@department.company.com
- Determine the department (sales, development , accounting), if none leave blank
- Generate a random String for a password
- Have a set methods to change the passwords, set the mailbox capacity, and define an alternate       email address
- Have a get methods to display the name, email, and mailbox capacity */

package emailapplication;

import java.io.IOException;

public class EmailApp {

    public static void main(String[] args) throws IOException {

        //create an object from the class Email. This will "call the constructor" with the 2 parameters
        Email email_1 = new Email("Marcus", "Simoes");

        email_1.setAlternateEmail("general@cryptocoin.com");

        System.out.println(email_1.getEmailInfo());
    }
}
