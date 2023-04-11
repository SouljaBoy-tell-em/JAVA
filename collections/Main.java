import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
         ARRAYLIST:
         void add(int index, E obj): добавляет в список по индексу index объект obj
         boolean addAll(int index, Collection<? extends E> col): добавляет в список по индексу index все элементы коллекции col. Если в результате добавления список был изменен, то возвращается true, иначе возвращается false
         E get(int index): возвращает объект из списка по индексу index
         int indexOf(Object obj): возвращает индекс первого вхождения объекта obj в список. Если объект не найден, то возвращается -1
         int lastIndexOf(Object obj): возвращает индекс последнего вхождения объекта obj в список. Если объект не найден, то возвращается -1
         ListIterator<E> listIterator (): возвращает объект ListIterator для обхода элементов списка
         static <E> List<E> of(элементы): создает из набора элементов объект List
         E remove(int index): удаляет объект из списка по индексу index, возвращая при этом удаленный объект
         E set(int index, E obj): присваивает значение объекта obj элементу, который находится по индексу index
         void sort(Comparator<? super E> comp): сортирует список с помощью компаратора comp
         List<E> subList(int start, int end): получает набор элементов, которые находятся в списке между индексами start и end
        */

//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Yung Trappa");
//        arrayList.add("Yanix");
//        arrayList.add("D.Masta");
//
//        System.out.println("size: " + arrayList.size());
//        int i = 0;
//        for(i = 0; i < arrayList.size(); i++)
//            System.out.println(arrayList.get(i));
//
//        ArrayList<String> removePartList = new ArrayList<>();
//        removePartList.add("D.Masta");
//
//        System.out.println("size: " + removePartList.size());
//        System.out.println(removePartList.get(0) + "\n\n");
//
//        arrayList.removeAll(removePartList);
//        for(i = 0; i < arrayList.size(); i++)
//            System.out.println(arrayList.get(i));



//        ArrayList<String> somethingList = new ArrayList<>();
//        somethingList.add("D.Masta");
//
//        ArrayList<String> arrayList = new ArrayList<>(somethingList);
//        arrayList.add("Yung Trappa");
//
//        int i = 0;
//        for(i = 0; i < arrayList.size(); i++)
//            System.out.printf("arrayList[%d]: %s\n", i, arrayList.get(i));
//
//       System.out.println("status: " + arrayList.contains("D.Masta"));
//       System.out.println("status: " + arrayList.contains("aoiksdn"));

//        ArrayList<Integer> numberList = new ArrayList<Integer>();
//        int i = 0;
//        for(i = 0; i < 5; i++)
//            numberList.add(i + 7);
//
//        for(i = 0; i < numberList.size(); i++)
//            System.out.printf("numberList[%d]: %d\n", i, numberList.get(i));
//
//        List<Integer> partCopy = new ArrayList<>(3);
//        partCopy = numberList.subList(2, 5); // получит 3, 4, 5 элементы;
//        for(i = 0; i < partCopy.size(); i++)
//            System.out.printf("partCopy[%d]: %d\n", i, partCopy.get(i));


        // QUEUE:

//        E element(): возвращает, но не удаляет, элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
//
//        boolean offer(E obj): добавляет элемент obj в конец очереди. Если элемент удачно добавлен, возвращает true, иначе - false
//
//        E peek(): возвращает без удаления элемент из начала очереди. Если очередь пуста, возвращает значение null
//
//        E poll(): возвращает с удалением элемент из начала очереди. Если очередь пуста, возвращает значение null
//
//        E remove(): возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException

        // Queue<Integer> queue = new Queue<Integer>(); Queue в java является абстрактным классом, поэтому не может быть создан;


//        Queue<Integer> queue = new LinkedList<>();
//
//        int i = 0;
//        for(i = 0; i < 5; i++)
//            queue.add(i + 7);
//
//        for(i = 0; i < 5; i++)
//            System.out.println(queue.remove());
//
//        System.out.println(queue.size());



        // DEQUE - расширяет множество(интерфейс) QUEUE.
//        void addFirst(E obj): добавляет элемент в начало очереди
//        void addLast(E obj): добавляет элемент obj в конец очереди
//        E getFirst(): возвращает без удаления элемент из головы очереди. Если очередь пуста, генерирует исключение NoSuchElementException
//        E getLast(): возвращает без удаления последний элемент очереди. Если очередь пуста, генерирует исключение NoSuchElementException
//        boolean offerFirst(E obj): добавляет элемент obj в самое начало очереди. Если элемент удачно добавлен, возвращает true, иначе - false
//        boolean offerLast(E obj): добавляет элемент obj в конец очереди. Если элемент удачно добавлен, возвращает true, иначе - false
//        E peekFirst(): возвращает без удаления элемент из начала очереди. Если очередь пуста, возвращает значение null
//        E peekLast(): возвращает без удаления последний элемент очереди. Если очередь пуста, возвращает значение null
//        E pollFirst(): возвращает с удалением элемент из начала очереди. Если очередь пуста, возвращает значение null
//        E pollLast(): возвращает с удалением последний элемент очереди. Если очередь пуста, возвращает значение null
//        E pop(): возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
//        void push(E element): добавляет элемент в самое начало очереди
//        E removeFirst(): возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
//        E removeLast(): возвращает с удалением элемент из конца очереди. Если очередь пуста, генерирует исключение NoSuchElementException
//        boolean removeFirstOccurrence(Object obj): удаляет первый встреченный элемент obj из очереди. Если удаление произшло, то возвращает true, иначе возвращает false.
//        boolean removeLastOccurrence(Object obj): удаляет последний встреченный элемент obj из очереди. Если удаление произшло, то возвращает true, иначе возвращает false.

//        Deque<Integer> deque = new LinkedList<>();
//
//        int i = 0;
//        for(i = 0; i < 15; i++)
//            deque.add(i);
//
//        System.out.println(deque.getFirst());
//        System.out.println(deque.getLast());
//
//        System.out.println(deque.pop());
//        System.out.println(deque.pop());
//
//        System.out.println(deque.getFirst());
//        System.out.println(deque.getLast());


//        Deque<String> deque = new LinkedList<>();
//        ArrayList<String> arrayList = new ArrayList<>(15);
//
//        int i = 0;
//        for(i = 0; i < 15; i++)
//            arrayList.add(i, "Hello" + i);
//
//
//        for(i = 0; i < arrayList.size(); i++)
//            deque.add(arrayList.get(i));
//
//        System.out.println(deque.peekLast()); // возвращаем последний элемент очереди;
//        System.out.println(deque.pollLast()); // возвращаем последний элемент очереди и удаляем его;
//        System.out.println(deque.peekLast());





        // LINKEDLIST - связнйы список;
//        LinkedList содержит все те методы, которые определены в интерфейсах List, Queue, Deque.
//
//        addFirst() / offerFirst(): добавляет элемент в начало списка
//        addLast() / offerLast(): добавляет элемент в конец списка
//        removeFirst() / pollFirst(): удаляет первый элемент из начала списка
//        removeLast() / pollLast(): удаляет последний элемент из конца списка
//        getFirst() / peekFirst(): получает первый элемент
//        getLast() / peekLast(): получает последний элемент


//        LinkedList<Node<String>> linkedList = new LinkedList<>();
//
//        int i = 0;
//        for(i = 0; i < 15; i++){
//            linkedList.addLast(new Node<String>("String" + (i + 1))); // создание объекта и сразу размещение;
//        }
//
//        for(; linkedList.size() > 0;) {
//
//            Node<String> capacityBuffer = linkedList.removeLast();
//            System.out.println(capacityBuffer.GetNode());
//        }


        // HASHSET - хэш-таблица. Хеш-таблица - структура данных, в которой все объекты имеют уникальный ключ
        // или хэш-код.
//        HashSet(): создает пустой список
//
//        HashSet(Collection<? extends E> col): создает хеш-таблицу, в которую добавляет все элементы коллекции col
//
//        HashSet(int capacity): параметр capacity указывает начальную емкость таблицы, которая по умолчанию равна 16
//
//        HashSet(int capacity, float koef): параметр koef или коэффициент заполнения, значение которого должно быть в
//        пределах от 0.0 до 1.0, указывает, насколько должна быть заполнена емкость объектами прежде чем произойдет ее расширение.
//        Например, коэффициент 0.75 указывает, что при заполнении емкости на 3/4 произойдет ее расширение.

//        HashSet<Node<String>> hashTable = new HashSet<>();
//
//        int i = 0;
//        for(i = 0; i < 15; i++)
//            System.out.println(hashTable.add(new Node<String>("String" + (i + 1))));
//
//        System.out.println(hashTable.add(new Node<String>("String12")));


        // TreeSet - структура данных в виде дерева, в которой объекты хранятся в отсортированном виде по возрастанию.
//        TreeSet(): создает пустое дерево
//        TreeSet(Collection<? extends E> col): создает дерево, в которое добавляет все элементы коллекции col
//        TreeSet(SortedSet <E> set): создает дерево, в которое добавляет все элементы сортированного набора set
//        TreeSet(Comparator<? super E> comparator): создает пустое дерево, где все добавляемые элементы впоследствии будут отсортированы компаратором.
//        TreeSet<Integer> treeSet = new TreeSet<>();

//        TreeSet<String> treeSet = new TreeSet<String>();
//
//        treeSet.add("Omsk");
//        treeSet.add("Moscow");
//        treeSet.add("Saint P");
//        treeSet.add("Magadan");
//
//        System.out.printf("TreeSet contains %d elements \n", treeSet.size());
//        treeSet.remove("Saint P");
//
//        for(String state : treeSet)
//            System.out.println(state); //state, а не treeSet для поэлементного вывода.
//
////        System.out.println("\n\n\n");
////        System.out.println(treeSet.first());
////        System.out.println(treeSet.last());
////        System.out.println(treeSet.lower(3));


        // MAP - ключ-значение. MAP является интерфейсом для HASHMAP (т.е. HASHMAP impl
//        void clear(): очищает коллекцию
//        boolean containsKey(Object k): возвращает true, если коллекция содержит ключ k
//        boolean containsValue(Object v): возвращает true, если коллекция содержит значение v
//        Set<Map.Entry<K, V>> entrySet(): возвращает набор элементов коллекции. Все элементы представляют объект Map.Entry
//        boolean equals(Object obj): возвращает true, если коллекция идентична коллекции, передаваемой через параметр obj
//        boolean isEmpty: возвращает true, если коллекция пуста
//        V get(Object k): возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, то возвращается значение null
//        V getOrDefault(Object k, V defaultValue): возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, то возвращается значение defaultVlue
//        V put(K k, V v): помещает в коллекцию новый объект с ключом k и значением v. Если в коллекции уже есть объект с подобным ключом, то он перезаписывается.
//        После добавления возвращает предыдущее значение для ключа k, если он уже был в коллекции. Если же ключа еще не было в коллекции, то возвращается значение null
//        V putIfAbsent(K k, V v): помещает в коллекцию новый объект с ключом k и значением v, если в коллекции еще нет элемента с подобным ключом.
//        Set<K> keySet(): возвращает набор всех ключей отображения
//        Collection<V> values(): возвращает набор всех значений отображения
//        void putAll(Map<? extends K, ? extends V> map): добавляет в коллекцию все объекты из отображения map
//        V remove(Object k): удаляет объект с ключом k
//        int size(): возвращает количество элементов коллекции

//      HASHMAP - ключ значение. Встроенные методы HASHMAP:


//        Map<Long, String> dataBase = new HashMap<>();
//        dataBase.put(812812812L, "Yung Trappa");
//        dataBase.put(381238123812L, "Alexander Zaytsev");
//        dataBase.put(495495495L, "YANIX");
//
//        Map<Long, String> addDataBase = new HashMap<>();
//        addDataBase.put(347347347L, "Boulevard Depo");
//        addDataBase.put(383383383L, "ALLJ");
//
//        System.out.println("dataBase size: " + dataBase.size());
//        System.out.println("addDataBase size: " + addDataBase.size());
//
//        System.out.println("dataBase contains element \"Yung Trappa\": " + dataBase.containsValue("Yung Trappa"));
//        System.out.println("addDataBase contains element \"Yung Trappa\": " + addDataBase.containsValue("Yung Trappa"));
//
//        dataBase.putAll(addDataBase);
//        System.out.println(dataBase.size()); // добавили объекты из addDataBase в dataBase;
//        Set<Long> keysDataBase = dataBase.keySet();
//        Set<Long> keysAddDataBase = new HashSet<>();
//        keysAddDataBase = addDataBase.keySet();
//        System.out.println("dataBase keys: " + keysDataBase);
//        System.out.println("addDataBase keys: " + keysAddDataBase);




        // SortedMap: коллекция такого типа будет выстроена в порядке возрастания ключей.
//        K firstKey(): возвращает ключ первого элемента отображения
//        K lastKey(): возвращает ключ последнего элемента отображения
//        SortedMap<K, V> headMap(K end): возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap вплоть до элемента с ключом end
//        SortedMap<K, V> tailMap(K start): возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap, начиная с элемента с ключом start
//        SortedMap<K, V> subMap(K start, K end): возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap вплоть от элемента с ключом start до элемента с ключом end

        // NavigableMap: расширяет интерфейс SortedMap.
//        Map.Entry<K, V> ceilingEntry(K key): возвращает элемент с наименьшим ключом k, который больше или равен ключу key (k >=key). Если такого ключа нет, то возвращается null.
//        Map.Entry<K, V> floorEntry(K key): возвращает элемент с наибольшим ключом k, который меньше или равен ключу key (k <=key). Если такого ключа нет, то возвращается null.
//        Map.Entry<K, V> higherEntry(K key): возвращает элемент с наименьшим ключом k, который больше ключа key (k >key). Если такого ключа нет, то возвращается null.
//        Map.Entry<K, V> lowerEntry(K key): возвращает элемент с наибольшим ключом k, который меньше ключа key (k <key). Если такого ключа нет, то возвращается null.
//        Map.Entry<K, V> firstEntry(): возвращает первый элемент отображения
//        Map.Entry<K, V> lastEntry(): возвращает последний элемент отображения
//        Map.Entry<K, V> pollFirstEntry(): возвращает и одновременно удаляет первый элемент из отображения
//        Map.Entry<K, V> pollLastEntry(): возвращает и одновременно удаляет последний элемент из отображения
//        K ceilingKey(K key): возвращает наименьший ключ k, который больше или равен ключу key (k >=key). Если такого ключа нет, то возвращается null.
//        K floorKey(K key): возвращает наибольший ключ k, который меньше или равен ключу key (k <=key). Если такого ключа нет, то возвращается null.
//        K lowerKey(K key): возвращает наибольший ключ k, который меньше ключа key (k <key). Если такого ключа нет, то возвращается null.
//        K higherKey(K key): возвращает наименьший ключ k, который больше ключа key (k >key). Если такого ключа нет, то возвращается null.
//        NavigableSet<K> descendingKeySet(): возвращает объект NavigableSet, который содержит все ключи отображения в обратном порядке
//        NavigableMap<K, V> descendingMap(): возвращает отображение NavigableMap, которое содержит все элементы в обратном порядке
//        NavigableSet<K> navigableKeySet(): возвращает объект NavigableSet, который содержит все ключи отображения
//        NavigableMap<K, V> headMap(K upperBound, boolean incl): возвращает отображение NavigableMap, которое содержит все элементы оригинального NavigableMap
//        вплоть от элемента с ключом upperBound. Параметр incl при значении true указывает, что элемент с ключом upperBound также включается в выходной набор.
//        NavigableMap<K, V> tailMap(K lowerBound, boolean incl): возвращает отображение NavigableMap, которое содержит все элементы оригинального NavigableMap,
//        начиная с элемента с ключом lowerBound. Параметр incl при значении true указывает, что элемент с ключом lowerBound также включается в выходной набор.
//        NavigableMap<K, V> subMap(K lowerBound, boolean lowIncl, K upperBound, boolean highIncl): возвращает отображение NavigableMap, которое содержит все элементы
//        оригинального NavigableMap от элемента с ключом lowerBound до элемента с ключом upperBound. Параметры lowIncl и highIncl при значении true включают в
//        выходной набор элементы с ключами lowerBound и upperBound соответственно.


//        NavigableMap<Long, String> navigableMap = new TreeMap<>(); // условно происходит расширение множества функций;
//        navigableMap.put(812812812L, "Yung Trappa");
//        navigableMap.put(381238123812L, "Alexander Zaytsev");
//        navigableMap.put(495495495L, "YANIX");
//        System.out.println(navigableMap.ceilingKey(0L));
//        System.out.println(navigableMap.lastKey());




        ArrayList<Integer> arrayList = new ArrayList<>();

        int i = 0;
        for(i = 0; i < 15; i++)
            arrayList.add(i + 10);

        ListIterator<Integer> listIterator = arrayList.listIterator();
//        System.out.println(listIterator.previousIndex());
//        System.out.println(arrayList.get(4));
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.previousIndex());
//        System.out.println(listIterator.previousIndex());
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.next()); // можно упереться в край arrayList;


        listIterator.next();
        listIterator.remove();
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());

    }
}
