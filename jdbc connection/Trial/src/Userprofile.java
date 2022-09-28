
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Userprofile {
    private static final String sql="INSERT INTO candidates" +"(name,numbers,email,gender,jobrole,location) values " +"(?,?,?,?,?,?);";
   
    private static void printSQLException(SQLException ex) {
        for(Throwable e:ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("Sqlstate" + ((SQLException) e).getSQLState());
                System.err.println("Error code "+((SQLException) e).getErrorCode());
                System.err.println("Message"+ e.getMessage());
                Throwable t=ex.getCause();
                while (t!=null) {
                    System.out.println("Cause" + t);
                    t=t.getCause();
                }
            }
        }
    }
    public static void printBatchupdateException(BatchUpdateException b){
        System.err.println("sqlstate"+ b.getSQLState() ); 
        System.err.println("Message"+b.getMessage());
        System.err.println("Vendor"+ b.getErrorCode());
        System.err.println("Update counts: ");
       
    }
  
    public static   String isValidmail(){
        Scanner s=new Scanner(System.in);
         while (true) {
            String email=s.next();
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";  
            if(email.matches(regex)){
                return email;
            }
            else{
                System.out.println("Enter the valid mail");
            }
         }
        }
    public static String isValidPhonenumber(){
        Scanner s=new Scanner(System.in);
        while (true) {
            String number=s.next();
            Pattern p = Pattern.compile("^\\d{10}$");
            Matcher m = p.matcher(number);
            if(m.matches()){
                return number;
            }
            else{
                System.out.println("----------------------");
                System.out.println("Enter the valid number");
                System.out.println("----------------------");
            }
        }
    }
    public static String genders(){
        Scanner s=new Scanner(System.in);
        System.out.println("Choose the given below");
        System.out.println("1) Male");
        System.out.println("2) Female");
        int n=s.nextInt();
        if(n==1){
            return "male";
        }
        if(n==2){
            return "female";
        }
        else{
            System.out.println("----------------------");
                        return "Enter the given choice";
        }
    }
        public static void main(String[] args) {
            
            Scanner s=new Scanner(System.in); 
        
       ArrayList<CandidateInfo>arr=new ArrayList<>();
       
       String name;String numbers;String email,gender;
    //    Scanner s=new Scanner(System.in);
       System.out.println("Enter the number of students to update in list");
       System.out.println("-----------------------------------------------");
            System.out.print("Enter the name  ");
            name=s.next();
            System.out.print("Enter the number  ");
            numbers=isValidPhonenumber();
            System.out.println("Enter the email  ");
            email=isValidmail();
             System.out.println("Enter the gender");
            gender=genders();
            RoleSelection role=new RoleSelection();
            arr.add(new CandidateInfo(name, numbers, (email),gender,role.jobrole,role.location));
       
       
            // for (CandidateInfo i : arr) {
            //     System.out.println(i.toString());
            // }
            
       
            try (
     
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "Chrisevans@2309");
        PreparedStatement preparedstatement=connection.prepareStatement(sql)){
            connection.setAutoCommit(false);
        for(Iterator<CandidateInfo> iterator=arr.iterator(); iterator.hasNext();){
            CandidateInfo candidate=(CandidateInfo)iterator.next();
            preparedstatement.setString(1,candidate.getName() );
            preparedstatement.setString(2, candidate.getNumbers());
            preparedstatement.setString(3, candidate.getEmail());
            preparedstatement.setString(4, candidate.getGender());
            preparedstatement.setString(5, candidate.getJobrole());
            preparedstatement.setString(6, candidate.getLocation());
            preparedstatement.addBatch();
        }
        int[] count=preparedstatement.executeBatch();
        System.out.println(Arrays.toString(count));
        connection.commit();
        connection.setAutoCommit(true);
        
  
    }
    catch(BatchUpdateException batchUpdateException){
            printBatchupdateException(batchUpdateException);
        }
        catch(SQLException e){
            printSQLException(e);
        }
       
    s.close();
 
    }
  
}

