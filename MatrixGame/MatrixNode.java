package MatrixGame;

public class MatrixNode <E> {  
 	 	
    E signal;  	 	
    MatrixNode E; 
    MatrixNode W; 
    MatrixNode N;            
    MatrixNode S; 
       
    int columnindex = 0;
    int rowindex = 0;
    int arrived = 0;
               
    //  int index = 0;
    public MatrixNode(E signal) { 
         	 	
        this.signal = signal;          
        E = W = N = S = null; 
               
}

}
