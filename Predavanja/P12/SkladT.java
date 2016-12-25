public class SkladT implements Sklad {
    private Object[] tabela;
    private int vrh = -1; // ko je sklad prazen je indeks vrha -1

    public SkladT(int kapaciteta) {
    	this.tabela = new Object[kapaciteta];
    }

    @Override
    public void dodaj(Object obj) {
    	if (this.vrh == this.tabela.length - 1) {
    		System.out.println("Sklad je poln");
    		System.exit(0);
    	}
    	this.vrh++;
    	this.tabela[this.vrh] = obj;
    }

    public Object odvzemi() {
    	if (this.vrh == -1) {
    		System.out.println("Sklad je prazen");
    	}
    	Object obj = this.tabela[this.vrh];
    	this.tabela[this.vrh] = null;
    	this.vrh--;
    	return obj;
    }

    public Object vrhnji() {
    	if (this.vrh == -1) {
    		System.out.println("Sklad je prazen");
    	}
    	return this.tabela[this.vrh];
    }

    public boolean jePrazen() {
    	return this.vrh == -1;
    }

    public int velikost() {
    	return this.vrh + 1;
    }

    public void izpisiVsebino() {
    	for (int i = this.vrh; i >= 0; i--) {
    		System.out.println(this.tabela[i] + "\t");
    	}
    	System.out.println();
    }
}