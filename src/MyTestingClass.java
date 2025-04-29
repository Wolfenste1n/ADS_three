public class MyTestingClass {
    private final int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTestingClass other = (MyTestingClass) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int[] data = {id};
        if (data == null) return 0;
        int hash = 11;
        for (int i = 0; i < data.length; i++) {
            hash = 31 * hash + data[i];
        }
        return hash;
    }
}