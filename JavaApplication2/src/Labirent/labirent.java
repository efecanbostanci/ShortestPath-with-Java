package Labirent;
import Labirent.algorithm;

public class labirent {
    
    

    static int x = 5;
    static int y = 10;
    static int gg, gc;
    static int yol;
    static int newMaze[][] = new int[x][y];
    static int maze[][] = obstacle(newMaze);

    static int getX() {
        return x;
    }

    static int getY() {
        return y;
    }

    static int ebob(int x, int y) {
        /*
        X ve Y değerlerinin en büyük ortak bölenini alıp engelimizi o
        değere göre oluşturuyoruz.
         */
        /*
        We take the greatest common divisor of the values ​​X and Y and set our obstacle to that.
        We create based on value.
         */
        int ebob = 0;
        for (int i = 1; i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                ebob = i;
            }
        }
        return ebob;
    }

    void create() {
        /*
        Matris oluşturma methodu.
         */
        /*
        Matrix creation method.
         */

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (maze[i][j] != 1) {
                    maze[i][j] = 0;
                }
            }

        }

    }

    void print() {
        /*
        Oluşturduğumuz matrisi yazdirma methodu.
         */
        /*
        Method for printing the matrix we created.
         */
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                System.out.print(maze[i][j]);

            }
            System.out.println(" ");

        }
    }

    static int[][] obstacle(int matris[][]) {

        int yenimatris[][] = matris;
        for (int i = 0; i <= 2 * (x + y) / ebob(x, y); i++) {
            // Matrisin sınırına göre random x ve y değerleri üretiyoruz.
            // We generate random x and y values ​​according to the boundary of the matrix.
            int xe = (int) (Math.random() * x);
            int ye = (int) (Math.random() * y);
            //
            for (int j = 0; j < 1; j++) {
                if (xNull(xe) && xe >= ye) {
                    /*X değeri sınır değilse  ve seçilen noktanın x değeri y değerinden 
                    büyükse veya eşitse o noktaya ve altına engel oluşturuyor.
                     */
                    /*If the x value is not a limit and the x value of the selected point is greater than the y value
                    If it is greater than or equal to that point, it creates an obstacle to that point and below.
                     */
                    yenimatris[xe][ye] = 1;
                    yenimatris[xe + 1][ye] = 1;
                }
                if (yNull(ye) && ye >= xe) {
                    /*Y değeri sınır değilse  ve seçilen noktanın y değeri x değerinden 
                    büyükse veya eşitse o noktaya ve altına engel oluşturuyor.
                     */
                    /*If the y value is not a limit and the y value of the selected point is greater than the x value
                    If it is greater than or equal to that point, it creates an obstacle to that point and below.
                     */
                    yenimatris[xe][ye] = 1;
                    yenimatris[xe][ye + 1] = 1;
                }

            }
        }

        return yenimatris;
    }

    static boolean xNull(int x) {
        boolean bos = true;
        if (x == labirent.getX() - 1) {
            bos = false;
        }
       
        return bos;
    }

    static boolean yNull(int y) {
        boolean bos = true;
        if (y == labirent.getY() - 1) {
            bos = false;
        }
        return bos;
    }

    static void ship() {
        boolean olustu = true;
        while (olustu) {
            gg = (int) (Math.random() * x);
            if (maze[gg][0] == 0 && maze[gg][1] == 0) {
                maze[gg][0] = 0;
                olustu = false;
            }
        }
        /*
        Gemiyi rastgele üreten kod.
        */
        /*
        Code that randomly generates the ship.
        */
    }

    static int shipGetX() {
        return gg;  //Geminin X konumu
                    //Ship's X position

    }

   static int shipGetY() {
        return 0;  //Geminin Y konumu
                   //Ship's Y position
    } 

    static int exitGetX() {
        return gc; //Çıkışın X konumu
                   //X position of the exit
    }

  static  int exitGetY() {
        return y - 1;//Çıkışın Y konumu
                    //Y position of the exit

    }

   static void exit() {
        boolean olustu = true;
        while (olustu) {
            gc = (int) (Math.random() * x);
            if (maze[gc][y - 1] == 0 && maze[gc][y - 1] == 0) {
                maze[gc][y - 1] = 0;
                olustu = false;
            }
        }
        
        /*
        Çıkışın X konumunun rastgele oluştuğu method.
        
        */
        /*
        Method in which the X position of the output occurs randomly.
        
        */

    }
   static void calculate(){
     yol=algorithm.ShortestPath.findShortestPath(maze, shipGetX(), shipGetY(), exitGetX(), exitGetY());
        System.out.println("En Kisa Yol "+ yol+" Adimda olur.");
        
    
        
        
    }
}
