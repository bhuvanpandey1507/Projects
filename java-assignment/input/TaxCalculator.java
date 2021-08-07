package company2;



public class TaxCalculator{

private String type ;
private double qty;
private double price;
public double tax=0;
public double fppi;
public double tax(String type,double price,double quantity){

    this.price=price;
    this.qty=quantity;
    this.type=type;
    switch (type){
        case "raw":
        	tax=Mainvalidator.TAX_RATE_RAW*price;
    		fppi=price+tax;
    		
            break;
        case "manufactured":
        	tax=Mainvalidator.TAX_RATE_MANUFACTURED*price+
			(1+Mainvalidator.TAX_RATE_MANUFACTURED)*
			price*Mainvalidator.SURCHARGE_RATE_IMPORTED;
	        fppi=price+tax;
            break;
        default:
        	tax=Mainvalidator.IMPORT_DUTY_IMPORTED*price;
    		fppi=price+tax;
    		if(fppi<=100)
    		{
    			tax+=5;
    			fppi+=5;
    		}
    		else if(fppi<=200)
    		{
    			tax+=10;
    			fppi+=10;
    			
    		}
    		else {
    			fppi=1.05*fppi;
    			tax=fppi-price;
    		}
            break;
    }
    return fppi;
   
}
}