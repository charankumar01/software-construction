import java.util.ArrayList;
import java.util.List;

interface Employee {
    public abstract void doWork();
}

class Designer implements Employee {
    @Override
    public void doWork() {
        System.out.println("Designer is creating designs.");
    }
}

class Developer implements Employee {
    @Override
    public void doWork() {
        System.out.println("Developer is writing code.");
    }
}

class Artist implements Employee {
    @Override
    public void doWork() {
        System.out.println("Artist is creating artwork.");
    }
}

class Tester implements Employee {
    @Override
    public void doWork() {
        System.out.println("Tester is testing the software.");
    }
}

abstract class Company {
    public void createSoftware() {
        System.out.println("\nCompany is starting to create software...");

        List<Employee> employees = getEmployees();

        for (Employee e : employees) {
            e.doWork();
        }
        System.out.println("Software creation process finished.");
    }

    protected abstract List<Employee> getEmployees();
}

class GameDevCompany extends Company {
    @Override
    protected List<Employee> getEmployees() {
        List<Employee> team = new ArrayList<>();
        team.add(new Designer());
        team.add(new Developer());
        team.add(new Artist());
        return team;
    }
}

class OutsourcingCompany extends Company {
    @Override
    protected List<Employee> getEmployees() {
        List<Employee> team = new ArrayList<>();
        team.add(new Developer());
        team.add(new Tester());
        return team;
    }
}

public class Factory {
    public static void main(String[] args) {
        System.out.println("--- Factory Method Pattern ---");

        Company gameCo = new GameDevCompany();
        System.out.println("--- Game Development Company Process ---");
        gameCo.createSoftware();

        Company outsourcingCo = new OutsourcingCompany();
        System.out.println("\n--- Outsourcing Company Process ---");
        outsourcingCo.createSoftware();
    }
}
