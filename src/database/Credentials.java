package database;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public final class Credentials {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    @Override
    public String toString() {
        return "credentials{" + " name=" + name + ", password="
                + password + ", accountType=" + accountType + ", country="
                + country + ", balance=" + balance + '}';
    }
}
