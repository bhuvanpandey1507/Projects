package company2;
import java.util.Locale;
import java.util.regex.Pattern;

public class Acceptor {
	 
	    private String type;
	    private String itemname;
	    private String price;
	    private String qty;
	    public double priceformat;
	    public int quantityformat;
	    public String itemnameformat,typeformat;
	    private int length_arguments;
	    public double fppi;


	    public boolean setLength_arguments(int length_arguments) {
	        if(length_arguments==4){
	        this.length_arguments = length_arguments;
	         return true;
	        }
	        else{
	            throw new IllegalArgumentException("kindly enter all details");

	        }

	    }


	    public String getitemname() {
	        return itemname;
	    }

	    public void setItemname(String itemname) {
	        this.itemname = itemname;
	    }

	    public String getPrice() {
	        return price;
	    }

	    public void setPrice(String price) {
	        this.price = price;
	    }

	    public String getQuantity() {
	        return qty;
	    }

	    public void setQuantity(String quantity) {
	        this.qty = quantity;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }
	    public double getfppi() {
	    	return fppi;
	    }
	   
	    // Validating Item price
	    public double pricevalidation(String price) {
	        if (price.startsWith("-")) {
	            if (price.length() < 2) {
	                throw new NumberFormatException("Please enter a valid item amount : ");
	            } else if (!Pattern.matches("^[-][0-9]+$", price)) {
	                throw new NumberFormatException("Invalid item price ,plz provide correct format");
	            }
	            else{
	                priceformat=Double.parseDouble(price.substring(1,price.length()));
	            }
	        } else {
	            throw new NumberFormatException("kindly provide input like -200,-300,etc.");
	        }

	return priceformat;
	    }
	    
	    // Validating Item name
	    public String namevalidation(String itemname) {
	        if (itemname.startsWith("-")) {
	            if (itemname.length() < 2) {
	                throw new NumberFormatException(" enter a valid item name : " + itemname);
	            }  else if (!Pattern.matches("^[-][a-zA-Z]+$", itemname)) {
	                throw new NumberFormatException("Invalid item name");
	            }else{itemnameformat=itemname.substring(1,itemname.length());

	            }
	        }
	        else {throw new NumberFormatException("kindly provide input like -jeans , -Shirt /etc.");
	        }
	        return itemnameformat;
	 }

//	    validating quantity
	    public int quantityvalidation(String quantity) {
	        if (quantity.startsWith("-")) {
	            if (quantity.length() < 2) {
	                throw new NumberFormatException(" enter a valid item quantity : ");
	            } else if (!Pattern.matches("^[-][0-9]+$", quantity)) {
	                throw new NumberFormatException("Invalid item quantity /n ,plz enter quantity in integer format");
	            }
	            else{
	               quantity.substring(1,quantity.length()-1);
	                quantityformat=Integer.parseInt(quantity.substring(1));
	            }
	        } else {
	            throw new NumberFormatException("kindly provide input like -20");
	        }

	        return quantityformat;
	    }
	    //        validating type here
	    public String itemTypevalidation(String type) {
	      String type1=type.toUpperCase();
	        if (type1.startsWith("-")) {
	            if (type1.length() < 2) {
	                throw new NumberFormatException("Please enter a valid type : " + type1);
	            }  else if (!Pattern.matches("-RAW|-MANUFACTURED|-IMPORTED", type1)) {
	                throw new NumberFormatException("Invalid selection [raw|manufactured|imported]");
	            }else{ typeformat=type.substring(1,type.length()); }
	        }
	        else {throw new NumberFormatException("You entred type in wrong format.\n Enter one of the following (-raw,-imported,-manufactured): "); }
	        return typeformat;
	    }

	    public int getLength_arguments() {
	        return length_arguments;
	    }


}
