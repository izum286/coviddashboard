package com.izum286.coviddashboard.ui;

import com.example.Datum;
import com.izum286.coviddashboard.CVService;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import java.util.List;

@Route("")
@PWA(name = "Simple Coronavirus Dashboard", shortName = "COVID19_App", description = "A covid dashboard app")
public class DashboardView extends VerticalLayout {
    public DashboardView(CVService service) {
        List<Datum> data = service.timeline().getData();
        Datum latest = data.get(0);
        Board board = new Board();
        board.addRow(
                new DashboardNumber("Confirmed", latest.getConfirmed()),
                new DashboardNumber("Confirmed Deaths", latest.getDeaths()),
                new DashboardNumber("Confirmed Recovered", latest.getRecovered())
        );
        board.addRow(
                new DashboardChart(data, ChartType.SPLINE, "Cumulative", Datum::getConfirmed,
                        Datum::getDeaths, Datum::getRecovered),
                new DashboardChart(data.subList(0,7), ChartType.COLUMN,"Daily",
                        Datum::getNewConfirmed, Datum::getNewDeaths, Datum::getNewRecovered)
        );
        add(
                new H1("CovidDashBord"),
                board

        );
    }
}
