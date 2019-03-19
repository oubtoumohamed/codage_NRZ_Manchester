import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Chart {

    private Codage codage ;

	public void make() {
		char[] code_brut = this.getCodage().getCodeBrut();
		String title = this.getCodage().getTitle();

	    NumberAxis xAxis = new NumberAxis("", 0, code_brut.length, 0.5);
	    NumberAxis yAxis = new NumberAxis("Tension", -1.5, 1.5, 1);
	    
		yAxis.setMinorTickCount(0);
        xAxis.setMinorTickCount(0);
        xAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(xAxis) {
            @Override
            public String toString(final Number object) {
            	int i = object.intValue();
            	if( object.floatValue() == i+0.5 && i < code_brut.length )
	            	return ""+code_brut[i];
            	else
	            	return "";
            }
        });
        
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle( title );					
		lineChart.setCreateSymbols(false);
        lineChart.setHorizontalGridLinesVisible(false);
     
		lineChart.getData().add( this.getCodage().buildSeries() );

        StackPane root = new StackPane();
        root.getChildren().add(lineChart);
        
        Scene scene = new Scene(root, 800, 275);
        Stage stage = new Stage();
        stage.setTitle("Codage ");
        stage.setScene(scene);
        stage.showAndWait();
	}


	public Codage getCodage() {
		return codage;
	}

	public void setCodage(Codage codage) {
		this.codage = codage;
	}
}