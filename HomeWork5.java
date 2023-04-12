
/**
 * HomeWork5
 */
public class HomeWork5 {

    public static void main(String[] args) {
        //Task1 createlephoneDirectory = new Task1();
        //createlephoneDirectory.CreatTelephoneDirectory();
        // Task2 map = new Task2();
        // Task2NameList.CreatPeople();
        // map.CreatMap();
        // map.nameRepeat();
        // map.sortMap();
        
        // Task3 task3 = new Task3();
        // int[] array = task3.CreatArray();
        // task3.HeapSort(array);
        // for(int el: array) System.out.printf("%d ", el);

        Task4 board = new Task4(8);
        board.placeQueens(0);
        board.printBoard();
    }
}