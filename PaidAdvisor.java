package assign6;

import java.util.Scanner;

public class PaidAdvisor extends Person {

private String name;

private double regularPayRate;

private double specialPayRate;

private double overtimePayRate;

private double hoursWorked;

private double hoursSpecial;

private double amountToBePaid;

public PaidAdvisor() {

regularPayRate = 25;

specialPayRate = 50;

overtimePayRate = 1.5 * regularPayRate;

}

public String toString() {

return "PaidAdvisor [ name= " + name

+ ", regularPayRate=" + regularPayRate

+ ", specialPayRate=" + specialPayRate

+ ", overtimePayRate=" + overtimePayRate

+ ", hoursWorked=" + hoursWorked

+ ", hoursSpecial=" + hoursSpecial + "]";

}

public double calculatePay(double totalHours, double specialHours) {

if (totalHours > 30) {

amountToBePaid = (totalHours - 30) * overtimePayRate + 30 * regularPayRate;

} else {

amountToBePaid = totalHours * regularPayRate;

}

if (specialHours > 0) {

amountToBePaid += specialHours * specialPayRate;

}

return amountToBePaid;

}

public double getPayRate(double totalHours) {

if (totalHours > 30) {

return overtimePayRate;

} else {

return regularPayRate;

}

}

public double getHoursWorked() {

return hoursWorked;

}

public void setNameRateHours(String fname, String lname,

double rate, double totalHours, double specialHours) {

Person p = new Person();

p.setName(fname, lname);

name = p.toString();

hoursWorked = totalHours;

hoursSpecial = specialHours;

}

public static void main(String[] args) {

Scanner sc=new Scanner(System.in);  

System.out.println("Enter your First Name:");  

String firstName = sc.next();

System.out.println("Enter your Last Name:");  

String lastName = sc.next();

System.out.println("Enter hours worked:");  

double totalHours = sc.nextDouble();

System.out.println("Enter if any special hours: (enter 0 if no special hours)");  

double specialHours = sc.nextDouble();

PaidAdvisor pa = new PaidAdvisor();

double rate = pa.getPayRate(totalHours);

pa.setNameRateHours(firstName, lastName, rate, totalHours, specialHours);

System.out.println("Amount to be paid: " + pa.calculatePay(totalHours, specialHours));

System.out.println(pa.toString());

}

Person.java

public class Person {

private String firstName;

private String lastName;

public Person() {

firstName = "";

lastName = "";

}

public Person(String first, String last) {

setName(first, last);

}

@Override

public String toString() {

return (firstName + " " + lastName);

}

public void setName(String first, String last) {

firstName = first;

lastName = last;

}

public String getFirstName() {

return firstName;

}

public String getLastName() {

return lastName;

}
}
}



