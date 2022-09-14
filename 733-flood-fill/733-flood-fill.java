class Solution {
    public int[][] floodFill(int[][] image, int x, int y, int newColor) {
        if(image[x][y] != newColor){
            ColorChanger(image, x, y, image[x][y], newColor);
        }
        return image;
    }
    
    private static void ColorChanger(int[][] image, int x, int y, int oldColor, int newColor){
        if(image[x][y]==oldColor) {
            image[x][y] = newColor;

            //up
            if (x - 1 >= 0) { ColorChanger(image, x - 1, y, oldColor, newColor); }

            //left
            if (y - 1 >= 0) { ColorChanger(image, x, y - 1, oldColor, newColor); }

            //down
            if (x + 1 < image.length) { ColorChanger(image, x + 1, y, oldColor, newColor); }

            //right
            if (y + 1 < image[0].length) { ColorChanger(image, x, y + 1, oldColor, newColor); }
        }
    }
}
