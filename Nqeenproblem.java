public class Nqeenproblem{
    public static boolean issafe(char[][] arr,int row,int col){
		// up
		for(int i=row-1;i>=0;i--){
			if(arr[i][col]=='Q'){
				return false;
			}
		}

		// left up
		for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
			
				if(arr[i][j]=='Q'){
					return false;
				}
			}
		
		//right up
		for(int i=row-1,j=col+1;i>=0 && j<arr.length;i--,j++){
				if(arr[i][j]=='Q'){
					return false;
				}
			}
		
		return true;
		
	}
	public static void nqueen(char[][] arr,int i){
		if(i==arr.length){
			print(arr);
			return;
		}

		for(int j=0;j<arr.length;j++){

		if(issafe(arr, i, j)){
			arr[i][j]='Q';
			nqueen(arr, i+1);
			arr[i][j]='X';
		}
	}
} 
static void print(char[][] arr){
	int n=arr.length;
	System.out.println("-----------");
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			System.out.print(arr[i][j]);
		}
	System.out.println();
}

}
public static void main(String args[]){
	int n=4;
	char[][] arr=new char[n][n];
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			arr[i][j]='X';
		}
	
}
nqueen(arr, 0);
}
}