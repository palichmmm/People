public class Main {
    public static void main(String[] args) {

        Person person = new PersonBuilder()
                .setName("Иван")
                .setSurname("Лопатов")
                .build();

        System.out.println(person);

        // Увеличение возраста с неизвестным возрастом
        person.happyBirthday();

        // Добавление недостающего возраста
        person.setAge(28);
        System.out.println(person);

        // День рождения
        person.happyBirthday();
        System.out.println(person);

        // Повторное изменение возраста
        person.setAge(48);

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("\nУ " + mom + " есть сын, " + son);
        son.happyBirthday();
        System.out.println("У сына " + son.getName() + " День Рождения!!! Ему исполнилось - " + son.age.getAsInt() + " год\n");

        // Не хватает обязательных полей
        new PersonBuilder().build();
        // Возраст меньше нуля
        new PersonBuilder().setAge(-100).build();


    }
}
