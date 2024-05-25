package CRUD.Repositiry;

import CRUD.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Books, Long> {
}
