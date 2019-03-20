import java.util.ArrayList;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class Codage {
	private String code;
	private ArrayList<Ligne> lignes = new ArrayList<Ligne>();

	public Codage() {
		this.code = "";
	}
	public Codage(String c) {
		this.setCode( c );
	}

	// getter & setter code
	public String getCode() {
		return this.code;
	}
	public void setCode(String c) {
		this.code = c;
	}

	// getter & setter lignes
	public ArrayList<Ligne> getLignes() {
		return lignes;
	}
	public void addLigne(Ligne l) {
		this.getLignes().add(l);
	}

	// return the code as array ex : [0,1,0,1,0] 
	public char[] getCodeBrut() {
		return this.getCode().toCharArray();
	}

	// transform the points as lignes 
	public void transform() {
		float x = 0,y =0 ;
		
		for ( char c : this.getCodeBrut() ) {			
			Ligne l = new Ligne();

			l = this.traceLigne(l, x, y, c);

			x = l.getFin().getX();
			y = l.getFin().getY();
			
			this.addLigne(l);
		}
	}
	public Series buildSeries() {        
		this.transform();
        Series series = new Series();
        
		for( Ligne l : this.getLignes() ){
			series.getData().add( new XYChart.Data( l.getDebut().getX() , l.getDebut().getY() ) );
			series.getData().add( new XYChart.Data( l.getFin().getX() , l.getFin().getY() ) );
		}
		
		return series;
	}

	public float positionY(char c) {
		return 0;
	}
	public float positionX(float x,char c) {
		return 0;
	}
	
	public String getTitle() {
		return "";
	}
	
	public Ligne traceLigne(Ligne l, float x, float y, char c) {
		return l;
	}
}