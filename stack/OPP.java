public class Main{
    
    static class Person{
        int age;
        String name;
        
        // default constructor
        public Person(){
            
        }
        
        public Person(int age, String name){
            // System.out.println("created person");
            this.age = age;
            this.name = name;
        }
        
        public void sayHii(){
            System.out.println(name+"["+age+"] "+" says hii");
        }
    }
    
    public static void main(String[]args){
        
        Person p1 = new Person(10, "A");
        // p1.age = 10;
        // p1.name = "A";
        p1.sayHii();
        
        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";
        p2.sayHii();
        
        // swap1(p1, p2);
        // swap2(p1, p2);
        // swap3(p1, p2);
        
        // p1.sayHii();
        // p2.sayHii();
    }
    
    public static void swap3(Person ps1, Person ps2){
        // ps1 = new Person();
        
        int age = ps1.age;
        ps1.age = ps2.age;
        ps2.age = age;
        
        ps2 = new Person();
        String name = ps1.name;
        ps1.name = ps2.name;
        ps2.name = name;
    }
    
    public static void swap1(Person ps1, Person ps2){
        Person tmp = ps1;
        ps1 = ps2;
        ps2 = tmp;
    }
    
    public static void swap2(Person ps1, Person ps2){
        int age = ps1.age;
        ps1.age = ps2.age;
        ps2.age = age;
        
        String name = ps1.name;
        ps1.name = ps2.name;
        ps2.name = name;
    }
    
}




