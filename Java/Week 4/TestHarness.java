
class TestHarness {

    public static void main(String[] args)
    {

        DSACircularQueue circQueue = new DSACircularQueue();

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
            circQueue.dequeue();
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
                circQueue.dequeue();
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
