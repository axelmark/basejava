import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

  Resume[] storage = new Resume[10000];
  private int size = 0;

  void clear() {
    while (size > 0) {
      storage[--size] = null;
    }
  }

  // TODO: 01.03.2021
  void save(Resume r) {
    try {
      if (size >= storage.length) {
        // Можно увеличить динамически capacity
        throw new Exception();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    storage[size++] = r;
  }

  Resume get(String uuid) {
    for (int i = 0; i < size; i++) {
      if (storage[i].uuid.equals(uuid)) {
        return storage[i];
      }
    }
    return null;
  }

  void delete(String uuid) {
    for (int i = 0; i < size; i++) {
      if (storage[i].uuid.equals(uuid)) {
        storage[i] = storage[--size];
        storage[size] = null;
        break;
      }
    }
  }

  /**
   * @return array, contains only Resumes in storage (without null)
   */
  Resume[] getAll() {
    Resume[] newStorage = new Resume[size];
    for (int i = 0; i < size; i++)
      newStorage[i] = storage[i];
    return newStorage;

  }

  int size() {
    return size;
  }

  int capacity() {
    return storage.length;
  }
}
