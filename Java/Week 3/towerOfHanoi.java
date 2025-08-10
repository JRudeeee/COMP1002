public class towerOfHanoi {

    public static int[] numTowers = { 0, 0, 0 };
    public static int recursionLevel = 1;
    public static int numMoves = 0;

    public static void main(String[] args)
    {
        int n = 4;
        int src = 1;
        int dest = 3;

        numTowers[src - 1] = n;

        System.out.printf("towers(%d, %d, %d)\n", n, src, dest);
        towers(n, src, dest);
        System.out.printf("... # There are %d moves for this problem.\n", numMoves);
    }

    public static void towers(int n, int src, int dest)
    {
        int tmp;

        if (n == 1)
        {
            System.out.printf("    ".repeat(recursionLevel - 1) + "Recursion Level=%d\n", recursionLevel);
            System.out.printf("    ".repeat(recursionLevel - 1) + "Moving Disk %d from Source %d to Destination %d\n",
                    n, src, dest);
            System.out.printf("    ".repeat(recursionLevel - 1) + "n=%d, src=%d, dest=%d\n\n",
                    n, src, dest);
            moveDisc(src, dest);
            recursionLevel -= 1;
        } else
        {
            recursionLevel += 1;
            tmp = 6 - src - dest;
            towers(n - 1, src, tmp);

            System.out.printf("    ".repeat(recursionLevel - 1) + "Recursion Level=%d\n", recursionLevel);
            System.out.printf("    ".repeat(recursionLevel - 1) + "Moving Disk %d from Source %d to Destination %d\n",
                    n, src, tmp);
            System.out.printf("    ".repeat(recursionLevel - 1) + "n=%d, src=%d, dest=%d\n\n",
                    n, src, tmp);

            moveDisc(src, dest);

            towers(n - 1, tmp, dest);
        }
    }

    public static void moveDisc(int src, int dest)
    {
        numMoves++;
        if (numTowers[src - 1] > 0)
        {
            numTowers[src - 1] -= 1;

            numTowers[dest - 1] += 1;
        } else
        {
            System.out.printf("    ".repeat(recursionLevel - 1) + "Error, can't move nothing!");
        }

    }

}
