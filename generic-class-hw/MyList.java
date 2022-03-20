import java.util.Arrays;

public class MyList<T> {
    private T[] array;

    // Default Constructor.
    public MyList() {
        array = (T[]) new Object[10]; // Default length : 10
    }

    // Constructor with array size parameter.
    public MyList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    // Returns Array capacity size.
    public int getCapacity() {
        return this.array.length;
    }

    // Returns number of elements in array.
    public int size() {
        int arraySize = 0;
        for (T obj : this.array) {
            if (obj != null) {
                arraySize++;
            }
        }
        return arraySize;
    }

    // Gets data from index number (getDataAtIndexOf()).
    public T get(int index) {
        return this.array[index] != null ? this.array[index] : null;
    }

    // Adds new data to the array.
    public void add(T data) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == null) {
                this.array[i] = data;
                break;
            } else if (i == this.getCapacity() - 1) {
                // Not enough memory size to add data! Array capacity will double.
                doubleArrayCapacity();
                this.array[i + 1] = data;
                break;
            }
        }
    }

    // Increases array size 2x.
    private void doubleArrayCapacity() {
        // Setting new double size array.
        T[] doubledArray = (T[]) new Object[this.array.length * 2];
        int doubledSize = this.array.length * 2;

        // Data transfer.
        doubledArray = Arrays.copyOf(this.array, this.array.length * 2);

        // Setting array with doubled size version of itself.
        this.array = doubledArray;
    }

    // Removes data from array.
    public T remove(int index) {
        // If data deleted than return deleted object.
        if (this.array[index] != null) {
            // deletion by overwriting.
            T temp = this.array[index];
            for (int i = index; i < this.array.length - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
            return temp;
        }
        // else return null
        return null;
    }

    // Sets new data to the given index.
    public T set(int index, T data) {
        // If operation successful then return given data back else return null
        if (index >= this.array.length) {
            // Invalid index.
            return null;
        }
        this.array[index] = data;
        // If data set to index than return data.
        return data;
    }

    // Returns array context as String.
    public String toString() {
        String arrayDetails = "[";

        for (int i = 0; i < this.array.length; i++) {
            // If index not null then add to arrayDetails.
            if (this.array[i] != null) {
                arrayDetails += this.array[i];
            }
            // if next index is null then break and do not put ',' to the end.
            if (this.array[i + 1] == null) {
                break;
            }
            arrayDetails += ",";

        }
        arrayDetails += "]";

        return arrayDetails;
    }

    // Returns index of element equals to the given data.
    public int indexOf(T data) {
        // When finds first equal element it returns the index of it.
        for (int i = 0; i < this.array.length; i++) {
            if (this.get(i) == data) {
                return i;
            }
        }
        // Element not found then return -1.
        return -1;
    }

    // Returns index of last element equals to the given data.
    public int lastIndexOf(T data) {
        // When finds last equal element it returns the index of it.
        for (int i = size() - 1; i >= 0; i--) {
            if (this.get(i) == data) {
                return i;
            }
        }
        // Element not found then return -1.
        return -1;
    }

    // Returns the array is empty or not.
    public boolean isEmpty() {
        return size() == 0;
    }

    // Returns as a Object array.
    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.size());
    }

    // Clears the array.
    public void clear() {
        T[] emptyArray = (T[]) new Object[this.getCapacity()];
        this.array = emptyArray;
    }

    // Returns sublist of array for the given index range.
    public MyList<T> subList(int start, int finish) {
        MyList<T> list = new MyList<>((finish - start + 2)); // For '\0'
        // Loop for copying data for given range.
        for (int i = start; i <= finish; i++) {
            if (i < this.getCapacity()) {
                list.add(this.array[i]);
            } else {
                // Print out of range messsage.
                System.out.println("Out of range index value!");
                break;
            }
        }
        return list;
    }

    public boolean contains(T data) {
        for (int i = 0; i < size(); i++) {
            if(this.get(i) == data) {
                return true;
            }
        }
        return false;
    }
}
















