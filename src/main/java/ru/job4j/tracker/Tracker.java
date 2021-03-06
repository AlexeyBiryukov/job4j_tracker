package ru.job4j.tracker;

import java.security.PublicKey;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        /*  Item[] itemsWithoutNull = new Item[items.length];
           for (int index = 0; index < items.length; index++) {
               Item id = items[index];
               if (id != null) {
                   itemsWithoutNull[size] = id;
                  size++;
            }
         */
        Item[] rsl = Arrays.copyOf(items, size);
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] itemsWithName = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
          Item name = items[index];
          if (name.getName().equals(key)) {
              itemsWithName[count] = name;
              count++;
          }
        }
        Item[] rsl = Arrays.copyOf(itemsWithName, count);
        return rsl;
    }

    public Item findById(int id) {
       /* Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }

        }
        */
        /* Находим индекс */
       int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
       return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
             rsl = index;
             break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
      int index = indexOf(id);
      if (index != -1) {
          items[index] = item;
          item.setId(id);
          return true;
      }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        int start = index + 1;
        int distPos = index;
        int length = size - index;
        if (index != -1) {
            System.arraycopy(items, start, items, distPos, length);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}
