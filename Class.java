import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Class {
        String NameOfGroup;
        int maxStudents;
        ArrayList<Student>listOfStudents = new ArrayList<Student>();

        Class(String _name, int _maxStudents){
            NameOfGroup = _name;
            maxStudents=_maxStudents;
        }

   public int getActualSizeOfGroup(){
            return listOfStudents.size();
   }

    public int getMaxStudents() {
        return maxStudents;
    }

    public String getNameOfGroup() {
        return NameOfGroup;
    }

    public void addStudent(Student S1){
            if(listOfStudents.size()<maxStudents) {
                boolean ifBelongsToTheGroup = false;
                for(int i =0; i < listOfStudents.size(); i++){
                    if(listOfStudents.get(i).name == S1.name){
                        ifBelongsToTheGroup = true;
                    }
                }
                if (ifBelongsToTheGroup) {
                        System.out.println("Students is currently in that group");
                }
                else{
                        listOfStudents.add(S1);
                }
            }else{
                System.err.println("Too much Students in the group");
            }
        }
        public void addPoints(Student S1, double _points){
            S1.points+=_points;
        }
        public void getStudent(Student S1){
            if(S1.points ==0){
                if(listOfStudents.contains(S1)){
                    listOfStudents.remove(S1);
                }
            }else{
                System.out.println("Student " + S1.getLastName() + " still have " + S1.getPoints());
            }
        }
        public void changeCondition(Student S1, StudentCondition Condition){
            S1.SCondition =Condition;
        }
        public void removePoints(Student S1, double _points){
            S1.points-=_points;
        }
        public Student search(String lastName){
            Student S1 = new Student("",lastName,StudentCondition.NIEOBECNY,"",0);
            for(int i =0; i< listOfStudents.size(); i++){
                   if(listOfStudents.get(i).compareTo(S1)==0){
                       System.out.println("I found student with that last name");
                       return listOfStudents.get(i);
                   }else{
                       System.out.println("Student with this lastName isn't in List of Students");
                   }
            }
            return S1;
        }
        public ArrayList<Student> searchPartial(String peaceOfName){
            ArrayList<Student>searchingStudents = new ArrayList<Student>();
            for(int i =0; i<listOfStudents.size(); i++){
                if(listOfStudents.get(i).lastName.contains(peaceOfName)){
                    searchingStudents.add(listOfStudents.get(i));
                }
            }
            return searchingStudents;
        }
        public int countByCondition(StudentCondition Condition){
            int sum=0;
            for(int i=0; i<listOfStudents.size(); i++){
                if(listOfStudents.get(i).SCondition==Condition){
                    sum++;
                }
            }
            return sum;
        }
        public void summary(){
            for(int i=0; i < listOfStudents.size(); i++) {
                listOfStudents.get(i).print();
            }
        }
        public ArrayList<Student> sortByName() {
            ArrayList<Student>sortedByLastName = new ArrayList<>(listOfStudents); // very important line
            sortedByLastName.sort(Comparator.comparing(S -> S.getLastName()));
            System.out.println(sortedByLastName.size());
            return sortedByLastName;
       }
       public static Comparator<Student>ByPoints = new Comparator<Student>() {
            public int compare(Student S1, Student S2){
                double points2 = S2.getPoints();
                double points1 = S1.getPoints();
                return (int)points2 -(int)points1; // i have to change it
            }

       };

    public ArrayList<Student>sortByPoints(){
        ArrayList<Student>sortByPoints = new ArrayList<>(listOfStudents);
        Collections.sort(sortByPoints, new Comparator<Student>() {
            @Override
            public int compare(Student S1, Student S2) {
                double points2 = S2.getPoints();
                double points1 = S1.getPoints();
                return (int)points2 -(int)points1;
            }
        });
        return sortByPoints;
    }
}
