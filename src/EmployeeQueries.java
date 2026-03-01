import model.Employee;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


public class EmployeeQueries {
    private static List<Employee> createEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(177, "Iqbal Hussain", 43, "Male", "Security And Transport", 2010, 10500.0));
        employeeList.add(new Employee(166, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        employeeList.add(new Employee(276, "Aaa kumar", 31, "Male", "Product Development", 2012, 35700.0));
        return employeeList;
    }

    private static void maleAndFemale(List<Employee> employeeList) {
        System.out.println("1----Male&Female employees: Count only----");
        Map<String, Long> map = employeeList.stream()
                .collect(Collectors.groupingBy(o -> o.gender(), Collectors.counting()));
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
//       prints:
//       Male: 12
//       Female: 6
        System.out.println("1----Male&Female employees: separate List----");

        Map<String, List<Employee>> Collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::gender));
        for (Map.Entry<String, List<Employee>> entry : Collect.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
//       prints:
//        Male: [Employee[id=122, name=Paul Niksui, age=25, gender=Male, department=Sales And Marketing, yearOfJoining=2015, salary=13500.0], Employee[id=133, name=Martin Theron, age=29, gender=Male, department=Infrastructure, yearOfJoining=2012, salary=18000.0], Employee[id=144, name=Murali Gowda, age=28, gender=Male, department=Product Development, yearOfJoining=2014, salary=32500.0], Employee[id=177, name=Iqbal Hussain, age=43, gender=Male, department=Security And Transport, yearOfJoining=2010, salary=10500.0], Employee[id=166, name=Manu Sharma, age=35, gender=Male, department=Account And Finance, yearOfJoining=2010, salary=27000.0], Employee[id=188, name=Wang Liu, age=31, gender=Male, department=Product Development, yearOfJoining=2015, salary=34500.0], Employee[id=200, name=Jaden Dough, age=38, gender=Male, department=Security And Transport, yearOfJoining=2015, salary=11000.5], Employee[id=222, name=Nitin Joshi, age=25, gender=Male, department=Product Development, yearOfJoining=2016, salary=28200.0], Employee[id=244, name=Nicolus Den, age=24, gender=Male, department=Sales And Marketing, yearOfJoining=2017, salary=10700.5], Employee[id=255, name=Ali Baig, age=23, gender=Male, department=Infrastructure, yearOfJoining=2018, salary=12700.0], Employee[id=277, name=Anuj Chettiar, age=31, gender=Male, department=Product Development, yearOfJoining=2012, salary=35700.0], Employee[id=276, name=Aaa kumar, age=31, gender=Male, department=Product Development, yearOfJoining=2012, salary=35700.0]]
//        Female: [Employee[id=111, name=Jiya Brein, age=32, gender=Female, department=HR, yearOfJoining=2011, salary=25000.0], Employee[id=155, name=Nima Roy, age=27, gender=Female, department=HR, yearOfJoining=2013, salary=22700.0], Employee[id=199, name=Amelia Zoe, age=24, gender=Female, department=Sales And Marketing, yearOfJoining=2016, salary=11500.0], Employee[id=211, name=Jasna Kaur, age=27, gender=Female, department=Infrastructure, yearOfJoining=2014, salary=15700.0], Employee[id=233, name=Jyothi Reddy, age=27, gender=Female, department=Account And Finance, yearOfJoining=2013, salary=21300.0], Employee[id=266, name=Sanvi Pandey, age=26, gender=Female, department=Product Development, yearOfJoining=2015, salary=28900.0]]

    }

    private static void departmentNames(List<Employee> employees) {
        System.out.println("2. Print the name of all the dept in organization");

        List<String> departments = employees.stream()
                .map(Employee::department).distinct().collect(Collectors.toList());
        // .distinct()-> otherwise redundant department names will appear
        departments.forEach(System.out::println);
//        prints:
//        HR
//        Sales And Marketing
//        Infrastructure
//        Product Development
//        Security And Transport
//        Account And Finance

    }

    private static void avarageAgeOfMaleFemale(List<Employee> employees) {

        System.out.println("3. What is the average age of male and female employees");
        Map<String, Double> map = employees.stream().collect(Collectors.groupingBy(Employee::gender, Collectors.averagingDouble(o -> o.age())));

        //employees.stream().collect(Collectors.groupingBy(Employee::gender) -> means we have a map with 2 entries ,
        // Male : list of male employees , Female : list of female employees
        //  Downstream : Collectors.averagingDouble(o->o.age() ) -> It will perform average on both the list separately , key extractor function returns age of each employee

        map.forEach((k, v) -> {
            System.out.println(k + " : " + v.intValue());
        });
//        prints:
//        Male : 30
//        Female : 27
        System.out.println("3. What is the average age of male and female employees but less concise");
        Map<String, List<Employee>> groupByGender = employees.stream().collect(Collectors.groupingBy(Employee::gender));

        for (Map.Entry<String, List<Employee>> group : groupByGender.entrySet()) {
            Double age = group.getValue().stream().collect(Collectors.averagingInt(Employee::age));
            System.out.println(group.getKey() + ":" + age.intValue());
        }
//        prints:
//        Male:30
//        Female:27

    }

    private static void highestPaid(List<Employee> employeeList) {
        System.out.println("4. Get the details of highest paid employee in the organization");

        Employee employee = employeeList.stream().max(Comparator.comparing(o -> o.salary())).orElse(null);
        //employeeList.stream().max() -> looking of single top employee
        // Comparator.comparing(o->o.salary()) ->need to compare on the basis of salary
        //.orElse(null)-> max/min returns optional, so if optional is empty .get()it will throw exception

        System.out.println(employee);
//        prints:
//        Employee[id=277, name=Anuj Chettiar, age=31, gender=Male, department=Product Development, yearOfJoining=2012, salary=35700.0]

        System.out.println("4. Get the details of highest paid employee in the organization , different way");
        Optional<Employee> highestPaid = employeeList.stream().max(Comparator.comparing(Employee::salary));

        highestPaid.ifPresentOrElse(System.out::println, () -> System.out.println("Highest paid doesn't exist"));

        System.out.println("4. Get the details of highest paid employee in the organization , " +
                "Now multiple employees can have same salary , pick lexicographically smaller name");

        Employee employeeSmallerName = employeeList.stream()
                .max(
                        Comparator.comparing(Employee::salary)
                                .thenComparing(Employee::name, Comparator.reverseOrder())
                ).orElse(null);

        System.out.println(employeeSmallerName);
        // for tiebreaker, I used name using .thenComparing()
        //Why Comparator.reverseOrder() ? See max always pick value which is higher
        // for salary it will pick higher salary
        // for name it will also pick higher (between 'amit' and 'zara' : 'zara' will be picked)
        // but we want 'amit'
//        prints:
//        Employee[id=276, name=Aaa kumar, age=31, gender=Male, department=Product Development, yearOfJoining=2012, salary=35700.0]

        System.out.println("4. Get the details of highest paid employee in the organization , " +
                "Now multiple employees can have same salary , pick lexicographically smaller name , but using 'MIN");
        Employee employeeSmallerName2 = employeeList.stream()
                .min(
                        Comparator.comparing(Employee::salary).reversed().thenComparing(Employee::name)
                )
                .orElse(null);
        System.out.println(employeeSmallerName2);


    }


    private static void joinedAfter2015(List<Employee> employees) {
        System.out.println("5. Get names of all employees who have joined after 2015");

        List<String> employeeNames = employees.stream().filter(o -> o.yearOfJoining() > 2015).map(Employee::name).toList();//java17+, immutable list
        List<String> employeeNames1 = employees.stream().filter(o -> o.yearOfJoining() > 2015).map(Employee::name).collect(Collectors.toList());//java8+ , mutable list
        //employees.stream().filter(o->o.yearOfJoining()>2015) ->filtered out all employees joined after 2015
        // map(Employee::name) -> only took out name of the employee , get rid of everything else

        String collect = employeeNames.stream().collect(Collectors.joining(", "));
        System.out.println(collect);
//        prints:
//        Amelia Zoe, Nitin Joshi, Nicolus Den, Ali Baig
    }

    private static void noOfEmployeesInEachDept(List<Employee> employees) {

        System.out.println("6. Count the number of employees in each dept");

        Map<String, Long> employeesInDepartmentMap = employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.counting()));

        //employees.stream().collect(Collectors.groupingBy(Employee::department)->  means we have a map with multiple entries
        //like->  depart1 : [list of employees in depart1] , depart2 : [list of employees in depart2] ...
        //Collectors.counting()) , downstream function  to count  no of objects in each list

        employeesInDepartmentMap.forEach((k, v) -> {
            System.out.println(k + " : " + v.intValue());
        });

        System.out.println("6. Count the number of employees in each dept , more concise");
        employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.counting())).forEach((k, v) -> {
            System.out.println(k + " : " + v.intValue());
        });
//        prints:
//        Product Development : 6
//        Security And Transport : 2
//        Sales And Marketing : 3
//        Infrastructure : 3
//        HR : 2
//        Account And Finance : 2
    }

    private static void avgSalaryOfEachDept(List<Employee> employees) {
        System.out.println("7. What is the average salary of each department?");

        Map<String, Double> deptWiseSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));

        // if I directly print double then many digits will appear after the decimal
        // lets limit the digits after decimal , using our custom DecimalFormat
        deptWiseSalary.forEach((k, v) -> {
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(k + " : " + df.format(v));
        });
//        prints:
//        Product Development : 32583.33
//        Security And Transport : 10750.25
//        Sales And Marketing : 11900.17
//        Infrastructure : 15466.67
//        HR : 23850.00
//        Account And Finance : 24150.00
    }

    private static void youngestInProdDevDept(List<Employee> employees) {
        System.out.println("8. Details of the youngest male employee in the product development department");
        employees.stream()
                .filter(o -> o.gender().equalsIgnoreCase("male") && o.department().equalsIgnoreCase("Product Development"))
                .min(Comparator.comparing(Employee::age))
                .ifPresentOrElse(System.out::println, () -> {
                    System.out.println("No male employee in product development department");
                });
        //.filter(o->o.gender().equalsIgnoreCase("male")&&o.department().equalsIgnoreCase("Product Development")) ->filtered out all male employees who are working in product development
        //.min(Comparator.comparing(Employee::age))-> filtered youngest employee
        //ifPresentOrElse(System.out::println(Consumer) ,()->{System.out.println("No male employee in product development department");} (runnable));
//        prints:
//        Employee[id=222, name=Nitin Joshi, age=25, gender=Male, department=Product Development, yearOfJoining=2016, salary=28200.0]

    }

    public static void mostWorkingExperience(List<Employee> employees) {
        System.out.println("9. Who has the most working experience in the organization");

        employees.stream()
                .min(Comparator.comparing(Employee::yearOfJoining))
                .ifPresentOrElse(System.out::println, () -> System.out.println("No employee exist"));

//        prints:
//        Employee[id=177, name=Iqbal Hussain, age=43, gender=Male, department=Security And Transport, yearOfJoining=2010, salary=10500.0]
        System.out.println("9. Who has the most working experience in the organization , if multiple then select with lower id");
        employees.stream()
                .min(Comparator.comparing(Employee::yearOfJoining).thenComparing(Employee::id))
                .ifPresentOrElse(System.out::println, () -> System.out.println("No employee exist"));
//         prints:
//         Employee[id=166, name=Manu Sharma, age=35, gender=Male, department=Account And Finance, yearOfJoining=2010, salary=27000.0]
//


    }

    public static void maleFamaleCountInSalesTeam(List<Employee> employees) {
        System.out.println("10. How many male and female employees are there in the sales and marketing team");
        employees.stream()
                .filter(o -> o.department().equalsIgnoreCase("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::gender, Collectors.counting()))
                .forEach((k, v) -> {
                    System.out.println(k + " : " + v.intValue());
                });

//        prints:
//        Female : 1
//        Male : 2


    }

    public static void avgSalaryOfMaleFemale(List<Employee> employees) {
        System.out.println("11. What is the avg salary of male and female employees?");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.averagingDouble(Employee::salary)))
                .forEach((k, v) -> {
                    System.out.println(k + " : " + v.intValue());
                });
//        prints:
//        Male : 22500
//        Female : 20850
//

    }

    public static void namesOfEmployeesInEachDept(List<Employee> employees) {
        System.out.println("12.List down the names of all employees in each department");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.mapping(Employee::name, Collectors.toList())))
                .forEach((k, v) -> {
                    System.out.println(k + " : " + v.toString());
                });
        //.collect(Collectors.groupingBy(Employee::department) -> this will create a map
        //like dept1 -> listOf employee objects , but we need name only
        //Collectors.mapping(Employee::name,Collectors.toList())-> this downstream function will  transform employee object to employee name
        // and stores names in the list


//        prints:
//        List down the names of all employees in each department
//        Product Development : [Murali Gowda, Wang Liu, Nitin Joshi, Sanvi Pandey, Anuj Chettiar, Aaa kumar]
//        Security And Transport : [Iqbal Hussain, Jaden Dough]
//        Sales And Marketing : [Paul Niksui, Amelia Zoe, Nicolus Den]
//        Infrastructure : [Martin Theron, Jasna Kaur, Ali Baig]
//        HR : [Jiya Brein, Nima Roy]
//        Account And Finance : [Manu Sharma, Jyothi Reddy]


    }

    private static void avgAndTotalSalaryAndStats(List<Employee> employees) {
        System.out.println("13. What is the average salary and total salary of the whole organization?");
        DecimalFormat df = new DecimalFormat("0.00");
        double average = employees.stream()
                .mapToDouble(Employee::salary)
                .average()
                .orElse(0);
        System.out.println(average);
        System.out.println(df.format(average));
//        prints:
//        21950.055555555555
//        21950.06
        Double totalSalary = employees.stream()
                .map(Employee::salary)
                .reduce((o1, o2) -> o1 + o2)
                .orElse(-1.0);
        System.out.println(df.format(totalSalary.intValue()));
//        prints:
//        395101.00

        System.out.println("13. What is the average salary and total salary of the whole organization? , other way");
        DoubleSummaryStatistics stats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::salary));

        System.out.printf("""
                        Average: %S,\
                        Max: %S,\
                        Min: %s,
                        Sum: %S
                        """,
                df.format(stats.getAverage()),
                df.format(stats.getMax()),
                df.format(stats.getMin()),
                df.format(stats.getSum()));
//        prints:
//        Average: 21950.06,Max: 35700.00,Min: 10500.00,
//        Sum: 395101.00


    }

    private static void partitionYoungAndOld(List<Employee> employees) {
        System.out.println("14. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy(o -> o.age() <= 25));

        collect.forEach((k, v) -> {
            System.out.println(k ? "Young" : "old");
            System.out.println(v.stream().map(Employee::name).collect(Collectors.joining(", ")));
        });
//        prints:
//        old
//        Jiya Brein, Martin Theron, Murali Gowda, Nima Roy, Iqbal Hussain, Manu Sharma, Wang Liu, Jaden Dough, Jasna Kaur, Jyothi Reddy, Sanvi Pandey, Anuj Chettiar, Aaa kumar
//        Young
//        Paul Niksui, Amelia Zoe, Nitin Joshi, Nicolus Den, Ali Baig
    }

    private static void oldestEmployee(List<Employee> employees) {
        System.out.println("15. Who is the oldest employee in the organization? What is his age and which department he belongs to?");

        employees.stream()
                .max(Comparator.comparing(Employee::age))
                .ifPresentOrElse((employee) -> {
                    System.out.println("Age: " + employee.age());
                    System.out.println("Department: " + employee.department());
                }, () -> System.out.println("No employee exist"));

//        prints:
//        Age: 43
//        Department: Security And Transport
    }

    private static void  duplicateEmployees(List<Employee> employeeList)
    {
        System.out.println("16. Find Duplicate Employees in list");
        Set<Integer> seen = new HashSet<>();

        List<Employee> duplicates =
                employeeList.stream()
                        .filter(e -> !seen.add(e.id()))
                        .toList();
        // seen.add(element) returns true if element is not present
        // return false if already added
        // Note : equals() and hashcode() methods are implemented in your class

    }
    private static void duplicateElements()
    {
        System.out.println("17. Find Duplicate elements in list");
        List<Integer> numbers = Arrays.asList(1,2,2,3,4,5,2,3,3,6,7,1);
        Set<Integer> seen = new HashSet<>();

        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());
        // why set? why not list?
        // Everytime it sees an element which has been seen before
        // so 1 added ones , 2 added twice , 3 added twice
        // output [2,2,3,3,1] but we want [ 2, 3,1]

        duplicates.forEach(duplicate -> {
            System.out.print(duplicate);
        });
//        prints:
//        123

    }
    private static void firstNonRepeating()
    {
        System.out.println( "18. Find First Non-Repeating Character in a String");
        String str = "java interview";

        Character result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        // str.chars()-> covert char array to IntStream(primitive)not CharStream
        // so it is stored like [ 97 , 99 , 100 , 111] (asccii) not[ a , c, d ]
        // mapToObj(c -> (char) c)  -> this will iterate the Intstream covert the asscii to character ( Stream of character)
        // Now we know how to deal with Normal streama ,( primitive  streams don't behave like normal stream ), There is nothing called CharStream
        //  LinkedHashMap::new -> to preserve insertion order
        //.collect() -> now we have mapping of character and their frequency
        // .filter() we filtered out the mapping (character's) whose frequency is one.
        //  .map(Map.Entry::getKey) -> now transform mapping to just character.
        //. findFirst()-> selected the first character
        System.out.println(result);

    }


    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        // 1. Male and Female employees
        maleAndFemale(employees);

        //2. Print the name of all the dept in organization
        departmentNames(employees);

        //3. What is the average age of male and female employees
        avarageAgeOfMaleFemale(employees);

        //4. Get the details of highest paid employee in the organization
        highestPaid(employees);

        //5. Get names of all employees who have joined after 2015
        joinedAfter2015(employees);

        //6. Count the number of employees in each dept
        noOfEmployeesInEachDept(employees);

        //7. What is the average salary of each department?
        avgSalaryOfEachDept(employees);

        //8. Details of the youngest male employee in the product development department
        youngestInProdDevDept(employees);

        //9. Who has the most working experience in the organization
        mostWorkingExperience(employees);

        //10. How many male and female employees are there in the sales and marketing team
        maleFamaleCountInSalesTeam(employees);

        //11. What is the avg salary of male and female employees?
        avgSalaryOfMaleFemale(employees);

        //12. List down the names of all employees in each department
        namesOfEmployeesInEachDept(employees);

        //13. What is the average salary and total salary of the whole organization?
        avgAndTotalSalaryAndStats(employees);

        //14. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        partitionYoungAndOld(employees);

        //15. Who is the oldest employee in the organization? What is his age and which department he belongs to?
        oldestEmployee(employees);

        //16. Find Duplicate Employees in Employee List
        duplicateEmployees(employees);

        //17. Find Duplicate Elements in a List
        // wrapper class question
        duplicateElements();

        //18. Find First Non-Repeating Character in a String
        // primitive stream question
        firstNonRepeating();
    }

}