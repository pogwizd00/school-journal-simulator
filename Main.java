import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
            Student S1 = new Student("Piotr","Pogwizd",StudentCondition.ODRABIAJĄCY,"10:10:2000",1000);
            Student S2 = new Student("xxxx","xxxx",StudentCondition.ODRABIAJĄCY,"12:12:2001",1200);
            Student S3 = new Student("ANONIM", "ANONIM", StudentCondition.ODRABIAJĄCY, "20:11:2001", 500);
            Student S4 = new Student("Elzbieta", "Porcja", StudentCondition.ODRABIAJĄCY, "20:12:2001", 300);
            Class class1 = new Class("KlasaA",20);
            Class class2 = new Class("KlasaB", 30);
            Class class3 = new Class("KlasaC",22);
            Class class4 = new Class("KlasaD",22);
            Class class5 = new Class("KlasaE",22);


            //-------INFORMATION ABOUT STUDENT-----
            S1.print();
            S2.print();
            //-------COMPARE STUDENTS USING COMPARE TO-----
            S1.compareTo(S1);
            S1.compareTo(S2);
            //--------ADDING STUDENT TO CLASS-------------
            class1.addStudent(S1);
            class1.addStudent(S1); // already belong to class
            class1.addStudent(S2);
            class3.addStudent(S3);
            class1.addStudent(S4);
            //-----ADDING POINTS TO STUDENT-----
            class1.addPoints(S1,200.0);
            //-----REMOVE STUDENT FROM CLASS-----
            class1.getStudent(S2);
            //----CHANGING CONDITION STUDENT
            class1.changeCondition(S1,StudentCondition.NIEOBECNY);
            //-----REMOVE POINTS STUDENT --------
            class1.removePoints(S1,150.0);
            System.out.println("Currently points " + S1.getLastName() + " " + S1.getPoints());
            //----- RETURN STUDENT WITH LASTNAME-----
            Student Sf = class1.search("Porcja");
            Sf.print();
            //-----RETURN EVERY STUDENT WHO'S LASTNAME EQUALS PHRASE
            ArrayList<Student>foundStudents = class1.searchPartial("Po");
            //-----COUNT BY CONDITION-------
            int howManyConditions = class1.countByCondition(StudentCondition.ODRABIAJĄCY);
            System.out.println("Odrabiajcacych w class1 jest: "+ howManyConditions);
            //-----INFORMATION ABOUT STUDENT IN CLASS----------
            class1.summary();
            //-----SORTED LIST BY LASTNAME----------
            System.out.println("SORTED BY LASTNAME");
            ArrayList<Student>sortedByLastName = class1.sortByName();
            for(int i=0; i < sortedByLastName.size(); i++){
                    sortedByLastName.get(i).print();
            }
            //-----SORTED LIST BY POINTS-----------
            ArrayList<Student>sortedByPoints= class1.sortByPoints();
            System.out.println("SORTED BY POINTS");
            for(int i =0; i< sortedByPoints.size(); i++){
                    sortedByPoints.get(i).print();
            }
            //-------SUMMARY EVERY CLASSES--------
            ClassContainer classes = new ClassContainer();
            classes.addClass(class1,20);
            classes.addClass(class2,22);
            classes.addClass(class3,30);
            classes.addClass(class4,10);
            classes.addClass(class5,100);

            //--------REMOVE GROUP BY NAME-----------
            classes.removeClass("KlasaA");

            //-------RETURN LIST OF EMPTY GROUP-------
            ArrayList<Class>emptyClasses = classes.findEmpty();

            for(int i=0; i < emptyClasses.size(); i++){
                System.out.println(emptyClasses.get(i).getNameOfGroup());
            }

            //-------SUMMARY GROUPS-----------------
            classes.summary();

    }
}
