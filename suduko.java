public class suduko{
    public static boolean issafe(int arr[][],int row,int col,int digit){
        // check for row 
        for(int i=0;i<9;i++){
            if(arr[i][col]==digit){      //row change col same//
                return false;
            }
        }
        // check for col
        for(int j=0;j<9;j++){
            if(arr[row][j]==digit){          //row same col change//
                return false;
            }
        }


        // also check for 3*3 grid
        int strow=(row/3)*3;
        int stcol=(col/3)*3;

        for(int i=strow;i<(strow+3);i++){ 
            for(int j=stcol;j<(stcol+3);j++){
                if(arr[i][j]==digit){
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean sudukosolver(int arr[][],int row,int col){
        // base case
        if(row==9){
            return true;
        }

        // recursion
        int nextRow=row,nextCol=col+1;

        // row change tb hoga jb col==9 hoga
        if(col+1==9){
        nextRow=row+1;
            nextCol=0;
        } 
        // cell is not equal to 0 then you perform below operation
        if(arr[row][col]!=0){
           return sudukosolver(arr,nextRow,nextCol);                                    
        }

        for(int digit=1;digit<=9;digit++){
        if(issafe(arr,row,col,digit)){
            arr[row][col]=digit;

            // recursion call    if ans exit suduko functio return true so we aslo return true
            if(sudukosolver(arr, nextRow, nextCol)){
                return true;
            }
            arr[row][col]=0; //*backtrack ke time ans exit nhi krga to
                                 //digit store nhi krenge aur 0 store kra denge*//
        }
    }
    return false;
    }

    public static void main(String[] args) {
        int arr[][]={{0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,0,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3},};

        if(sudukosolver(arr, 0, 0)){
            System.out.println("suduko exist");
            print(arr);
        }
        else{
            System.out.println("not exist");
        }
    }
    public  static void print(int arr[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}