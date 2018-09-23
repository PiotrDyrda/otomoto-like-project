package JAVA_otomoto_like.repositories;

import JAVA_otomoto_like.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
