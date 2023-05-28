package HarcosEsVarazslo;

class Varazslo extends Jatekos {
    public Varazslo(){
        super();
    }

    @Override
    public void tamad(Jatekos jatekos) {
        int utesEro = Dobokocka.dob();
        jatekos.setEletEro(utesEro);
        System.out.println("- A Varázsló támad! ütése = " + utesEro + " > H:" + jatekos.getEletEro() + ", V:" + getEletEro());
    }
}