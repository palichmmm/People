import java.util.OptionalInt;

public class PersonBuilder {
    private final Person newPerson;
    public PersonBuilder() {
        newPerson = new Person();
    }
    public PersonBuilder setName(String name) {
        if (newPerson.name != null) {
            try {
                throw new IllegalStateException("Имя определено. Нельзя менять имя!!!");
            } catch (Exception err) {
                err.printStackTrace();
            }
        } else {
            newPerson.name = name;
        }
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        if (newPerson.surname != null) {
            try {
                throw new IllegalStateException("Фамилия определена. Нельзя менять фамилию!!!");
            } catch (Exception err) {
                err.printStackTrace();
            }
        } else {
            newPerson.surname = surname;
        }
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (newPerson.hasAge()) {
            try {
                throw new IllegalStateException("Возраст не может быть изменен повторно!!!");
            } catch (Exception err) {
                err.printStackTrace();
            }
        } else {
            if (age >= 0) {
                newPerson.age = OptionalInt.of(age);
            } else {
                try {
                    throw new IllegalArgumentException("Возраст не может быть меньше нуля!!!");
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        }
        return this;
    }
    public PersonBuilder setAddress(String address) {
        newPerson.address = address;
        return this;
    }
    public Person build() {
        if (newPerson.getName() == null && newPerson.getSurname() == null) {
            try {
                throw new IllegalStateException("Не хватает обязательных полей");
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return newPerson;
    }
}
