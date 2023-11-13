package Labirent;
 import java.util.LinkedList;
import java.util.Queue;


public class algorithm {

   

public class ShortestPath {
    public static int findShortestPath(int[][] matrix, int startX, int startY, int endX, int endY) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
       
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
               

                return matrix[x][y]; // Hedefe ulaşıldığında yolu bulduk
                                     // Once the destination is reached, we find the path
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && matrix[newX][newY] != 1) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    matrix[newX][newY] = matrix[x][y] + 1; // Adım sayısını güncelle
                                                           //Update step count
                   
                }
            }
        }

        return -1; // Hedefe ulaşılamadı                
                   // Destination not reached
    }
    
        
        
        
    }
    

    



}
