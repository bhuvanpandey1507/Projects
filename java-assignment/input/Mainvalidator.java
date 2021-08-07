package company2;
import java.util.Scanner;

public class Mainvalidator {
	public static String Item_Name, Item_type;
    public static double price;
    static int quantity;
    public static String user_choice;
    public static final Double TAX_RATE_RAW=0.125;
	public static final Double TAX_RATE_MANUFACTURED=0.02;
	public static final Double SURCHARGE_RATE_IMPORTED=0.1;
	public static final double IMPORT_DUTY_IMPORTED=0.1;
	
	

    public static void main(String[] args) throws NumberFormatException {

        double finalcost2;

            try {
                // validating valid item details

                Acceptor argu_length = new Acceptor();
                if (argu_length.setLength_arguments(args.length)) {

                    //  item name validating
                    try {
                        Acceptor validate_name = new Acceptor();
                        validate_name.setItemname(args[0]);
                        Item_Name = validate_name.namevalidation(args[0]);

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                  // item price validating
                    try {
                        Acceptor validate_itemprice = new Acceptor();
                        validate_itemprice.setPrice(args[1]);
                        price = validate_itemprice.pricevalidation(args[1]);

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                   //validating quantity
                    try {
                        Acceptor validate_itempquantity = new Acceptor();
                        validate_itempquantity.setQuantity(args[2]);
                        quantity = validate_itempquantity.quantityvalidation(args[2]);

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                   //item type validation
                    try {
                        Acceptor validate_itemtype = new Acceptor();
                        validate_itemtype.setType(args[3]);
                        Item_type = validate_itemtype.itemTypevalidation(args[3]);

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    // calculating tax
                    TaxCalculator tax_calculation = new TaxCalculator();
                    double tax = tax_calculation.tax(Item_type, price, quantity);
                    //// calculating final cost including tax
                    EffectiveCost finalcost = new EffectiveCost();
                    finalcost2 = finalcost.effectivecost(quantity, price, tax);
                    //  diplaying final output
                  DisplayInfo user_response  = new DisplayInfo(quantity,Item_Name,Item_type, price, tax, finalcost2);
                  user_choice=user_response.response();
                  System.out.print("...\n"+user_choice);
                  Scanner sc=new Scanner(System.in);
                  do
                  {
                	  System.out.print("Enter Item name :");
                	  Item_Name=sc.next();
                	  System.out.print("Enter  Item Type: ");
                	  Item_type=sc.next();
                	  System.out.print("Enter Item price :");
                	  price=sc.nextDouble();
                	  System.out.print("Enter item quantity :");
                	  quantity=sc.nextInt();
                	  double tax1= tax_calculation.tax(Item_type, price, quantity);
                	  finalcost2 = finalcost.effectivecost(quantity, price, tax1);
                	  DisplayInfo user_response1  = new DisplayInfo(quantity,Item_Name,Item_type, price, tax1, finalcost2);

                	  
                  }while((user_choice=="y"|| user_choice=="Y"));
                  if(user_choice=="n"||user_choice=="N") {
                	  System.out.print("Thanks for using tool");
                  }
                   
                	
                  
                  
                  }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
    }


}
