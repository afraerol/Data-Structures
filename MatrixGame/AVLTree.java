package MatrixGame;

public class AVLTree<Item> {

    AVLNode<Item> root;

    public AVLTree() {
        root = null;
    }

    public int height(AVLNode<Item> d) {
        if (d == null) {
            return 0;
        } else {
            return d.height;
        }
    }

    int getBalance(AVLNode<Item> focus) {
        if (focus == null) {
            return 0;
        }
        return height(focus.left) - height(focus.right);
    }

     void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(AVLNode node){
    
    if (node != null) {
        inOrder(node.left);
        System.out.print(node.key + " ");	
	inOrder(node.right);
		}
	}


void postOrder(AVLNode node){
    
    if (node != null) {
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");	
	
		}
	
   
} 
     
    public int Ceil(AVLNode node, int input) {
        if (node == null) {
            return -1;
        }
        if (node.key == input) {
            return node.key;
        }
        if (node.key < input) {
            return Ceil(node.right, input);
        }
        int ceil = Ceil(node.left, input);
        if (ceil != -1) {
            return ceil;
        } else {
            return node.key;
        }

    }

    public int floor(AVLNode root, int key) {
        if (root == null) {
            return -1;
        }
        if (root.key == key) {
            return root.key;
        }
        if(root.key > key){
        return floor(root.left,key);
        }
        int floorValue = floor(root.right, key);
        if (floorValue != -1) {
            return floorValue;
        } else {
            return root.key;
        }
    }

    public AVLNode<Item> rotateMyLeft(AVLNode focus) {
        AVLNode<Item> k = focus.left;
        focus.left = k.right;
        k.right = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    public AVLNode<Item> rotateMyRight(AVLNode focus) {
        AVLNode<Item> k = focus.right;
        focus.right = k.left;
        k.left = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    public AVLNode<Item> doubleRotateLeftSide(AVLNode focus) {
        focus.left = rotateMyRight(focus.left);
        return rotateMyLeft(focus);
    }

    public AVLNode<Item> doubleRotateRightSide(AVLNode focus) {
        focus.right = rotateMyLeft(focus.right);
        return rotateMyRight(focus);
    }

    public AVLNode<Item> insert(AVLNode focus, Item data, int key) {
        if (focus == null) {
            focus = new AVLNode(data, key);    
        } 
        // Left hand side
        else if (key < focus.key) {
            focus.left = insert(focus.left, data, key);
            if (getBalance(focus) == 2) {
                if (key < focus.left.key) {
                    focus = rotateMyLeft(focus);
                } else {
                    focus = doubleRotateLeftSide(focus);
                }
            }
        }
        // Right hand side
        else if (key > focus.key) {
            focus.right = insert(focus.right, data, key);
            if (getBalance(focus) == 2) {
                if (key > focus.right.key) {
                    focus = rotateMyRight(focus);
                } else {
                    focus = doubleRotateRightSide(focus);
                }
            }
        }
        // Means key is equal no need to add
        else {
            // key is equal to focus.key, update data
            focus.data = data;
        }
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        return focus;
    }

    public void insert(Item data, int key) {
        root = insert(root, data, key);
    }


}

