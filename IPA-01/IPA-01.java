import java.util.*;
class Footwear{
  private int footwearId;
private String footwearName;
private String footwearType;
private int price;
    public Footwear(int footwearId,String footwearName,String footwearType,int price){
        this.footwearId=footwearId;
        this.footwearName=footwearName;
        this.footwearType=footwearType;
        this.price=price;
    }
    //getters
    public int getId(){
        return footwearId;
    }
    public String getName(){
        return footwearName;
    }
    public String getType(){
        return footwearType;
    }
    public int getPrice(){
        return price;
    }
    //setters
    public void setId(int footwearId){
        this.footwearId=footwearId;
    }
    public void setName(String footwearName){
        this.footwearName=footwearName;
    }
     public void setType(String footwearType){
        this.footwearType=footwearType;
    }
     public void setPrice(int price){
     this.price=price;   
    }
}
class Solution{
    public static int getCountByType(Footwear[] footwear,String type){
        int cnt=0;
        for(int i=0;i<footwear.length;i++){
            if(footwear[i].getType().equalsIgnoreCase(type)){
                cnt++;
            }
        }
        return cnt;
    }
    public static Footwear getSecondHighestPriceByBrand(Footwear[]footwear, String type){
        Footwear [] obj =new Footwear[0];
        for(int i=0;i<footwear.length;i++){
            if(footwear[i].getName().equalsIgnoreCase(type)){
                obj = Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=footwear[i];
            }
        }
        int large=0,seclarge=0;
        for(int i=0;i<obj.length;i++){
            if(obj[i].getPrice()>large){
                seclarge=large;
                large=obj[i].getPrice();
            }
            else if(obj[i].getPrice()>seclarge && obj[i].getPrice()< large){
                seclarge=obj[i].getPrice();
            }
        }
        for(int i=0;i<obj.length;i++){
            if(obj[i].getPrice()==seclarge) return obj[i];
        }
        return null;
        
    }
    
}
public class Main
{
	public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
	    int n= sc.nextInt();
	    Footwear [] footwear=new Footwear[n];
	    for(int i=0;i<n;i++){
	        int a=sc.nextInt();
	        sc.nextLine();
	        String b= sc.nextLine();
	        String c= sc.nextLine();
	        int d=sc.nextInt();
	        footwear[i]=new Footwear(a,b,c,d);
	    }
	    sc.nextLine();
	    String type=sc.nextLine();
	    int ans1=Solution.getCountByType(footwear,type);
	    if(ans1>0){
	        System.out.println(ans1);
	    }
	    else System.out.println("Footwear not available");
	    String name=sc.nextLine();
	    Footwear ans2=Solution.getSecondHighestPriceByBrand(footwear,name);
	    if(ans2==null) System.out.println("Brand not available");
	    else {
	        System.out.println(ans2.getId());
System.out.println(ans2.getName());
System.out.println(ans2.getPrice());
	    }
	
	}
}