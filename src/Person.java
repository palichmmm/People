import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    protected Person() {}

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address)
                .setAge(0);
    }

    public boolean hasAge() {
        return age.isPresent();
    }
    public boolean hasAddress() {
        return address != null;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return OptionalInt.empty();
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        if (hasAge()) {
            try {
                throw new IllegalStateException("Возраст не может быть введен повторно!!!");
            } catch (Exception err) {
                err.printStackTrace();
            }
        } else {
            if (age < 0) {
                try {
                    throw new IllegalArgumentException("Возраст не может быть меньше нуля!!!");
                } catch (Exception err) {
                    err.printStackTrace();
                }
            } else {
                this.age = OptionalInt.of(age);
            }
        }
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        } else {
            try {
                throw new IllegalStateException("Возраст не определен. Увеличить возраст невозможно!!!");
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age.isPresent() ? age.getAsInt() : "N/O")  +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
