class HighArray{
   private long[] a;                 
   private int nElems;               
 
   public HighArray(int max){
      a = new long[max];                
      nElems = 0;                      
      }
   
   public int find(long searchKey){                              
      int j;
      for(j=0; j<nElems; j++)           
         if(a[j] == searchKey)          
            break;                     
      if(j == nElems)                  
         return -1;                   
      else
         return j;                  
      }  
  
   public void insert(long value){
      a[nElems] = value;            
      nElems++;                     
      }
  
   public boolean delete(long value){
     if(find(value) == -1){
         return false;
     }
      else{
         int j = find(value);
         for(int k=j; k<nElems -1; k++) {
            a[k] = a[k+1];
         }
         nElems--;                  
         return true;
         }
      }  
  
   public void display(){
      for(int j=0; j<nElems; j++)       
         System.out.print(a[j] + " ");  
      System.out.println("");
      }
   
   public long getMax(){
     long max = a[0];
        for(int i = 1; i < nElems; i++){
            if(a[i] > max) {
                max = a[i];
            }
          if(max == 0) {
                max = -1;
        }
        }
            return max;
   }
   
   public long removeMax(){
       long max = getMax();
       delete(max);
       return max;
   }
   
   public int numItems(){
      int counter = 0;
        for (int i = 0; i < a.length; i ++){
                if (a[i] != 0)  counter++;
        }
        return counter;
   }
        
////////////////////////////////////////////////////////////////

   public static void main(String[] args){
      int maxSize = 100;           
      HighArray arr;    
      arr = new HighArray(maxSize); 

      arr.insert(77);             
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();               

      long searchKey = 35;          
      if( arr.find(searchKey) != -1 )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);
      
      long x = 00;
      long y = 55;
      long z = 15;
      System.out.println("Deleting " + x +", " + y +", " + z );
      arr.delete(x);              
      arr.delete(y);
      arr.delete(z);

      arr.display();                
      System.out.println("");
      System.out.println("getMax() returned " + arr.getMax());
      System.out.println("");
      
      arr.removeMax();
      System.out.println("After calling removeMax()" );
      arr.display();
      System.out.println("");
      System.out.println("Sorting using removeMax()" );
     
      
      HighArray sortedArray = new HighArray(maxSize);
     long max = arr.removeMax();
      for(int i=3; i < arr.numItems(); i++){
             
             if( max != -1)
             sortedArray.insert(max);
             max = arr.removeMax();
             
             }
      
               sortedArray.display();
         
      
      
      
      }  
   }  
