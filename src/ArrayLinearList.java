import java.util.Scanner;

public class ArrayLinearList {
    private int[] list;
    private int size;

    public ArrayLinearList(int maxSize) {
        list = new int[maxSize];
        size = 0;
    }

    public void displayList() {
        if (size == 0) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
        }
    }

    public int find(int key) {
        int i;
        for (i = 0; i < size; i++) {
            if (list[i] == key) {
                break;
            }
        }
        if (i == size) {
            return -1;
        } else {
            return i;
        }
    }

    public void insert(int value) {
        int i;
        for (i = 0; i < size; i++) {
            if (list[i] > value) {
                break;
            }
        }
        for (int j = size; j > i; j--) {
            list[j] = list[j - 1];
        }
        list[i] = value;
        size++;
    }

    public void insertAfter(int key, int value) {
        int i = find(key);
        if (i == -1) {
            System.out.println("Key not found");
        } else {
            for (int j = size; j > i + 1; j--) {
                list[j] = list[j - 1];
            }
            list[i + 1] = value;
            size++;
        }
    }

    public void insertBefore(int key, int value) {
        int i = find(key);
        if (i == -1) {
            System.out.println("Key not found");
        } else {
            for (int j = size; j > i; j--) {
                list[j] = list[j - 1];
            }
            list[i] = value;
            size++;
        }
    }

    public void delete(int key) {
        int i = find(key);
        if (i == -1) {
            System.out.println("Key not found");
        } else {
            for (int j = i; j < size - 1; j++) {
                list[j] = list[j + 1];
            }
            size--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter maximum size of list: ");
        int maxSize = scanner.nextInt();
        ArrayLinearList list = new ArrayLinearList(maxSize);
        while (true) {
            System.out.println("1. Display list");
            System.out.println("2. Find element");
            System.out.println("3. Insert element");
            System.out.println("4. Insert element after");
            System.out.println("5. Insert element before");
            System.out.println("6. Delete element");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    list.displayList();
                    break;
                case 2:
                    System.out.print("Enter element to find: ");
                    int key = scanner.nextInt();
                    int index = list.find(key);
                    if (index == -1) {
                        System.out.println("Element not found");
                    } else {
                        System.out.println("Element found at index " + index);
                    }
                    break;
                case 3:
                    System.out.print("Enter element to insert: ");
                    int value = scanner.nextInt();
                    list.insert(value);
                    break;
                case 4:
                    System.out.print("Enter element to insert after: ");
                    int after = scanner.nextInt();
                    System.out.print("Enter element to insert: ");
                    int insertAfter = scanner.nextInt();
                    list.insertAfter(after, insertAfter);
                    break;
                case 5:
                    System.out.print("Enter element to insert before: ");
                    int before = scanner.nextInt();
                    System.out.print("Enter element to insert: ");
                    int insertBefore = scanner.nextInt();
                    list.insertBefore(before, insertBefore);
                    break;
                case 6:
                    System.out.print("Enter element to delete: ");
                    int delete = scanner.nextInt();
                    list.delete(delete);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}