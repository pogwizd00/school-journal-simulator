public class Student  implements Comparable<Student>{
    String name;
    String lastName;
    StudentCondition SCondition;
    String dateOfBirth;
    double points;

    public Student(String _name, String _lastName, StudentCondition _SCondition, String _dateOfBirth, double _points) {
        this.name = _name;
        this.lastName = _lastName;
        this.SCondition= _SCondition;
        this.dateOfBirth = _dateOfBirth;
        this.points = _points;
    }
    public void print(){
        System.out.println("Name: " + this.name);
        System.out.println("LastName: " + this.lastName);
        System.out.println("StudentCondition: " + this.SCondition);
        System.out.println("DateOfBirth: " + this.dateOfBirth);
        System.out.println("Points: " + this.points + "\n");

    }

    public String getLastName() {
        return lastName;
    }

    public double getPoints() {
        return points;
    }

    @Override
    public int compareTo(Student ST1) {
        if(this.lastName.compareTo(ST1.lastName) == 0){
            System.out.println("LastName's are the same.");
            return 0;
        }else{
            System.out.println("LastName's are different");
            return -1;
        }
//        return 0;
    }
}

