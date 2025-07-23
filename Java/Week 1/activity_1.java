class activity_1
{
    public static void main(String[] args)
    {
        int[] temps = {22, 30, 25, 28, 35, 31, 27};
        int numEl = 7;
        int j;

        int maxValue = temps[0];
        int minValue = temps[0];
        

        for(j=0; j<numEl; j++)
            if (temps[j] > maxValue)
                maxValue = temps[j];

            else if (temps[j] < minValue)
                minValue = temps[j];    

        System.out.println("Max Temperature: " + maxValue + "\u00B0C, Min Temperature: " + minValue + "\u00B0C\n");

    }
    

}