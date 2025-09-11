import java.util.NoSuchElementException;

public class DSABinarySearchTree {

    private class DSATreeNode {
        private String m_key;
        private Object m_value;
        private DSATreeNode m_leftChild;
        private DSATreeNode m_rightChild;

        public DSATreeNode(String inKey, Object inVal)
        {
            if (inKey == null)
            {
                throw new IllegalArgumentException("Key cannot be null");
            }
            m_key = inKey;
            m_value = inVal;
            m_rightChild = null;
            m_leftChild = null;
        }

        public String getKey()
        {
            return m_key;
        }

        public Object getValue()
        {
            return m_value;
        }

        public DSATreeNode getLeft()
        {
            return m_leftChild;
        }

        public void setLeft(DSATreeNode newLeft)
        {
            m_leftChild = newLeft;
        }

        public DSATreeNode getRight()
        {
            return m_rightChild;
        }

        public void setRight(DSATreeNode newRight)
        {
            m_rightChild = newRight;
        }
    }

    private final DSATreeNode m_root;

    public DSABinarySearchTree()
    {
        m_root = null;
    }

    public Object find(String key)
    {
        return findRec(key, m_root);
    }

    private Object findRec(String key, DSATreeNode currNode)
    {
        Object value = null;

        if (currNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not found");
        } else if (key.equals(currNode.getKey()))
        {
            value = currNode.getValue();
        } else if (key.compareTo(currNode.getKey()) < 0)
        {
            value = findRec(key, currNode.getLeft());
        } else
        {
            value = findRec(key, currNode.getRight());
        }

        return value;
    }

    public void insert(String key, Object value)
    {
        insertRec(key, value, m_root);
    }

    private DSATreeNode insertRec(String key, Object value, DSATreeNode currNode)
    {
        DSATreeNode updateNode = currNode;
        if (currNode == null)
        {
            updateNode = new DSATreeNode(key, value);
        } else if (key.equals(currNode.getKey()))
        {
            throw new IllegalStateException("Key " + key + " must be unique.");
        } else if (key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(insertRec(key, value, currNode.getLeft()));
        } else
        {
            currNode.setRight(insertRec(key, value, currNode.getRight()));
        }
        return updateNode;
    }

    public void delete(String key)
    {
        deleteRec(key, m_root);
    }

    private DSATreeNode deleteRec(String key, DSATreeNode currNode)
    {
        DSATreeNode updateNode = currNode;

        if (currNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not found.");
        } else if (key.equals(currNode.getKey()))
        {
            updateNode = deleteNode(currNode);
        } else if (key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(deleteRec(key, currNode.getLeft()));
        } else
        {
            currNode.setRight(deleteRec(key, currNode.getRight()));
        }

        return updateNode;
    }

    private DSATreeNode deleteNode(DSATreeNode delNode)
    {
        DSATreeNode updateNode;

        if (delNode.getLeft() == null && delNode.getRight() == null)
        {
            updateNode = null;
        } else if (delNode.getLeft() != null && delNode.getRight() == null)
        {
            updateNode = delNode.getLeft();
        } else if (delNode.getLeft() == null && delNode.getRight() != null)
        {
            updateNode = delNode.getRight();
        } else
        {
            updateNode = promoteSuccessor(delNode.getRight());
            if (updateNode != delNode.getRight())
            {
                updateNode.setRight(delNode.getRight());
            }
            updateNode.setLeft(delNode.getLeft());
        }

        return updateNode;
    }

    private DSATreeNode promoteSuccessor(DSATreeNode currNode)
    {
        DSATreeNode successor = currNode;

        if (currNode.getLeft() != null)
        {
            successor = promoteSuccessor(currNode.getLeft());
            if (successor == currNode.getLeft())
            {
                currNode.setLeft(successor.getRight());
            }
        }
        return successor;
    }

    public String min()
    {
        return minIter(m_root);
    }

    private String minIter(DSATreeNode currNode)
    {
        String minKey;
        while (currNode.getLeft() != null)
        {
            currNode = currNode.getLeft();
        }
        minKey = currNode.getKey();
        return minKey;
    }

    public String max()
    {
        return maxIter(m_root);
    }

    private String maxIter(DSATreeNode currNode)
    {
        String maxKey;
        while (currNode.getRight() != null)
        {
            currNode = currNode.getRight();
        }
        maxKey = currNode.getKey();
        return maxKey;
    }

    public int height()
    {

        return heightRec(m_root);
    }

    private int heightRec(DSATreeNode currNode)
    {
        int htSoFar, iLeftHt, iRightHt;

        if (currNode == null)
        {
            htSoFar = -1;
        } else
        {
            iLeftHt = heightRec(currNode.getLeft());
            iRightHt = heightRec(currNode.getRight());

            if (iLeftHt > iRightHt)
            {
                htSoFar = iLeftHt + 1;
            } else
            {
                htSoFar = iRightHt + 1;
            }

        }
        return htSoFar;
    }



}
