import java.awt.geom.Area;
import java.util.*;

public class ClassContainer {
    Map<String,Class>classes = new HashMap<>();
    public void showHowManyGroups(){
        System.out.println(classes.size());
    }
    public void addClass(Class newGroup, int _maxStudents){
        classes.put(newGroup.getNameOfGroup(),newGroup);
    }
    public void removeClass(String _name){
        classes.remove("_name");
    }

    public ArrayList<Class>findEmpty(){
        ArrayList<Class>emptyClasses = new ArrayList<Class>();
        Set<Map.Entry<String,Class>>entrySet = classes.entrySet();
        for(Map.Entry<String,Class>entry : entrySet) {
            Class locClass = (Class)entry.getValue();
            if(locClass.getActualSizeOfGroup()==0){
                emptyClasses.add(locClass);
            }
        }
        return emptyClasses;
    }
    public void summary(){
        Set<Map.Entry<String,Class>>entrySet = classes.entrySet();
        for (Map.Entry<String,Class>entry: entrySet){
            Class locClass = (Class)entry.getValue(); // casting entry.get value to class on purpose because I want to have access to variable inside a class which is inside a map
            double locPercentages = ((double)locClass.getActualSizeOfGroup()/(double)locClass.getMaxStudents())*100;
            System.out.println("Name: " + entry.getKey() + " Percentages filling: " + locPercentages + "%");
        }

    }
}
