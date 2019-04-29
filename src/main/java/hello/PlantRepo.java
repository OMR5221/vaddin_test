package hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepo extends JpaRepository<Plant, Long> {
	// Return a list of Plants by Operation Mode:
	List<Plant> findByOpModeWithIgnoreCase(String plantCode);
}
