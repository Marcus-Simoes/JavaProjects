package emailapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Email {

    //use encapsulation(Java modifier "private"). People should not access this directly.
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String emailCompanySuffix = ".cryptocoin.com";
    private String alternateEmail;
    private int emailBoxCapacity = 500;

    //Constructor(used to initialize objects) for the firstName and lastName variable
    public Email(String firstName, String lastName) throws IOException {

        //reference to class variable = reference to local variable
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New employee: " + this.firstName + " " + this.lastName);

        //Choose the department and return the department
        this.department = setDepartment();

        //return a  random password with a method. The length of the random password should be 10.
        this.password = randomPassword(10);
        System.out.println("Your password is: " + this.password);

        //generate E-mail
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + emailCompanySuffix;
    }

    //Determine the department with a set Method
    private String setDepartment() throws IOException {
        System.out.println("Department Number: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        System.out.print("Choose the department number: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int chooseDepart = Integer.parseInt(reader.readLine());
        if (chooseDepart == 1) {
            return "Sales";
        } else if (chooseDepart == 2) {
            return "Development";
        } else if (chooseDepart == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    /*Generates a random String for a password:
    Determine a random password and as a parameter how long should that password be, with (int length)*/
    private String randomPassword(int length){

        //Define what we can choose from. The possibilities that we can can choose from
        String passwordSet = "ABCDFGHIJKLMNOPQRSTUWVXYZ0123456789!?$%+-*/";

        //Array of char equal to a new sequence of char of the size of length
        char[] password = new char[length];

        //iterate through the value of the length
        for(int i = 0; i < length; i++){

            //Generate a random Number Math.random(perfect for that) = number in between 0 and 1
           int randNumber = (int)(Math.random() * passwordSet.length());

           //charAt() method returns the character at the specified index in a string
           password[i] = passwordSet.charAt(randNumber);
        }

        /*the password variable is a set of chars. It must be modify by a new String
        and pass the char (password) as a parameter to get a random password*/
      return new String(password);
    }

    //Set the mailbox capacity
    public void setEmailBoxCapacity(int capacity){
        this.emailBoxCapacity = capacity;
    }

    //Set an alternate E-Mail
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Set password
    public void changePassword(String password){
        this.password = password;
    }

    //display the name, email, and mailbox capacity with a get method
    public int getEmailBoxCapacity(){
        return emailBoxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String getEmailInfo(){
        return "Employee: " + firstName + " " + lastName +
                "\nYour E-Mail: " + email +
                "\nAlternate E-Mail: " + getAlternateEmail() +
                "\nYour E-Mailbox capacity: " + emailBoxCapacity + "mb";
    }
}

