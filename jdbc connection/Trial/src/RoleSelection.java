import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RoleSelection {
        String jobrole;
        String location;
        
        ArrayList<RoleSelection>candidatepreference=new ArrayList<>();
 public RoleSelection(String jobrole, String location) {
                this.jobrole = jobrole;
                this.location = location;
        }

RoleSelection(){
        Scanner s=new Scanner(System.in);
        System.out.println("Choose  the role one of the below");
        System.out.println("1) Analyst");
        System.out.println("2) Web designer");
        System.out.println("3) Developer");
        System.out.println("4) HR"); 
        
        while(true){
                System.out.println("Enter the choice");
                int n=s.nextInt(); 
        if(n==1){
                jobrole="Analyst";
                break;
        }
        if(n==2){
                jobrole="Web desinger";
                break;
        }
        if(n==3){
                jobrole="Developer";
                break;
        }
        if(n==4){
                jobrole="HR";
                break;
        }
        else{
                System.out.println("Enter the valid number");
                
        }
        
}

        System.out.println("Choose one of the location");
        System.out.println("1) Chennai");
        System.out.println("2) Banglore");
        System.out.println("3) Coimbatore");
        while(true){
                System.out.println("Enter the choice");
                int n=s.nextInt(); 
        if(n==1){
                location="Chennai";
                break;
        }
        if(n==2){
                location="Bangalore";
                break;
        }
        if(n==3){
                 location="Coimbatore";
                break;
        } 
        else{
                System.out.println("Enter the valid number");
                
        } 
        }
        candidatepreference.add(new RoleSelection(jobrole, location));
     
}

public String getJobrole() {
        return jobrole;
}

public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
}

public String getLocation() {
        return location;
}

public void setLocation(String location) {
        this.location = location;
}

public Iterator<RoleSelection> iterator() {
        return null;
}
}
