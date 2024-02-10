import java.util.Scanner;
import java.util.ArrayList;
class contact{
    int id;
    String name;
    String mobNum;
    String email;
    contact(int id,String name,String mobNum,String email){
        this.id=id;
        this.name=name;
        this.mobNum=mobNum;
        this.email=email;
    }
}

class contactManager{
    Scanner s=new Scanner(System.in);
    
    void showConDet(ArrayList<contact> contactDet,int n){
        for(int i=0;i<n;i++){
            System.out.println("Contact Id: "+contactDet.get(i).id);
            System.out.println("Name: "+contactDet.get(i).name);
            System.out.println("Mobile Number: "+contactDet.get(i).mobNum);
            System.out.println("Email: "+contactDet.get(i).email);
            System.out.println("\n");
        }
    }
    
    void addNewCont(ArrayList<contact> contactDet){
        System.out.println("Do you want to add new contact details (y/n): ");
        String ip=s.nextLine();
        if (ip.equals("y")){
            System.out.println("How many new contacts you want to add: ");
            int num=s.nextInt();
            s.nextLine();
            for(int i=contactDet.size();i<(num+contactDet.size());i++){
                int id=(i+1);
                System.out.println(id);
                System.out.println("Enter Name: ");
                String name=s.nextLine();
                System.out.println("Enter Mobile Number: ");
                String mobNum=s.nextLine();
                System.out.println("Enter Email: ");
                String email=s.nextLine();
                s.nextLine();
                contact c=new contact(id,name,mobNum,email);
                contactDet.add(c);
            }
            showConDet(contactDet, (contactDet.size()+num));
        }
        else{
            showConDet(contactDet, contactDet.size());
        }
    }
    
    void searchCont(ArrayList<contact> contactDet){
        System.out.println("Do you want to search contact details (y/n): ");
        String ip=s.nextLine();
        if(ip.equals("y")){
            System.out.println("Enter the NAME you are searching for: ");
            String sName=s.nextLine();
            for(int i=0;i<contactDet.size();i++){
                if(contactDet.get(i).name.equals(sName)){
                    showConDet(contactDet, (i+1));
                }
                else{
                    System.out.println("You have entered the wrong name.");
                    break;
                }
            }
        }
    }
    void updateCont(ArrayList<contact> contactDet,int id,String name,String mobNum,String email){
        for(int i=0;i<contactDet.size();i++){
            if(contactDet.get(i).id==id){
                contactDet.get(i).name=name;
                contactDet.get(i).mobNum=mobNum;
                contactDet.get(i).email=email;
            }
        }
        showConDet(contactDet, id);
    }
    void deleteDet(ArrayList<contact> contactDet){
        System.out.println("Do you want to delete contact details (y/n): ");
        String ip=s.nextLine();
        if(ip.equals("y")){
            System.out.println("Which contact id you want to delete: ");
            int id0=s.nextInt();
            for(int i=0;i<contactDet.size();i++){
                if(String.valueOf(contactDet.get(i).id).equals(String.valueOf(id0))){
                    contactDet.remove(i);
                    showConDet(contactDet,contactDet.size());
                }
            }   
        }
        else{
            System.out.println("You have entered wrong Contact Id");
        }
    }
}

public class assignment{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("How many contact details you want to enter: ");
        int n=s.nextInt();
        ArrayList<contact> contDet=new ArrayList<>();
        s.nextLine();
        s.nextLine();
        for(int i=0;i<n;i++){
            int id=(i+1);
            System.out.println("Contact Number: "+id);
            System.out.println("Enter Name: ");
            String name=s.nextLine();
            System.out.println("Enter Mobile Number: ");
            String mobNum=s.nextLine();
            System.out.println("Enter Email: ");
            String email=s.nextLine();
            s.nextLine();
            contact c=new contact(id,name,mobNum,email);
            contDet.add(c);
        }
        contactManager cm=new contactManager();
        cm.showConDet(contDet,n);
        cm.addNewCont(contDet);
        cm.searchCont(contDet);
        System.out.println("Do you want to update the list (y/n): ");
        String ip=s.nextLine();
        if(ip.equals("y")){
            System.out.println("Enter the id: ");
            int id1=s.nextInt();
            s.nextLine();
            for(int i=0;i<n;i++){
                if(String.valueOf(contDet.get(i).id).equals(String.valueOf(id1))){
                        System.out.println("Enter new Name: ");
                        String name=s.nextLine();
                        System.out.println("Enter new Mobile Number: ");
                        String mobNum=s.nextLine();
                        System.out.println("Enter new Email: ");
                        String email=s.nextLine();
                        cm.updateCont(contDet, id1, name, mobNum, email);
                        break;
                }
            }
        }
        cm.deleteDet(contDet);
    }
}