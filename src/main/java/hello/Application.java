package hello;

import org.slfj.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner loadData(PlantRepo repo) {
		return (args) -> {
			// save data records: Need to convert to DB Connection:
			repo.save(new Plant(502, 'BBR1', 'Babcock BESS'));
			repo.save(new Plant(503, 'PCS1', 'Citrus BESS'));
			repo.save(new Plant(1227, 'BEH1', 'East Hampton'));
			repo.save(new Plant(1228, 'BPB', 'PIMA'));

			// Fetch records for Plants:
			log.info("Plants found with findAll(): ");
			log.info("=============================");
			for (Plant plant : repo.findAll()) {
				log.info(plant.toString());
			}
			log.info("");

			// Get a single Plant by its id:
			Plant plant = repo.findById(1227).get();
			log.info("Plant found with findById(1227): ");
			log.info("---------------------------------");
			log.info(plant.toString());
			log.info("");

			// Get Plants by PlantName:
			log.info("Plant found with findByPlantName('Citrus BESS')");
			log.info("-----------------------------------------------");
			for (Plant citrus: repo.findByPlantName('Citrus BESS')) {
				log.info(citrus.toString());
			}
			log.info("");
		}
	}
};
