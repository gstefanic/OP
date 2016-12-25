public interface Sklad {
	// metode so abstraktne
	public void dodaj(Object obj);
	public Object odvzemi();
	public Object vrhnji();
	public boolean jePrazen();
	public int velikost();
	public void izpisiVsebino();
}