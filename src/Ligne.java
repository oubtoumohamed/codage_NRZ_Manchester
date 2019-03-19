
public class Ligne {
	private Point debut;
	private Point fin;
	
	public Ligne() {
		this.debut = new Point();
		this.fin = new Point();
	}	
	public Ligne(Point pd, Point pf) {
		this.debut = pd;
		this.fin = pf;
	}

	// getter & setter Debut
	public Point getDebut() {
		return this.debut;
	}
	public void setDebut(Point p) {
		this.debut = p;
	}
	
	// getter & setter Fin
	public Point getFin() {
		return this.fin;
	}
	public void setFin(Point p) {
		this.fin = p;
	}
}
