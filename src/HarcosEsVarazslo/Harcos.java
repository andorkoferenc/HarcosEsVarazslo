package HarcosEsVarazslo;

class Harcos extends Jatekos {
    public Harcos(){
        super();
    }

    @Override
    public void tamad(Jatekos jatekos) {
        int utesEro = Dobokocka.dob();
        jatekos.setEletEro(utesEro);
        System.out.println("- A Harcos támad! ütése = " + utesEro + " > H:" + getEletEro() + ", V:" + jatekos.getEletEro());
    }
}


