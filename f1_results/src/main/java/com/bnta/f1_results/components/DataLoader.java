package com.bnta.f1_results.components;

import com.bnta.f1_results.models.Driver;
import com.bnta.f1_results.models.Race;
import com.bnta.f1_results.models.Team;
import com.bnta.f1_results.repositories.DriverRepository;
import com.bnta.f1_results.repositories.RaceRepository;
import com.bnta.f1_results.repositories.TeamRepository;
import com.fasterxml.classmate.util.LRUTypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Add some teams
        Team mercedes = new Team("Mercedes");
        Team redBull = new Team("Red Bull");
        Team ferrari = new Team("Ferrari");
        Team mclaren = new Team("Mclaren");
        Team alphaTauri = new Team("Alpha Tauri");
        Team alfaRomeo = new Team("Alfa Romeo");
        Team williams = new Team("Williams");
        Team astonMartin = new Team("Aston Martin");
        Team alpine = new Team("Alpine");
        Team haas = new Team("Haas");
        teamRepository.saveAll(Arrays.asList(mercedes, redBull,
                ferrari, mclaren, alphaTauri, alfaRomeo,
                williams, astonMartin, alpine, haas));

        // Add some drivers
        Driver russell = new Driver("George Russell", mercedes, "British");
        Driver hamilton = new Driver("Lewis Hamilton", mercedes, "British");
        Driver norris = new Driver("Lando Norris", mclaren, "British");
        Driver dannyric = new Driver("Daniel Ricciardo", mclaren, "Australian");
        Driver leclerc = new Driver("Charles Leclerc", ferrari, "Monaco");
        Driver sainz = new Driver("Carlos Sainz", ferrari, "Spanish");
        Driver verstappen = new Driver("Max Verstappen", redBull, "Dutch");
        Driver checo = new Driver("Sergio Perez", redBull, "Mexican");
        Driver gasly = new Driver("Pierre Gasly", alphaTauri, "French");
        Driver tsunoda = new Driver("Yuki Tsunoda", alphaTauri, "Japanese");
        Driver bottas = new Driver("Valteri Bottas", alfaRomeo, "Finnish");
        Driver zhou = new Driver("Zhou Guanyu", alfaRomeo, "Chinese");
        Driver albon = new Driver("Alex Albon", williams, "Thai");
        Driver latifi = new Driver("Nicholas Latifi", williams, "Canadian");
        Driver stroll = new Driver("Lance Stroll", astonMartin, "Canadian");
        Driver vettel = new Driver("Sebastian Vettel", astonMartin, "German");
        Driver ocon = new Driver("Esteban Ocon", alpine, "French");
        Driver alonso = new Driver("Fernando Alonso", alpine, "Spanish");
        Driver kMag = new Driver("Kevin Magnussen", haas, "Danish");
        Driver mick = new Driver("Mick Schumacher", haas, "German");
        Driver hulk = new Driver("Nico Hulkenburg", astonMartin, "German");
        Driver kimi = new Driver("Kimi Raikonnen", alfaRomeo, "Finnish");
        Driver giovinazzi = new Driver("Antonio Giovinazzi", alfaRomeo, "Italian");
        Driver mazespin = new Driver("Nikita Mazepin", haas, "Russian");
        driverRepository.saveAll(Arrays.asList(russell, hamilton, norris, dannyric, leclerc,
                sainz, verstappen, checo, gasly, tsunoda, bottas, zhou, albon, latifi,
                stroll, vettel, ocon, alonso, kMag, mick, hulk, kimi, giovinazzi, mazespin));

        // Add some races
        Race miami22 = new Race("Miami Grand Prix", "United States", 2022,
                Arrays.asList(verstappen, leclerc, sainz, checo, russell, hamilton, bottas, ocon, albon, stroll, alonso, tsunoda, dannyric, latifi, mick, kMag, vettel, gasly, norris, zhou),
                Arrays.asList(mercedes, redBull, ferrari, mclaren, alphaTauri, alfaRomeo, williams, astonMartin, alpine, haas));
        Race bahrain22 = new Race("Bahrain Grand Prix", "Bahrain", 2022,
                Arrays.asList(leclerc, sainz, hamilton, russell, kMag, bottas, ocon, tsunoda, alonso, zhou, mick, stroll, albon, dannyric, norris, latifi, hulk, checo, verstappen, gasly),
                Arrays.asList(mercedes, redBull, ferrari, mclaren, alphaTauri, alfaRomeo, williams, astonMartin, alpine, haas));
        Race saudi22 = new Race("Saudi Arabia Grand Prix", "Saudi Arabia", 2022,
                Arrays.asList(verstappen, leclerc, sainz, checo, russell, ocon, norris, gasly, kMag, hamilton, zhou, hulk, stroll, albon, bottas, alonso, dannyric, latifi, tsunoda, mick),
                Arrays.asList(mercedes, redBull, ferrari, mclaren, alphaTauri, alfaRomeo, williams, astonMartin, alpine, haas));
        Race aus22 = new Race("Australian Grand Prix", "Australia", 2022,
                Arrays.asList(leclerc, checo, russell, hamilton, norris, dannyric, ocon, bottas, gasly, albon, zhou, stroll, mick, kMag, tsunoda, latifi, alonso, verstappen, vettel, sainz),
                Arrays.asList(mercedes, redBull, ferrari, mclaren, alphaTauri, alfaRomeo, williams, astonMartin, alpine, haas));
        Race imola22 = new Race("Emilia Romagna Grand Prix", "Italy", 2022,
                Arrays.asList(verstappen, checo, norris, russell, bottas, leclerc, tsunoda, vettel, kMag, stroll, albon, gasly, hamilton, ocon, zhou, latifi, mick, dannyric, alonso, sainz),
                Arrays.asList(mercedes, redBull, ferrari, mclaren, alphaTauri, alfaRomeo, williams, astonMartin, alpine, haas));
        Race bahrain21 = new Race("Bahrain Grand Prix", "Bahrain", 2021,
                Arrays.asList(hamilton, verstappen, bottas, norris, checo, leclerc, dannyric, sainz, tsunoda, stroll, kimi, giovinazzi, ocon, russell, vettel, mick, gasly, latifi, alonso, mazespin),
                Arrays.asList(mercedes, redBull, ferrari, mclaren, alphaTauri, alfaRomeo, williams, astonMartin, alpine, haas));
        Race imola21 = new Race("Emilia Romagna Grand Prix", "Italy", 2021,
                Arrays.asList(verstappen, hamilton, norris, leclerc, sainz, dannyric, gasly, stroll, ocon, alonso, checo, tsunoda, kimi, giovinazzi, vettel, mick, mazespin, bottas, russell, latifi),
                Arrays.asList(mercedes, redBull, ferrari, mclaren, alphaTauri, alfaRomeo, williams, astonMartin, alpine, haas));
        Race saudi21 = new Race("Saudi Arabia Grand Prix", "Saudi Arabia", 2021,
                Arrays.asList(hamilton, verstappen, bottas, ocon, dannyric, gasly, leclerc, sainz, giovinazzi, norris, stroll, latifi, alonso, tsunoda, kimi, vettel, checo, mazespin, russell, mick),
                Arrays.asList(mercedes, redBull, ferrari, mclaren, alphaTauri, alfaRomeo, williams, astonMartin, alpine, haas));
        raceRepository.saveAll(Arrays.asList(miami22, bahrain22, saudi22, aus22, imola22, bahrain21,
                imola21, saudi21));
    }
}
