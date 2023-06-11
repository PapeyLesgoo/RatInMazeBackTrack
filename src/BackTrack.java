import java.util.Scanner;

public class BackTrack {
    public static void main(String[] args) {
        BackTrack b = new BackTrack();
        b.solve(0,0,0);
        b.display();
    }

    int[][] arr = new int[5][5];
    Scanner sc = new Scanner(System.in);
    int temp;

    public BackTrack() {
        arr[0] = new int[]{0, 0, 0, 1, 0};
        arr[1] = new int[]{0, 1, 1, 0, 0};
        arr[2] = new int[]{0, 0, 0, 0, 1};
        arr[3] = new int[]{1, 0, 1, 1, 0};
        arr[4] = new int[]{1, 0, 0, 0, 9};
    }

    void display() {
        System.out.println("AAAAAAA");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("--------");
        }
    }

    void display(int r, int c) {
        System.out.println("AAAAAAA");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i==r&&j==c){
                    System.out.print("7");
                }
                else {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println("|");
            System.out.println("--------");
        }
    }




    //1 is right
    //2 is left
    //3 is up
    //4 is down

    int solve(int row, int column, int dir) {
        if (arr[row][column] != 9) {
            display();
            arr[row][column]=5;
            if (column + 1 < arr.length && dir != 2) {
                if ((arr[row][column + 1] == 0 || arr[row][column + 1] == 9)) {
                    if(solve(row,column+1,1) == 1){
                        return 1;
                    }
                    else {
                        arr[row][column + 1] = 3;
                    }
                }
            }
            if (column -1 >= 0 && dir != 1) {
                if (arr[row][column - 1] == 0 || arr[row][column - 1] == 7 || arr[row][column -1 ]==9) {
                    if(solve(row,column-1,2) == 1){
                        return 1;
                    }
                    else {
                        arr[row][column - 1] = 3;
                    }
                }
            }
            if(row + 1 < arr.length && dir!=3){
                if (arr[row + 1][column] == 0 || arr[row + 1][column] == 7 || arr[row + 1][column]==9) {
                    if(solve( row+1,column,4) == 1){
                        return 1;
                    }
                    else {
                        arr[row + 1][column] = 3;
                    }
                }
            }
            if(row - 1 >= 0 && dir != 4){
                if (arr[row - 1][column]==0 || arr[row - 1][column] == 7 || arr[row-1][column]==9) {
                    if(solve(row-1,column,3)==1){
                        return 1;
                    }
                    else {
                        arr[row - 1][column] = 3;
                    }
                }
            }
        }
        else if(arr[row][column]==9){
            return 1;
        }
        return 0;
    }
}