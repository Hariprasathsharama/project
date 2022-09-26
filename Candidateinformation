
import java.util.regex.Pattern;
public class CandidateInfo {
    
    private String name;
    private long number;
    private String Email;
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";  
    //Compile regular expression to get the pattern  
    Pattern pattern = Pattern.compile(regex);  
  public   CandidateInfo(String name, long number, String email) {
        this.name = name;
        this.number = number;
        this.Email = email;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    
   public static  boolean isValidmail(String email){
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
  
    return email.matches(regex);
   }


   public String toString(){
    if(isValidmail(Email)==false){
    System.out.println("Mail is not valid");
    }
    return "Candidate name=" + " "+ name +" "+ "Phone number=" +number+" " +"Email=" + Email;
}   

}

