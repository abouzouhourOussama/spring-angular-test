package lu.atozdigital.api.repositories;

import lu.atozdigital.api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
