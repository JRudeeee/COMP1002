public class towerOfHanoi {

    public static int[] numTowers = { 0, 0, 0 };
    public static int recursionLevel = 1;

    public static void main(String[] args)
    {
        int n = 3;
        int src = 1;
        int dest = 3;

        numTowers[src - 1] = n;

        for (int ii = 0; ii < 3; ii++)
        {
            System.out.printf("%d ", numTowers[ii]);
        }
        System.out.printf("\n");
        towers(n, src, dest);
    }

    public static void towers(int n, int src, int dest)
    {
        int tmp;

        if (n == 1)
        {
            moveDisc(src, dest);
            recursionLevel -= 1;
        } else
        {
            recursionLevel += 1;
            tmp = 6 - src - dest;

            towers(n - 1, src, tmp);

            moveDisc(src, dest);

            towers(n - 1, tmp, dest);
        }
    }

    public static void moveDisc(int src, int dest)
    {

        for (int jj = 0; jj < recursionLevel-1; jj++)
        {
            System.out.printf("    ");
        }

        if (numTowers[src - 1] > 0)
        {
            numTowers[src - 1] -= 1;

            numTowers[dest - 1] += 1;
        } else
        {
            System.out.println("Error, can't move nothing!");
        }

        for (int ii = 0; ii < 3; ii++)
        {
            System.out.printf("%d ", numTowers[ii]);
        }
        System.out.printf("\n");

    }

}
