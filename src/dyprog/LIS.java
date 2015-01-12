package dyprog;

public class LIS {

	public static void main(String args[]){
		int[]	 input = {1,2,3,0,4,6,11,7,12,2,3,1};
		System.out.println(findLIS(input));
	}

public static int findLIS(int[] seq){
    int[] L=new int[seq.length];
    L[0]=1;
    for(int i=1;i<L.length;i++){
      int maxn=0;
      for(int j=0;j<i;j++){
        if(seq[j]<seq[i]&&L[j]>maxn){
          maxn=L[j];
        }
      }
      L[i]=maxn+1;
    }
    int maxi=0;
    for(int i=0;i<L.length;i++){
      if(L[i]>maxi){
        maxi=L[i];
      }
    }
    return(maxi);
  }

}
