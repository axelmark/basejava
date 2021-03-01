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

    void save(Resume r) {
        try {
            if (size >= storage.length) {
                // Можно увеличить динамически capacity массива
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
        if (size >= 0) {
            System.arraycopy(storage, 0, newStorage, 0, size);
        }
        return newStorage;
    }

    int size() {
        return size;
    }
}
