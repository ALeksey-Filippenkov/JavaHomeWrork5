import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {

    Map<String, Integer> telephoneDirectory = new HashMap<>();
    Scanner in = new Scanner(System.in);

    public void CreatTelephoneDirectory() {
        System.out.println("Телефонный справочник.");
        System.out.println(
                "Если вы хотите добавить контакт введите 1 или +. \nЕсли вы хотите удалить контакт нажмите 2 или -. \nЕсли хотите изменить контакт нажмите 3 или *. \nЕсли хотите выйти нажмите q");
        System.out.print("Введите значение: ");
        char operation = in.nextLine().charAt(0);
        switch (operation) {
            case '1':
            case '+': {
                CreatContact();
                break;
            }
            case '2':
            case '-':
                DeleteElement();
                break;
            case '3':
            case '*':
                ReplaceElement();
                break;
            case 'q':
            case 'Q': {
                System.out.println("Всего доброго!");
                break;
            }
            default: {
                СontinueExecution();
                break;
            }
        }
    }

    public void CreatContact() {
        System.out.print("Пожалуйста введите Фамилию: ");
        String surname = in.nextLine();
        if (surname != null) {
            System.out.print("Пожалуйста введите телефон: ");
            Integer phoneNumber = Integer.parseInt(in.nextLine());
            telephoneDirectory.put(surname, phoneNumber);
            System.out.println("\nПоздравляем, контакт успешно создан.");
            PrintTelephoneDirectory(telephoneDirectory);
            СontinueExecution();
            CreatTelephoneDirectory();
        } else {
            System.out.println("Вы не ввели никакое значение");
            СontinueExecution();
        }
    }

    public void DeleteElement() {
        System.out.print("Введите фамилию, которую хотите удалить: ");
        String surname = in.nextLine();
        if (surname != null) {
            telephoneDirectory.remove(surname);
            System.out.println("\nПоздравляем, контакт успешно удален.");
            PrintTelephoneDirectory(telephoneDirectory);
            СontinueExecution();
        } else {
            System.out.println("Вы не ввели никакое значение!");
            СontinueExecution();
        }
    }

    public void ReplaceElement() {
        System.out.print("Введите фамилию контакта, в котором вы хотите заменить телефон: ");
        String surname = in.nextLine();
        if (surname != null) {
            System.out.print("Введите новый номер телефона: ");
            Integer newPhoneNumber = Integer.parseInt(in.nextLine());
            telephoneDirectory.replace(surname, newPhoneNumber);
            System.out.println("\nПоздравляем, контакт успешно изменен.");
            PrintTelephoneDirectory(telephoneDirectory);
            СontinueExecution();
        } else {
            System.out.println("Всего доброго!");
        }
    }

    public void PrintTelephoneDirectory(Map<String, Integer> telephoneDirectory) {
        for (var item : telephoneDirectory.entrySet())
            System.out.printf("Фамилия: %s Телефон: %s  \n", item.getKey(), item.getValue());
    }

    public void СontinueExecution() {
        System.out.println("\nВы хотите продолжить? Если да введите Y, если нет N");
        char exit = in.nextLine().charAt(0);
        if (exit == 'y' || exit == 'Y')
            CreatTelephoneDirectory();
        else
            System.out.println("Всего доброго.");
    }
}
