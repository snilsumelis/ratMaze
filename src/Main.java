
import java.util.Scanner;

public class Main {
    static int [][] maze;
    static int m;
    static MyStack<Position> path = new MyStack<Position>();

    public static boolean InputMaze()
    {// Input the maze.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter maze size :" );
        m = input.nextInt();
        maze = new int[m+2][m+2];
        System.out.println("Enter maze in row major order");
        for (int i=1; i<=m; i++){
            for (int j=1; j<=m; j++)
                maze[i][j] = input.nextInt();
            for (i=1; i<=m; i++){
                for (int j=1; j<=m; j++)
                    System.out.print(maze[i][j] + " ");
                System.out.println("");
            }
        }

        return true;
    }

    public static boolean FindPath(){

        Position [] offset = new Position[4];
        for(int i = 0; i <= 3; i++)
            offset[i] = new Position();
        offset[0].row = 0;
        offset[0].col = 1; // right
        offset[1].row = 1;
        offset[1].col = 0; // down
        offset[2].row = 0;
        offset[2].col = -1; // left
        offset[3].row = -1;
        offset[3].col = 0; // up


        for (int i = 0; i <= m+1; i++) {
            maze[0][i] = maze[m+1][i] = 1; // bottom and top
            maze[i][0] = maze[i][m+1] = 1; // left and right
        }

        Position here = new Position();
        Position next = new Position();
        here.row = 1;
        here.col = 1;
        maze[1][1] = 1; // prevent return to entrance
        int option = 0; // next move
        int LastOption = 3;

        // search for a path
        while (here.row != m || here.col != m) {// not exit
            // find a neighbor to move to
            int r = 0;
            int c = 0;
            while (option <= LastOption) {
                r = here.row + offset[option].row;
                c = here.col + offset[option].col;
                if (maze[r][c] == 0) break;
                option++; // next option
            }

            // was a neighbor found?
            if (option <= LastOption) {// move to maze[r][c]
                here = new Position(r,c);
                path.push(here);
                here.row = r;
                here.col = c;
                // set to 1 to prevent revisit
                maze[r][c] = 1;
                option = 0;
            }
            else {// no neighbor to move to, back up
                if (path.IsEmpty()) return false;


                next = path.pop();
                if (next.row == here.row)
                    option = 2 + next.col - here.col;
                else option = 3 + next.row - here.row;
                here = next;
            }
        }
        return true;  // at exit

    }

    public static void OutputPath()
    {// Output path to exit.
        System.out.println("The path is");
        while (!path.IsEmpty()) {
            Position here = path.pop();
            System.out.print(here.row);
            System.out.print(" ");
            System.out.println((here.col));
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        boolean alo = InputMaze();
        alo = FindPath();
        OutputPath();
    }

}

