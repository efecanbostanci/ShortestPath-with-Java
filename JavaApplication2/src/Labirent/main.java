
package Labirent;

public class main {
    public static void main(String[] args) {
        labirent l=new labirent();
        
        l.create();
        l.ship();
        l.exit();
        l.print();
        
       
       
       
        System.out.println("Gemi "+l.shipGetX()+" "+l.shipGetY()+" Noktasinda");  //Ship Coordinate
        System.out.println("Cikis "+l.exitGetX()+" "+l.exitGetY()+" Noktasinda");//Exit Coordinate
        l.calculate(); //Calculate the path.
        
      
        
        
        
    }
    
}
