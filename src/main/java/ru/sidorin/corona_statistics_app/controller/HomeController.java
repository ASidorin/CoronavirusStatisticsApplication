package ru.sidorin.corona_statistics_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import ru.sidorin.corona_statistics_app.model.LocationStats;
import ru.sidorin.corona_statistics_app.service.CoronaServiceData;

@Controller
public class HomeController {
	
	@Autowired
	private CoronaServiceData coronaServiceData;
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = coronaServiceData.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		model.addAttribute("totalNewCases", totalNewCases);
		
		return "home";
	}

}
