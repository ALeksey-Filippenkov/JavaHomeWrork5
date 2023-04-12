import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task2 {

    static Map<String, Integer> numberUnicName = new HashMap<>();
    static Map<Integer, ArrayList<String>> sortMap = new HashMap<>();
    static ArrayList<Integer> listCount = new ArrayList<>();

    public void CreatMap() {

        for (int i = 0; i < Task2NameList.people.size(); i++) {
            int count = 0;
            String name = Task2NameList.people.get(i).split(" ", 2)[0];
            for (int j = 0; j < Task2NameList.people.size(); j++) {
                String name2 = Task2NameList.people.get(j).split(" ", 2)[0];
                if (name.equals(name2))
                    count++;
            }
            if (!numberUnicName.containsKey(name))
                numberUnicName.put(name, count);
        }
        System.out.println(numberUnicName);
    }

    public void nameRepeat() {
        System.out.println("Повторяющиеся имена: ");
        for (var item : numberUnicName.entrySet()) {
            if (item.getValue() > 1)
                System.out.printf("%s: %d \n", item.getKey(), item.getValue());
        }
    }

    public void sortMap() {
        for (var item : numberUnicName.entrySet()) {
            if (!listCount.contains(item.getValue()))
                listCount.add(item.getValue());
        }
        listCount.sort(null);
        System.out.println("Имена, отсортированные по убыванию популярности: ");
        for (int i = listCount.size() - 1; i > 0; i--) {
            for (var item : numberUnicName.entrySet()) {
                if (listCount.get(i) == item.getValue())
                    System.out.printf("%s : %d \n", item.getKey(), item.getValue());
            }
        }
    }
}
