import java.math.BigInteger; 
import java.util.Scanner; 
public class Aes_FirstRound 
{
private static final String[] S={
   "63",	"7c",	"77",	"7b",	"f2",	"6b",	"6f",	"c5",	"30",	"01",	"67",	"2b",	"fe",	"d7",	"ab",	"76",
	"ca",	"82",	"c9",	"7d",	"fa",	"59",	"47",	"f0",	"ad",	"d4",	"a2",	"af",	"9c",	"a4",	"72",	"c0",
	"b7",	"fd",	"93",	"26",	"36",	"3f",	"f7",	"cc",	"34",	"a5",	"e5",	"f1",	"71",	"d8",	"31",	"15",
	"04",	"c7",	"23",	"c3",	"18",	"96",	"05",	"9a",	"07", "12",	"80",	"e2",	"eb",	"27",	"b2",	"75",
	"09",	"83",	"2c",	"1a",	"1b",	"6e",	"5a",	"a0",	"52",	"3b",	"d6",	"b3",	"29",	"e3",	"2f",	"84",
	"53",	"d1",	"00",	"ed",	"20",	"fc",	"b1",	"5b",	"6a",	"cb",	"be",	"39",	"4a",	"4c",	"58",	"cf",
	"d0",	"ef",	"aa",	"fb",	"43",	"4d",	"33",	"85",	"45",	"f9",	"02",	"7f",	"50",	"3c",	"9f",	"a8",
	"51",	"a3",	"40",	"8f",	"92",	"9d",	"38",	"f5",	"bc",	"b6",	"da",	"21",	"10",	"ff",	"f3",	"d2",
	"cd",	"0c",	"13",	"ec",	"5f",	"97",	"44",	"17",	"c4",	"a7",	"7e",	"3d",	"64",	"5d",	"19",	"73",
	"60",	"81",	"4f",	"dc",	"22",	"2a",	"90",	"88",	"46",	"ee",	"b8",	"14",	"de",	"5e",	"0b",	"db",
	"e0",	"32",	"3a",	"0a",	"49",	"06",	"24",	"5c",	"c2",	"d3",	"ac",	"62",	"91",	"95",	"e4",	"79",
	"e7",	"c8",	"37",	"6d",	"8d",	"d5",	"4e",	"a9",	"6c",	"56",	"f4",	"ea",	"65",	"7a",	"ae",	"08",
	"ba",	"78",	"25",	"2e",	"1c",	"a6",	"b4",	"c6",	"e8",	"dd",	"74",	"1f",	"4b",	"bd",	"8b",	"8a",
	"70",	"3e", "b5",	"66",	"48",	"03",	"f6",	"0e",	"61",	"35",	"57",	"b9",	"86",	"c1",	"1d",	"9e",
	"e1",	"f8", "98",	"11",	"69",	"d9",	"8e",	"94",	"9b",	"1e",	"87",	"e9",	"ce",	"55",	"28",	"df",
	"8c",	"a1",	"89",	"0d",	"bf",	"e6",	"42",	"68",	"41",	"99", "2d",	"0f",	"b0",	"54",	"bb",	"16"
	};



private static String Sbox(String b) {
String s1="";
String s="";
String bits[]=new String[b.length()/2];
bits[0]=""+b.charAt(0)+b.charAt(1);
for (int i=1; i<b.length()/2;i=i+1)
{bits[i]=""+b.charAt(2*i)+b.charAt(2*i+1);
}

		String output[] = new String[16];
		for(int i=0 ; i < b.length()/2 ; i++) {
		
		
        s1= bits[i];
          String hex = s1.charAt(0)+"";
          String hex1 = s1.charAt(1)+"";
  int iRow = Integer.parseInt(hex, 16); 
  int iColumn = Integer.parseInt(hex1, 16); 

        
			output[i] = S[(iRow*16) + iColumn];
       	
			
         s=s+output[i];} 
         return s;}
         
         


   private static String leftShift(String b) {
		// Left shifting takes place here, i.e. each bit is rotated to the left
		// and the leftmost bit is stored at the rightmost bit. This is a left
		// shift operation.
      String s1="";
      String s="";
      
   String st1="";
   String st2="";
   String st3="";
   String st4="";
      String bits[]=new String[b.length()/2];
bits[0]=""+b.charAt(0)+b.charAt(1);
for (int i=1; i<b.length()/2;i=i+1)
{bits[i]=""+b.charAt(2*i)+b.charAt(2*i+1);}

 String r1[] = new String[4];
   String r2[] = new String[4];
   String r3[] = new String[4];
   String r4[] = new String[4];
  for (int i=0; i<4; i++)
  {r1[i]=bits[i];  
  r2[i]=bits[i+4]; 
  r3[i]=bits[i+8]; 
  r4[i]=bits[i+12];}

		String answer[] = new String[b.length()/2];
		System.arraycopy(bits, 0, answer, 0, bits.length);
		for(int i=0 ; i < 1 ; i++) {
			String temp = r2[0];
			for(int j=0 ; j < r2.length-1 ; j++) {
				r2[j] = r2[j+1];
			}
			r2[r2.length-1] = temp;
		}
      
      	for(int i=0 ; i < 2 ; i++) {
			String temp = r3[0];
			for(int j=0 ; j < r2.length-1 ; j++) {
				r3[j] = r3[j+1];
			}
			r3[r3.length-1] = temp;
		}
      	for(int i=0 ; i < 3 ; i++) {
			String temp = r4[0];
			for(int j=0 ; j < r2.length-1 ; j++) {
				r4[j] = r4[j+1];
			}
			r4[r4.length-1] = temp;
		}
      for (int i=0; i<4; i++){  
      String str =""+ r1[i];
      String str1=""+r2[i];
      String str2=""+r3[i];
      String str3=""+r4[i];
      st1=st1+str;
      st2=st2+str1;
      st3=st3+str2;
      st4=st4+str3;
      }
      s=s+st1+st2+st3+st4;

return s;}
         
 public static String zhvendos1(String a)
   {String s="";
    char[] vr= new char[a.length()];;
   for (int i=0; i<vr.length; i++)
   {vr[i]=a.charAt(i);}
      //boolean [] vr=new boolean[a.length];
      for (int i=0; i<vr.length-1; i++)
         {vr[i]=vr[i+1]; s=s+vr[i];
         } 
     vr[7]='0';
      String str = s+vr[7];

return str;
   } 
   
    
   private static String xor(String a1, String b1) {
		// Simple xor function on two int arrays
		String answer="";
       int ans[] = new int[a1.length()];
       int a[] = new int[a1.length()];
       int b[] = new int[b1.length()];
      for(int i=0 ; i < a1.length() ; i++) {
      if(a1.charAt(i)=='1') a[i]=1;
      if(b1.charAt(i)=='1') b[i]=1;
      }
		for(int i=0 ; i < a1.length() ; i++) {
			ans[i] = a[i]^b[i];
 
         answer=answer+ans[i];
		}
		return answer;
	}      
    
private static String mult(String a, String b)
{
String ans="";
String k="00011011";
String answer="";
String rez="";
String s1="";
String s2="";

if(a=="02")
{String a1=""+b.charAt(0);
String b1=""+b.charAt(1);
s1 = Integer.toBinaryString(Integer.parseInt(a1, 16)); 
s2 = Integer.toBinaryString(Integer.parseInt(b1, 16));
while(s1.length()<4){s1="0"+s1;} 
while(s2.length()<4){s2="0"+s2;} 
ans=s1+s2;
String c=ans;
ans=zhvendos1(ans);
if(c.charAt(0)=='1') ans=xor(ans,k);
rez=ans;

}

if(a=="03"){
String a1=""+b.charAt(0);
String b1=""+b.charAt(1);
s1 = Integer.toBinaryString(Integer.parseInt(a1, 16)); 
s2 = Integer.toBinaryString(Integer.parseInt(b1, 16));
while(s1.length()<4){s1="0"+s1;} 
while(s2.length()<4){s2="0"+s2;} 
ans=s1+s2;
String c=ans;
ans=zhvendos1(ans);
if(c.charAt(0)=='1') ans=xor(ans,k);



rez=xor(ans,c);
}
if(a=="01")
{String a1=""+b.charAt(0);
String b1=""+b.charAt(1);
s1 = Integer.toBinaryString(Integer.parseInt(a1, 16)); 
s2 = Integer.toBinaryString(Integer.parseInt(b1, 16));
while(s1.length()<4){s1="0"+s1;} 
while(s2.length()<4){s2="0"+s2;} 
ans=s1+s2;
rez=ans;}
return rez;

}

 
public static String mix(String b)
{String rez="";
String s="";
String s1="";
String s3="";
String s4="";
String s5="";
String s2="02030101010203010101020303010102";
String b1[]=new String[4];
   String col[]=new String[s2.length()/2];
col[0]=""+s2.charAt(0)+s2.charAt(1);
for (int i=1; i<s2.length()/2;i=i+1)
{col[i]=""+s2.charAt(2*i)+s2.charAt(2*i+1);}

 String bits1[]=new String[b.length()/2];
bits1[0]=""+b.charAt(0)+b.charAt(1);
for (int i=1; i<b.length()/2;i=i+1)
{bits1[i]=""+b.charAt(2*i)+b.charAt(2*i+1);}

String d1="";
String d2="";
String d3="";
String d4="";
for(int i=0; i<4;i++)
{d1=mult("02",bits1[0+i]);
d2=mult("03",bits1[4+i]);
d3=mult("01",bits1[8+i]);
d4=mult("01",bits1[12+i]);


String e1=xor(d1,d2);
String e2=xor(d3,d4);
rez=xor(e1,e2);
int decimal = Integer.parseInt(rez.substring(0,4),2);
int decimal1 = Integer.parseInt(rez.substring(4,8),2);
String hexStr = Integer.toString(decimal,16);
String hexStr1 = Integer.toString(decimal1,16);
s=hexStr+hexStr1;
s1=s1+s;
}
for(int i=0; i<4;i++)
{d1=mult("01",bits1[0+i]);
d2=mult("02",bits1[4+i]);
d3=mult("03",bits1[8+i]);
d4=mult("01",bits1[12+i]);


String e1=xor(d1,d2);
String e2=xor(d3,d4);
rez=xor(e1,e2);
int decimal = Integer.parseInt(rez.substring(0,4),2);
int decimal1 = Integer.parseInt(rez.substring(4,8),2);
String hexStr = Integer.toString(decimal,16);
String hexStr1 = Integer.toString(decimal1,16);
s=hexStr+hexStr1;
s3=s3+s;
}
for(int i=0; i<4;i++)
{d1=mult("01",bits1[0+i]);
d2=mult("01",bits1[4+i]);
d3=mult("02",bits1[8+i]);
d4=mult("03",bits1[12+i]);
String e1=xor(d1,d2);
String e2=xor(d3,d4);
rez=xor(e1,e2);
int decimal = Integer.parseInt(rez.substring(0,4),2);
int decimal1 = Integer.parseInt(rez.substring(4,8),2);
String hexStr = Integer.toString(decimal,16);
String hexStr1 = Integer.toString(decimal1,16);
s=hexStr+hexStr1;
s4=s4+s;
}
for(int i=0; i<4;i++)
{d1=mult("03",bits1[0+i]);
d2=mult("01",bits1[4+i]);
d3=mult("01",bits1[8+i]);
d4=mult("02",bits1[12+i]);


String e1=xor(d1,d2);
String e2=xor(d3,d4);
rez=xor(e1,e2);
int decimal = Integer.parseInt(rez.substring(0,4),2);
int decimal1 = Integer.parseInt(rez.substring(4,8),2);
String hexStr = Integer.toString(decimal,16);
String hexStr1 = Integer.toString(decimal1,16);
s=hexStr+hexStr1;
s5=s5+s;
}
return s1+s3+s4+s5;
}

public static String hexToBin(String s) {
  return new BigInteger(s, 16).toString(2);
}
public static String key(String b)
{
String s="";
String rez="";
String s2="";
String s3="";
String x1="";
String x2="";
String s4="";
String s_4="";
String s5="";
String s_5="";
String s6="";
String s_6="";
String r2[] = new String[4];
 String bits1[]=new String[b.length()/2];
bits1[0]=""+b.charAt(0)+b.charAt(1);
for (int i=1; i<b.length()/2;i=i+1)
{bits1[i]=""+b.charAt(2*i)+b.charAt(2*i+1);}
for (int i=0; i<4;i=i+1)
{
s=bits1[4*i+3];
r2[i]=bits1[4*i+3];
s2=bits1[4*i];
s3=s3+s2;
s_4=bits1[4*i+1];
s_5=bits1[4*i+2];
s4=s4+s_4;
s5=s5+s_5;
s6=s6+s;}

for(int i=0 ; i < 1 ; i++) {
			String temp = r2[0];
			for(int j=0 ; j < r2.length-1 ; j++) {
				r2[j] = r2[j+1];
			}
			r2[r2.length-1] = temp;
		}
      String str="";
for (int i=0; i<4; i++){  
       String st =""+ r2[i];
       str=str+st;
      }  
String box= Sbox(str);
String Rcon="01000000";
String v="";
String v1="";
String bin1 = Integer.toBinaryString(Integer.parseInt(s3, 16)); 
String bin2 = hexToBin(box);
String bin3 = Integer.toBinaryString(Integer.parseInt(Rcon,16));
String bin4=hexToBin(s4);
String bin5=hexToBin(s5);
String bin6=hexToBin(s6);
while(bin1.length()<32){bin1="0"+bin1;} 
while(bin2.length()<32){bin2="0"+bin2;}
while(bin3.length()<32){bin3="0"+bin3;}
while(bin4.length()<32){bin4="0"+bin4;}
while(bin5.length()<32){bin5="0"+bin5;}
while(bin6.length()<32){bin6="0"+bin6;}
x1=xor(bin1,bin2);
x2=xor(x1,bin3);
String h1 = new BigInteger(x2, 2).toString(16);
String c2=xor(x2,bin4);
String h2=new BigInteger(c2, 2).toString(16);
String c3=xor(bin5,c2);
String h3=new BigInteger(c3, 2).toString(16);
String c4=xor(bin6,c3);
String h4=new BigInteger(c4, 2).toString(16);   
for(int i=0; i<8;i=i+2)
{
v=""+h1.charAt(i)+h1.charAt(i+1)+h2.charAt(i)+h2.charAt(i+1)+h3.charAt(i)+h3.charAt(i+1)+h4.charAt(i)+h4.charAt(i+1);
v1=v1+v;
}
 return v1;
}



public static String Addkey(String b, String a)
{String s="";
String s2="";
String s3="";
String s4="";
String s_4="";
String s5="";
String s_5="";
String s6="";
String s_6="";

String c2="";
String c3="";
String c4="";
String c_4="";
String c5="";
String c_5="";
String c6="";
String c_6="";
String r1[] = new String[4];
String r2[] = new String[4];

 String bits[]=new String[a.length()/2];
bits[0]=""+a.charAt(0)+a.charAt(1);
for (int i=1; i<a.length()/2;i=i+1)
{bits[i]=""+a.charAt(2*i)+a.charAt(2*i+1);}

 String bits1[]=new String[b.length()/2];
bits1[0]=""+b.charAt(0)+b.charAt(1);
for (int i=1; i<b.length()/2;i=i+1)
{bits1[i]=""+b.charAt(2*i)+b.charAt(2*i+1);}

String h1="";
String h2="";
String h3="";
String h4="";
String v="";
String v1="";
String c="";
for (int i=0; i<4;i=i+1)
{
c=bits[4*i+3];
r1[i]=bits[4*i+3];
c2=bits[4*i];
c3=c3+c2;
c_4=bits[4*i+1];
c_5=bits[4*i+2];
c4=c4+c_4;
c5=c5+c_5;
c6=c6+c;}

String bin_1=hexToBin(c3); 
String bin_4=hexToBin(c4);
String bin_5=hexToBin(c5);
String bin_6=hexToBin(c6);
while(bin_1.length()<32){bin_1="0"+bin_1;} 
while(bin_4.length()<32){bin_4="0"+bin_4;}
while(bin_5.length()<32){bin_5="0"+bin_5;}
while(bin_6.length()<32){bin_6="0"+bin_6;}

for (int i=0; i<4;i=i+1)
{
s=bits1[4*i+3];
r2[i]=bits1[4*i+3];
s2=bits1[4*i];
s3=s3+s2;
s_4=bits1[4*i+1];
s_5=bits1[4*i+2];
s4=s4+s_4;
s5=s5+s_5;
s6=s6+s;}

String bin1 = hexToBin(s3); 
String bin4=hexToBin(s4);
String bin5=hexToBin(s5);
String bin6=hexToBin(s6);
while(bin1.length()<32){bin1="0"+bin1;} 
while(bin4.length()<32){bin4="0"+bin4;}
while(bin5.length()<32){bin5="0"+bin5;}
while(bin6.length()<32){bin6="0"+bin6;}

h1=xor(bin1,bin_1);
h2=xor(bin4,bin_4);
h3=xor(bin5,bin_5);
h4=xor(bin6,bin_6);

String h_1=new BigInteger(h1, 2).toString(16);
String h_2=new BigInteger(h2, 2).toString(16);
String h_3=new BigInteger(h3, 2).toString(16);
String h_4=new BigInteger(h4, 2).toString(16);
while(h_4.length()<8){h_4="0"+h_4;}
while(h_3.length()<8){h_3="0"+h_3;}
while(h_2.length()<8){h_2="0"+h_2;}
while(h_1.length()<8){h_1="0"+h_1;}

for(int i=0; i<8;i=i+2)
{
v=""+h_1.charAt(i)+h_1.charAt(i+1)+h_2.charAt(i)+h_2.charAt(i+1)+h_3.charAt(i)+h_3.charAt(i+1)+h_4.charAt(i)+h_4.charAt(i+1);
v1=v1+v;
}

return v1;}
         
         
public static void main(String[] args)
{
String s="000102030405060708090A0B0C0D0E0F";
String key="01010101010101010101010101010101";
System.out.println("Mesazhi    :"+s);
System.out.println("Celesi     :"+key);
String sbox=Sbox(s);
System.out.println("SubByte    :"+Sbox(s));
String l=leftShift(sbox);
System.out.println("ShiftByte  :"+l);
String hex="2f";
String binAddr = Integer.toBinaryString(Integer.parseInt(hex, 16)); 
String mix=mix(l);

System.out.println("MicColumn  :"+mix);
String k=key(key);
System.out.println("RoundKey   :"+k);
String add=Addkey(mix,k);
System.out.println("AddRoundKey:"+add);
System.out.println("AddRoundKey:"+mult("01","53"));
String c1=mult("02","d3");
String c2=mult("03","ff");
String c3=mult("01","02");
String c4=mult("01","53");
String c5=xor(c1,c2);
String c6=xor(c3,c4);
String c7=xor(c5,c6);
String h_1=new BigInteger(c7, 2).toString(16);
System.out.println(h_1);
}}