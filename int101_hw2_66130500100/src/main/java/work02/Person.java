package work02;

import java.util.Objects;
import work01.*;

public class Person {
    private static int nextId = 1;
    private final int id;
    
    private String firstname;
    private String lastname;
    
    public Person(String firstname, String lastname) {
        this.firstname = Utilitor.testString(firstname);
        this.lastname = Utilitor.testString(lastname);
        
        id = nextId;
        nextId++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Person(");
        sb.append(id).append(",");
        sb.append(firstname).append(",");
        sb.append(lastname);
        sb.append(")");
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = Utilitor.testString(firstname);
    }

    public void setLastname(String lastname) {
        this.lastname = Utilitor.testString(lastname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        return Objects.equals(this.lastname, other.lastname);
    }
}
