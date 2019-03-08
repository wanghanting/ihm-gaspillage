package Program;

import Program.Controller.ControllerConsomationG;
import Program.Model.ModelListOfFood;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class ViewConsomationG {
    ModelListOfFood listOfFood ;
    public void init(ControllerConsomationG controllerConsomationG,ModelListOfFood listOfFood){
        this.listOfFood=listOfFood;
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(new PieChart.Data("okFood",listOfFood.getListOfOkFoodG().size()),
                        new PieChart.Data(" ppFood",listOfFood.getListOfPPFoodG().size()),
                        new PieChart.Data(" perimeFood",listOfFood.getListOfPerimeFoodG().size()));
        controllerConsomationG.getPiechart().setData(pieChartData);

    }
}
