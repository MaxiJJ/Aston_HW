package ru.maxiJ;

public class MyHashMap<K, V> {
    //array of entry
    private Entry<K, V>[] tableEntry;
    //capacity of hash map
    private final static int DEFAULT_VALUE_OF_TABLE = 16;


    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //constructor of MyHashMap with the default count
    @SuppressWarnings("unchecked")
    public MyHashMap() {
        tableEntry = new Entry[DEFAULT_VALUE_OF_TABLE];
    }

    //method of add value to collection
    public void put(K newKey, V value) {
        //does not allow to key null
        if (newKey == null) {
            return;
        }

        //calculate hash of key
        int hash = hash(newKey);
        //create new Entry
        Entry<K, V> newEntry = new Entry<K, V>(newKey, value, null);
        //if table doesn't contain entry. Write the entry there
        if (tableEntry[hash] == null) {
            tableEntry[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> currentEntry = tableEntry[hash];

            //we are looking for the latest entry
            while (currentEntry != null) {
                if (currentEntry.key.equals(newKey)) {
                    //key-value need to be inserted on first of map
                    if (previous == null) {
                        newEntry.next = currentEntry.next;
                        tableEntry[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = currentEntry.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = currentEntry;
                currentEntry = currentEntry.next;
            }
        }
    }


    //method returns value by key
    public V get(K key) {
        int hash = hash(key);
        if (tableEntry[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = tableEntry[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }
            return null; //returns null if key is not found
        }
    }

    //Method removes key-value pair from map
    public boolean remove(K removeKey) {
        int hash = hash(removeKey);

        if (tableEntry[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = tableEntry[hash];

            while (current != null) {
                if (current.key.equals(removeKey)) {
                    if (previous == null) {
                        tableEntry[hash] = tableEntry[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

    public void showMap() {

        for (int i = 0; i < DEFAULT_VALUE_OF_TABLE; i++) {
            if (tableEntry[i] != null) {
                Entry<K, V> entry = tableEntry[i];
                while (entry != null) {
                    System.out.println("{" + entry.key + " = " + entry.value + "} ");
                    entry = entry.next;
                }
            }
        }
    }

    //method return size map



    //method has hashing functional. It's help to find locate our collection and does not allow it to go beyond
    private int hash(K key) {
        return Math.abs(key.hashCode()) % DEFAULT_VALUE_OF_TABLE;
    }

}
