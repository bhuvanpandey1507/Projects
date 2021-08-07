package company2;
import java.util.Scanner;

public class DisplayInfo {
	public String decision;
    Scanner sc = new Scanner(System.in);
    DisplayInfo(int quantity ,String name,String Item_type,double price,double tax,double finalprice2){
        System.out.printf("Name of item  :%s \n",name);
        System.out.printf("Price of Item : %f \n",price);
        System.out.printf("The type of item (raw |manufactured |imported ):%s\n",Item_type);
        System.out.printf("Quantity of above mentioned type: %d\n",quantity);
        
        System.out.printf("Tax on each item :%f \n",(tax-price));
        System.out.printf("price after tax :%f \n",tax);
        System.out.printf("Total price  of overall quantity:%f\n",finalprice2);
        
       

    }
    public String response(){
        System.out.print("do You want to add  another item y/n :");

        decision = sc.nextLine();
        return decision;
    }

}
