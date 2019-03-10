package Program.Controller;

import Program.Model.ModelChart;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.text.Text;

public class ControllerChart extends Controller{
    @FXML
    private PieChart chart;
    @FXML
    private Text name;

    public PieChart getPiechart(){return chart;}

    public void init(ModelChart modelChar){
        name.setText(modelChar.getName());
        chart.setData(modelChar.getPieChartData());
    }
}
