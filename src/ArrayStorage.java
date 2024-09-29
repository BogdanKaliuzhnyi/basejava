/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            } else {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                storage[i].uuid = r.uuid;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume r : storage) {
            if (r == null) {
                break;
            }
            if (r.uuid.equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid.equals(uuid)) {
                if (i < storage.length - 1) {
                    for (int j = i + 1; j < storage.length; j++) {
                        if (storage[j] != null) {
                            storage[i] = storage[j];
                            storage[j] = null;
                            i++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int storageSize = size();
        Resume[] outputStorage = new Resume[storageSize];
        for (int i = 0; i < storageSize; i++) {
            outputStorage[i] = new Resume();
            outputStorage[i].uuid = storage[i].uuid;
        }
        return outputStorage;
    }

    int size() {
        int storageSize = 0;
        for (Resume r : storage) {
            if (r != null) {
                storageSize++;
            } else {
                break;
            }
        }
        return storageSize;
    }
}
