package HarcosEsVarazslo;

abstract class Jatekos  {

    protected int eletEro;
    protected int elhelyezkedes = -1;
    public Jatekos() {
        this.eletEro = Dobokocka.eletero();
    }

    public int getElhelyezkedes() {
        return elhelyezkedes;
    }

    public void setElhelyezkedes(int elhelyezkedes) {
        this.elhelyezkedes = elhelyezkedes;
    }

    public int getEletEro() {
        return eletEro;
    }

    public void setEletEro(int eletEro) {
        int ujEletEro = this.eletEro - eletEro;
        if(ujEletEro < 0){
            this.eletEro = 0;
        } else {
            this.eletEro = ujEletEro;
        }
    }


    public void tamad(Jatekos jatekos) {
        int utesEro = Dobokocka.dob();
        jatekos.setEletEro(utesEro);
        System.out.println("- A Harcos támad: " + utesEro + " > H:" + jatekos.getEletEro() + ", V:" + getEletEro());
    }
}
