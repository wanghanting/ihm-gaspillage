package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;

public class ModelListOfChart {
    private ObservableList<ModelChart> listOfChart;
    private ObservableList<ModelChart> listOfCharByType;
    private ObservableList<ModelChart> listOfCharByAli;
    private ObservableList<ModelSum> listOfConsom;
    private ObservableList<ModelSum> listOfGas;
    private ObservableList<ModelSum> listOfConsomByType;
    private ObservableList<ModelSum> listOfGasByType;
    private ObservableList<ModelSum> listOfConsomByAli;
    private ObservableList<ModelSum> listOfGasByAli;

    public ModelListOfChart(){
        listOfChart = FXCollections.observableList(new ArrayList<>());
        listOfCharByType = FXCollections.observableList(new ArrayList<>());
        listOfCharByAli = FXCollections.observableList(new ArrayList<>());
        listOfConsom = FXCollections.observableList(new ArrayList<>());
        listOfGas = FXCollections.observableList(new ArrayList<>());
        listOfConsomByType = FXCollections.observableList(new ArrayList<>());
        listOfGasByType = FXCollections.observableList(new ArrayList<>());
        listOfConsomByAli = FXCollections.observableList(new ArrayList<>());
        listOfGasByAli = FXCollections.observableList(new ArrayList<>());
    }

    public void init(ModelListOfSum listOfSum){
        listOfConsom = listOfSum.getListOfConsom();
        listOfGas = listOfSum.getListOfGas();
        listOfConsomByAli = listOfSum.getListOfConsomByAli();
        listOfGasByAli = listOfSum.getListOfGasByAli();
        listOfConsomByType = listOfSum.getListOfConsomByType();
        listOfGasByType = listOfSum.getListOfGasByType();
    }

    public ObservableList<ModelChart> getListOfChart(){
        return getListOfCharts(listOfChart,listOfConsom,listOfGas);
    }

    public ObservableList<ModelChart> getListOfCharByType(){
        return getListOfCharts(listOfCharByType,listOfConsomByType,listOfGasByType);
    }

    public ObservableList<ModelChart> getListOfCharByAli(){
        return getListOfCharts(listOfCharByAli,listOfConsomByAli,listOfGasByAli);
    }

    private ObservableList<ModelChart> getListOfCharts(ObservableList<ModelChart> listChart, ObservableList<ModelSum> listConsom, ObservableList<ModelSum> listGas){
        listChart.removeAll(listChart);
        for (int cmp = 0;cmp < listConsom.size();cmp ++){
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(new PieChart.Data(listConsom.get(cmp).getName() + " consommée ",Integer.parseInt(listConsom.get(cmp).getSum())),
                            new PieChart.Data(listGas.get(cmp).getName() + " gaspillée",Integer.parseInt(listGas.get(cmp).getSum())));
            listChart.add(new ModelChart(listConsom.get(cmp).getName(),pieChartData));
        }
        return listChart;
    }
}
