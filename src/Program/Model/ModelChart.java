package Program.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class ModelChart {
    private StringProperty name;
    private ObservableList<PieChart.Data> pieChartData;

    public ModelChart(String name, ObservableList<PieChart.Data> pieChartData){
        this.name = new SimpleStringProperty(name);
        this.pieChartData = pieChartData;
    }

    public ObservableList<PieChart.Data> getPieChartData(){
        return pieChartData;
    }

    public String getName(){return name.getValue();}
}
