package gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Input.DataOneDay;
import Input.STOCK;
import javafx.collections.FXCollections;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class CreateLineChart {
	public static XYChart.Series<String, Number> create(CategoryAxis xAxis, NumberAxis yAxis, 
														ArrayList<DataOneDay> dataBefore, STOCK stock, Date date) {
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		long dateTime = date.getTime();
		Predicate<DataOneDay> predicate = new Predicate<DataOneDay>() {
			
			@Override
			public boolean test(DataOneDay dataOneDay) {
				long dateData = dataOneDay.getDate().getTime();
				return (dateData <= dateTime);
			}
		};
		ArrayList<DataOneDay> data = dataBefore.stream().filter(predicate).limit(90).collect(Collectors.toCollection(ArrayList::new));
		Collections.reverse(data);
		
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();

		Function<DataOneDay, String> mapper = new Function<DataOneDay, String>() {
			
			@Override
			public String apply(DataOneDay t) {
				return " " + formats.format(t.getDate()) + " ";
			}
		};
		
		
		xAxis.setAutoRanging(false); 
		ArrayList<String> arr = data.stream().map(mapper).limit(90).collect(Collectors.toCollection(ArrayList::new)); 
		xAxis.setCategories(FXCollections.<String>observableArrayList(arr)); 
		xAxis.invalidateRange(arr);
	    
	    Comparator<DataOneDay> comparator = new Comparator<DataOneDay>() {
			
			@Override
			public int compare(DataOneDay o1, DataOneDay o2) {
				return o1.getGiaDongCua() > o2.getGiaDongCua() ? 1 : -1;
			}
		};
		
		int maxPrice = getPrice(data.stream().max(comparator).get().getGiaDongCua(), true);
		int minPrice = getPrice(data.stream().min(comparator).get().getGiaDongCua(), false);

	    yAxis.setAutoRanging(false);
	    yAxis.setLowerBound(minPrice);
	    yAxis.setUpperBound(maxPrice);
	    yAxis.setTickUnit(getTickUnit(maxPrice - minPrice));
	    
		
	    for (DataOneDay item : data) {
	    	dataSeries.getData().add(new XYChart.Data<>(" " + formats.format(item.getDate()) + " ", item.getGiaDongCua()));
		}
	    
	    
		return dataSeries;
	}
    
    private static int getPrice(Double price, boolean bool) {
    	int i = (int)Math.ceil(price/5);
    	int Price  = 0;
    	if(bool) {
    		Price = i * 5;
    		if((double)Price <= (price + 2.5d)) {
    			Price += 5;
    		}
    	}else {
    		Price = (i-1) * 5;
    		if((double)Price >= (price - 2.5d)) {
    			Price -= 5;
    		}
    	}
    	return Price;
    }
    
    private static int getTickUnit(int difference) {
    	int tickUnit = (int)(difference/10);
    	return tickUnit > 10 ? 20 : (tickUnit < 5 ? 5 :10);
    }
}
