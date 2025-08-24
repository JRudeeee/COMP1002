class TestHarness {

    public static void main(String[] args)
    {
        // testCircular();
        //testShuffle();
        testStack();
        //EquationSolver mySovler = new EquationSolver();

        //double result = mySovler.solve("( 25.09 + 1.57 / 2 ) * 3.2 - 8 / 2");

        //System.out.println(result);
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

    public static void testShuffle()
    {

        DSAQueue shuffQueue = new DSAShuffleQueue();

        System.out.println(shuffQueue.isFull());
        System.out.println(shuffQueue.isEmpty());
        System.out.println(shuffQueue.getCount());
        try
        {
            shuffQueue.dequeue();
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(shuffQueue.peek());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        shuffQueue.enqueue(1);
        System.out.println(shuffQueue.peek());
        shuffQueue.dequeue();

        try
        {
            System.out.println(shuffQueue.peek());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        for (int ii = 0; ii < shuffQueue.DEFAULT_CAPACITY; ii++)
        {
            shuffQueue.enqueue(ii);
        }

        try
        {
            System.out.println(shuffQueue.isFull());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            shuffQueue.enqueue(1);
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(shuffQueue.peek());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        for (int ii = 0; ii < 50; ii++)
        {
            System.out.print(shuffQueue.dequeue() + ", ");
        }

        try
        {
            System.out.println(shuffQueue.peek());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            for (int ii = 0; ii < 50; ii++)
            {
                System.out.print(shuffQueue.dequeue() + ", ");
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(shuffQueue.peek());
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void testStack(){
        DSAStack stack = new DSAStack();

        System.out.println(stack.isFull());
        System.out.println(stack.isEmpty());
        System.out.println(stack.getCount());

        try
        {
            stack.pop();
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            stack.top();
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            stack.push(1);
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(stack.top());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(stack.pop());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(stack.top());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            for (int ii = 0; ii < 100; ii++){
                stack.push(ii);
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(stack.top());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            stack.push(100);
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(stack.pop());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(stack.top());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            for (int ii = 98; ii > 0; ii--){
                System.out.println(stack.pop());
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(stack.top());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(stack.pop());
        } catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            System.out.println(stack.pop());
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
