import java.util.HashMap;
import java.util.Map;
import java.util.Map.*;

public class HashMapLesson {
    public static void main(String[] args) {
        Map<Employee, Integer> testMap = new HashMap<>();
        Employee java = new Employee("Java", 1, 10000.00);
        Employee techies = new Employee("Techies",  2, 20000.00);
        Employee angular = new Employee("Angular", 3, 15000.00);
        Employee html = new Employee("HTML", 4, 12000.00);
        testMap.put(java, 1); // put takes 2 parameters - key and value
        testMap.put(techies, 2);
        testMap.put(techies, 3);
//        testMap.put(techies, 4); // replaces previous techies values
//        testMap.put(techies, null);


        testMap.put(null, 5); // null key is accepted
        testMap.put(null, 6);
        testMap.putIfAbsent(angular, 6); // putIfAbsent means put specified value if key is not yet in the map
        testMap.remove(null);
        testMap.put(html,null);

        // getOrDefault - get value if already in the Map, otherwise, assign the value to the key.
        Employee react = new Employee("React", 5, 10000);
        String result = String.valueOf(testMap.getOrDefault(react, 1));
        testMap.put(react, 2);
        System.out.println(result);

        Employee tmKey = techies;
        int tmValue = 4;
        System.out.println("testMap contains key " + tmKey.name + ": " + testMap.containsKey(tmKey)); // checks for the specified key
        System.out.println("testMap contains value " + tmValue + ": " + testMap.containsValue(tmValue)); // checks for the specified value

        testMap.compute(techies, (k,v) -> {
            if(v!=null){
                return v.intValue() + 5;
//                return v.intValue();
            } else
                return 1;

        });

        for (Map.Entry entry : testMap.entrySet()){
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

}
class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            long temp;
            temp = Double.doubleToLongBits(salary);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if(obj == null)
                return false;
            if(getClass() != obj.getClass())
                return false;
            Employee other = (Employee) obj;
            if(id != other.id)
                return false;
            if(name == null){
                if(other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if(Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
                return false;
            return true;
        }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
