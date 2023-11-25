abstract class Employee {
    public static final double GAIN_FACTOR_CLIENT = 500;
    public static final double GAIN_FACTOR_TRAVEL = 100;

    public static final double GAIN_FACTOR_PROJECTS = 200;
    public static final double GAIN_FACTOR_ERROR = 10;
    public String name;
    private int birthYear;
    private double monthlyIncome;
    private double occupationRate;
    private Vehicle vehicle;

    private Contract contract;

    public Employee(String name, int birthYear, double monthlyIncome, double occupationRate, Vehicle vehicle,
            String type) {
        this.name = name;
        this.birthYear = birthYear;
        setMonthlyIncome(monthlyIncome);
        setOccupationRate(occupationRate);
        this.vehicle = vehicle;
        System.out.println("We have a new employee: " + this.name + ", " + type);
        // System.out.println("We have a new employee: " + this.toString());
    }

    public Employee(String name, String type) {
        this.name = name;
        System.out.println("We have a new employee: " + this.name + ", " + type);
    }

    public int getAge(int currentYear) {
        return currentYear - birthYear;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getOccupationRate() {
        return occupationRate;
    }

    public void signContract(Contract contract) {
        this.contract = contract;
    }

    public void setOccupationRate(double occupationRate) {
        if (occupationRate < 10) {
            this.occupationRate = 10;
        } else if (occupationRate > 100) {
            this.occupationRate = 100;
        } else {
            this.occupationRate = occupationRate;
        }
    }

    public double calculateAnnualIncome() {
        return getMonthlyIncome() * 12 * getOccupationRate() / 100;
    }

    public Contract getContract() {
        return contract;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Birth Year: " + birthYear + ", Monthly Income: $" + monthlyIncome +
                ", Occupation Rate: " + occupationRate + "%, " + vehicle.toString();
    }

    public abstract String contractInfo();

}

class Manager extends Employee {
    private int nbClients;
    private int nbTravelDays;

    public Manager(String name, int birthYear, double monthlyIncome, double occupationRate,
            int nbClients, int nbTravelDays, Vehicle vehicle) {
        super(name, birthYear, monthlyIncome, occupationRate, vehicle, "a manager");
        this.nbClients = nbClients;
        this.nbTravelDays = nbTravelDays;
    }

    @Override
    public double calculateAnnualIncome() {
        double baseIncome = super.calculateAnnualIncome();
        return baseIncome + nbClients * GAIN_FACTOR_CLIENT + nbTravelDays * GAIN_FACTOR_TRAVEL * 100; // Corrected
                                                                                                      // formula
    }

    @Override
    public String contractInfo() {
        // return name + "is a Manager\n" +
        // "Age: " + getAge(2023) + "\n" +
        // super.toString() + "\n" +
        // "Serge has an Occupation rate: " + getOccupationRate() + "% " +
        // "He/She travelled " + nbTravelDays + " days and\n" +
        // "has brought " + nbClients + " new clients.\n" +
        // "His/Her estimated annual income is " + calculateAnnualIncome();

        Contract contract = getContract();
        System.out.println("Contracr is:" + contract);
        if (contract instanceof Permanent) {
            Permanent permanentContract = (Permanent) contract;
            return String.format("%s is a %s. %s and he/she has %d children.\n" +
                    "He/She has worked for %d days and upon contract his/her monthly\n" +
                    "salary is %.2f.\n", name, getClass().getSimpleName().toLowerCase(),
                    permanentContract.getMaritalStatusInfo(), permanentContract.getNumberOfChildren(),
                    permanentContract.accumulatedDays, permanentContract.calculateSalary(this));
        } else if (contract instanceof Temporary) {
            Temporary temporaryContract = (Temporary) contract;
            return String.format("%s is a %s." + "he is temporary employee with %d hourly salary" +
                    "he has worked for %d hours " +
                    "salary is %.2f.\n", name, getClass().getSimpleName().toLowerCase(),
                    temporaryContract.hourlySalary, temporaryContract.accumulatedHours);
        } else {
            return "";
        }
    }
}

class Tester extends Employee {
    private int nbBugs;

    public Tester(String name, int birthYear, double monthlyIncome, double occupationRate,
            int nbBugs, Vehicle vehicle) {
        super(name, birthYear, monthlyIncome, occupationRate, vehicle, "a tester");
        this.nbBugs = nbBugs;
    }

    @Override
    public double calculateAnnualIncome() {
        return super.calculateAnnualIncome() + nbBugs * GAIN_FACTOR_ERROR;
    }

    @Override
    public String contractInfo() {
        return "Name: " + name + ", a Tester\n" +
                "Age: " + getAge(2023) + "\n" +
                super.toString() + "\n" +
                "Pierre has an Occupation rate: " + getOccupationRate() + "% and solved " + nbBugs + " bugs.\n" +
                "His/Her estimated annual income is " + calculateAnnualIncome();
    }
}

class Programmer extends Employee {
    private int nbProjects;

    public Programmer(String name, int birthYear, double monthlyIncome, double occupationRate,
            int nbProjects, Vehicle vehicle) {
        super(name, birthYear, monthlyIncome, occupationRate, vehicle, "a programmer");
        this.nbProjects = nbProjects;
    }

    @Override
    public double calculateAnnualIncome() {
        double baseIncome = super.calculateAnnualIncome();
        return baseIncome + nbProjects * GAIN_FACTOR_PROJECTS;
    }

    @Override
    public String contractInfo() {
        return "Name: " + name + ", a Programmer\n" +
                "Age: " + getAge(2023) + "\n" +
                super.toString() + "\n" +
                "Paul has an Occupation rate: " + getOccupationRate() + "% and completed " + nbProjects + " projects.\n"
                +
                "His/Her estimated annual income is " + calculateAnnualIncome();
    }
}