import java.util.ArrayList;

public class FloodFill {
    
    
    private static void dfs(
        Integer row, 
        Integer col, 
        int originalColor, 
        Integer new_color, 
        ArrayList<ArrayList<Integer>> image
    ) {
        
        image.get(row).set(col,new_color);
        
        if(row+1 < image.size() &&  image.get(row+1).get(col) == originalColor){
             dfs(row+1, col, originalColor,new_color,image);
        }

        if(col+1 < image.get(row).size() &&  image.get(row).get(col+1) == originalColor){
             dfs(row, col+1, originalColor,new_color,image);
        }

        if(row-1>=0 &&  image.get(row-1).get(col) == originalColor){
             dfs(row-1,col, originalColor,new_color,image);
        }

        if(col-1 >= 0 &&  image.get(row).get(col-1) == originalColor){
             dfs(row,col-1, originalColor,new_color,image);
        }
    }


    static ArrayList<ArrayList<Integer>> flood_fill(
        Integer pixel_row, Integer pixel_column,
        Integer new_color, 
        ArrayList<ArrayList<Integer>> image
    ) {
        int originalColor = image.get(pixel_row).get(pixel_column);
        if(originalColor == new_color) return image;
        
        dfs(pixel_row, pixel_column, originalColor, new_color, image);
        return image;
    } 
}
