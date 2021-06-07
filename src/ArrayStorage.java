/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
                size--;
            } else {
                break;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume r : storage) {
            if (r != null && r.uuid.equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int deleted = 0;
        if (storage[0].uuid.equals(uuid)){
            storage[0] = null;
            size--;
        } else {
            for (int i = 1; i < storage.length; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    deleted = i;
                    storage[i] = null;
                    size--;
                    break;
                }
            }
        }

        if ((deleted == 0 && storage[0] == null) || (deleted > 0)) {
            for (int i = deleted; i < storage.length - 1; i++) {
                if (storage[i + 1] == null) break;
                storage[i] = storage[i + 1];
            }
        }

        storage[size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[size()];
        if (newStorage.length == 0) {
            return newStorage;
        }
        for (int i = 0; i < newStorage.length; i++) {
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    int size() {
        return size;
    }
}
