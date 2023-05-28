package HarcosEsVarazslo;

import java.util.Random;

public class Jatek {

    //public Random random;
    protected Jatekos varazslo;
    protected Jatekos harcos;

    public Jatek(){
        //random = new Random();
        varazslo = new Varazslo();
        harcos = new Harcos();
    }

    public void start() {
        System.out.println("### - INDULJON A JÁTÉK - ###");
        while(varazslo.getEletEro() > 0 && harcos.getEletEro() > 0){
            ////////////////////////////jatekosokLepnek();
            // lépnek a játékosok
            varazslo.setElhelyezkedes(Dobokocka.lepes());
            harcos.setElhelyezkedes(Dobokocka.lepes());

            // kiírjuk az állást
            System.out.println(getKorAllas());

            // ha ugyanott vannak akkor harcolnak
            if(varazslo.getElhelyezkedes() == harcos.getElhelyezkedes()){
                //System.out.println(getKorAllas());
                varazslo.tamad(harcos);
                harcos.tamad(varazslo);
            } else {
                //System.out.println(getKorAllas());
            }


        }

        eredmenyHirdetes();

        System.out.println("### - VÉGE - ###");
    }

    public void eredmenyHirdetes(){
        String eredmeny = "!DÖNTETLEN!";
        if(varazslo.getEletEro() > harcos.getEletEro()) {
            eredmeny = "Gyöztes: VARÁZSLÓ";
        }
        if(harcos.getEletEro() > varazslo.getEletEro()) {
            eredmeny = "Gyöztes: HARCOS";
        }
        System.out.println(eredmeny);
    }




    public String getKorAllas() {
        String eredmeny = "";

        if(harcos.getElhelyezkedes() == 0) {
            if(varazslo.getElhelyezkedes() == 0){
                eredmeny = "X__ --> harc ";
            }
            if(varazslo.getElhelyezkedes() == 1){
                eredmeny = "HV_ --> ";
            }
            if(varazslo.getElhelyezkedes() == 2){
                eredmeny = "H_V --> ";
            }
        }

        if(harcos.getElhelyezkedes() == 1) {
            if(varazslo.getElhelyezkedes() == 0){
                eredmeny = "VH_ --> ";
            }
            if(varazslo.getElhelyezkedes() == 1){
                eredmeny = "_X_ --> hrac: ";
            }
            if(varazslo.getElhelyezkedes() == 2){
                eredmeny = "_HV --> ";
            }
        }

        if(harcos.getElhelyezkedes() == 2) {
            if(varazslo.getElhelyezkedes() == 0){
                eredmeny = "V_H --> ";
            }
            if(varazslo.getElhelyezkedes() == 1){
                eredmeny = "_VH --> ";
            }
            if(varazslo.getElhelyezkedes() == 2){
                eredmeny = "__X --> harc: ";
            }
        }

        return eredmeny + "H:" + harcos.getEletEro() + ", V:" + varazslo.getEletEro();
    }

}

class Varazslo extends Jatekos {
    public Varazslo(){
        super();
    }

    public void tamad(Jatekos jatekos) {
        int utesEro = Dobokocka.dob();
        jatekos.setEletEro(utesEro);
        System.out.println("- A Varázsló támad: " + utesEro + " > H:" + jatekos.getEletEro() + ", V:" + getEletEro());
    }
}

class Harcos extends Jatekos {
    public Harcos(){
        super();
    }

    public void tamad(Jatekos jatekos) {
        int utesEro = Dobokocka.dob();
        jatekos.setEletEro(utesEro);
        System.out.println("- A Harcos támad: " + utesEro + " > H:" + jatekos.getEletEro() + ", V:" + getEletEro());
    }
}

