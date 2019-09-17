package Utils;

import com.github.javafaker.Faker;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

public class NewUser {
    private Faker faker = new Faker(new Locale("en"));
    private Random random = new Random();

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String address = faker.address().streetName();
    private String city = faker.address().city();
    private String phoneNo = String.valueOf((long)((Math.random() * 9000000000L)+1000000));

    public String getFirstName() {
        String firstName = this.firstName;
        return firstName;
    }

    public String getLastName() {
        lastName = this.lastName;
        return this.lastName;
    }

    public  String getAddress() {
        address = this.address;
        return this.address;
    }

    public String getCity() {
        city = this.city;
        return city;
    }

    public String getPhoneNo() {
        phoneNo = this.phoneNo;
        return phoneNo;
    }

}




