

public class CandidateInfo {
    
    private String name;
    private String numbers;
    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    private String Email;
    private String Gender;
    private String jobrole;
    private String location;
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobrole() {
        return jobrole;
    }

    public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
    }


    
    public CandidateInfo(String name, String number, String email, String gender, String jobrole, String location) {
        this.name = name;
        this.numbers = number;
        this.Email = (email);
        Gender = gender;
        this.jobrole = jobrole;
        this.location = location;
       
    }

    public CandidateInfo() {
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }




    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

   public String toString(){
   
    
    
    return "Candidate name=" + " "+ name +" "+ "Phone number=" +numbers+" " +"Email=" + Email;
}   

}

