package Task1;

import lombok.Data;

@Data
public class Person implements Comparable<Person> {
    final int id;
    final String name;

    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.name);

        if (result == 0) {
            result = Integer.compare(this.id, o.id);
        }
        return result;
    }
}
