package com.example.myapplication.P;

import android.util.Log;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;

public class SetPivotName {
    String one="";
    Counter integer1=new Counter();
    int cunter =0;
    int pivote_counter=0;
    String1 string1;
    Counter  counter;

    public SetPivotName(String one, String1 string1,Counter counter) {
        this.one = one;
        this.string1 = string1;
        this.counter=counter;
    }





    public void set(){
        int w=one.length();
        w-=2;
        Log.e("0",""+w);
        one_item();
 findcountname(0,one.length());

    }
    public void setname(int i, int j) { //////////////////gh


        String sum = "";
        String h;
        String ft = "";
        for (int b = i; b <= j; b++) {
            sum += one.charAt(b);
        }

        ft =sum;
        counter.setChannel_count(counter.getChannel_count()+1);
        ////////////////////////////////////////////


        ////////////////////////////////////////////

        if (cunter==0){
            string1.pivote[0]=ft;
        }
        if (cunter==1){
            string1.pivote[1]=ft;
        }
        if (cunter==2){
            string1.pivote[2]=ft;
        } if (cunter==3){
            string1.pivote[3]=ft;
        } if (cunter==4){
            string1.pivote[4]=ft;
        } if (cunter==5){
            string1.pivote[5]=ft;
        } if (cunter==6){
            string1.pivote[6]=ft;
        } if (cunter==7){
            string1.pivote[7]=ft;
        } if (cunter==8){
            string1.pivote[8]=ft;
        } if (cunter==9){
            string1.pivote[9]=ft;
        } if (cunter==10){
            string1.pivote[10]=ft;
        } if (cunter==11){
            string1.pivote[11]=ft;
        } if (cunter==12){
            string1.pivote[12]=ft;
        } if (cunter==13){
            string1.pivote[13]=ft;
        } if (cunter==14){
            string1.pivote[14]=ft;
        } if (cunter==15){
            string1.pivote[15]=ft;
        } if (cunter==16){
            string1.pivote[16]=ft;
        } if (cunter==17){
            string1.pivote[17]=ft;
        } if (cunter==18){
            string1.pivote[18]=ft;
        } if (cunter==19){
            string1.pivote[19]=ft;
        } if (cunter==20){
            string1.pivote[20]=ft;
        } if (cunter==21){
            string1.pivote[21]=ft;
        } if (cunter==22){
            string1.pivote[22]=ft;
        } if (cunter==23){
            string1.pivote[23]=ft;
        } if (cunter==24){
            string1.pivote[24]=ft;
        } if (cunter==25){
            string1.pivote[25]=ft;
        } if (cunter==26){
            string1.pivote[26]=ft;
        } if (cunter==27){
            string1.pivote[27]=ft;
        } if (cunter==28){
            string1.pivote[28]=ft;
        } if (cunter==29){
            string1.pivote[29]=ft;
        } if (cunter==30){
            string1.pivote[30]=ft;
        } if (cunter==31){
            string1.pivote[31]=ft;
        } if (cunter==32){
            string1.pivote[32]=ft;
        } if (cunter==33){
            string1.pivote[33]=ft;
        } if (cunter==34){
            string1.pivote[34]=ft;
        } if (cunter==35){
            string1.pivote[35]=ft;
        } if (cunter==36){
            string1.pivote[36]=ft;
        } if (cunter==37){
            string1.pivote[37]=ft;
        } if (cunter==38){
            string1.pivote[38]=ft;
        } if (cunter==39){
            string1.pivote[39]=ft;
        } if (cunter==40){
            string1.pivote[40]=ft;
        } if (cunter==41){
            string1.pivote[41]=ft;
        } if (cunter==42){
            string1.pivote[42]=ft;
        } if (cunter==43){
            string1.pivote[43]=ft;
        } if (cunter==44){
            string1.pivote[44]=ft;
        } if (cunter==45){
            string1.pivote[45]=ft;
        } if (cunter==46){
            string1.pivote[46]=ft;
        } if (cunter==47){
            string1.pivote[47]=ft;
        } if (cunter==48){
            string1.pivote[48]=ft;
        } if (cunter==49){
            string1.pivote[49]=ft;
        }if (cunter==50){
            string1.pivote[50]=ft;
        }if (cunter==51){
            string1.pivote[51]=ft;
        }if (cunter==52){
            string1.pivote[52]=ft;
        }if (cunter==53){
            string1.pivote[53]=ft;
        }if (cunter==54){
            string1.pivote[54]=ft;
        }if (cunter==55){
            string1.pivote[55]=ft;
        }if (cunter==56){
            string1.pivote[56]=ft;
        }if (cunter==57){
            string1.pivote[57]=ft;
        }if (cunter==58){
            string1.pivote[58]=ft;
        }if (cunter==59){
            string1.pivote[59]=ft;
        }if (cunter==60){
            string1.pivote[60]=ft;
        }if (cunter==61){
            string1.pivote[61]=ft;
        }if (cunter==62){
            string1.pivote[62]=ft;
        }if (cunter==63){
            string1.pivote[63]=ft;
        }
  cunter++;

    }
    public void findcountname(int i,int j){ ////////////////////////sd
        for(int b=6;b<=j-1;b++){
            if(one.charAt(b)==' '){
                for(int y=b-1;y>b-6;y--){
                    if(one.charAt(y)==' '){

                        setname(y+1,b-1);
                        y=-1;

                        break;

                    }
                }
            }

        }
    }
    public void one_item() {
        String h="";
        int s=0;
        //Log.e("fffffffffffff","5555");

        for(s=0;s<6;s++){
            if(one.charAt(s)!=' '){
                h+=one.charAt(s);

            }
            else {break;}
        }
        setname(0,s-1);
    }

}
