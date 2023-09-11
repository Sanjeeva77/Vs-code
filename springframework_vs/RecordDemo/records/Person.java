package records;
public record Person(int id,String name,String address,String phone){


    public Person(String name,String address){
        this(2,name,address,null);
    }
    public void displayName(){
        System.out.println("Hello I am "+name);
    }

    public static void justTest(){
        System.out.println("This is testing static method");
    }
}