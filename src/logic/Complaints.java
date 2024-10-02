/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author David
 */
public class Complaints {
    //declaring strings
    private String complaintUserName;
    private String complaintEmail;
    private String complaint;
    private String dateOfComplaint;
    
    //declaring getters and setters
          public String getComplaintUserName(){
        return this.complaintUserName;
    }
    public void setComplaintUserName(String complaintUserName){
        this.complaintUserName = complaintUserName;
    }
    
    
          public String getComplaintEmail(){
        return this.complaintEmail;
    }
    public void setComplaintEmail(String complaintEmail){
        this.complaintEmail = complaintEmail;
    }
             public String getcomplaint(){
        return this.complaint;
    }
    public void setComplaint(String complaint){
        this.complaint = complaint;
    }
              public String getDateOfComplaint(){
        return this.dateOfComplaint;
    }
    public void setDateOfComplaint(String dateOfComplaint){
        this.dateOfComplaint = dateOfComplaint;
    }
    
        //converting to csv
        public String convertToCsv(){
        return this.getComplaintUserName()
                + "," + this.getComplaintEmail()
                + "," + this.getDateOfComplaint()
                + "," + this.getcomplaint();
             
    }
        public String convertToReadable(){
            //making data more easily readible
            return this.getComplaintUserName()
                    + "," + " Email: " + this.getComplaintEmail()
                    + "," + " Date of Complaint: " + this.getDateOfComplaint()
                    + "\n" + " Complaint: " + this.getcomplaint();
                    }
}