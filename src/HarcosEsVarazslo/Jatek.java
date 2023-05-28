package HarcosEsVarazslo;


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
        try{
            while(varazslo.getEletEro() > 0 && harcos.getEletEro() > 0){
                ////////////////////////////jatekosokLepnek();
                // lépnek a játékosok
                varazslo.setElhelyezkedes(Dobokocka.lepes());
                harcos.setElhelyezkedes(Dobokocka.lepes());

                // kiírjuk az állást
                System.out.println(getKorAllas());

                // ha ugyanott vannak akkor harcolnak
                if(varazslo.getElhelyezkedes() == harcos.getElhelyezkedes()){
                    varazslo.tamad(harcos);
                    harcos.tamad(varazslo);
                }


            }

            if(varazslo.getEletEro() == harcos.getEletEro()) {
                throw new DontetlenException("A játékosoknak egyszerre fogyott el az életerejük");
            }

            // Eredmény kiírása
            System.out.print("\nEREDMÉNYHIRDETÉS: ");
            System.out.println(eredmenyHirdetes()+"\n");

        } catch (DontetlenException e) {
            System.out.println("### Döntetlen! ### : " + e.getMessage());
        }




        System.out.println("### - VÉGE - ###");
    }

    public String eredmenyHirdetes(){
        String eredmeny = "!DÖNTETLEN!";
        if(varazslo.getEletEro() > harcos.getEletEro()) {
            eredmeny = "Győzött a VARÁZSLÓ";
        }
        if(harcos.getEletEro() > varazslo.getEletEro()) {
            eredmeny = "Győzött a HARCOS";
        }
       return eredmeny;
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




