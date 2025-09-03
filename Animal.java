public class Animal {
   void eating(){
        System.out.println("Animal is eating");
    }
     void sound(){

        System.out.println("Animal is making sound");

    }

}

class Dog extends Animal{
    @Override
    void sound() {
//        super.sound();//super keyword is like this keyword It refers to the parent method or constructor.
        System.out.println("Dog in barking");
    }

    void run(){
     System.out.println("The dog is running");
 }
}
