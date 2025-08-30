public class Build{
    
    public static void main(String[] args){
        //car object creation 
        car c1 = new car(); //default constructor has been created.
        c1.brand = "Honda";
        c1.color = "Black";
        c1.price = 1500000;

        c1.displayinfo();

    }
}

//Car class blue print of car;
class car{
    String brand;
    String color;
    int price;

    public void displayinfo(){
        System.out.println("The car is from brand: "+brand+" and color is "+color+" and price is "+price);
    }
}