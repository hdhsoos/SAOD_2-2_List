import java.util.Scanner;

class ArrayLinearList {
    private Object[] elements;
    private int size;

    public ArrayLinearList(int MaxSize) {
        elements = new Object[MaxSize];
        size = 0;
    }

    public void printList() {
        if (size == 0) {
            System.out.println("Список пуст.");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(elements[i]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public int search(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void add(Object element) {
        if (size == elements.length) {
            System.out.println("Список заполнен.");
        } else {
            int index = size;
            for (int i = 0; i < size; i++) {
                if (((Comparable) element).compareTo(elements[i]) < 0) {
                    index = i;
                    break;
                }
            }
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    public boolean addAfter(Object after, Object element) {
        int index = search(after);
        if (index == -1) {
            return false;
        } else {
            if (size == elements.length) {
                System.out.println("Список заполнен.");
            } else {
                int newIndex = index + 1;
                for (int i = size; i > newIndex; i--) {
                    elements[i] = elements[i - 1];
                }
                elements[newIndex] = element;
                size++;
            }
            return true;
        }
    }

    public boolean addBefore(Object before, Object element) {
        int index = search(before);
        if (index == -1) {
            return false;
        } else {
            if (size == elements.length) {
                System.out.println("Список заполнен.");
            } else {
                int newIndex = index;
                for (int i = size; i > newIndex; i--) {
                    elements[i] = elements[i - 1];
                }
                elements[newIndex] = element;
                size++;
            }
            return true;
        }
    }

    public boolean delete(Object element) {
        int index = search(element);
        if (index == -1) {
            return false;
        } else {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите максимальную длину списка: ");
        int maxSize = scanner.nextInt();
        ArrayLinearList list = new ArrayLinearList(maxSize);
        int choice;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Вывести список на экран.");
            System.out.println("2. Найти элемент в списке.");
            System.out.println("3. Добавить новый элемент в список.");
            System.out.println("4. Добавить новый элемент после заданного.");
            System.out.println("5. Добавить новый элемент перед заданным.");
            System.out.println("6. Удалить заданный элемент.");
            System.out.println("0. Выйти.");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    list.printList();
                    break;
                case 2:
                    System.out.println("Введите элемент для поиска: ");
                    String elementToFind = scanner.next();
                    int index = list.search(elementToFind);
                    if (index == -1) {
                        System.out.println("Элемент не найден.");
                    } else {
                        System.out.println("Элемент найден на позиции " + index);
                    }
                    break;
                case 3:
                    System.out.println("Введите новый элемент: ");
                    String newElement = scanner.next();
                    list.add(newElement);
                    break;
                case 4:
                    System.out.println("Введите элемент, после которого нужно добавить новый элемент: ");
                    String afterElement = scanner.next();
                    System.out.println("Введите новый элемент: ");
                    String newElementAfter = scanner.next();
                    boolean addedAfter = list.addAfter(afterElement, newElementAfter);
                    if (!addedAfter) {
                        System.out.println("Элемент " + afterElement + " не найден.");
                    }
                    break;
                case 5:
                    System.out.println("Введите элемент, перед которым нужно добавить новый элемент: ");
                    String beforeElement = scanner.next();
                    System.out.println("Введите новый элемент: ");
                    String newElementBefore = scanner.next();
                    boolean addedBefore = list.addBefore(beforeElement, newElementBefore);
                    if (!addedBefore) {
                        System.out.println("Элемент " + beforeElement + " не найден.");
                    }
                    break;
                case 6:
                    System.out.println("Введите элемент, который нужно удалить: ");
                    String elementToDelete = scanner.next();
                    boolean deleted = list.delete(elementToDelete);
                    if (!deleted) {
                        System.out.println("Элемент " + elementToDelete + " не найден.");
                    }
                    break;
                case 0:
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Ошибка ввода.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }
}