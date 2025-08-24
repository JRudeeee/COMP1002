class TestHarness {

    public static void main(String[] args) {
        //testCircular();

        EquationSolver mySovler = new EquationSolver();

        double result = mySovler.solve("( 25.09 + 1.57 / 2 ) * 3.2 - 8 / 2");
        
        System.out.println(result);
    }



    public static void testCircular()
    {

        
        DSAQueue circQueue = new DSACircularQueue();

        System.out.println(circQueue.isFull());
        System.out.println(circQueue.isEmpty());
        System.out.println(circQueue.getCount());
        try
        {
            circQueue.dequeue();
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(circQueue.peek());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        circQueue.enqueue(1);
        System.out.println(circQueue.peek());
        circQueue.dequeue();

        try
        {
            System.out.println(circQueue.peek());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        for (int ii = 0; ii < circQueue.DEFAULT_CAPACITY; ii++)
        {
            circQueue.enqueue(ii);
        }

        try
        {
            System.out.println(circQueue.isFull());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            circQueue.enqueue(1);
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(circQueue.peek());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        for (int ii = 0; ii < 50; ii++)
        {
            System.out.print(circQueue.dequeue() + ", ");
        }

        try
        {
            System.out.println(circQueue.peek());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            for (int ii = 0; ii < 50; ii++)
            {
                System.out.print(circQueue.dequeue() + ", ");
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
    
        try
        {
            System.out.println(circQueue.peek());
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
