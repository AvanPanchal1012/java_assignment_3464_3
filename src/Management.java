import java.util.ArrayList;
import java.util.List;

public class Management {
    static double workingDaysPerMonth = 20.0;

    List<Employee> employees = new ArrayList<>();

    // constructor for Motorcycle
    // make, plate, color, category, sidecar
    Motorcycle m1 = new Motorcycle("Kawasaki", "Custom Plate", "Yellow", VehicleType.RACE, false);
    Motorcycle m2 = new Motorcycle("Honda", "Custom Plate", "Black", VehicleType.NOT_FOR_RACE, true);

    // constructor for Car
    // make, plate, color, category, gear, type
    Car vt1 = new Car("Lamborghini", "Custom Plate", "White", VehicleType.Family, Gear.Manual, CarType.Sport);
    Car vt2 = new Car("BMW", "Custom Plate", "Black", VehicleType.Family, Gear.Automatic, CarType.Sedan);
    Car vt3 = new Car("Renault Clio", "Custom Plate", "Blue", VehicleType.Family, Gear.Manual, CarType.Hatchback);
    Car vt4 = new Car("Mazda", "Custom Plate", "White", VehicleType.Family, Gear.Automatic, CarType.SUV);

    //    Employee constructors
    // Manager: name, birthYear, nbClients, nbTravelDays, rate
    // Programmer: name, birthYear, nbProjects, rate
    // Tester: name, birthYear, nbBugs, rate
    public void hireTest1() {
        employees.add(new Manager("Serge", 1985, 5000, 100, 30, 4, new Car("Lamborghini", "Custom Plate", "White", VehicleType.Family, Gear.Manual, CarType.Sport)));
        employees.add(new Manager("Cindy", 1974, 6000, 80, 20, 6, new Car("BMW", "Custom Plate", "Black", VehicleType.Family, Gear.Automatic, CarType.Sedan)));
        employees.add(new Programmer("Paul", 1993, 4500, 75, 3, new Motorcycle("Kawasaki", "Custom Plate", "Yellow", VehicleType.RACE, false)));
        employees.add(new Tester("Pierre", 1987, 4000, 50, 124, new Motorcycle("Honda", "Custom Plate", "Black", VehicleType.NOT_FOR_RACE, true)));
        employees.add(new Programmer("Matt", 1981, 5500, 110, 5, new Car("Mazda", "Custom Plate", "White", VehicleType.Family, Gear.Automatic, CarType.SUV)));
        employees.add(new Programmer("Sarah", 1986, 6000, 100, 3, new Car("Renault Clio", "Custom Plate", "Blue", VehicleType.Family, Gear.Manual, CarType.Hatchback)));
    }

    //    Employee constructors
    // Manager: name, birthYear, nbClients, nbTravelDays, rate, employeeVehicle
    // Programmer: name, birthYear, nbProjects, rate, employeeVehicle
    // Tester: name, birthYear, nbBugs, rate, employeeVehicle
    public void hireTest2() {
        employees.clear();
        employees.add(new Manager("Serge", 1985, 5000, 100, 30, 4, new Car("Lamborghini", "Custom Plate", "White", VehicleType.Family, Gear.Manual, CarType.Sport)));
        employees.add(new Manager("Cindy", 1974, 6000, 80, 20, 6, new Car("BMW", "Custom Plate", "Black", VehicleType.Family, Gear.Automatic, CarType.Sedan)));
        employees.add(new Programmer("Paul", 1993, 4500, 75, 3, new Motorcycle("Kawasaki", "Custom Plate", "Yellow", VehicleType.RACE, false)));
        employees.add(new Tester("Pierre", 1987, 4000, 50, 124, new Motorcycle("Honda", "Custom Plate", "Black", VehicleType.NOT_FOR_RACE, true)));
        employees.add(new Programmer("Matt", 1981, 5500, 110, 5, new Car("Mazda", "Custom Plate", "White", VehicleType.Family, Gear.Automatic, CarType.SUV)));
        employees.add(new Programmer("Sarah", 1986, 6000, 100, 3, new Car("Renault Clio", "Custom Plate", "Blue", VehicleType.Family, Gear.Manual, CarType.Hatchback)));
        for (Employee employee : employees) {
            System.out.println("-------------------------");
            System.out.println(employee);
            System.out.println("-------------------------");
        }
    }

    public void hireTest3() {
        employees.clear();
        Employee Serge = new Manager("Serge", 1985, 5000, 100, 30, 4, new Car("Lamborghini", "Custom Plate", "White", VehicleType.Family, Gear.Manual, CarType.Sport));
        Employee Cindy = new Manager("Cindy", 1974, 6000, 80, 20, 6, new Car("BMW", "Custom Plate", "Black", VehicleType.Family, Gear.Automatic, CarType.Sedan));
        Employee Paul = new Programmer("Paul", 1993, 4500, 75, 3, new Motorcycle("Kawasaki", "Custom Plate", "Yellow", VehicleType.RACE, false));
        Employee Pierre = new Tester("Pierre", 1987, 4000, 50, 124, new Motorcycle("Honda", "Custom Plate", "Black", VehicleType.NOT_FOR_RACE, true));
        Employee Matt = new Programmer("Matt", 1981, 5500, 110, 5, new Car("Mazda", "Custom Plate", "White", VehicleType.Family, Gear.Automatic, CarType.SUV));
        Employee Sarah = new Programmer("Sarah", 1986, 6000, 100, 3, new Car("Renault Clio", "Custom Plate", "Blue", VehicleType.Family, Gear.Manual, CarType.Hatchback));

        Contract p1 = new Permanent(2, true, 6000, 200, 17);
        Contract p2 = new Permanent(3, false, 5000, 150, 19);
        Contract t1 = new Temporary(60, 30);
        Contract t2 = new Temporary(50, 60);
        Contract p3 = new Permanent(1, true, 4000, 100, 20);
        Contract p4 = new Permanent(4, true, 4500, 100, 19);
        Serge.signContract(p1);
        Cindy.signContract(p2);
        Paul.signContract(t1);
        Matt.signContract(t2);
        Pierre.signContract(p3);
        Sarah.signContract(p4);

        employees.add(Serge);
        employees.add(Cindy);
        employees.add(Paul);
        employees.add(Pierre);
        employees.add(Matt);
        employees.add(Sarah);

        for (Employee employee : employees) {
            System.out.println("-------------------------");
            System.out.println(employee);
            System.out.println("-------------------------");
        }

        System.out.println("-------------------------");
        System.out.println("Contracts: ");
        System.out.println("-------------------------");
        for (Employee employee : employees) {
            System.out.print(employee.contractInfo());
        }
        System.out.println("-------------------------");

        // updating Matt's contract
        Contract p5 = new Permanent(1, true, 5000, 200, 30);
        Matt.signContract(p5);

        System.out.println("-------------------------");
        System.out.println("Contracts: ");
        System.out.println("-------------------------");
        for (Employee employee : employees) {
            System.out.print(employee.contractInfo());
        }
        System.out.println("-------------------------");

    }
}
