/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size++] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (size > 0) {
            int deleted = 0;
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    deleted = i;
                    found = true;
                    break;
                }
            }

            if(found) {
                if (size - 1 - deleted >= 0)
                    System.arraycopy(storage, deleted + 1, storage, deleted, size - 1 - deleted);
                storage[size--] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[size];
        if (newStorage.length == 0) {
            return newStorage;
        }
        System.arraycopy(storage, 0, newStorage, 0, newStorage.length);
        return newStorage;
    }

    int size() {
        return size;
    }
}
